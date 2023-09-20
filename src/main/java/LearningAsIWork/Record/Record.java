package LearningAsIWork.Record;

public record Record() {
    static String name = "Maron";
    public String  getName(){
        return  name;
    }
    public static void main(String[] args){
       // Record record = new Record("maron",20,"2020");
      //  System.out.println(record.getName());
        System.out.println(Record.name);
    }
}
/*public class Record {
    Stri
}*/