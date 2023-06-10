package io.github.teamgensouspark.kekkai;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

import io.github.teamgensouspark.kekkai.proxy.Const;

@Mod(
    modid = Const.MODID,
    name = Const.NAME,
    version = Const.VERSION,
    dependencies = "required-after:mirror@[0.4.0,);required-after:danmakucore"
)
public class Kekkai {
    public static Logger logger;


    @SidedProxy(clientSide = "io.github.teamgensouspark.kekkai.proxy.ClientProxy", serverSide = "io.github.teamgensouspark.kekkai.proxy.CommonProxy")
    public static CommonProxy proxy;
    @EventHandler
    public static void PreInit(FMLPreInitializationEvent event)
    {
        logger=event.getModLog();
        ModReg.preInitRegistries();
    }
}
