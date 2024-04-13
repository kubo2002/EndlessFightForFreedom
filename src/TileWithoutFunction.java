import fri.shapesge.Image;

public class TileWithoutFunction extends Tile {
    public TileWithoutFunction(int positionX, int positionY, Image image) {
        super(positionX, positionY, image);
    }

    @java.lang.Override
    public void setTilePosition(int x, int y) {
        super.setTilePosition(x, y);
    }


}
