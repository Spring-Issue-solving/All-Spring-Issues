package IssueSolving.UnableProxyWhenCallInnerMethodAtAOP.Service;


import IssueSolving.UnableProxyWhenCallInnerMethodAtAOP.AOP.ExecutionTimer;
import IssueSolving.UnableProxyWhenCallInnerMethodAtAOP.Entity.Content;
import IssueSolving.UnableProxyWhenCallInnerMethodAtAOP.Repository.ContentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ContentService {

    private final ContentRepository contentRepository;
    private final ContentLogicService contentLogicService;

    @ExecutionTimer
    public void modifyContents(){
        List<Content> contents = contentRepository.findAll();

//        modifyLogic(contents);

        //Sol 3
        contentLogicService.modifyLogic(contents);

    }

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


    // point 변경최소화
//    //SOL 1
//    private ContentService contentService;
//
//    @Autowired
//    public void setContentService(ContentService contentService){
//        this.contentService = contentService;
//    }
//
//    @ExecutionTimer
//    public void modifyContents_sol1(){
//        List<Content> contents = contentRepository.findAll();
//
//        contentService.modifyLogic(contents);
//
//    }

    //SOL 2
//    private final ObjectProvider<ContentService> contentServiceProvider;


    private ApplicationContext context;
    @Autowired
    public void setContext(ApplicationContext context) {
        this.context = context;
    }
    @ExecutionTimer
    public void modifyContents_sol2(){
        List<Content> contents = contentRepository.findAll();


        ContentService contentService = (ContentService) context.getBean("contentService");
//        ContentService contentService = contentServiceProvider.getObject();
        contentService.modifyLogic(contents);

    }


}