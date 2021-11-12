public class QuoteTable {
    private Flooring[] option;
    private int lengthInch;
    private int widthInch;
    private double markup;

    public QuoteTable(Flooring[] option, int lengthInch, int widthInch, double markup) {
        this.option = option;
        this.lengthInch = lengthInch;
        this.widthInch = widthInch;
        this.markup = markup;
    }

    public void setOptions(Flooring[] option){
        this.option = option;
    }
    public void setLength(int lengthInch){
        this.lengthInch = lengthInch;
    }
    public void setWidth(int widthInch){
        this.widthInch = widthInch;
    }
    public void setMarkup(double markup){
        this.markup = markup;
    }

    // loop through each option (varOption), and if its quoteCent method is lower than the previously lowest price...
    // it sets minValue to the quoteCents value of that option, once all options have been tested, it returns minValue;
    public int getCheapestValue(){
        int minValue = Integer.MAX_VALUE;
        for (Flooring varOption : option){
            int quoteCents = varOption.quoteCents(lengthInch, widthInch, markup);
            if (quoteCents < minValue) {
                minValue = quoteCents;
            }
        }
        return minValue;
    }

    // same logic as getCheapestValue, just with wasteRatio instead of quoteCents.
    public double getCleanestValue(){
        double minValue = Double.MAX_VALUE;
        for (Flooring varOption : option){
            double wasteRatio = varOption.wasteRatio(lengthInch, widthInch);
            if (wasteRatio < minValue) {
                minValue = wasteRatio;
            }
        }
        return minValue;
    }

    private static String displayHundredths(int hundredths) {
        return hundredths / 100 + "." + (hundredths / 10 % 10) + "" + hundredths % 10;
    }

    public String display() {
        String out = "For a floor " + Flooring.toFeet(lengthInch) + " by " + Flooring.toFeet(widthInch) + "\n\n";

        int cheapestValue = getCheapestValue();
        double cleanestValue = getCleanestValue();

        out += "Material\tWaste\tCost\n";
        out += "--------\t-----\t----\n";
        for (int i = 0; i < option.length; i++) {
            double waste = option[i].wasteRatio(lengthInch, widthInch);
            int cost = option[i].quoteCents(lengthInch, widthInch, markup);

            out += option[i].getType() + "-";
            out += option[i].getMaterial() + "\t";
            out += displayHundredths((int) (10000 * waste)) + "%\t";
            out += "$" + displayHundredths(cost);
            if (waste == cleanestValue)
                out += " Eco";
            if (cost == cheapestValue)
                out += " $$";
            out += "\n";
        }
        return out;
    }
}



