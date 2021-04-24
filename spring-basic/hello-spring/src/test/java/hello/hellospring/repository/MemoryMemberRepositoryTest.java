package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach // 각 테스트 메소드 동작 후 수행할 동작 정의
    public void afterEach() {
        // 테스트 끝난 후 저장된 내용 지우기, 테스트 순서 지정 불가능하기 때문에 각 테스트끼리의 영향을 없애기 위해 추가, 테스트 끼리 의존관계 없어야 함
        repository.clearStore(); 
    }

    @Test
    public void save() {
        Member member = new Member();

        member.setName("spring");
        repository.save(member);

        //Optional 로 반환된 것은 get()으로..?
        Member result = repository.findById(member.getId()).get();
//        System.out.println("result = " + (result == member));
//        Assertions.assertEquals(member, null);
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);
        
        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get(); // Optional 이기 때문에 get() 사용

        assertThat(result).isEqualTo(member1);

    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}
