public class Item {
    String id;
    String name;
    String details;
    Item(String i, String n, String  d){
        this.id=i;
        this.name=n;
        this.details=d;
    }
    
    public String getID(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getDetails(){
        return details;
    }
}