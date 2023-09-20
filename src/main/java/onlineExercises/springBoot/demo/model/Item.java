package onlineExercises.springBoot.demo.model;

public class Item {
    private int id;
    private String itemName;
    private  String description;

    public Item(int id, String itemName, String description) {
        this.id = id;
        this.itemName = itemName;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
