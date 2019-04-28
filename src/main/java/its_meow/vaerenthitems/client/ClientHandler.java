package its_meow.vaerenthitems.client;

import its_meow.vaerenthitems.VaerenthItemsMod;
import its_meow.vaerenthitems.Ref;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(modid = Ref.MODID, value = Side.CLIENT)
public class ClientHandler {
    
    @SubscribeEvent
    public static void modelRegister(ModelRegistryEvent e) {
        for(Item item : VaerenthItemsMod.items) {
            initModel(item, 0);
        }
    }
    
    public static void initModel(Item item, int meta) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }
    
}
