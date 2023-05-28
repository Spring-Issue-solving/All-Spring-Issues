package IssueSolving.Can_or_Cannot_MultipleFetchJoin.Repository;

import IssueSolving.Can_or_Cannot_MultipleFetchJoin.Entity.Contract;
import IssueSolving.Can_or_Cannot_MultipleFetchJoin.Entity.House;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseRepository extends JpaRepository<House, Long> {
}
