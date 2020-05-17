package surprise.give;

import bag.IBag;
import bag.factory.Factory;
import surprise.ISurprise;

import java.util.concurrent.TimeUnit;

public abstract class AbstractGiveSurprises {

    private static Factory factory = Factory.getInstance();
    private IBag bagOfSurprises;
    private int waitTime;

    public AbstractGiveSurprises(String type, int waitTime) {
        this.bagOfSurprises = factory.makeBag(type);
        this.waitTime = waitTime;
    }

    public void put(ISurprise newSurprise) {
        this.bagOfSurprises.put(newSurprise);
    }

    public void put(IBag bagOfSurprises) {
        this.bagOfSurprises.put(bagOfSurprises);
    }

    public void give() {
        ISurprise surprise = this.bagOfSurprises.takeOut();
        surprise.enjoy();
        giveWithPassion();
        System.out.println();
    }

    public void giveAll() {
        while (!this.bagOfSurprises.isEmpty()) {
            ISurprise surprise = this.bagOfSurprises.takeOut();
            surprise.enjoy();
            giveWithPassion();
            System.out.println();
            try {
                TimeUnit.SECONDS.sleep(10); // number of seconds to sleep
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isEmpty() {
        return this.bagOfSurprises.isEmpty();
    }

    protected abstract void giveWithPassion();

    @Override
    public String toString(){
        return this.bagOfSurprises.toString();
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }

        if(obj == null){
            return false;
        }

        if(this.getClass() != obj.getClass()){
            return false;
        }

        AbstractGiveSurprises other = (AbstractGiveSurprises) obj;
        return this.bagOfSurprises.equals(other.bagOfSurprises) && this.waitTime == other.waitTime;
    }

    @Override
    public int hashCode(){
        int prime = 31;
        int result = 1;
        result = prime * result + ((this.bagOfSurprises == null) ? 0 : this.bagOfSurprises.hashCode());
        result = prime * result + this.waitTime;
        return result;
    }
}
