package IssueSolving.UnableProxyWhenCallInnerMethodAtAOP.Repository;

import IssueSolving.UnableProxyWhenCallInnerMethodAtAOP.Entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content, Long> {


    
}
