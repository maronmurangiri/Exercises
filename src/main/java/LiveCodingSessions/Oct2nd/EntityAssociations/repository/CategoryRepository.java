package LiveCodingSessions.Oct2nd.EntityAssociations.repository;

import LiveCodingSessions.Oct2nd.EntityAssociations.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
