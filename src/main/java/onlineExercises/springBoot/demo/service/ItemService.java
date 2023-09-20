package onlineExercises.springBoot.demo.service;

import onlineExercises.springBoot.demo.model.Item;

public interface ItemService {

    Item createItem(Item item);


    Item updateItem(Item item);

    Item deleteItem(int itemId);

    Item getItem(int itemId);

}
