package surprise;

public class MinionToy implements ISurprise {

    private final static String[] nameList = {"Dave", "Carl", "Kevin", "Stuart", "Jerry", "Tim"};
    private final String name;
    private static int counter;

    private MinionToy(String name){
        this.name = name;
    }

    // Static method used for generating a random MinionToy
    public static MinionToy generate(){
        if(MinionToy.counter == MinionToy.nameList.length - 1){
            MinionToy.counter = 0;
        }
        return new MinionToy(MinionToy.nameList[MinionToy.counter++]);
    }

    // Enjoy method - it will print out the MinionToy's message
    @Override
    public void enjoy() {
        System.out.println(this);
    }

    @Override
    public String toString(){
        return "This minion's name is " + this.name;
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

        MinionToy other = (MinionToy) obj;
        return this.name.equals(other.name);
    }

    @Override
    public int hashCode(){
        int prime = 31;
        int result = 1;
        result = prime * result + ((this.name == null) ? 0 : this.hashCode());
        return result;
    }
}
