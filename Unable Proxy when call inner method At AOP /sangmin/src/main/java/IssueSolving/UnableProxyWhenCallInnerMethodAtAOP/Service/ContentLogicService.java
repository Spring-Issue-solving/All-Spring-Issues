package IssueSolving.UnableProxyWhenCallInnerMethodAtAOP.Service;

import IssueSolving.UnableProxyWhenCallInnerMethodAtAOP.AOP.ExecutionTimer;
import IssueSolving.UnableProxyWhenCallInnerMethodAtAOP.Entity.Content;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ContentLogicService {



    @ExecutionTimer
    public void modifyLogic(List<Content> contents) {
        contents.stream()
                .forEach(content -> {

                    content.setText1(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
                    content.setText2(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
                    content.setText3(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
                    content.setText4(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
                });
    }
}
