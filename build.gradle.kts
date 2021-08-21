import com.google.gson.Gson
import com.google.gson.JsonObject
import com.matthewprenger.cursegradle.*
import org.apache.tools.ant.filters.ReplaceTokens
import java.io.FileInputStream
import java.io.InputStreamReader
import java.time.Instant
import java.time.format.DateTimeFormatter
import java.util.*

plugins {
    id("java")
    id("net.minecraftforge.gradle")
    id("idea")
    id("maven-publish")
    id("com.matthewprenger.cursegradle") version "1.4.0"
}

repositories {
    maven("https://ldtteam.jfrog.io/ldtteam/modding/")
    maven("https://harleyoconnor.com/maven")
}

fun property(key: String): String =
    project.property(key).toString()

fun version(dependencyName: String) =
    property("dependency.$dependencyName.version")

val modName = property("modName")
val modId = property("modId")
val modVersion = property("modVersion")

val mcVersion = property("mcVersion")
val forgeVersion = property("forgeVersion")
val mappingsVersion = property("mappingsVersion")

version = "$mcVersion-$modVersion"
group = property("group")

minecraft {
    mappings("snapshot", mappingsVersion)

    runs {
        create("client") {
            workingDirectory = file("run").absolutePath

            property("forge.logging.markers", "SCAN,REGISTRIES,REGISTRYDUMP")
            property("forge.logging.console.level", "debug")

            if (project.hasProperty("mcUuid")) {
                args("--uuid", project.property("mcUuid"))
            }
            if (project.hasProperty("mcUsername")) {
                args("--username", project.property("mcUsername"))
            }
            if (project.hasProperty("mcAccessToken")) {
                args("--accessToken", project.property("mcAccessToken"))
            }
        }

        create("server") {
            workingDirectory = file("run").absolutePath

            property("forge.logging.markers", "SCAN,REGISTRIES,REGISTRYDUMP")
            property("forge.logging.console.level", "debug")
        }
    }
}

dependencies {
    minecraft("net.minecraftforge:forge:$mcVersion-${forgeVersion}")

    implementation("com.ferreusveritas.dynamictrees:DynamicTrees-$mcVersion:${version("dynamictrees")}")
    implementation("prospector.traverse:Traverse:$mcVersion-${version("traverse")}")
}

// Workaround for resources issue. Use gradle tasks rather than generated runs for now.
sourceSets {
    main {
        output.setResourcesDir(file("build/combined"))
        java.destinationDirectory.set(file("build/combined"))
    }
}

tasks.processResources {
    duplicatesStrategy = DuplicatesStrategy.INCLUDE

    inputs.property("version", project.version)
    inputs.property("mcversion", mcVersion)

    from(sourceSets.main.get().resources.srcDirs) {
        include("mcmod.info")

        expand("version" to project.version, "mcversion" to mcVersion)
    }

    from(sourceSets.main.get().resources.srcDirs) {
        exclude("mcmod.info")
    }
}

// Assign version constant in ModConstants.
val prepareSources = tasks.register("prepareSources", Copy::class) {
    from("src/main/java")
    into("build/src/main/java")
    filter<ReplaceTokens>("tokens" to mapOf("VERSION" to version.toString()))
}

tasks.compileJava {
    source = prepareSources.get().outputs.files.asFileTree
}

tasks.jar {
    manifest.attributes(
        "Specification-Title" to project.name,
        "Specification-Vendor" to "ferreusveritas",
        "Specification-Version" to "1",
        "Implementation-Title" to project.name,
        "Implementation-Version" to project.version,
        "Implementation-Vendor" to "ferreusveritas",
        "Implementation-Timestamp" to DateTimeFormatter.ISO_INSTANT.format(Instant.now())
    )

    archiveBaseName.set(modName)
    finalizedBy("reobfJar")
}

java {
    withSourcesJar()

    toolchain {
        languageVersion.set(JavaLanguageVersion.of(8))
    }
}

fun readChangelog(): String? {
//    val versionInfoFile = file("version_info.json") ?: return null
//    val jsonObject = Gson().fromJson(InputStreamReader(versionInfoFile.inputStream()), JsonObject::class.java)
//    return jsonObject
//        .get(mcVersion)?.asJsonObject
//        ?.get(project.version.toString())?.asString
    return ""
}

curseforge {
    if (project.hasProperty("curseApiKey")) {
        apiKey = project.property("curseApiKey")

        project {
            id = "407056"

            addGameVersion(mcVersion)

            changelog = readChangelog() ?: "No changelog provided."
            changelogType = "markdown"
            releaseType = property("curseFileType") ?: "release"

            addArtifact(tasks.findByName("sourcesJar"))

            mainArtifact(tasks.findByName("jar")) {
                relations {
                    requiredDependency("dynamictrees")
                    requiredDependency("traverse")
                }
            }
        }
    } else {
        project.logger.log(LogLevel.WARN, "API Key and file type for CurseForge not detected; uploading will be disabled.")
    }
}

// Extensions to make CurseGradle extension slightly neater.

fun CurseExtension.project(action: CurseProject.() -> Unit) {
    this.project(closureOf(action))
}

fun CurseProject.mainArtifact(artifact: Task?, action: CurseArtifact.() -> Unit) {
    this.mainArtifact(artifact, closureOf(action))
}

fun CurseArtifact.relations(action: CurseRelation.() -> Unit) {
    this.relations(closureOf(action))
}
