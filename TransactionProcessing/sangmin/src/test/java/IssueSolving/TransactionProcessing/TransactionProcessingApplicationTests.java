package IssueSolving.TransactionProcessing;

import IssueSolving.TransactionProcessing.Entity.Member;
import IssueSolving.TransactionProcessing.Repository.MemberRepository;
import IssueSolving.TransactionProcessing.Service.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.ObjectOptimisticLockingFailureException;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TransactionProcessingApplicationTests {

	@Autowired
	MemberService memberService;

	@Autowired
	MemberRepository memberRepository;

	@BeforeEach
	void beforeEach() {

		Member m1 = new Member("이상민", 10000);
		memberRepository.save(m1);
	}

	@Test
	void 멀티스레드에서_차감테스트() throws InterruptedException {
		AtomicInteger successCount = new AtomicInteger();
		int numberOfExcute = 100;
		ExecutorService service = Executors.newFixedThreadPool(10);
		CountDownLatch latch = new CountDownLatch(numberOfExcute);

		for (int i = 0; i < numberOfExcute; i++) {
			service.execute(() -> {
				try {
					memberService.decreasePrice("이상민", 1000);
					successCount.getAndIncrement();
					System.out.println("성공");
				} catch (ObjectOptimisticLockingFailureException oe) {
					System.out.println("충돌감지");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				latch.countDown();
			});
		}
		latch.await();

		assertThat(successCount.get()).isEqualTo(10);
	}
}