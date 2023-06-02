package IssueSolving.UnableProxyWhenCallInnerMethodAtAOP.Config;

import IssueSolving.UnableProxyWhenCallInnerMethodAtAOP.Entity.Content;
import IssueSolving.UnableProxyWhenCallInnerMethodAtAOP.Repository.ContentRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class InitData {


    private final ContentRepository contentRepository;

    @PostConstruct
    public void init(){

        for(int i=0; i<100; i++){
            Content content = new Content();

            content.setName("이름" + i);
            content.setText1(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
            content.setText2(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
            content.setText3(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
            content.setText4(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));

            contentRepository.save(content);
        }
    }
}
