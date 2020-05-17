package surprise;

import java.util.Random;

public class Candies implements ISurprise {

    private static Random random = new Random();
    private int noCandies;
    private final static String[] typeList = {"chocolate", "jelly", "fruits", "vanilla",};
    private final String type;
    private final static int noCandiesLimit = 100;

    private Candies(int noCandies, String type) {
        this.noCandies = noCandies;
        this.type = type;
    }

    // Static method used for generating a random Candies
    public static Candies generate() {
        int noCandies = random.nextInt(Candies.noCandiesLimit);
        int noType = random.nextInt(Candies.typeList.length);
        String type = Candies.typeList[noType];
        return new Candies(noCandies, type);
    }

    @Override
    public void enjoy() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "The type of candies is " + this.type + " and there are " + this.noCandies + " candies.";
    }

    // Enjoy method - it will print out the Candies message
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (this.getClass() != obj.getClass()) {
            return false;
        }

        Candies other = (Candies) obj;
        return this.noCandies == other.noCandies && this.type.equals(other.type);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + this.noCandies;
        result = prime * result + ((this.type == null) ? 0 : this.type.hashCode());
        return result;
    }
}
