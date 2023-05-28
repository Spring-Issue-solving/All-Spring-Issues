package IssueSolving.JPADirtyCheckingPerformanceIssue.Controller;

import IssueSolving.JPADirtyCheckingPerformanceIssue.AOP.ExecutionTimer;
import IssueSolving.JPADirtyCheckingPerformanceIssue.Entity.Content;
import IssueSolving.JPADirtyCheckingPerformanceIssue.Repository.ContentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PerformanceController {

    private final ContentRepository contentRepository;

    @ExecutionTimer
    @GetMapping("/prob-dirty-checking")
    public String prob_dirty_checking(){
        List<Content> contents = contentRepository.findAll();

        System.out.print("=======================================");

        contents.stream()
                .forEach(content -> {

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

                });

        System.out.print("=======================================");

        return "prob_dirty_checking";
    }

    @ExecutionTimer
    @GetMapping("solv-readonly")
    @Transactional(readOnly = true)
    public String solv_readonly(){
        List<Content> contents = contentRepository.findAll();

        System.out.print("=======================================");

        contents.stream()
                .forEach(content -> {
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

                });

        System.out.print("=======================================");

        return "solv_readonly";
    }
}
