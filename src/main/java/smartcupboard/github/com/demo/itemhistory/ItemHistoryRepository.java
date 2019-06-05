package smartcupboard.github.com.demo.itemhistory;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemHistoryRepository extends JpaRepository<ItemHistory, Long> {
    List<ItemHistory> findByItemId(Long itemId);
}
