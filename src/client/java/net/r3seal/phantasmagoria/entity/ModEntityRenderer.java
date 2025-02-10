package net.r3seal.phantasmagoria.entity;

import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.entity.EntityType;
import net.minecraft.util.Identifier;
import net.r3seal.phantasmagoria.Phantasmagoria;
import net.r3seal.phantasmagoria.entity.ModPigModel;

public class ModEntityRenderer {
    public static final EntityModelLayer MOD_PIG_LAYER = new EntityModelLayer(new Identifier(Phantasmagoria.MOD_ID, "pig"), "main");

    public static void register() {
        EntityRendererRegistry.register(EntityType.PIG, ModPigRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(MOD_PIG_LAYER, () -> ModPigModel.getTexturedModelData(new Dilation(0.0F)));
    }
}
