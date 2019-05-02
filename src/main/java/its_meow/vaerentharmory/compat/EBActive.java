package its_meow.vaerentharmory.compat;

import electroblob.wizardry.event.SpellCastEvent;
import electroblob.wizardry.item.ItemWand;
import its_meow.vaerentharmory.VaerenthArmoryMod;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EBActive implements ModInteropProxy {

    @Override
    public boolean register() {
        MinecraftForge.EVENT_BUS.register(this);
        return true;
    }
    
    @SubscribeEvent
    public void spellCastedPost(SpellCastEvent.Post event) {
        int oldCost = event.getSpell().cost;
        EnumHand hand = event.getEntityLiving().getActiveHand();
        ItemStack handItem = event.getEntityLiving().getHeldItem(hand);
        if(event.getEntityLiving() instanceof EntityPlayer && ((EntityPlayer) event.getEntityLiving()).capabilities.isCreativeMode) {
            return; // Creative players do not have damage applied
        }
        if(handItem.getItem() instanceof ItemWand) {
            float newCost = ((float) oldCost);
            for(EntityEquipmentSlot slot : VaerenthArmoryMod.ARMOR_SLOTS) {
                int lvl = EnchantmentHelper.getEnchantmentLevel(VaerenthArmoryMod.ARCANE_AFFINITY, event.getEntityLiving().getItemStackFromSlot(slot));
                if(lvl > 0) {
                    newCost *= 0.8F;
                }
            }
            if(newCost != oldCost) {
                int damage = handItem.getItemDamage();
                damage -= oldCost;
                damage += newCost;
                handItem.setItemDamage(damage);
            }
        }
    }

}
