package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
// @Component 애노테이션이 붙은 클래스를 스캔해서 스프링 빈으로 등록한다.
@ComponentScan(
        // refactor
        // basePackages = "hello.core.member",
        // basePackageClasses = AutoAppConfig.class,
        // AppConfig의 bean도 같이 자동으로 등록되는 것을 방지하기 위해.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}
