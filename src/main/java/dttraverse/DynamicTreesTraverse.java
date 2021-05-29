package dttraverse;

import com.ferreusveritas.dynamictrees.api.registry.RegistryHandler;
import net.minecraftforge.fml.common.Mod;

@Mod(DynamicTreesTraverse.MOD_ID)
public final class DynamicTreesTraverse {

    public static final String MOD_ID = "dttraverse";

    public DynamicTreesTraverse() {
        RegistryHandler.setup(MOD_ID);
    }

}
