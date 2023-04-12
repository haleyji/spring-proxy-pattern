package hello.proxy.pureproxy.decorator;

import hello.proxy.pureproxy.decorator.code.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
public class DecoratorPatternTest {
    @Test
    @DisplayName("데코레이터 패턴 사용")
    void test() {
        Component realComponent = new RealComponent();
        DecoratorPatternClient client = new DecoratorPatternClient(realComponent);
        client.execute();
        client.execute();
        client.execute();
    }

    @Test
    @DisplayName("응답값을 꾸며주는 데코레이터 프록시를 만들어 사용한다")
    void test1(){
        RealComponent realComponent = new RealComponent();
        MessageDecorator messageDecorator = new MessageDecorator(realComponent);
        DecoratorPatternClient client = new DecoratorPatternClient(messageDecorator);
        client.execute();
    }

    @Test
    @DisplayName("프록시 체인을 사용하여 시간을 측정하는 데코레이터를 만들어 사용한다")
    void test2(){
        RealComponent realComponent = new RealComponent();
        MessageDecorator messageDecorator = new MessageDecorator(realComponent);
        TimeDecorator timeDecorator = new TimeDecorator(messageDecorator);
        DecoratorPatternClient client = new DecoratorPatternClient(timeDecorator);
        client.execute();
    }
}
