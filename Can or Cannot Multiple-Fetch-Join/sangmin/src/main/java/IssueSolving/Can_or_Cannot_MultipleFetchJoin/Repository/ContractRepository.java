package IssueSolving.Can_or_Cannot_MultipleFetchJoin.Repository;

import IssueSolving.Can_or_Cannot_MultipleFetchJoin.Entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, Long> {
}
