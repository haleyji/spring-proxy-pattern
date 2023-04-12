package hello.proxy.pureproxy.decorator.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageDecorator implements Component {
    private Component component;

    public MessageDecorator(Component component) {
        this.component = component;
    }

    @Override
    public String operation() {
        log.info("Message Decorator 실행");
        String operation = component.operation();
        String decoResult = "****" + operation + "****";
        log.info("deco 전 ={}, deco 후={}", operation, decoResult);
        return decoResult;
    }
}
