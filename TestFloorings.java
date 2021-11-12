public class TestFloorings {
    public static int passed=0;
    public static int tested=0;

    public static void main(String[] args) {
        //Testing

        Flooring f1 = new Flooring("resin",0.04);
        // Flooring toString
        test(1,"Flooring toString", f1.toString().equals("Flooring-poured resin @0.04 sq. in"));

        // Flooring amountOfMaterial
        test(2,"Flooring amountOfMaterial", f1.amountOfMaterial(120,500) == 60000);

        // Flooring quoteCents
        test(3,"Flooring quoteCents", f1.quoteCents(120,500,0.1) == 264000);

        String feetTest = Flooring.toFeet(73)+" "+Flooring.toFeet(7)+" "+Flooring.toFeet(36);
        // Flooring toFeet
        test(4,"Flooring toFeet", feetTest.equals("6'1'' 7'' 3'"));

        Roll r1 = new Roll("linoleum", 12 * 12, 3.29);
        // Roll subclass
        test(5,"Roll subclass", r1 instanceof Flooring);

        // Roll toString
        test(6,"Roll toString", r1.toString().equals("Flooring-roll linoleum @3.29 per inch of a 12' roll"));

        // Roll amountOfMaterial
        test(7,"Roll amountOfMaterial", r1.amountOfMaterial(120,500) == 69120);

        // Roll unusedMaterial
        test(8,"Roll unusedMaterial", r1.unusedMaterial(500,17) == 1292);

        // Roll wasteRatio
        test(9,"Roll wasteRatio", r1.wasteRatio(500,17) == 0.13194444444444445);

        Plank p1 = new Plank("oak",12*8, 5,21.02);
        // Plank toString
        test(10,"Plank toString", p1.toString().equals("Flooring-plank oak @21.02 per 8' by 5''"));

        // Plank amountOfMaterial
        test(11,"Plank amountOfMaterial", p1.amountOfMaterial(120,500) == 69120);

        // Plank unusedMaterial
        test(12,"Plank unusedMaterial", p1.unusedMaterial(500,17) == 3020);

        // Plank wasteRatio
        test(13,"Plank wasteRatio", p1.wasteRatio(500,17) == 0.2621527777777778);

        Tile t1 = new Tile("ceramic", 12, 3.50);
        // Tile toString
        test(14,"Tile toString", t1.toString().equals("Flooring-tile ceramic @3.5 per 1' by 1'"));

        // Tile subclass
        test(15,"Tile subclass", t1 instanceof Flooring && t1 instanceof Plank);

        // Tile amountOfMaterial
        test(16,"Tile amountOfMaterial", t1.amountOfMaterial(120,500) == 60480);


        System.out.println("Your code scored: "+passed+" / "+tested);
    }

    public static void test(int testNumber, String message, boolean testStatus) {
        tested++;
        System.out.println("Test "+testNumber+" ("+message+") "+(testStatus?"passed":"failed"));
        if(testStatus) passed++;
    }
}
