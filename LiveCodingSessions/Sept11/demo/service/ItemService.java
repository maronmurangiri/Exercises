package LiveCodingSessions.Sept11.demo.service;


import LiveCodingSessions.Sept11.demo.model.Item;

public interface ItemService {

    Item createItem(Item item);


    Item updateItem(Item item);

    Item deleteItem(Integer itemId);

    Item getItem(Integer itemId);

}
