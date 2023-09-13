package LiveCodingSessions.Sept11.demo.dao;


import LiveCodingSessions.Sept11.demo.model.Item;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ItemDao {
    Map<Integer, Item> itemMap = new HashMap<>();

    public Map<Integer, Item> getItemMap() {
        return itemMap;
    }

    public void setItemMap(Map<Integer, Item> itemMap) {
        this.itemMap = itemMap;
    }


    public Item createItem( Item item) {
        if (itemMap.containsKey(item.getId())){
            throw new IllegalArgumentException("The item exist");
        }
        itemMap.put(item.getId(),item);
        return item;
    }


    public Item updateItem(Item item) {
        if (!itemMap.containsKey(item.getId())){
            throw new IllegalArgumentException("no such item");
        }
        itemMap.replace(item.getId(), item);
        return item;
    }


    public Item deleteItem(Integer itemId) {
        if (!itemMap.containsKey(itemId)){
            throw new IllegalArgumentException("no such item");
        }
        Item item = itemMap.remove(itemId);
        return item;
    }


    public Item getItem(Integer itemId) {
        if (!itemMap.containsKey(itemId)){
            throw new IllegalArgumentException("no such item");
        }
        Item item = itemMap.get(itemId);
        return item;
    }

}
