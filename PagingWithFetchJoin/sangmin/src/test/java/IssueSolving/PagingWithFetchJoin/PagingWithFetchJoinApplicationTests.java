package IssueSolving.PagingWithFetchJoin;

import IssueSolving.PagingWithFetchJoin.Entity.Contract;
import IssueSolving.PagingWithFetchJoin.Entity.Member;
import IssueSolving.PagingWithFetchJoin.Entity.QMemberContractDto;
import IssueSolving.PagingWithFetchJoin.Repository.ContractRepository;
import IssueSolving.PagingWithFetchJoin.Repository.MemberRepository;
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

import static IssueSolving.PagingWithFetchJoin.Entity.QContract.contract;
import static IssueSolving.PagingWithFetchJoin.Entity.QMember.member;
import static com.querydsl.core.group.GroupBy.groupBy;
import static com.querydsl.core.group.GroupBy.list;


@SpringBootTest
class PagingWithFetchJoinApplicationTests {
	@Autowired
	ContractRepository contractRepository;

	@Autowired
	MemberRepository memberRepository;

	@PersistenceContext
	EntityManager em;

	JPAQueryFactory queryFactory;
	@BeforeEach
	public void setUp(){

		List<Contract> contracts = new ArrayList<>();
		for(int i = 0; i < 10; i++){
			Contract contract = new Contract();
			contract.setName("계약 " + i);
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
	void 페치조인_페이징_문제() {
		queryFactory = new JPAQueryFactory(em);

		System.out.print("==========================");

		queryFactory.selectFrom(member)
				.innerJoin(member.contracts, contract).fetchJoin()
				.where(member.id.eq(1L))
				.limit(5)
				.fetch();

		System.out.print("==========================");

	}


	@Test
	@Transactional
	void 페치조인_페이징_방향을_반대로() {
		queryFactory = new JPAQueryFactory(em);

		System.out.print("==========================");

		queryFactory.selectFrom(contract)
				.innerJoin(contract.member, member).fetchJoin()
				.where(member.id.eq(1L))
				.limit(5)
				.fetch();

		System.out.print("==========================");

	}


	@Test
	@Transactional
	void 페치조인_페이징_DTO로() {
		queryFactory = new JPAQueryFactory(em);

		System.out.print("==========================");

		queryFactory.from(contract)
				.innerJoin(contract.member, member)
				.where(member.id.eq(1L))
				.limit(5)
				.transform(
						groupBy(contract.member.id)
								.list(new QMemberContractDto(member.name, list(contract.name)))
				);
//		.get(0);

		System.out.print("==========================");

	}



	@Test
	@Transactional
	void 페치조인_페이징_조인하지않음() {
		queryFactory = new JPAQueryFactory(em);

		System.out.print("==========================");


		queryFactory.selectFrom(contract)
				.where(contract.member.id.eq(1L))
				.limit(5)
				.fetch();


		System.out.print("==========================");

	}
}
