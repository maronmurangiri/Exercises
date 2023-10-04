package LiveCodingSessions.Oct2nd.EntityAssociations.service;


import LiveCodingSessions.Oct2nd.EntityAssociations.dto.ItemDto;
import LiveCodingSessions.Oct2nd.EntityAssociations.model.Category;
import LiveCodingSessions.Oct2nd.EntityAssociations.model.Item;

import java.util.List;

public interface ItemService {
    Item createItem(Item item);
    Item updateItem(Item item);
    boolean deleteItem(Integer itemId);
    Item getItem(Integer itemId);

    Category createCategory(Category category);
    public List<Category> getAllCategories();
    public List<Item> getItemsByCategoryId(Integer categoryId);


     Item convertToEntity(ItemDto itemDto);

    ItemDto convertToDto(Item item);



}
/*
public interface ItemService {

    Item createItem(Item item);


    Item updateItem(Item item);

    boolean deleteItem(Integer itemId);

    Item getItem(Integer itemId);

}*/
