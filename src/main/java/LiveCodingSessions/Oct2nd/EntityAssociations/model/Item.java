package LiveCodingSessions.Oct2nd.EntityAssociations.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Item{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String itemName;
    private String description;
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId")
    private Category category;
    String createdBy;
    Timestamp createdOn;
    String updatedBy;
    String updatedOn;

    public Item() {
    }

    public Item(Integer id, String itemName, String description, int quantity, String createdBy, Timestamp createdOn, String updatedBy, String updatedOn) {
        this.id = id;
        this.itemName = itemName;
        this.description = description;
        this.quantity = quantity;
        this.createdBy = createdBy;
        this.createdOn = createdOn;
        this.updatedBy = updatedBy;
        this.updatedOn = updatedOn;
    }
}
/*@Entity
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String itemName;
    private  String description;
    private  int quantity;
    String createdBy;
    Timestamp createdOn;
    String updatedBy;
    Timestamp updatedOn;

    public Item(Integer id, String itemName, String description) {
        this.id = id;
        this.itemName = itemName;
        this.description = description;
    }

    public Item() {
    }

}*/
