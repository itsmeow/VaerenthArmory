package its_meow.vaerentharmory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import its_meow.vaerentharmory.compat.ModInteropProxy;
import its_meow.vaerentharmory.content.ItemZyrannaArmor;
import its_meow.vaerentharmory.content.ItemZyrannaCrown;
import its_meow.vaerentharmory.content.ModEnchantment;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantment.Rarity;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemSword;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
@Mod(modid = Ref.MODID, name = Ref.NAME, version = Ref.VERSION, dependencies = "after:ebwizardry")
public class VaerenthArmoryMod {
	
	public static final ItemZyrannaCrown crown = new ItemZyrannaCrown("crown");
	public static final ItemZyrannaArmor chestplate = new ItemZyrannaArmor("zyranna_chestplate", EntityEquipmentSlot.CHEST);
	public static final ItemZyrannaArmor leggings = new ItemZyrannaArmor("zyranna_leggings", EntityEquipmentSlot.LEGS);
	public static final ItemZyrannaArmor boots = new ItemZyrannaArmor("zyranna_boots", EntityEquipmentSlot.FEET);
	public static final ItemSword zyranna_sword = (ItemSword) new ItemSword(ToolMaterial.DIAMOND).setRegistryName(Ref.MODID, "zyranna_sword").setTranslationKey("vaerentharmory.zyranna_sword").setCreativeTab(CreativeTabs.COMBAT);
	public static final ItemSword walter_sword = (ItemSword) new ItemSword(ToolMaterial.DIAMOND).setRegistryName(Ref.MODID, "walter_sword").setTranslationKey("vaerentharmory.walter_sword").setCreativeTab(CreativeTabs.COMBAT);
	public static final Item[] items = {walter_sword, zyranna_sword, crown, chestplate, leggings, boots};
	
	public static final EntityEquipmentSlot[] ARMOR_SLOTS = new EntityEquipmentSlot[] {EntityEquipmentSlot.CHEST, EntityEquipmentSlot.LEGS, EntityEquipmentSlot.FEET, EntityEquipmentSlot.HEAD};
	
	public static final Enchantment ARCANE_AFFINITY = new ModEnchantment(Rarity.VERY_RARE, EnumEnchantmentType.ARMOR, ARMOR_SLOTS).setRegistryName(Ref.MODID, "arcaneaffinity").setName("arcaneaffinity");
	
	public static final Logger logger = LogManager.getLogger();
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
	    ModInteropProxy ebProxy = getInteropProxy(ModInteropProxy.class, "ebwizardry", "EBActive", "EBInactive");
	    if(ebProxy != null) {
	        ebProxy.register();
	    }
	}
	
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        for(Item item : items) {
            item.setCreativeTab(CreativeTabs.COMBAT);
        }
        event.getRegistry().registerAll(items);
    }
    
    @SubscribeEvent
    public static void registerEnchants(Register<Enchantment> event) {
        event.getRegistry().register(ARCANE_AFFINITY);
    }
    
    /** Get the compatability proxy for a given modid, uses reflection.
     * @param type - Type of class to return
     * @param modid - Modid to check if loaded
     * @param classNameActive - The class name to return if the mod is active in com.ocelot.betteranimals.compat
     * @param classNameInactive - The class name to return if the mod is not present located in com.ocelot.betteranimals.compat
     * @return The proper proxy class for whether the mod is loaded or not **/
    private static <T>T getInteropProxy(Class<T> type, String modid, String classNameActive, String classNameInactive) {
        T proxy = null;
        try {
            if (Loader.isModLoaded(modid)) {
                logger.debug("Loading compat classes for mod " + modid + " with type " + type.getSimpleName());
                // reflection to avoid hard dependency
                proxy = Class.forName("its_meow.vaerentharmory.compat." + classNameActive).asSubclass(type).newInstance();
                logger.debug("Found proxy: " + proxy);
            } else {
                proxy = Class.forName("its_meow.vaerentharmory.compat." + classNameInactive).asSubclass(type).newInstance();
            }
        } catch(ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            logger.error("Error retrieving compatibility class for mod " + modid + " in Vaerenth Armory. This is a bug. Report this on our issues page (see Curse).");
            logger.info("Load status on " + modid + " is " + Loader.isModLoaded(modid));
        }
        return proxy;
    }
	
}