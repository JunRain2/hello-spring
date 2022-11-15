package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;


public class MemberService {

    /**
     * 회원 가입
    */
    private final MemberRepository memberRepository;

    @Autowired//스프링 컨테이너에 올라가야만 작동.
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }//외부에서 넣어주도록 변경.

    public Long join(Member member){
        //같은 이름이 있는 중복 회원X


        validateDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();

    }

    private void validateDuplicateMember(Member member) {
//        Optional<Member> result = memberRepository.findByName(member.getName());//null이 가능성이 있으면 Optional로 한번 감쌈.
//        result.ifPresent(m->{ //값을 가지고 있으면 예외처리 메소드
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        });//직접 꺼내는 것을 권장하지 않음.
        memberRepository.findByName(member.getName())
                        .ifPresent(m->{
                            throw new IllegalStateException("이미 존재하는 회원입니다.");
                        });
    }
    /**
     * 전체 회원 조회
     * */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
