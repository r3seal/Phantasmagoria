package net.r3seal.phantasmagoria.entity;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.model.Dilation;
import net.minecraft.client.render.entity.model.PigEntityModel;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.util.math.MathHelper;
import java.util.Random;

public class ModPigModel extends PigEntityModel<PigEntity> {
    private final Random random = new Random();

    public ModPigModel(ModelPart root) {
        super(root);
    }

    @Override
    public void animateModel(PigEntity entity, float limbAngle, float limbDistance, float tickDelta) {
        super.animateModel(entity, limbAngle, limbDistance, tickDelta);

        // Generate a random but consistent seed based on the entity's UUID
        long seed = entity.getUuid().getMostSignificantBits() ^ entity.getUuid().getLeastSignificantBits();
        random.setSeed(seed);

        // Random stretched head
        float stretchX = 1.0F + (random.nextFloat() * 3.0F - 2F);
        float stretchY = 1.0F + (random.nextFloat() * 3.0F - 2F);
        float stretchZ = 1.0F + (random.nextFloat() * 3.0F - 2F);

        head.xScale = stretchX;
        head.yScale = stretchY;
        head.zScale = stretchZ;

        // Legs flipped upside down
        if (random.nextBoolean()) {
            leftFrontLeg.roll = (float) Math.PI; // Flips the leg upside-down
        }
        if (random.nextBoolean()) {
            rightFrontLeg.roll = (float) Math.PI;
        }
        if (random.nextBoolean()) {
            leftHindLeg.roll = (float) Math.PI;
        }
        if (random.nextBoolean()) {
            rightHindLeg.roll = (float) Math.PI;
        }
    }

    public static TexturedModelData getTexturedModelData(Dilation dilation) {
        return PigEntityModel.getTexturedModelData(dilation);
    }
}

