package be.noah.ritual_magic.block.entity;

import be.noah.ritual_magic.Multiblocks.MultiBlockStructure;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;


public class ModTeleportorEntity extends BlockEntity {
    public boolean MULTIBLOCK_OK = false;
    private static final MultiBlockStructure structure = MultiBlockStructure.getTeleporterStruct();
    public ModTeleportorEntity( BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.MOD_TELEPORTER.get(), pPos, pBlockState);
    }
    public void tick(Level pLevel, BlockPos pPos, BlockState pState){
        int x = pPos.getX();
        int y = pPos.getY();
        int z = pPos.getZ();
        if (pLevel.getGameTime() % 79L == 0L) {
            if (updateStructure(pLevel, x, y, z)) {
                this.MULTIBLOCK_OK = true;
            } else {
                this.MULTIBLOCK_OK = false;
            }
        }

    }
    private boolean updateStructure(Level pLevel, int pX, int pY, int pZ){
        return structure.checkStructure(3,pLevel,pX,pY,pZ);
    }
}
