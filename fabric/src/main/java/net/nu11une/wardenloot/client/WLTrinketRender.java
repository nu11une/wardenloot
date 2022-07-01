package net.nu11une.wardenloot.client;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.client.TrinketRenderer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3f;
import net.nu11une.wardenloot.register.WLTrinketItems;

public class WLTrinketRender implements TrinketRenderer {

    @Override
    public void render(ItemStack itemStack, SlotReference slotReference, EntityModel<? extends LivingEntity> entityModel, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int light, LivingEntity livingEntity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        if (livingEntity instanceof AbstractClientPlayerEntity player) {
            PlayerEntityModel<AbstractClientPlayerEntity> model = (PlayerEntityModel<AbstractClientPlayerEntity>) entityModel;
            ItemStack stack = new ItemStack(WLTrinketItems.WARDEN_EARS_TRINKET);
            if (!player.isInSwimmingPose() && !player.isFallFlying()) {
                if (player.isInSneakingPose() && !model.riding) {
                    matrixStack.translate(0.0, 0.25, 0.0);
                }
                matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(headYaw));
                matrixStack.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(headPitch));
            } else {
                matrixStack.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(model.head.roll));
                matrixStack.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(headYaw));
                matrixStack.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(-45.0F));
            }

            matrixStack.translate(0.0, 0.8,  0);
            MinecraftClient.getInstance().getItemRenderer().renderItem(stack, ModelTransformation.Mode.HEAD, light, OverlayTexture.DEFAULT_UV, matrixStack, vertexConsumerProvider, 0);
        }
    }
}
