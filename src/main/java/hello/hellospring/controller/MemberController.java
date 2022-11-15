package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller//정의만 해두어도 스프링이 관리.
public class MemberController {

//    private final MemberService memberService = new MemberService();//여러 컨트롤러들이 멤버서비스를 사용할 수 있음. 하나만 생성하고 공용으로 사용하면 됨.

    private final MemberService memberService;

    @Autowired//스프링 컨테이너안에 MemberController를 가져와 실행. DI : 의존관계를 주입.
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
//개발은 최대한 호출하면 안될 메소드를 호출하면 안됨. 생성자 주입을 권장.
