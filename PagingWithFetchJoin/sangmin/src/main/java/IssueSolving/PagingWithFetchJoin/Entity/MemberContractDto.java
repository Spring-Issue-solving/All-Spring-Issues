package IssueSolving.PagingWithFetchJoin.Entity;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

import java.util.List;

@Getter
public class MemberContractDto {


    private final String memberName;
    private final List<String> contractName;

    @QueryProjection
    public MemberContractDto(final String memberName, final List<String> contractName) {
        this.memberName = memberName;
        this.contractName = contractName;
    }
}
