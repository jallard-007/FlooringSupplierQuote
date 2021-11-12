public class Roll extends Flooring{
    private final int rollWidthInch;
    private final double rollPricePerInch;

    // pricePerSqrInch is equal to rollPricePerInch divided by rollWidthInch...
    // because rollPricePerInch is the price of 1 inch by the whole width of the roll...
    // therefore to get pricePerSqrInch we have to divide out the width of the roll to reduce the price to one square inch
    public Roll(String materialName, int rollWidthInch, double rollPricePerInch){
        super(materialName, rollPricePerInch/rollWidthInch);
        setType("roll");
        this.rollWidthInch = rollWidthInch;
        this.rollPricePerInch = rollPricePerInch;
    }

    // we have to find the area of roll when rolled both length wise and width wise.
    // divide length or width by the width of the roll, and take the ceiling to get the number of rolls needed.
    // then multiply by the width of the roll and the other room measurement to get the area of the roll.
    // then return the lower value.
    public int amountOfMaterial(int roomLength, int roomWidth){
        int areaRolledWidthWise = (int) Math.ceil((double)roomLength / rollWidthInch) * rollWidthInch * roomWidth;
        int areaRolledLengthWise = (int) Math.ceil((double)roomWidth / rollWidthInch) * rollWidthInch * roomLength;
        return Math.min(areaRolledWidthWise, areaRolledLengthWise);
    }

    public int unusedMaterial(int roomLength, int roomWidth) {
        return amountOfMaterial(roomLength, roomWidth) - super.amountOfMaterial(roomLength, roomWidth);
    }

    public String toString(){
        return ("Flooring-" + getType() + " " + getMaterial() + " @" + rollPricePerInch + " per inch of a 12' roll");
    }
}

