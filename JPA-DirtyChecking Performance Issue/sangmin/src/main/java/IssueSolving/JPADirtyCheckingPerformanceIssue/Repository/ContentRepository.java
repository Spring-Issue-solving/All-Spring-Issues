package IssueSolving.JPADirtyCheckingPerformanceIssue.Repository;

import IssueSolving.JPADirtyCheckingPerformanceIssue.Entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content, Long> {


    
}
