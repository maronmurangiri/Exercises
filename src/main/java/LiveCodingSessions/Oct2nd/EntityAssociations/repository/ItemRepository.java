package LiveCodingSessions.Oct2nd.EntityAssociations.repository;

import LiveCodingSessions.Oct2nd.EntityAssociations.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public  interface ItemRepository extends JpaRepository<Item,Integer> {
    List<Item> findByCategory_CategoryId(Integer category_id);
}
/*@Repository
public interface ItemRepository extends JpaRepository<Item,Integer> {

}*/
