package LiveCodingSessions.Sept11.demo.service;


import LiveCodingSessions.Sept11.demo.dao.ItemDao;
import LiveCodingSessions.Sept11.demo.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.HashMap;
import java.util.Map;

@Service
public class ItemServiceImpl implements ItemService{
    ItemDao itemDao;


    @Autowired
    public ItemServiceImpl(ItemDao itemDao) {
        this.itemDao = itemDao;
    }

    @Override
    public Item createItem(Item item) {
        if(item.getId()<=0 ){
            throw new IllegalArgumentException("Id cannot be null and less than zero");
        }
        if (item.getItemName()==null || item.getItemName().isBlank()){
            throw new IllegalArgumentException("Item name can neither be blank nor null");
        }
        if (item.getDescription()==null|| item.getDescription().isBlank()){
            throw new IllegalArgumentException("Item description can neither be blank nor null");
        }
        if (item == null){
            throw new IllegalArgumentException("Item can neither be blank nor null");
        }
       return itemDao.createItem(item);
    }

    @Override
    public Item updateItem(Item item) {
        if(item.getId()<=0 ){
            throw new IllegalArgumentException("Id cannot be null and less than zero");
        }
        if (item.getItemName()==null || item.getItemName().isBlank()){
            throw new IllegalArgumentException("Item name can neither be blank nor null");
        }
        if (item.getDescription()==null|| item.getDescription().isBlank()){
            throw new IllegalArgumentException("Item description can neither be blank nor null");
        }
        if (item == null){
            throw new IllegalArgumentException("Item can neither be blank nor null");
        }
        return itemDao.updateItem(item);
    }

    @Override
    public Item deleteItem(Integer itemId) {
        if (itemId== null){
            throw  new IllegalArgumentException("Item id can not be null");
        }

        return itemDao.deleteItem(itemId);
    }

    @Override
    public Item getItem(Integer itemId) {
        if (itemId== null){
            throw  new IllegalArgumentException("Item id can not be null");
        }
        return itemDao.getItem(itemId);
    }
}
