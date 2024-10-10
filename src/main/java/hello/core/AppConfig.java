package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Appconfig에도 @Configuration이 붙어있기 때문에 ComponentScan의 대상이 된다.
// fileter를 사용하여 componetscan 대상에 configuration을 뺀 이유.

// 스프링은 @Configuration이 붙은 AppConfig를 설정 정보로 사용한다.
@Configuration
public class AppConfig {

    // @Bean이 적힌 메서드를 모두 호출하여 반환된 객체를 스프링 컨테이너에 등록.
    // 스프링 빈은 @Bean이 붙은 메서드의 명을 스프링 빈의 이름으로 사용한다.


    // @Bean memberService -> New MemoryMemberRepository()
    // @Bean orderService -> New MemoryMemberRepository()
    // singleton이 깨지는 것일까? -> 그렇지 않다!!!

    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
}
