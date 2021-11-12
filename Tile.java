public class Tile extends Plank {
    public Tile(String materialName, int sideLength, double pricePerTile){
        super(materialName, sideLength, sideLength, pricePerTile);
        setType("tile");
    }
}
