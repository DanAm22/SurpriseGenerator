package bag;

import surprise.ISurprise;

public class LIFOBag extends AbstractBag {

    @Override
    public ISurprise takeOut(){
        if(!super.isEmpty()){
            ISurprise surprise = super.getSurpriseList().get(super.getSurpriseList().size() - 1);
            super.getSurpriseList().remove(surprise);
            return surprise;
        }
        return null;
    }

    @Override
    public String toString(){
        return "LIFOBag :" + super.getSurpriseList();
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

        LIFOBag other = (LIFOBag) obj;
        return super.equals(other);
    }
  }
