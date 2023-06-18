package IssueSolving.PagingWithFetchJoin.Repository;

import IssueSolving.PagingWithFetchJoin.Entity.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRepository extends JpaRepository<House, Long> {
}
