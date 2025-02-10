package net.r3seal.phantasmagoria.entity;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.PigEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.util.Identifier;

import java.util.Random;

public class ModPigRenderer extends PigEntityRenderer {
    private static final Identifier[] TEXTURES = new Identifier[]{
            new Identifier("phantasmagoria", "textures/entity/pig/texture1.png"),
            new Identifier("phantasmagoria", "textures/entity/pig/texture2.png"),
            new Identifier("phantasmagoria", "textures/entity/pig/texture3.png")
    };

    private final Random random;

    public ModPigRenderer(EntityRendererFactory.Context context) {
        super(context);
        this.random = new Random();
    }

    // Use the entity's UUID to choose a consistent random state for that entity's texture
    @Override
    public Identifier getTexture(PigEntity entity) {
        random.setSeed(entity.getUuid().getMostSignificantBits() ^ entity.getUuid().getLeastSignificantBits());

        // Randomly choose a texture based on the entity's UUID for uniqueness
        int textureIndex = random.nextInt(TEXTURES.length);
        return TEXTURES[textureIndex];
    }

    // Use the entity's UUID to choose a consistent random state for that entity's size
    @Override
    public void scale(PigEntity entity, MatrixStack matrices, float partialTicks) {
        super.scale(entity, matrices, partialTicks);
        random.setSeed(entity.getUuid().getMostSignificantBits() ^ entity.getUuid().getLeastSignificantBits());

        // Randomly choose a size based on the entity's UUID for uniqueness
        float scale = 1.0F + (random.nextFloat() - 0.5F); // ±50% size variation
        matrices.scale(scale, scale, scale);
    }
}