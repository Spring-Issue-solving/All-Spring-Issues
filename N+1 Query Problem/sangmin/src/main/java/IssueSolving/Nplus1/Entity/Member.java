package IssueSolving.Nplus1.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Table
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Case 1. 연관관계의 Fetch 전략이 즉시로딩
    @OneToMany(mappedBy = "member", fetch = FetchType.EAGER)
    // Case 1. 연관관계의 Fetch 전략이 지연로딩
//     @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Contract> contracts = new ArrayList<>();


//    @BatchSize(size=5)
//    @Fetch(FetchMode.SUBSELECT)
//    @OneToMany(mappedBy = "member", fetch = FetchType.EAGER)
//    private List<Contract> contracts = new ArrayList<>();



    public void addContract(Contract contract) {
        contracts.add(contract);
        if (contract.getMember() != this) {
            contract.setMember(this);
        }
    }
}
