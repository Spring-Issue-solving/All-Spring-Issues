package IssueSolving.TransactionProcessing.Repository;

import IssueSolving.TransactionProcessing.Entity.Member;
import jakarta.persistence.LockModeType;
import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;

public interface MemberRepository  extends JpaRepository<Member, Long> {
    Member findByName(String name);

//    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select m from Member m where m.name = :name")
//    @QueryHints({@QueryHint(name = "javax.persistence.lock.timeout", value ="10000")})
    Member findWithNameForUpdate(@Param("name") String name);
}

