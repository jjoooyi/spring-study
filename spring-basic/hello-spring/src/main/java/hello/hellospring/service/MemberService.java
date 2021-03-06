package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//@Service - config에 직접 bean 등록해서 사용하기 때문에 주석
@Transactional // JPA를 사용 시 항상 있어야 한다
public class MemberService {

    private final MemberRepository memberRepository;
    
    // MemberService 생성 시 리포지토리 주입
//    @Autowired - 지금은 config를 활용하여 직접 bean 관리
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     */
    public Long join(Member member) {
        //같은 이름이 있는 중복 회원X
        //Optional 을 바로 쓰면 안이쁘니까..ㅎㅎ
//        Optional<Member> result = memberRepository.findByName(member.getName());
//        // ifPresent 값이 존재한다면
//        result.ifPresent(m -> {
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        });

        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
