package LiveCodingSessions.Sept11.demo.controller;


import LiveCodingSessions.Sept11.demo.model.Item;
import LiveCodingSessions.Sept11.demo.service.ItemServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ItemController {

    ItemServiceImpl itemService;
    private ModelMapper modelMapper;


    @Autowired
    public ItemController(ItemServiceImpl itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/post/item")
    public ResponseEntity<?> createItem(@RequestBody Item item){
        try {
            return ResponseEntity.ok(itemService.createItem(item));
        }
        catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/put/item")
    public ResponseEntity<?> updateItem(@RequestBody Item item){
        try {
            return ResponseEntity.ok(itemService.updateItem(item)+"mmmm");
        }
        catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @DeleteMapping("/delete/item/{id}")
    public ResponseEntity<?> deleteItem(@PathVariable("id") Integer id){
        try {
            return ResponseEntity.ok(itemService.deleteItem(id));
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/get/item/{id}")
    public ResponseEntity<?> getItem(@PathVariable("id") Integer id){
        try{
            return ResponseEntity.ok(itemService.getItem(id));
        }
        catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
/*
@RestController
public class ItemController {

    @Autowired
    ItemServiceImpl itemServiceimpl;

    @PostMapping("/post/item")
    public ResponseEntity<?> createItem(@RequestBody Item item){
        try {
            Item item1 = itemServiceimpl.createItem(item);
            return ResponseEntity.ok("Item "+item1.getItemName()+" successfully created");
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }


    }

    @PutMapping("/put/item")
    public ResponseEntity<?> updateItem(@RequestBody Item item){
        try {
            Item item1 = itemServiceimpl.updateItem(item);
            return ResponseEntity.ok("Item name updated successfully to" + item1.getItemName());
        }catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/item/{itemId}")
    public ResponseEntity<?> deleteItem(@PathVariable("itemId") int itemId){
        try {
            boolean state = itemServiceimpl.deleteItem(itemId);
            if (state){
                return ResponseEntity.ok("Item id "+itemId+"  deleted successfully");
            }
            else {
                return ResponseEntity.internalServerError().body("not deleted");
            }

        }catch (IllegalArgumentException e) {

            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("/get/items/{itemId}")
    public ResponseEntity<?> getItems(@PathVariable("itemId") Integer itemId){
       try {
           Item item = itemServiceimpl.getItem(itemId);
           return ResponseEntity.ok(item);
       }catch (IllegalArgumentException e) {

           return ResponseEntity.badRequest().body(e.getMessage());
       }
    }
}*/
