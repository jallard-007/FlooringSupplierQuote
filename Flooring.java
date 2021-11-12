public class Flooring {
    private String type;
    private final String materialName;
    private final double pricePerSqInch;

    public Flooring(String materialName, double pricePerSqInch) {
        this.materialName = materialName;
        this.pricePerSqInch = pricePerSqInch;
        this.type = "poured";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMaterial() {
        return materialName;
    }

    public double getPricePerSqInch() {
        return pricePerSqInch;
    }

    public int amountOfMaterial(int roomLength, int roomWidth) {
        return (roomLength * roomWidth);
    }

    // to get a quote, we multiply the amount of material by the price per square inch,
    // then multiply by 100 to convert to cents,
    // then multiply by 1 + the markup to factor in the contractors additional charge
    public int quoteCents(int roomLength, int roomWidth, double markup) {
        return (int) Math.ceil(amountOfMaterial(roomLength, roomWidth) * getPricePerSqInch() * 100 * (1 + markup));
    }

    // since there are three different output configurations (only inches, only feet, both feet and inches)...
    // we can create three separate return lines that account for each one. we could have also created a string variable...
    // that adds the feet and inches along with ' or '' and then return that variable:
    //
    // String out = "";
    // if (inches/12 > 0){out += inches/12 + "'";}
    // if (inches%12 != 0){out += inches%12 + "''";}
    // return out;
    //
    public static String toFeet(int inches) {
        if (inches < 12){
            return inches + "''";
        }
        if (inches%12 == 0) {
            return (inches / 12 + "'");
        }
        return (inches/12 + "'" + inches%12 + "''");
    }

    // there is no waste when using a poured type, therefore 0 unused material.
    // we need to have this method in here even thought it seems useless...
    // because the method wasteRatio would not work without it.
    public int unusedMaterial(int roomLength, int roomWidth) {
        return 0;
    }

    public double wasteRatio(int roomLength, int roomWidth) {
        return (double)unusedMaterial(roomLength, roomWidth) / amountOfMaterial(roomLength, roomWidth);
    }

    public String toString() {
        return ("Flooring-" + getType() + " " +materialName+" @"+pricePerSqInch+" sq. in");
    }
}

