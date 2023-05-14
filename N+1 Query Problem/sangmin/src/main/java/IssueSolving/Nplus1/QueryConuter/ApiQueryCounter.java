package IssueSolving.Nplus1.QueryConuter;

import lombok.Getter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
@Getter
public class ApiQueryCounter {

    private int count;

    public void resetCount() {count = 0;}
    public void increaseCount() {
        count++;
    }
}