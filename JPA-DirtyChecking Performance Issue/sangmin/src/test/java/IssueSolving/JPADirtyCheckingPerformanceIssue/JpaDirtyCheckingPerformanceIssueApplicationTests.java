package IssueSolving.JPADirtyCheckingPerformanceIssue;

import IssueSolving.JPADirtyCheckingPerformanceIssue.Entity.Content;
import IssueSolving.JPADirtyCheckingPerformanceIssue.Repository.ContentRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.reflect.MethodSignature;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Slf4j
@SpringBootTest
class JpaDirtyCheckingPerformanceIssueApplicationTests {


	@Autowired
	ContentRepository contentRepository;

	@PersistenceContext
	EntityManager em;

	StopWatch stopWatch;

	@BeforeEach
	public void setUp(){

		for(int i=0; i<100; i++){ //2000
			Content content = new Content();

			content.setName("이름" + i);

			content.setText1(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
			content.setText2(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
			content.setText3(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
			content.setText4(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
			content.setText5(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
			content.setText6(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
			content.setText7(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
			content.setText8(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
			content.setText9(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
			content.setText10(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
			content.setText11(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
			content.setText12(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
			content.setText13(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
			content.setText14(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
			content.setText15(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
			content.setText16(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
			content.setText17(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
			content.setText18(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
			content.setText19(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
			content.setText20(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
			content.setText21(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
			content.setText22(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
			content.setText23(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
			content.setText24(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
			content.setText25(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
			content.setText26(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
			content.setText27(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
			content.setText28(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
			content.setText29(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
			content.setText30(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));

			contentRepository.save(content);
		}

		em.clear();

		//시간측정 시작
		stopWatch = new StopWatch();
		stopWatch.start();
	}


	@AfterEach
	public void measureTime() {
		stopWatch.stop();
		long totalTimeMillis = stopWatch.getTotalTimeMillis();

		log.info("실행시간 = {}ms", totalTimeMillis);
	}


	@Test
	@Transactional
	void prob_더티체킹_부하() {

		System.out.println("========================================");
		List<Content> contents = contentRepository.findAll();

		contents.stream()
				.forEach(content -> {

					content.setText1(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
					content.setText2(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
					content.setText3(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
					content.setText4(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
					content.setText5(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
					content.setText6(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
					content.setText7(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
					content.setText8(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
					content.setText9(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
					content.setText10(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
					content.setText11(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
					content.setText12(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
					content.setText13(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
					content.setText14(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
					content.setText15(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
					content.setText16(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
					content.setText17(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
					content.setText18(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
					content.setText19(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
					content.setText20(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
					content.setText21(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
					content.setText22(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
					content.setText23(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
					content.setText24(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
					content.setText25(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
					content.setText26(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
					content.setText27(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
					content.setText28(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
					content.setText29(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
					content.setText30(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));

				});

		System.out.println("========================================");

	}

	@Test
	@Transactional(readOnly=true)
	void solv_트랜젝션_readOnly() {

	}

//	@Test
//	@Transactional(readOnly=true)
//	void solv_트랜젝션_readOnly() {
//
//		System.out.println("========================================");
//		List<Content> contents = contentRepository.findAll();
//
//		contents.stream()
//				.forEach(content -> {
//                    content.setText1(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
//                    content.setText2(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
//                    content.setText3(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
//                    content.setText4(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
//                    content.setText5(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
//                    content.setText6(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
//                    content.setText7(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
//                    content.setText8(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
//                    content.setText9(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
//                    content.setText10(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
//                    content.setText11(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
//                    content.setText12(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
//                    content.setText13(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
//                    content.setText14(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
//                    content.setText15(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
//                    content.setText16(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
//                    content.setText17(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
//                    content.setText18(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
//                    content.setText19(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
//                    content.setText20(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
//                    content.setText21(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
//                    content.setText22(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
//                    content.setText23(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
//                    content.setText24(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
//                    content.setText25(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
//                    content.setText26(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
//                    content.setText27(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
//                    content.setText28(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
//                    content.setText29(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
//                    content.setText30(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
//				});
//
//		System.out.println("========================================");
//
//	}



}
