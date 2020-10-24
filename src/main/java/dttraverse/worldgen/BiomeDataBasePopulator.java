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
        final Species spruce = TreeRegistry.findSpecies(new ResourceLocation(ModConstants.MODID, "spruce"));
        final Species acacia = TreeRegistry.findSpecies(new ResourceLocation(ModConstants.MODID, "acacia"));
        final Species swamp = TreeRegistry.findSpecies(new ResourceLocation(ModConstants.MODID, "oakswamp"));
        final Species darkOak = TreeRegistry.findSpecies(new ResourceLocation(ModConstants.MODID, "darkoak"));
        final Species cactus = TreeRegistry.findSpecies(new ResourceLocation(ModConstants.MODID, "cactus"));

        // TraverseWorld.autumnalWoodsBiome
        this.addSpeciesSelector(biomeDataBase, TraverseWorld.autumnalWoodsBiome, new BiomePropertySelectors.RandomSpeciesSelector().add(autumnYellow, 4).add(autumnOrange, 5).add(oak, 1).add(autumnBrown, 2).add(autumnRed, 4));
        this.addDensitySelector(biomeDataBase, TraverseWorld.autumnalWoodsBiome, this.scale(0.9));
        this.addChanceSelector(biomeDataBase, TraverseWorld.autumnalWoodsBiome, this.chance(1.0f));

        // TraverseWorld.autumnalWoodedHillsBiome
        this.addSpeciesSelector(biomeDataBase, TraverseWorld.autumnalWoodedHillsBiome, new BiomePropertySelectors.RandomSpeciesSelector().add(autumnYellow, 4).add(autumnOrange, 5).add(oak, 1).add(autumnBrown, 2).add(autumnRed, 4));
        this.addDensitySelector(biomeDataBase, TraverseWorld.autumnalWoodedHillsBiome, this.scale(0.9));
        this.addChanceSelector(biomeDataBase, TraverseWorld.autumnalWoodedHillsBiome, this.chance(1.0f));

        // TraverseWorld.temperateRainforestBiome
        this.addSpeciesSelector(biomeDataBase, TraverseWorld.temperateRainforestBiome, new BiomePropertySelectors.StaticSpeciesSelector(fir));
        this.addChanceSelector(biomeDataBase, TraverseWorld.temperateRainforestBiome, this.chance(1.0f));

        // TraverseWorld.snowyConiferousForestBiome
        this.addSpeciesSelector(biomeDataBase, TraverseWorld.snowyConiferousForestBiome, new BiomePropertySelectors.StaticSpeciesSelector(fir));
        this.addChanceSelector(biomeDataBase, TraverseWorld.snowyConiferousForestBiome, this.chance(1.0f));

        // TraverseWorld.aridHighlandBiome
        this.addSpeciesSelector(biomeDataBase, TraverseWorld.aridHighlandBiome, new BiomePropertySelectors.RandomSpeciesSelector().add(acacia, 4).add(oak, 1).add(cactus, 1));
        this.addDensitySelector(biomeDataBase, TraverseWorld.aridHighlandBiome, this.scale(0.1));
        this.addChanceSelector(biomeDataBase, TraverseWorld.aridHighlandBiome, this.chance(0.2f));

        // TraverseWorld.badlandsBiome
        this.addSpeciesSelector(biomeDataBase, TraverseWorld.badlandsBiome, new BiomePropertySelectors.RandomSpeciesSelector().add(autumnBrown, 1).add(oak, 1));
        this.addDensitySelector(biomeDataBase, TraverseWorld.badlandsBiome, this.scale(0.03));
        this.addChanceSelector(biomeDataBase, TraverseWorld.badlandsBiome, this.chance(0.0625f));

        // TraverseWorld.birchForestedHillsBiome
        this.addSpeciesSelector(biomeDataBase, TraverseWorld.birchForestedHillsBiome, new BiomePropertySelectors.StaticSpeciesSelector(birch));
        this.addChanceSelector(biomeDataBase, TraverseWorld.birchForestedHillsBiome, this.chance(1.25f));

        // TraverseWorld.forestedHillsBiome
        this.addSpeciesSelector(biomeDataBase, TraverseWorld.forestedHillsBiome, new BiomePropertySelectors.RandomSpeciesSelector().add(oak, 4).add(birch, 2));
        this.addDensitySelector(biomeDataBase, TraverseWorld.forestedHillsBiome, this.scale(0.9));
        this.addChanceSelector(biomeDataBase, TraverseWorld.forestedHillsBiome, this.chance(1.0f));

        // TraverseWorld.lushHillsBiome
        this.addSpeciesSelector(biomeDataBase, TraverseWorld.lushHillsBiome, new BiomePropertySelectors.RandomSpeciesSelector().add(oak, 4).add(swamp, 1));
        this.addDensitySelector(biomeDataBase, TraverseWorld.lushHillsBiome, this.scale(0.4));
        this.addChanceSelector(biomeDataBase, TraverseWorld.lushHillsBiome, this.chance(1.0f));

        // TraverseWorld.lushSwampBiome
        this.addSpeciesSelector(biomeDataBase, TraverseWorld.lushSwampBiome, new BiomePropertySelectors.RandomSpeciesSelector().add(swamp, 4).add(oak, 1));
        this.addDensitySelector(biomeDataBase, TraverseWorld.lushSwampBiome, this.scale(0.6));
        this.addChanceSelector(biomeDataBase, TraverseWorld.lushSwampBiome, this.chance(1.0f));

        // TraverseWorld.meadowBiome
        this.addSpeciesSelector(biomeDataBase, TraverseWorld.meadowBiome, new BiomePropertySelectors.RandomSpeciesSelector().add(oak, 2).add(birch, 1));
        this.addDensitySelector(biomeDataBase, TraverseWorld.meadowBiome, this.scale(0.01));
        this.addChanceSelector(biomeDataBase, TraverseWorld.meadowBiome, this.chance(0.5f));

        // TraverseWorld.rockyPlainsBiome
        this.addSpeciesSelector(biomeDataBase, TraverseWorld.rockyPlainsBiome,new BiomePropertySelectors.RandomSpeciesSelector().add(oak, 2));
        this.addDensitySelector(biomeDataBase, TraverseWorld.rockyPlainsBiome, this.scale(0.01));
        this.addChanceSelector(biomeDataBase, TraverseWorld.rockyPlainsBiome, this.chance(0.05f));

        // TraverseWorld.rockyPlateauBiome
        this.addSpeciesSelector(biomeDataBase, TraverseWorld.rockyPlateauBiome, new BiomePropertySelectors.RandomSpeciesSelector().add(oak, 2));
        this.addDensitySelector(biomeDataBase, TraverseWorld.rockyPlateauBiome, this.scale(0.01));
        this.addChanceSelector(biomeDataBase, TraverseWorld.rockyPlateauBiome, this.chance(0.5f));

        // TraverseWorld.thicketBiome
        this.addSpeciesSelector(biomeDataBase, TraverseWorld.thicketBiome, new BiomePropertySelectors.RandomSpeciesSelector().add(oak, 4).add(darkOak, 2));
        this.addDensitySelector(biomeDataBase, TraverseWorld.thicketBiome, this.scale(1.5));
        this.addChanceSelector(biomeDataBase, TraverseWorld.thicketBiome, this.chance(1.0f));

        // TraverseWorld.woodlandsBiome
        this.addSpeciesSelector(biomeDataBase, TraverseWorld.woodlandsBiome, new BiomePropertySelectors.StaticSpeciesSelector(oak));
        this.addDensitySelector(biomeDataBase, TraverseWorld.woodlandsBiome, this.scale(0.6));
        this.addChanceSelector(biomeDataBase, TraverseWorld.woodlandsBiome, this.chance(0.75f));

        // TraverseWorld.redDesertBiome
        this.addSpeciesSelector(biomeDataBase, TraverseWorld.redDesertBiome, new BiomePropertySelectors.StaticSpeciesSelector(cactus));
        this.addDensitySelector(biomeDataBase, TraverseWorld.redDesertBiome, this.scale(2.0));
        this.addChanceSelector(biomeDataBase, TraverseWorld.redDesertBiome, this.chance(0.05f));

        // TraverseWorld.mountainousDesertBiome
        this.addSpeciesSelector(biomeDataBase, TraverseWorld.mountainousDesertBiome, new BiomePropertySelectors.StaticSpeciesSelector(cactus));
        this.addDensitySelector(biomeDataBase, TraverseWorld.mountainousDesertBiome, this.scale(2.0));
        this.addChanceSelector(biomeDataBase, TraverseWorld.mountainousDesertBiome, this.chance(0.05f));

        // TraverseWorld.miniJungleBiome
        this.addSpeciesSelector(biomeDataBase, TraverseWorld.miniJungleBiome, new BiomePropertySelectors.RandomSpeciesSelector().add(oak, 1).add(miniJungle, 4));
        this.addDensitySelector(biomeDataBase, TraverseWorld.miniJungleBiome, this.scale(2.0));
        this.addChanceSelector(biomeDataBase, TraverseWorld.miniJungleBiome, this.chance(0.85f));

        // Cliffs - trees should be rather common as there's barely any dirt for them to spawn anyway.
        this.addSpeciesSelector(biomeDataBase, TraverseWorld.cliffsBiome, new BiomePropertySelectors.RandomSpeciesSelector().add(oak, 2).add(4));
        this.addDensitySelector(biomeDataBase, TraverseWorld.cliffsBiome, this.scale(2.0f));
        this.addChanceSelector(biomeDataBase, TraverseWorld.cliffsBiome, this.chance(0.5f));

        // Glacier - trees should be rather common as there's barely any dirt for them to spawn anyway.
        this.addSpeciesSelector(biomeDataBase, TraverseWorld.glacierBiome, new BiomePropertySelectors.RandomSpeciesSelector().add(spruce, 2).add(8));
        this.addDensitySelector(biomeDataBase, TraverseWorld.glacierBiome, this.scale(2.0f));
        this.addChanceSelector(biomeDataBase, TraverseWorld.glacierBiome, this.chance(0.5f));

        // Glacier Spikes - trees should be rather common as there's barely any dirt for them to spawn anyway.
        this.addSpeciesSelector(biomeDataBase, TraverseWorld.glacierSpikesBiome, new BiomePropertySelectors.RandomSpeciesSelector().add(spruce, 2).add(8));
        this.addDensitySelector(biomeDataBase, TraverseWorld.glacierSpikesBiome, this.scale(2.0f));
        this.addChanceSelector(biomeDataBase, TraverseWorld.glacierSpikesBiome, this.chance(0.5f));

        Biome.REGISTRY.forEach(biome -> {
            if (biome.getRegistryName().getNamespace().equals("traverse")) {
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

    private BiomePropertySelectors.IDensitySelector scale (double factor) {
        return (rand, noiseDensity) -> noiseDensity * factor;
    }

    // code from ferreusveritas' JsonBiomePropertyApplierChance
    private BiomePropertySelectors.IChanceSelector chance (float value) {
        if(value <= 0) {
            return (rnd, spc, rad) -> BiomePropertySelectors.EnumChance.CANCEL;
        }
        if(value >= 1) {
            return (rnd, spc, rad) -> BiomePropertySelectors.EnumChance.OK;
        }
        return (rnd, spc, rad) -> rnd.nextFloat() < value ? BiomePropertySelectors.EnumChance.OK : BiomePropertySelectors.EnumChance.CANCEL;
    }

}