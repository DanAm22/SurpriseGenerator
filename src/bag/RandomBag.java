package bag;

import surprise.ISurprise;

import java.util.Random;

public class RandomBag extends AbstractBag {

    private static Random random = new Random();

    @Override
    public ISurprise takeOut(){
        if(!super.isEmpty()){
            int index = RandomBag.random.nextInt(super.getSurpriseList().size());
            ISurprise surprise = super.getSurpriseList().get(index);
            super.getSurpriseList().remove(surprise);
            return surprise;
        }
        return null;
    }

    @Override
    public String toString(){
        return "RandomBag :" + super.getSurpriseList();
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

        RandomBag other = (RandomBag) obj;
        return super.equals(other);
    }
}
