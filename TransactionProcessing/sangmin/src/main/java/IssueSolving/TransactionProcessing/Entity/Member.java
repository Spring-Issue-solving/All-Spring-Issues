package IssueSolving.TransactionProcessing.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int price;

    public Member(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public int decreasePrice(int price) {
        if (this.price - price < 0) {
            throw new IllegalArgumentException("가격이 부족해");
        }
        return this.price -= price;
    }
}
