
public class TestQuoteTable {
    public static int passed = 0;
    public static int tested = 0;

    public static void main(String[] args) {
        // Testing
        Flooring[] option = new Flooring[3];
        option[0] = new Plank("birch", 12 * 6, 4, 14.95);
        option[1] = new Roll("linoleum", 79, 3.92);
        option[2] = new Plank("oak", 12 * 7, 5, 23.07);
        QuoteTable qt = new QuoteTable(option,750,300,0.15);

        // QuoteTable getCleanestValue
        test(1,"QuoteTable getCleanestValue", qt.getCleanestValue() == 0.007936507936507936);

        // QuoteTable getCheapestValue ****
        test(2,"QuoteTable getCheapestValue", qt.getCheapestValue() == 1352400 || qt.getCheapestValue() == 1352401);

        qt.setLength(510);
        qt.setMarkup(0.12);
        // QuoteTable getCleanestValue 2
        test(3,"QuoteTable getCleanestValue 2", qt.getCleanestValue() == 0.05063291139240506);

        // QuoteTable getCheapestValue 2
        test(4,"QuoteTable getCheapestValue 2", qt.getCheapestValue() == 895642 || qt.getCheapestValue() == 895642);

        // QuoteTable display
        test(5,"QuoteTable display", qt.display().equals("For a floor 42'6'' by 25'\n\nMaterial\tWaste\tCost\n--------\t-----\t----\nplank-birch\t11.45%\t$10046.41\nroll-linoleum\t5.06%\t$8956.42 Eco $$\nplank-oak\t10.71%\t$10542.07\n") ||
                qt.display().equals("For a floor 42'6'' by 25'\n\nMaterial\tWaste\tCost\n--------\t-----\t----\nplank-birch\t11.45%\t$10046.40\nroll-linoleum\t5.06%\t$8956.42 Eco $$\nplank-oak\t10.71%\t$10542.07\n"));

        option = new Flooring[6];
        option[0] = new Plank("oak", 12 * 8, 4, 25.30);
        option[1] = new Plank("birch", 12 * 7, 5, 16.90);
        option[2] = new Tile("ceramic", 12, 1.33);
        option[3] = new Tile("porcelain", 8, 1.28);
        option[4] = new Roll("linoleum", 140, 6.92);
        option[5] = new Roll("vinyl", 12 * 12, 1.19146);
        qt.setOptions(option);
        // QuoteTable display 2
        //test(6,"QuoteTable display 2", qt.display().equals("For a floor 42'6'' by 25'\n\nMaterial\tWaste\tCost\n--------\t-----\t----\nplank-oak\t11.45%\t$12751.20\nplank-birch\t10.71%\t$7722.63\ntile-ceramic\t1.16%\t$1601.33`Eco`$$\ntile-porcelain\t1.70%\t$3486.52\nroll-linoleum\t8.92%\t$9300.49\nroll-vinyl\t11.45%\t$1601.33`$$\n"));
        String[] pat = {"For a floor 42'6'' by 25'\n\nMaterial\tWaste\tCost\n--------\t-----\t----\nplank-oak\t11.45%\t$12751.2",
                "\nplank-birch\t10.71%\t$7722.63\ntile-ceramic\t1.16%\t$1601.3",
                " Eco $$\ntile-porcelain\t1.70%\t$3486.52\nroll-linoleum\t8.92%\t$9300.4",
                "\nroll-vinyl\t11.45%\t$1601.33"};

        String display = qt.display();
        test(6,"QuoteTable display 2*", display.contains(pat[0]) && display.contains(pat[1]) && display.contains(pat[1]) && display.contains(pat[1]));
        System.out.println("Your code scored: "+passed+" / "+tested);
    }

    public static void test(int testNumber, String message, boolean testStatus) {
        tested++;
        System.out.println("Test " + testNumber + " (" + message + ") " + (testStatus ? "passed" : "failed"));
        if (testStatus)
            passed++;
    }
}