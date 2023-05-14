package IssueSolving.Nplus1.Repository;

import IssueSolving.Nplus1.Entity.Member;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query("select m from Member m join fetch m.contracts")
    List<Member> findAllJoinFetch();


    @EntityGraph(attributePaths = "contracts")
    @Query("select m from Member m")
    List<Member> findAllEntityGraph();

}
