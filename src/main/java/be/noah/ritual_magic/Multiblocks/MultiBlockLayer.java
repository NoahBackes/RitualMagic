package be.noah.ritual_magic.Multiblocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.List;

public class MultiBlockLayer {
    private Block layer;
    private List<List<Integer>> coords;

    public MultiBlockLayer(Block layer, List<List<Integer>> coords){
        this.layer = layer;
        this.coords = coords;
    }
    public MultiBlockLayer(Block layer){
        this.layer = layer;
        this.coords = new ArrayList<>();
    }
    public boolean checkLayer(Level pLevel, int pX, int pY, int pZ){
        boolean res = true;
        for (int i = 0; i < coords.size(); i++){
            res = res && pLevel.getBlockState(new BlockPos(coords.get(i).get(0) + pX, coords.get(i).get(1) + pY, coords.get(i).get(2) + pZ)).is(layer);
        }
        return res;
    }
    public Block getlayerBlock(){
        return  layer;
    }
    public List<List<Integer>> getCoordsList(){
        return coords;
    }
    public void addCircle(int radius, int offsetX, int offsetY, int offsetZ, int orientation){
        int x = 0;
        int y = 0;
        int z = 0;
        for(int i = 0; i <= radius; i++){
            for(int j = 0; j <= radius; j++){
                if(!isExeption(radius,i,j)) {
                    if (Math.abs((double) radius - Math.sqrt(Math.pow((double) i, 2) + Math.pow((double) j, 2))) <= 0.5) {
                        switch (orientation){
                            case 0:
                                coords.add(List.of(i + offsetX, j + offsetY, offsetZ));
                                coords.add(List.of(-i + offsetX, j + offsetY, offsetZ));
                                coords.add(List.of(i + offsetX, -j + offsetY, offsetZ));
                                coords.add(List.of(-i + offsetX, -j + offsetY, offsetZ));
                                break;
                            case 1:
                                coords.add(List.of(offsetX, y + offsetY, i + offsetZ));
                                coords.add(List.of(offsetX, y + offsetY, -i + offsetZ));
                                coords.add(List.of(offsetX, -y + offsetY, i + offsetZ));
                                coords.add(List.of(offsetX, -y + offsetY, -i + offsetZ));
                                break;
                            case 2:
                                coords.add(List.of(i + offsetX, offsetY, j + offsetZ));
                                coords.add(List.of(-i + offsetX, offsetY, j + offsetZ));
                                coords.add(List.of(i + offsetX, offsetY, -j + offsetZ));
                                coords.add(List.of(-i + offsetX, offsetY, -j + offsetZ));
                                break;
                        }
                    }
                }
            }
        }
    }
    private boolean isExeption(int radius, int x, int y){
        if(radius == 4) {
            if((x == 2 && y == 4) || (x == 4 && y == 2)) {return true;}
        } else if (radius == 6) {
            if(x == 4 && y == 4){return true;}
        }
        return false;
    }
    public void deletePos(List<List<Integer>> list){

    }
    private void deleteDuplicats(){

    }
}
