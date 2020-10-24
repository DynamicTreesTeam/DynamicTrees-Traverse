package dttraverse.trees;

import com.ferreusveritas.dynamictrees.api.TreeHelper;
import com.ferreusveritas.dynamictrees.trees.Species;
import com.ferreusveritas.dynamictrees.trees.TreeFamily;
import dttraverse.DynamicTreesTraverse;
import dttraverse.ModContent;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import prospector.traverse.world.TraverseWorld;

import java.util.Random;

public final class SpeciesAutumnYellow extends Species {

    public SpeciesAutumnYellow(TreeFamily treeFamily) {
        super(new ResourceLocation(DynamicTreesTraverse.MODID, "autumn_yellow"), treeFamily, ModContent.autumnYellowLeavesProperties);

        this.setBasicGrowingParameters(0.1f, 14.0f, 4, 4, 1.25f);

        this.setRequiresTileEntity(true);

        this.envFactor(BiomeDictionary.Type.HOT, 0.50f);
        this.envFactor(BiomeDictionary.Type.DRY, 0.50f);
        this.envFactor(BiomeDictionary.Type.FOREST, 1.05f);

        this.generateSeed();
        this.setupStandardSeedDropping();

        this.leavesProperties.setTree(treeFamily);
    }

    @Override
    public boolean isBiomePerfect(Biome biome) {
        return isOneOfBiomes(biome, TraverseWorld.autumnalWoodedHillsBiome, TraverseWorld.autumnalWoodsBiome);
    }

    @Override
    public boolean rot (World world, BlockPos pos, int neighborCount, int radius, Random random, boolean rapid) {
        if (super.rot(world, pos, neighborCount, radius, random, rapid)) {
            if(radius > 4 && TreeHelper.isRooty(world.getBlockState(pos.down())) && world.getLightFor(EnumSkyBlock.SKY, pos) < 4) {
                world.setBlockState(pos, Blocks.BROWN_MUSHROOM.getDefaultState());//Change branch to a brown mushroom
                world.setBlockState(pos.down(), Blocks.DIRT.getDefaultState(), 3);//Change rooty dirt to dirt
            }
            return true;
        }

        return false;
    }

}
