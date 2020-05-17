package surprise.give;

public class GiveSurpriseAndApplause extends AbstractGiveSurprises {


    public GiveSurpriseAndApplause(String type, int waitTime){
        super(type,waitTime);
    }

    @Override
    protected void giveWithPassion(){
        System.out.println("Loud applause to you… For it is in giving that we receive.");
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

        GiveSurpriseAndApplause other = (GiveSurpriseAndApplause) obj;
        return super.equals(other);
    }


}
