package surprise;

import java.util.Random;

public final class GatherSurprises {

    private static final String[] types = {"FortuneCookie", "Candies", "MinionToy"};
    private static Random random = new Random();

    private GatherSurprises(){

    }

    public static ISurprise[] gather(int n) {
        ISurprise[] surprises = new ISurprise[n];
        for (int i = 0; i < n; i++) {
            surprises[i] = gather();
        }
        return surprises;
    }

    public static ISurprise gather() {
        int index = GatherSurprises.random.nextInt(GatherSurprises.types.length);
        if (index == 0) {
            return FortuneCookie.generate();
        } else if (index == 1) {
            return Candies.generate();
        } else {
            return MinionToy.generate();
        }
    }

    @Override
    public String toString(){
        return "We can gather this types of surprises: " + types;
    }

}
