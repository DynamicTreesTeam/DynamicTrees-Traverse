package dttraverse.worldgen;

import com.ferreusveritas.dynamictrees.ModConstants;
import com.ferreusveritas.dynamictrees.api.TreeRegistry;
import com.ferreusveritas.dynamictrees.api.worldgen.BiomePropertySelectors;
import com.ferreusveritas.dynamictrees.api.worldgen.IBiomeDataBasePopulator;
import com.ferreusveritas.dynamictrees.trees.Species;
import com.ferreusveritas.dynamictrees.worldgen.BiomeDataBase;
import dttraverse.DynamicTreesTraverse;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import prospector.traverse.init.TraverseBlocks;
import prospector.traverse.world.TraverseWorld;

import java.util.ArrayList;
import java.util.Optional;

public final class BiomeDataBasePopulator implements IBiomeDataBasePopulator {

    @Override
    public void populate(BiomeDataBase biomeDataBase) {

        // Traverse trees
        final Species fir = TreeRegistry.findSpecies(new ResourceLocation(DynamicTreesTraverse.MODID, "fir"));
        final Species autumnBrown = TreeRegistry.findSpecies(new ResourceLocation(DynamicTreesTraverse.MODID, "autumn_brown"));
        final Species autumnOrange = TreeRegistry.findSpecies(new ResourceLocation(DynamicTreesTraverse.MODID, "autumn_orange"));
        final Species autumnRed = TreeRegistry.findSpecies(new ResourceLocation(DynamicTreesTraverse.MODID, "autumn_red"));
        final Species autumnYellow = TreeRegistry.findSpecies(new ResourceLocation(DynamicTreesTraverse.MODID, "autumn_yellow"));
        final Species miniJungle = TreeRegistry.findSpecies(new ResourceLocation(DynamicTreesTraverse.MODID, "mini_jungle"));

        // Vanilla trees
        final Species birch = TreeRegistry.findSpecies(new ResourceLocation(ModConstants.MODID, "birch"));
        final Species oak = TreeRegistry.findSpecies(new ResourceLocation(ModConstants.MODID, "oak"));
        final Species acacia = TreeRegistry.findSpecies(new ResourceLocation(ModConstants.MODID, "acacia"));
        final Species swamp = TreeRegistry.findSpecies(new ResourceLocation(ModConstants.MODID, "oakswamp"));
        final Species darkOak = TreeRegistry.findSpecies(new ResourceLocation(ModConstants.MODID, "darkoak"));
        final Species jungle = TreeRegistry.findSpecies(new ResourceLocation(ModConstants.MODID, "jungle"));
        final Species cactus = TreeRegistry.findSpecies(new ResourceLocation(ModConstants.MODID, "cactus"));

        // TraverseWorld.autumnalWoodsBiome
        addSpeciesSelector(biomeDataBase, TraverseWorld.autumnalWoodsBiome,new BiomePropertySelectors.RandomSpeciesSelector().add(autumnYellow, 4).add(autumnOrange, 5).add(oak, 1).add(autumnBrown, 2).add(autumnRed, 4));
        addDensitySelector(biomeDataBase, TraverseWorld.autumnalWoodsBiome,scale(0.9) );
        addChanceSelector(biomeDataBase, TraverseWorld.autumnalWoodsBiome, chance(1.0f));

        // TraverseWorld.autumnalWoodedHillsBiome
        addSpeciesSelector(biomeDataBase, TraverseWorld.autumnalWoodedHillsBiome,new BiomePropertySelectors.RandomSpeciesSelector().add(autumnYellow, 4).add(autumnOrange, 5).add(oak, 1).add(autumnBrown, 2).add(autumnRed, 4));
        addDensitySelector(biomeDataBase, TraverseWorld.autumnalWoodedHillsBiome,scale(0.9) );
        addChanceSelector(biomeDataBase, TraverseWorld.autumnalWoodedHillsBiome, chance(1.0f));

        // TraverseWorld.temperateRainforestBiome
        addSpeciesSelector(biomeDataBase, TraverseWorld.temperateRainforestBiome,new BiomePropertySelectors.StaticSpeciesSelector(fir));
        addChanceSelector(biomeDataBase, TraverseWorld.temperateRainforestBiome, chance(1.0f));

        // TraverseWorld.snowyConiferousForestBiome
        addSpeciesSelector(biomeDataBase, TraverseWorld.snowyConiferousForestBiome,new BiomePropertySelectors.StaticSpeciesSelector(fir));
        addChanceSelector(biomeDataBase, TraverseWorld.snowyConiferousForestBiome, chance(1.0f));

        // TraverseWorld.aridHighlandBiome
        addSpeciesSelector(biomeDataBase, TraverseWorld.aridHighlandBiome,new BiomePropertySelectors.RandomSpeciesSelector().add(acacia, 4).add(oak, 1).add(cactus, 1));
        addDensitySelector(biomeDataBase, TraverseWorld.aridHighlandBiome,scale(0.1) );
        addChanceSelector(biomeDataBase, TraverseWorld.aridHighlandBiome, chance(0.2f));

        // TraverseWorld.badlandsBiome
        addSpeciesSelector(biomeDataBase, TraverseWorld.badlandsBiome,new BiomePropertySelectors.RandomSpeciesSelector().add(autumnBrown, 1).add(oak, 1));
        addDensitySelector(biomeDataBase, TraverseWorld.badlandsBiome,scale(0.03) );
        addChanceSelector(biomeDataBase, TraverseWorld.badlandsBiome, chance(0.0625f));

        // TraverseWorld.birchForestedHillsBiome
        addSpeciesSelector(biomeDataBase, TraverseWorld.birchForestedHillsBiome,new BiomePropertySelectors.StaticSpeciesSelector(birch));
        addChanceSelector(biomeDataBase, TraverseWorld.birchForestedHillsBiome, chance(1.25f));

        // TraverseWorld.forestedHillsBiome
        addSpeciesSelector(biomeDataBase, TraverseWorld.forestedHillsBiome,new BiomePropertySelectors.RandomSpeciesSelector().add(oak, 4).add(birch, 2));
        addDensitySelector(biomeDataBase, TraverseWorld.forestedHillsBiome,scale(0.9) );
        addChanceSelector(biomeDataBase, TraverseWorld.forestedHillsBiome, chance(1.0f));

        // TraverseWorld.lushHillsBiome
        addSpeciesSelector(biomeDataBase, TraverseWorld.lushHillsBiome,new BiomePropertySelectors.RandomSpeciesSelector().add(oak, 4).add(swamp, 1));
        addDensitySelector(biomeDataBase, TraverseWorld.lushHillsBiome,scale(0.4) );
        addChanceSelector(biomeDataBase, TraverseWorld.lushHillsBiome, chance(1.0f));

        // TraverseWorld.lushSwampBiome
        addSpeciesSelector(biomeDataBase, TraverseWorld.lushSwampBiome,new BiomePropertySelectors.RandomSpeciesSelector().add(swamp, 4).add(oak, 1));
        addDensitySelector(biomeDataBase, TraverseWorld.lushSwampBiome,scale(0.6) );
        addChanceSelector(biomeDataBase, TraverseWorld.lushSwampBiome, chance(1.0f));

        // TraverseWorld.meadowBiome
        addSpeciesSelector(biomeDataBase, TraverseWorld.meadowBiome,new BiomePropertySelectors.RandomSpeciesSelector().add(oak, 2).add(birch, 1));
        addDensitySelector(biomeDataBase, TraverseWorld.meadowBiome,scale(0.01) );
        addChanceSelector(biomeDataBase, TraverseWorld.meadowBiome, chance(0.5f));

        // TraverseWorld.rockyPlainsBiome
        addSpeciesSelector(biomeDataBase, TraverseWorld.rockyPlainsBiome,new BiomePropertySelectors.RandomSpeciesSelector().add(oak, 2));
        addDensitySelector(biomeDataBase, TraverseWorld.rockyPlainsBiome,scale(0.01) );
        addChanceSelector(biomeDataBase, TraverseWorld.rockyPlainsBiome, chance(0.05f));

        // TraverseWorld.rockyPlateauBiome
        addSpeciesSelector(biomeDataBase, TraverseWorld.rockyPlateauBiome,new BiomePropertySelectors.RandomSpeciesSelector().add(oak, 2));
        addDensitySelector(biomeDataBase, TraverseWorld.rockyPlateauBiome,scale(0.01) );
        addChanceSelector(biomeDataBase, TraverseWorld.rockyPlateauBiome, chance(0.5f));

        // TraverseWorld.thicketBiome
        addSpeciesSelector(biomeDataBase, TraverseWorld.thicketBiome,new BiomePropertySelectors.RandomSpeciesSelector().add(oak, 4).add(darkOak, 2));
        addDensitySelector(biomeDataBase, TraverseWorld.thicketBiome,scale(1.5) );
        addChanceSelector(biomeDataBase, TraverseWorld.thicketBiome, chance(1.0f));

        // TraverseWorld.woodlandsBiome
        addSpeciesSelector(biomeDataBase, TraverseWorld.woodlandsBiome,new BiomePropertySelectors.StaticSpeciesSelector(oak));
        addDensitySelector(biomeDataBase, TraverseWorld.woodlandsBiome,scale(0.6) );
        addChanceSelector(biomeDataBase, TraverseWorld.woodlandsBiome, chance(0.75f));

        // TODO: Normal cactus still seem to generate here.
        // TraverseWorld.redDesertBiome
        addSpeciesSelector(biomeDataBase, TraverseWorld.redDesertBiome, new BiomePropertySelectors.StaticSpeciesSelector(cactus));
        addDensitySelector(biomeDataBase, TraverseWorld.redDesertBiome,scale(2.0));
        addChanceSelector(biomeDataBase, TraverseWorld.redDesertBiome, chance(0.05f));

        // TraverseWorld.mountainousDesertBiome
        addSpeciesSelector(biomeDataBase, TraverseWorld.mountainousDesertBiome, new BiomePropertySelectors.StaticSpeciesSelector(cactus));
        addDensitySelector(biomeDataBase, TraverseWorld.mountainousDesertBiome,scale(2.0));
        addChanceSelector(biomeDataBase, TraverseWorld.mountainousDesertBiome, chance(0.05f));

        // TraverseWorld.miniJungleBiome
        // this.addSpeciesSelector(biomeDataBase, TraverseWorld.miniJungleBiome, new BiomePropertySelectors.RandomSpeciesSelector().add(oak, 1).add(jungle, 4));
        // this.addDensitySelector(biomeDataBase, TraverseWorld.miniJungleBiome, scale(2.0));
        // this.addChanceSelector(biomeDataBase, TraverseWorld.miniJungleBiome, chance(0.05f));

        ArrayList<Biome> blackList = new ArrayList<>();
        blackList.add(TraverseWorld.canyonBiome);
        blackList.add(TraverseWorld.cliffsBiome);
        blackList.add(TraverseWorld.cragCliffsBiome);
        blackList.add(TraverseWorld.desertShrublandBiome);
        blackList.add(TraverseWorld.glacierBiome);
        blackList.add(TraverseWorld.glacierSpikesBiome);
        blackList.add(TraverseWorld.miniJungleBiome);

        Biome.REGISTRY.forEach(biome -> {
            if (biome.getRegistryName().getPath().equals("traverse") && !blackList.contains(biome)) {
                biomeDataBase.setCancelVanillaTreeGen(biome, true);
            }
        });
    }

    private void addSpeciesSelector(BiomeDataBase dbase, Biome biome, BiomePropertySelectors.ISpeciesSelector selector) {
        dbase.setSpeciesSelector(biome, selector, BiomeDataBase.Operation.REPLACE);
    }

    private void addDensitySelector(BiomeDataBase dbase, Biome biome, BiomePropertySelectors.IDensitySelector selector) {
        dbase.setDensitySelector(biome, selector, BiomeDataBase.Operation.REPLACE);
    }

    private void addChanceSelector(BiomeDataBase dbase, Biome biome, BiomePropertySelectors.IChanceSelector selector) {
        dbase.setChanceSelector(biome, selector, BiomeDataBase.Operation.REPLACE);
    }

    private BiomePropertySelectors.IDensitySelector scale(double factor1) {
        return (rnd, nd) -> nd * factor1;
    }

    // code from ferreusveritas' JsonBiomePropertyApplierChance
    private BiomePropertySelectors.IChanceSelector chance(float value) {
        if(value <= 0) {
            return (rnd, spc, rad) -> BiomePropertySelectors.EnumChance.CANCEL;
        }
        if(value >= 1) {
            return (rnd, spc, rad) -> BiomePropertySelectors.EnumChance.OK;
        }
        return (rnd, spc, rad) -> rnd.nextFloat() < value ? BiomePropertySelectors.EnumChance.OK : BiomePropertySelectors.EnumChance.CANCEL;
    }

}