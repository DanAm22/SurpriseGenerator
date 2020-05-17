package bag;

import surprise.ISurprise;

public class FIFOBag extends AbstractBag {

    @Override
    public ISurprise takeOut(){
        if(!super.isEmpty()){
            ISurprise surprise = super.getSurpriseList().get(0);
            super.getSurpriseList().remove(surprise);
            return surprise;
        }
        return null;
    }

    @Override
    public String toString(){
        return "FIFOBag :" + super.getSurpriseList();
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

        FIFOBag other = (FIFOBag) obj;
        return super.equals(other);
    }

}
