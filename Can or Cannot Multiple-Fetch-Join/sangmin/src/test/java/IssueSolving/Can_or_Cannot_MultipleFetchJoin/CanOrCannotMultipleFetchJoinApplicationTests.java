package IssueSolving.Can_or_Cannot_MultipleFetchJoin;

import IssueSolving.Can_or_Cannot_MultipleFetchJoin.Entity.*;
import IssueSolving.Can_or_Cannot_MultipleFetchJoin.QueryConuter.ApiQueryCounter;
import IssueSolving.Can_or_Cannot_MultipleFetchJoin.Repository.ContractRepository;
import IssueSolving.Can_or_Cannot_MultipleFetchJoin.Repository.HouseRepository;
import IssueSolving.Can_or_Cannot_MultipleFetchJoin.Repository.MemberRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.hibernate.loader.MultipleBagFetchException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
class CanOrCannotMultipleFetchJoinApplicationTests {

	@Autowired
	ContractRepository contractRepository;

	@Autowired
	MemberRepository memberRepository;

	@Autowired
	HouseRepository houseRepository;

	@PersistenceContext
	EntityManager em;

	JPAQueryFactory queryFactory;


	@Autowired
	private ApiQueryCounter apiQueryCounter;

	@BeforeEach
	public void setUp(){

		List<Contract> contracts = new ArrayList<>();
		for(int i = 0; i < 10; i++){
			Contract contract = new Contract();
			contract.setName("계약 " + i);
			contracts.add(contract);
		}
		contractRepository.saveAll(contracts);

		List<House> likes = new ArrayList<>();
		for(int i = 0; i < 10; i++){
			House like = new House();
			like.setName("찜한집 " + i);
			likes.add(like);
		}
		houseRepository.saveAll(likes);


		List<Member> members = new ArrayList<>();
		for(int i = 0; i < 10; i++){
			Member member = new Member();
			member.setName("멤버" + i);
			member.setContracts(contracts);
			member.setLikes(likes);

			members.add(member);
		}
		memberRepository.saveAll(members);


		// 쿼리카운트 초기화
		apiQueryCounter.resetCount();

		em.clear();
	}

	// 에러 계층구조? 에서 에러테스팅 방법
	@Test
//	@Transactional
	void prob_XXXTOOne_2개() {

		System.out.println("========================================");

		List<Member> members = memberRepository.findAllJoinFetch();

//		assertThatThrownBy(() -> {
//			List<Member> members = memberRepository.findAllJoinFetch();
//		}).isInstanceOf(MultipleBagFetchException.class);

		System.out.println("========================================");

	}

	@Test
	@Transactional
	void solv_BatchSize_설정() {
		System.out.println("========================================");

		List<Member> members = memberRepository.findAll();

		members.stream()
				.map(Member::getContracts)
				.flatMap(Collection::stream)
				.map(Contract::getName)
				.collect(Collectors.toList());

		members.stream()
				.map(Member::getLikes)
				.flatMap(Collection::stream)
				.map(House::getName)
				.collect(Collectors.toList());



//		assertThatThrownBy(() -> {
//			List<Member> members = memberRepository.findAllJoinFetch();
//		}).isInstanceOf(MultipleBagFetchException.class);

		System.out.println("========================================");

		assertThat(apiQueryCounter.getCount()).isEqualTo(3);

	}

}
