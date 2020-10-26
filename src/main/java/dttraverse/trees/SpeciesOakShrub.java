package dttraverse.trees;

import com.ferreusveritas.dynamictrees.api.IGenFeature;
import com.ferreusveritas.dynamictrees.items.Seed;
import com.ferreusveritas.dynamictrees.systems.featuregen.FeatureGenBush;
import com.ferreusveritas.dynamictrees.trees.Species;
import com.ferreusveritas.dynamictrees.trees.TreeFamily;
import com.ferreusveritas.dynamictrees.trees.TreeFamilyVanilla;
import dttraverse.DynamicTreesTraverse;
import dttraverse.ModContent;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import prospector.traverse.world.TraverseWorld;

/**
 * @author Harley O'Connor
 */
public final class SpeciesOakShrub extends Species {

    public SpeciesOakShrub (final TreeFamily treeFamily) {
        super(new ResourceLocation(DynamicTreesTraverse.MOD_ID, "oak_shrub"), treeFamily);

        this.setStandardSoils();

        this.addGenFeature(new FeatureGenBush(), IGenFeature.FULLGEN);
    }

    @Override
    public boolean isBiomePerfect(Biome biome) {
        return isOneOfBiomes(biome, TraverseWorld.desertShrublandBiome);
    }

    @Override
    public ItemStack getSeedStack(int qty) {
        return this.getFamily().getCommonSpecies().getSeedStack(qty);
    }

    @Override
    public Seed getSeed() {
        return this.getFamily().getCommonSpecies().getSeed();
    }

}