package IssueSolving.JPADirtyCheckingPerformanceIssue.Config;

import IssueSolving.JPADirtyCheckingPerformanceIssue.Entity.Content;
import IssueSolving.JPADirtyCheckingPerformanceIssue.Repository.ContentRepository;
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

        for(int i=0; i<100000; i++){
            Content content = new Content();

            content.setName("이름" + i);
            content.setText1(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
            content.setText2(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
            content.setText3(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
            content.setText4(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
            content.setText5(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
            content.setText6(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
            content.setText7(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
            content.setText8(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
            content.setText9(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
            content.setText10(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
            content.setText11(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
            content.setText12(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
            content.setText13(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
            content.setText14(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
            content.setText15(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
            content.setText16(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
            content.setText17(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
            content.setText18(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
            content.setText19(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
            content.setText20(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
            content.setText21(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
            content.setText22(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
            content.setText23(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
            content.setText24(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
            content.setText25(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
            content.setText26(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
            content.setText27(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
            content.setText28(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
            content.setText29(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));
            content.setText30(UUID.randomUUID().toString().concat(UUID.randomUUID().toString().concat(UUID.randomUUID().toString())));

            contentRepository.save(content);
        }
    }
}
