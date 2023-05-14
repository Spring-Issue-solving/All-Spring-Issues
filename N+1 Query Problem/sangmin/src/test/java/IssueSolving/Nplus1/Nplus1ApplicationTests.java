package IssueSolving.Nplus1;

import IssueSolving.Nplus1.Entity.Contract;
import IssueSolving.Nplus1.Entity.Member;
import IssueSolving.Nplus1.Repository.ContractRepository;
import IssueSolving.Nplus1.Repository.MemberRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class Nplus1ApplicationTests {

	@Autowired
	ContractRepository contractRepository;

	@Autowired
	MemberRepository memberRepository;

	@PersistenceContext
	EntityManager em;
//	JPAQueryFactory queryFactory;
//
//	@BeforeEach
//	public void before() {
//		queryFactory = new JPAQueryFactory(em);
//	}

	@BeforeEach
	public void setUp(){

		List<Contract> contracts = new ArrayList<>();
		for(int i = 0; i < 10; i++){
			Contract contract = new Contract();
			contract.setName("계약" + i);
			contracts.add(contract);
		}
		contractRepository.saveAll(contracts);

		List<Member> members = new ArrayList<>();
		for(int i = 0; i < 10; i++){
			Member member = new Member();
			member.setName("멤버" + i);
			member.setContracts(contracts);
			members.add(member);
		}
		memberRepository.saveAll(members);
		em.clear();
	}
	@Test
	@Transactional
	void prob_즉시로딩_Nplus1() {

		System.out.println("========================================");
		List<Member> members = memberRepository.findAll();
		System.out.println("========================================");

	}

	@Test
	@Transactional
	void prob_지연로딩_Nplus1() {

		System.out.println("========================================");
		List<Member> members = memberRepository.findAll();
		System.out.println("========================================");
		members.get(0).getContracts();
		List<String> contractName = members.stream()
				.flatMap(it -> it.getContracts().stream().map(contract -> contract.getName())).collect(Collectors.toList());
		System.out.println("========================================");

	}


	// Fetch Join은 조인해서 모든 연관관계의 데이터를 가져오기 때문에
	// -> 연관관계의 FetchType은 무의미하다 (EAGER, LAZY)
	@Test
	@Transactional
	void sol_페치조인(){

		System.out.println("========================================");
		List<Member> members = memberRepository.findAllJoinFetch();
		System.out.println("========================================");

	}

	@Test
	@Transactional
	void sol_엔티티그래프(){

		System.out.println("========================================");
		List<Member> members = memberRepository.findAllEntityGraph();
		System.out.println("========================================");

	}

	@Test
	@Transactional
	void prob_페치모드_Subselect() {

		System.out.println("========================================");
		List<Member> members = memberRepository.findAll();
		System.out.println("========================================");

	}

	@Test
	@Transactional
	void prob_베치사이즈_Subselect() {

		System.out.println("========================================");
		List<Member> members = memberRepository.findAll();
		System.out.println("========================================");

	}

//	@Test
//	@Transactional
//	void prob_쿼리빌더_QueryDSL() {
//		QMember member = QMember.member;
//		QContract contract = QContract.contract;
//
//		System.out.println("========================================");
//		List<Member> members = queryFactory
//				.select(member)
//				.from(member).leftJoin(member.contracts, contract)
//				.fetchJoin()
//				.fetch();
//		System.out.println("========================================");
//
//	}

}
