package IssueSolving.Nplus1.Repository;

import IssueSolving.Nplus1.Entity.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, Long> {
}
