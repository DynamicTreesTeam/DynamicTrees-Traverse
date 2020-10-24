package dttraverse.trees;

import com.ferreusveritas.dynamictrees.ModTrees;
import com.ferreusveritas.dynamictrees.api.TreeRegistry;
import com.ferreusveritas.dynamictrees.blocks.BlockBranch;
import com.ferreusveritas.dynamictrees.blocks.BlockDynamicSapling;
import com.ferreusveritas.dynamictrees.systems.GrowSignal;
import com.ferreusveritas.dynamictrees.systems.featuregen.FeatureGenConiferTopper;
import com.ferreusveritas.dynamictrees.trees.Species;
import com.ferreusveritas.dynamictrees.trees.TreeFamily;
import com.ferreusveritas.dynamictrees.util.SafeChunkBounds;
import dttraverse.DynamicTreesTraverse;
import dttraverse.ModContent;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.registry.GameRegistry;
import prospector.traverse.init.TraverseBlocks;
import java.util.Collections;
import java.util.List;

public final class TreeFir extends TreeFamily {

    public static final class SpeciesFir extends Species {

        SpeciesFir(TreeFamily treeFamily) {
            super(treeFamily.getName(), treeFamily, ModContent.firLeavesProperties);

            this.setBasicGrowingParameters(0.3f, 26.0f, 7, 6, 0.9f);

            this.setGrowthLogicKit(TreeRegistry.findGrowthLogicKit(ModTrees.CONIFER));

            this.envFactor(BiomeDictionary.Type.HOT, 0.50f);
            this.envFactor(BiomeDictionary.Type.DRY, 0.25f);
            this.envFactor(BiomeDictionary.Type.WET, 0.75f);

            this.generateSeed();
            this.setupStandardSeedDropping();

            this.addGenFeature(new FeatureGenConiferTopper(getLeavesProperties()));
        }

        @Override
        public boolean isBiomePerfect(Biome biome) {
            return BiomeDictionary.hasType(biome, BiomeDictionary.Type.CONIFEROUS);
        }

    }

    public TreeFir() {
        super(new ResourceLocation(DynamicTreesTraverse.MODID, "fir"));

        Block firLog = TraverseBlocks.blocks.get("fir_log");
        Item firLeavesItem = new ItemBlock(firLog);
        firLeavesItem.setRegistryName(firLog.getRegistryName());
        GameRegistry.findRegistry(Item.class).register(firLeavesItem);
        IBlockState primLog = firLog.getDefaultState();
        DynamicTreesTraverse.logger.info("FIRLOG:" + firLog + " " + new ItemStack(firLog,1));
        setPrimitiveLog(primLog, new ItemStack(Item.getItemFromBlock(firLog),1));
        hasConiferVariants = true;

        ModContent.firLeavesProperties.setTree(this);
    }

    @Override
    public void createSpecies() {
        this.setCommonSpecies(new SpeciesFir(this));
    }

}
