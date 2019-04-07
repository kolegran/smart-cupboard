package smartcupboard.github.com.demo.itemhistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ItemHistoryRepository extends JpaRepository<ItemHistory, Long>, JpaSpecificationExecutor<ItemHistory> {
}
