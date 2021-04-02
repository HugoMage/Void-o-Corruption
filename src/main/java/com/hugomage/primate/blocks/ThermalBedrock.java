package com.hugomage.primate.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.particles.BasicParticleType;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import java.util.Random;

public class ThermalBedrock extends Block implements IWaterLoggable {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final BooleanProperty LIT = BlockStateProperties.LIT;
    private static final DirectionProperty FACING = HorizontalBlock.HORIZONTAL_FACING;
    private static VoxelShape SHAPE_N = VoxelShapes.combineAndSimplify(Block.makeCuboidShape(2, 0, 2, 14, 14, 14), Block.makeCuboidShape(4, 14, 4, 12, 29, 12), IBooleanFunction.OR);
    private static VoxelShape SHAPE_S = VoxelShapes.combineAndSimplify(Block.makeCuboidShape(2, 0, 2, 14, 14, 14), Block.makeCuboidShape(4, 14, 4, 12, 29, 12), IBooleanFunction.OR);
    private static VoxelShape SHAPE_W = VoxelShapes.combineAndSimplify(Block.makeCuboidShape(2, 0, 2, 14, 14, 14), Block.makeCuboidShape(4, 14, 4, 12, 29, 12), IBooleanFunction.OR);
    private static VoxelShape SHAPE_E = VoxelShapes.combineAndSimplify(Block.makeCuboidShape(2, 0, 2, 14, 14, 14), Block.makeCuboidShape(4, 14, 4, 12, 29, 12), IBooleanFunction.OR);
    public ThermalBedrock() {
        super(Properties.create(Material.ROCK)
                .setRequiresTool()
                .harvestTool(ToolType.PICKAXE)
                .harvestLevel(310)
                .sound(SoundType.STONE)
                .hardnessAndResistance(100.0F,100.0f)

        );


    }
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        boolean flag = false;
        return this.getDefaultState().with(WATERLOGGED, false).with(FACING, context.getPlacementHorizontalFacing().getOpposite());
    }


    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.with(FACING, rot.rotate(state.get(FACING)));
    }


    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(FACING)));
    }

    @Override
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        {
            Random random = worldIn.getRandom();
            BasicParticleType basicparticletype = ParticleTypes.CAMPFIRE_COSY_SMOKE;
            worldIn.addOptionalParticle(basicparticletype, true, (double)pos.getX() + 0.5D + random.nextDouble() / 3.0D * (double)(random.nextBoolean() ? 1 : -1), (double)pos.getY() + 1.0D + random.nextDouble() + random.nextDouble(), (double)pos.getZ() + 0.5D + random.nextDouble() / 3.0D * (double)(random.nextBoolean() ? 1 : -1), 0.0D, 0.07D, 0.0D);
             {
                worldIn.addParticle(ParticleTypes.SMOKE, (double)pos.getX() + 0.25D + random.nextDouble() / 2.0D * (double)(random.nextBoolean() ? 1 : -1), (double)pos.getY() + 1.5D, (double)pos.getZ() + 0.25D + random.nextDouble() / 2.0D * (double)(random.nextBoolean() ? 1 : -1), 0.0D, 0.005D, 0.0D);
            }

        }
    }

   @Override
   public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        switch (state.get(FACING)) {
            case SOUTH:
                return SHAPE_S;
            case WEST:
                return SHAPE_W;
            case EAST:
                return SHAPE_E;
            default:
                return SHAPE_N;
        }
   }


    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED);
    }

    public static void spawnSmokeParticles(World worldIn, BlockPos pos, boolean isSignalFire, boolean spawnExtraSmoke) {
        Random random = worldIn.getRandom();
        BasicParticleType basicparticletype = ParticleTypes.CAMPFIRE_COSY_SMOKE;
        worldIn.addOptionalParticle(basicparticletype, true, (double)pos.getX() + 0.5D + random.nextDouble() / 3.0D * (double)(random.nextBoolean() ? 1 : -1), (double)pos.getY() + random.nextDouble() + random.nextDouble(), (double)pos.getZ() + 0.5D + random.nextDouble() / 3.0D * (double)(random.nextBoolean() ? 1 : -1), 0.0D, 0.07D, 0.0D);
        if (spawnExtraSmoke) {
            worldIn.addParticle(ParticleTypes.SMOKE, (double)pos.getX() + 0.25D + random.nextDouble() / 2.0D * (double)(random.nextBoolean() ? 1 : -1), (double)pos.getY() + 0.4D, (double)pos.getZ() + 0.25D + random.nextDouble() / 2.0D * (double)(random.nextBoolean() ? 1 : -1), 0.0D, 0.005D, 0.0D);
        }

    }
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStillFluidState(false) : super.getFluidState(state);
    }
}
