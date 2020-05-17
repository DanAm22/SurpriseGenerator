package bag;

import surprise.ISurprise;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractBag implements IBag {

    private List<ISurprise> surpriseList = new ArrayList<ISurprise>();

    @Override
    public void put(ISurprise newSurprise){
        this.surpriseList.add(newSurprise);
    }

    @Override
    public void put(IBag bagOfSurprises){
        while(!bagOfSurprises.isEmpty()){
            ISurprise surprise = bagOfSurprises.takeOut();
            this.surpriseList.add(surprise);
        }
    }

    @Override
    public boolean isEmpty(){
        return this.surpriseList.size() == 0;
    }

    @Override
    public int size(){
        return this.surpriseList.size();
    }

    public List<ISurprise> getSurpriseList(){
        return this.surpriseList;
    }

    @Override
    public String toString(){
        return "This bag contains the following surprises: " + this.surpriseList;
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
        AbstractBag other = (AbstractBag) obj;
        return this.surpriseList.equals(other.surpriseList);
    }

    @Override
    public int hashCode(){
        int prime = 31;
        int result = 1;
        result = prime * result + ((this.surpriseList == null) ? 0 : this.surpriseList.hashCode());
        return result;
    }
}
