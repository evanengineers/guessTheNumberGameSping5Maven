package evan.learnprogramming.util.thymeleaf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class DecoupledLogicSetup {

    // == fields ==
    private final SpringResourceTemplateResolver templateResolver;

    // == Constructors ==
    public DecoupledLogicSetup(SpringResourceTemplateResolver templateResolver) {
        this.templateResolver = templateResolver;
    }

    // == init method ==
    @PostConstruct
    public void init() {
     templateResolver.setUseDecoupledLogic(true);
     log.info("Docoupled template logic enabled.");
    }


}
