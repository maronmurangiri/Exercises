package LiveCodingSessions.Sept11.demo.service;



import LiveCodingSessions.Sept11.demo.model.Item;
import LiveCodingSessions.Sept11.demo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService{
    ItemRepository itemRepository;


    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
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
       return itemRepository.save(item);
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
        if (itemRepository.existsById(item.getId())){
            return itemRepository.save(item);

        }
        return null;
    }

    @Override
    public boolean deleteItem(Integer itemId) {
        if (itemId== null){
            throw  new IllegalArgumentException("Item id can not be null");
        }

        if (itemRepository.existsById(itemId)){
            itemRepository.deleteById(itemId);
            return true;
        }
        return false;
    }

    @Override
    public Item getItem(Integer itemId) {
        if (itemId== null){
            throw  new IllegalArgumentException("Item id can not be null");
        }

        if (itemRepository.existsById(itemId)){
           return itemRepository.getById(itemId);

        }
        return null;
    }
}
