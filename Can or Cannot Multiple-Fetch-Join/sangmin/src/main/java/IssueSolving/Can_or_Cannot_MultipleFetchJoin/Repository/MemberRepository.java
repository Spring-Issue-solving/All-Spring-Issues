package IssueSolving.Can_or_Cannot_MultipleFetchJoin.Repository;

import IssueSolving.Can_or_Cannot_MultipleFetchJoin.Entity.Member;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query("select distinct m from Member m join fetch m.contracts join fetch m.likes")
    List<Member> findAllJoinFetch();


    @EntityGraph(attributePaths = "contracts")
    @Query("select m from Member m")
    List<Member> findAllEntityGraph();

}
