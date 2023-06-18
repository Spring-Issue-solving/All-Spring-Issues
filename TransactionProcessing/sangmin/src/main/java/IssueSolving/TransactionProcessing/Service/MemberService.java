package IssueSolving.TransactionProcessing.Service;

import IssueSolving.TransactionProcessing.Entity.Member;
import IssueSolving.TransactionProcessing.Repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public int currentPrice(String name) {
        Member member = memberRepository.findByName(name);
        return member.getPrice();
    }

    @Transactional(isolation =  Isolation.SERIALIZABLE)
    public int decreasePrice(String name, int price) {
        Member member = memberRepository.findWithNameForUpdate(name);
        member.decreasePrice(price);
        return member.getPrice();
    }
}