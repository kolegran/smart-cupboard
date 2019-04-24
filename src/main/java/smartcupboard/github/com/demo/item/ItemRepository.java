package smartcupboard.github.com.demo.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import smartcupboard.github.com.demo.cupboard.shelf.sector.Sector;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long>, JpaSpecificationExecutor<Item> {

    @Query(value = "SELECT item.* FROM item, item_history," +

            "(SELECT item_history.id, MAX(created_at) as created_at " +
            "FROM item_history WHERE item_history.sector_id IN :sectors " +
            "GROUP BY item_history.id) as last_records," +

            "WHERE item_history.item_id = item.id AND item_history.id = last_records.id AND item_history.created_at = last_records.created_at", nativeQuery = true)
    List<Item> findAllItems(@Param("sectors") List<Sector> sectors);
}
