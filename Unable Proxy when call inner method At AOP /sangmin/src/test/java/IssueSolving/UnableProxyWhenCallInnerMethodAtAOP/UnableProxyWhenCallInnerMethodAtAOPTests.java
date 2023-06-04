package IssueSolving.UnableProxyWhenCallInnerMethodAtAOP;

import IssueSolving.UnableProxyWhenCallInnerMethodAtAOP.AOP.ExecutionTimerAspect;
import IssueSolving.UnableProxyWhenCallInnerMethodAtAOP.Entity.Content;
import IssueSolving.UnableProxyWhenCallInnerMethodAtAOP.Repository.ContentRepository;
import IssueSolving.UnableProxyWhenCallInnerMethodAtAOP.Service.ContentService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StopWatch;

import java.util.List;
import java.util.UUID;


@Slf4j
@Import(ExecutionTimerAspect.class)
@SpringBootTest
class UnableProxyWhenCallInnerMethodAtAOPTests {

	@Autowired
	ContentRepository contentRepository;

	@Autowired
	ContentService contentService;

	@PersistenceContext
	EntityManager em;


	@BeforeEach
	public void setUp(){

		for(int i=0; i<10; i++){
			Content content = new Content();

			content.setName("이름" + i);

			content.setText1(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
			content.setText2(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
			content.setText3(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
			content.setText4(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));

			contentRepository.save(content);
		}
		em.clear();
	}

	@Test
	void AOP_외부메서드_호출() {
		contentService.modifyContents();
	}

//	@Test
//	void Sol1_자기자신주입() {
//		contentService.modifyContents_sol1();
//	}

	@Test
	void Sol2_지연조회() {
		contentService.modifyContents_sol2();
	}

	@Test
	void Sol3_구조나누기() {
		contentService.modifyContents();
	}




}



