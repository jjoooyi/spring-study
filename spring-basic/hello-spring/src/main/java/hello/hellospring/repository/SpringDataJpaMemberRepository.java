package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository { //Long -> 테이블의 Id값

    //JPQL select m from Member m where m.name = ?
    @Override
    Optional<Member> findByName(String name);
}
