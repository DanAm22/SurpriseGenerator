package surprise.give;

public class GiveSurpriseAndSing extends AbstractGiveSurprises {
    public GiveSurpriseAndSing(String type, int waitTime){
        super(type,waitTime);
    }

    @Override
    protected void giveWithPassion(){
        System.out.println("Singing a nice song, full of joy and genuine excitement…");
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

        GiveSurpriseAndSing other = (GiveSurpriseAndSing) obj;
        return super.equals(other);
    }
}
