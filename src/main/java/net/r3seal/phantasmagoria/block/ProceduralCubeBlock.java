package net.r3seal.phantasmagoria.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.AbstractBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;

public class ProceduralCubeBlock extends Block {
    // Define property (values 1, 2, or 3)
    public static final IntProperty VARIANT = IntProperty.of("variant", 1, 3);

    public ProceduralCubeBlock(AbstractBlock.Settings settings) {
        super(settings);
        // Set default state with variant = 1
        this.setDefaultState(this.stateManager.getDefaultState().with(VARIANT, 1));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(VARIANT); // Register property in state manager
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
        if (!world.isClient) {
            int randomVariant = world.getRandom().nextInt(3) + 1; // 1, 2, or 3
            world.setBlockState(pos, state.with(VARIANT, randomVariant), 2);
        }
        super.onPlaced(world, pos, state, placer, itemStack);
    }
}
