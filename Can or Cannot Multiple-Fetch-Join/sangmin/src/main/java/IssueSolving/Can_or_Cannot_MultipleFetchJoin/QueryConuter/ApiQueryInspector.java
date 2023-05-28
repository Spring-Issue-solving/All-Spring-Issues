package IssueSolving.Can_or_Cannot_MultipleFetchJoin.QueryConuter;

import lombok.RequiredArgsConstructor;
import org.hibernate.resource.jdbc.spi.StatementInspector;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class ApiQueryInspector implements StatementInspector {

    private final ApiQueryCounter apiQueryCounter;

    @Override
    public String inspect(final String sql) {
//        if (isInRequestScope()) { // Request Scope 일때만 카운팅하기
//            apiQueryCounter.increaseCount();
//        }

        apiQueryCounter.increaseCount();
        return sql;
    }

    private boolean isInRequestScope() {
        return Objects.nonNull(RequestContextHolder.getRequestAttributes());
    }
}
