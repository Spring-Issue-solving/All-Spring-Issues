package IssueSolving.PagingWithFetchJoin.Repository;

import IssueSolving.PagingWithFetchJoin.Entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, Long> {
}
