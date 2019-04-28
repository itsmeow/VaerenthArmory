package its_meow.vaerenthitems.content;

import its_meow.vaerenthitems.Ref;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

public class ItemZyrannaArmor extends ItemArmor {

    public ItemZyrannaArmor(String name, EntityEquipmentSlot slot) {
        super(EnumHelper.addArmorMaterial("zyranna", "vaerenthitems:zyranna", 33, new int[]{3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F), -1, slot);
        this.setRegistryName(Ref.MODID, name);
        this.setTranslationKey(Ref.MODID + "." + name);
        this.canRepair = true;
    }
    
    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return repair.getItem() == Items.GOLD_INGOT;
    }
    
}
