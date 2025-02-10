package net.r3seal.phantasmagoria.entity;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.entity.EntityType;

public class ModEntityRenderer {
    public static void register() {
        EntityRendererRegistry.register(EntityType.PIG, ModPigRenderer::new);
    }
}
