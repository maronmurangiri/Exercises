package LiveCodingSessions.Sept11.demo.service;


import LiveCodingSessions.Sept11.demo.model.Item;
import LiveCodingSessions.Sept11.demo.repository.ItemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.format.DateTimeFormatter;

@Service
public class ItemServiceImpl implements ItemService {
    ItemRepository itemRepository;

    Timestamp currentTimestamp = Timestamp.from(Instant.now());
    String pattern = "yyyy-MM-dd HH:mm:ss";

    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
    String formattedTimestamp = currentTimestamp.toLocalDateTime().format(dateTimeFormatter);
    Timestamp currentTimestampFormatted = Timestamp.valueOf(formattedTimestamp);

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    private ModelMapper modelMapper;


    @Override
    public Item createItem(Item item) {
        if (item.getItemName().isBlank() || item.getItemName() == null) {
            throw new IllegalArgumentException("Item name can neither be null nor blank");
        }
        if (item.getCreatedBy().isBlank() || item.getCreatedBy() == null) {
            throw new IllegalArgumentException("Item created by field cannot be null nor blank");
        }
        if (item.getDescription().isBlank() || item.getDescription() == null) {
            throw new IllegalArgumentException("Item description can neither be null nor blank");
        }
        if (item.getQuantity() < 0 || item.getQuantity() == null) {
            throw new IllegalArgumentException("Item quantity can neither be less than zero nor null");
        }
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        item.setCreatedOn(currentTimestampFormatted);
        return itemRepository.save(item);

    }

    @Override
    public Item updateItem(Item item) {
        if (itemRepository.existsById(item.getId())) {
            return itemRepository.save(item);
        }
        return null;
    }

    @Override
    public boolean deleteItem(Integer itemId) {
        if (itemRepository.existsById(itemId)) {
            itemRepository.deleteById(itemId);
            return true;
        }
        return false;
    }

    @Override
    public Item getItem(Integer itemId) {
        if (itemRepository.existsById(itemId)) {
            return itemRepository.getById(itemId);
        }
        return null;
    }
}
/*
@Service
public class ItemServiceImpl implements ItemService{
    ItemRepository itemRepository;

    LocalDate currentDate = LocalDate.now();

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
        item.setCreatedOn(currentDate);
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
*/