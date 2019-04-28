package its_meow.vaerenthitems.content;

import its_meow.vaerenthitems.client.model.ModelCrown;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemZyrannaCrown extends ItemZyrannaArmor {
    
    protected final String name;
    
    public ItemZyrannaCrown(String name) {
        super(name, EntityEquipmentSlot.HEAD);
        this.name = name;
    }
    
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
        return "vaerenthitems:textures/models/armor/" + name + ".png";
    }

    @Override
    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped defaultModel) {
        if (itemStack != null) {
            if (itemStack.getItem() instanceof ItemArmor) {
                ModelCrown armorModel = ModelCrown.INSTANCE;
                
                armorModel.bipedHead.showModel = armorSlot == EntityEquipmentSlot.HEAD;
                armorModel.bipedHeadwear.showModel = armorSlot == EntityEquipmentSlot.HEAD;
                
                armorModel.bipedBody.showModel = (armorSlot == EntityEquipmentSlot.CHEST) || (armorSlot == EntityEquipmentSlot.CHEST);
                armorModel.bipedRightArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
                armorModel.bipedLeftArm.showModel = armorSlot == EntityEquipmentSlot.CHEST;
                armorModel.bipedRightLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS) || (armorSlot == EntityEquipmentSlot.FEET);
                armorModel.bipedLeftLeg.showModel = (armorSlot == EntityEquipmentSlot.LEGS) || (armorSlot == EntityEquipmentSlot.FEET);
                
                armorModel.isSneak = defaultModel.isSneak;
                armorModel.isRiding = defaultModel.isRiding;
                armorModel.isChild = defaultModel.isChild;
                armorModel.rightArmPose = defaultModel.rightArmPose;
                armorModel.leftArmPose = defaultModel.leftArmPose;

                return armorModel;
            }
        }
        return null;
    }

}
