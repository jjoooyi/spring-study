package hello.hellospring.domain;

import javax.persistence.*;

@Entity
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // id값 DB에서 자동 생성..
    private Long id;
    private String name;

//    @Column(name="username") // DB 테이블의 컬럼명과 다를 경우 직접 매핑
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
