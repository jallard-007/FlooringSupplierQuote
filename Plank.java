public class Plank extends Flooring {
    private final int plankLengthInch;
    private final int plankWidthInch;
    private final double plankPrice;

    // we must divide the plank price by its dimensions to get its price per square inch.
    public Plank(String materialName, int plankLengthInch, int plankWidthInch, double plankPrice){
        super(materialName, plankPrice/(plankLengthInch*plankWidthInch));
        setType("plank");
        this.plankWidthInch = plankWidthInch;
        this.plankLengthInch = plankLengthInch;
        this.plankPrice = plankPrice;
    }

    // similar to roll amount of material, but we also need to take into account the fact that the length of the plank is set.
    // therefore, we must divide both the length and width by the plank's length and width, take the ceiling of those, and multiply by the corresponding plank dimension...
    // flip the length and width, repeat, then return whichever is lower.
    public int amountOfMaterial(int roomLength, int roomWidth){
        int plankAreaWidthWise = (int) (Math.ceil((double)roomLength / plankWidthInch) * plankWidthInch * Math.ceil((double)roomWidth/plankLengthInch) * plankLengthInch);
        int plankAreaLengthWise = (int) (Math.ceil((double)roomWidth / plankWidthInch) * plankWidthInch * Math.ceil((double)roomLength/plankLengthInch) * plankLengthInch);
        return Math.min(plankAreaWidthWise, plankAreaLengthWise);
    }

    public int unusedMaterial(int roomLength, int roomWidth){
        return amountOfMaterial(roomLength, roomWidth) - super.amountOfMaterial(roomLength, roomWidth);
    }

    public String toString(){
        return "Flooring-" + getType() + " " + getMaterial() + " @" + plankPrice + " per " + toFeet(plankLengthInch) + " by " + toFeet(plankWidthInch);
    }
}
