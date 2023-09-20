package onlineExercises.springBoot.demo.service;

import onlineExercises.springBoot.demo.model.Item;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ItemServiceImpl implements ItemService{
    Map<Integer,Item> itemMap = new HashMap<>();

    public Map<Integer, Item> getItemMap() {
        return itemMap;
    }

    public void setItemMap(Map<Integer, Item> itemMap) {
        this.itemMap = itemMap;
    }

    @Override
    public Item createItem( Item item) {
       itemMap.put(item.getId(),item);
       return item;
    }

    @Override
    public Item updateItem(Item item) {
     itemMap.replace(item.getId(), item);
        return item;
    }

    @Override
    public Item deleteItem(int itemId) {
        Item item = itemMap.remove(itemId);
        return item;
    }

    @Override
    public Item getItem(int itemId) {
        Item item = itemMap.remove(itemId);
        return item;
    }
}
