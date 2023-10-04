package LiveCodingSessions.Oct2nd.EntityAssociations.dto;

import lombok.Data;

@Data
public class ItemDto {
    private Integer id;
    private String itemName;
    private String description;
    private Integer quantity;
    private Integer categoryId;
}
