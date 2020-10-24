package dttraverse.trees;

import com.ferreusveritas.dynamictrees.items.Seed;
import com.ferreusveritas.dynamictrees.systems.featuregen.FeatureGenCocoa;
import com.ferreusveritas.dynamictrees.systems.featuregen.FeatureGenVine;
import com.ferreusveritas.dynamictrees.trees.Species;
import com.ferreusveritas.dynamictrees.trees.TreeFamily;
import dttraverse.DynamicTreesTraverse;
import net.minecraft.init.Biomes;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import prospector.traverse.world.TraverseWorld;

/**
 * @author Harley O'Connor
 */
public final class SpeciesMiniJungle extends Species {

    private final TreeFamily family;

    public SpeciesMiniJungle(final TreeFamily treeFamily) {
        super(new ResourceLocation(DynamicTreesTraverse.MODID, "mini_jungle"), treeFamily);

        this.family = treeFamily;

        this.setBasicGrowingParameters(0.4F, 9.0F, 2, 4, 0.9F);

        this.envFactor(BiomeDictionary.Type.HOT, 1.15F);
        this.envFactor(BiomeDictionary.Type.DRY, 1.2f);
        this.envFactor(BiomeDictionary.Type.FOREST, 1.15f);

        this.setGrowthLogicKit(this.family.getCommonSpecies().getGrowthLogicKit());

        this.setupStandardSeedDropping();

        this.addGenFeature(new FeatureGenCocoa());
        this.addGenFeature((new FeatureGenVine()).setQuantity(12).setMaxLength(6));

        this.getFamily().addSpeciesLocationOverride((world, trunkPos) -> (world.getBiome(trunkPos)).equals(TraverseWorld.miniJungleBiome) || (world.getBiome(trunkPos)).equals(Biomes.DESERT) ? this : NULLSPECIES);
    }

    @Override
    public boolean isBiomePerfect(Biome biome) {
        return BiomeDictionary.hasType(biome, BiomeDictionary.Type.JUNGLE);
    }

    @Override
    public ItemStack getSeedStack(int qty) {
        return this.family.getCommonSpecies().getSeedStack(qty);
    }

    @Override
    public Seed getSeed() {
        return this.family.getCommonSpecies().getSeed();
    }

}
