package dttraverse;

import com.ferreusveritas.dynamictrees.DynamicTrees;
import com.ferreusveritas.dynamictrees.api.registry.RegistryHandler;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(DynamicTreesTraverse.MOD_ID)
public final class DynamicTreesTraverse {

    public static final String MOD_ID = "dttraverse";

    public DynamicTreesTraverse() {
        RegistryHandler.setup(MOD_ID);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::gatherData);
    }

    private void gatherData(final GatherDataEvent event) {
        DynamicTrees.gatherTagGenerators(MOD_ID, event);
    }

}
