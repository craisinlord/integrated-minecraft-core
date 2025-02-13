package com.craisinlord.integrated_minecraft.mixin;

import com.craisinlord.integrated_minecraft.IntegratedMinecraft;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.item.armor.ExtendedArmorMaterials;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import org.spongepowered.asm.mixin.Mixin;

import java.lang.reflect.Field;
import java.util.Map;

@Mixin(ExtendedArmorMaterials.class)
public class ExtendedArmorMaterialsMixin {

    static {
        try {
            // Array of the specific materials to update
            ExtendedArmorMaterials[] materialsToUpdate = {
                    ExtendedArmorMaterials.PYROMANCER,
                    ExtendedArmorMaterials.ARCHEVOKER,
                    ExtendedArmorMaterials.CULTIST,
                    ExtendedArmorMaterials.CRYOMANCER,
                    ExtendedArmorMaterials.PRIEST,
                    ExtendedArmorMaterials.SHADOWWALKER,
                    ExtendedArmorMaterials.PLAGUED,
                    ExtendedArmorMaterials.NETHERITE_BATTLEMAGE,
                    ExtendedArmorMaterials.ELECTROMANCER
            };

            // Iterate through the selected materials and update their MAX_MANA
            for (ExtendedArmorMaterials material : materialsToUpdate) {
                // Log the original name before modification

                // Create new attributes map with the updated Max Mana value
                Map<Attribute, AttributeModifier> updatedAttributes = Map.of(
                        (Attribute) AttributeRegistry.MAX_MANA.get(),
                        new AttributeModifier("Max Mana", 75.0D, AttributeModifier.Operation.ADDITION)
                );

                // Use reflection to change the attributes field of the current armor material
                Field attributesField = ExtendedArmorMaterials.class.getDeclaredField("additionalAttributes");
                attributesField.setAccessible(true);
                attributesField.set(material, updatedAttributes);
            }

        } catch (NoSuchFieldException | IllegalAccessException e) {
            IntegratedMinecraft.LOGGER.error("Integrated Minecraft: Error modifying armor materials: ", e);
        }
    }
}