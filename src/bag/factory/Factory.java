package bag.factory;

import bag.FIFOBag;
import bag.IBag;
import bag.LIFOBag;
import bag.RandomBag;

public final class Factory implements IBagFactory {

    private static Factory instance;

    private Factory(){

    }

    public IBag makeBag(String type) {
        if (type.equals("RANDOM")) {
            return new RandomBag();
        } else if (type.equals("LIFO")) {
            return new LIFOBag();
        } else if (type.equals("FIFO")) {
            return new FIFOBag();
        }
        return null;
    }

    public static Factory getInstance(){
        if(Factory.instance == null){
            Factory.instance = new Factory();
        }
        return Factory.instance;
    }

    @Override
    public String toString(){
        return "This is the factory";
    }

}
