package dttraverse;

import com.ferreusveritas.dynamictrees.ModConstants;
import dttraverse.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid=DynamicTreesTraverse.MOD_ID, name = DynamicTreesTraverse.NAME, version = DynamicTreesTraverse.VERSION, dependencies = DynamicTreesTraverse.DEPENDENCIES, updateJSON = "https://github.com/Harleyoc1/DynamicTreesVersionInfo/blob/master/Add-ons/Traverse.json?raw=true")
public final class DynamicTreesTraverse {

    public static final String MOD_ID = "dttraverse";
    public static final String NAME = "Dynamic Trees Traverse";
    public static final String VERSION = "1.12.2-2.1";
    public static final String DEPENDENCIES = ModConstants.REQAFTER + ModConstants.DYNAMICTREES_LATEST + ModConstants.NEXT + ModConstants.REQAFTER + "traverse";

    @Mod.Instance
    public static DynamicTreesTraverse instance;

    public static final Logger logger = LogManager.getLogger(MOD_ID);

    @SidedProxy(clientSide = "dttraverse.proxy.ClientProxy", serverSide = "dttraverse.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit();
    }

}
