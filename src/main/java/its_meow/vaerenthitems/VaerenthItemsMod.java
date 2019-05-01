package its_meow.vaerenthitems;

import its_meow.vaerenthitems.content.ItemZyrannaArmor;
import its_meow.vaerenthitems.content.ItemZyrannaCrown;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemSword;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
@Mod(modid = Ref.MODID, name = Ref.NAME, version = Ref.VERSION)
public class VaerenthItemsMod {
	
	public static final ItemZyrannaCrown crown = new ItemZyrannaCrown("crown");
	public static final ItemZyrannaArmor chestplate = new ItemZyrannaArmor("zyranna_chestplate", EntityEquipmentSlot.CHEST);
	public static final ItemZyrannaArmor leggings = new ItemZyrannaArmor("zyranna_leggings", EntityEquipmentSlot.LEGS);
	public static final ItemZyrannaArmor boots = new ItemZyrannaArmor("zyranna_boots", EntityEquipmentSlot.FEET);
	public static final ItemSword zyranna_sword = (ItemSword) new ItemSword(ToolMaterial.DIAMOND).setRegistryName(Ref.MODID, "zyranna_sword").setTranslationKey("vaerenthitems.zyranna_sword").setCreativeTab(CreativeTabs.COMBAT);
	public static final ItemSword walter_sword = (ItemSword) new ItemSword(ToolMaterial.DIAMOND).setRegistryName("vaerenthitems", "walter_sword").setTranslationKey("vaerenthitems.walter_sword").setCreativeTab(CreativeTabs.COMBAT);
	public static final Item[] items = {walter_sword, zyranna_sword, crown, chestplate, leggings, boots};
	
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        for(Item item : items) {
            item.setCreativeTab(CreativeTabs.COMBAT);
        }
        event.getRegistry().registerAll(items);
    }
	
}