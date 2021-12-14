package entity;

public class Stuff {
    private String stuffName;
    private String stuffNumber;

    public String getStuffName(){
        return this.stuffName;
    }

    public void setStuffName(String stuffName){
        this.stuffName = stuffName;
    }

    public String getStuffNumber(){
        return this.stuffNumber;
    }

    public void setStuffNumber(String stuffNumber) {
        this.stuffNumber = stuffNumber;
    }

    //constructor
    public Stuff(String stuffName, String stuffNumber){
        this.stuffName = stuffName;
        this.stuffNumber = stuffNumber;
    }
}
