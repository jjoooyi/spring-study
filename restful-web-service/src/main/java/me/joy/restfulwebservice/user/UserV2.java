package me.joy.restfulwebservice.user;

import com.fasterxml.jackson.annotation.JsonFilter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter("UserInfoV2")
public class UserV2 extends User { //상속받을 부모 클래스에 디폴트 생성자가 없을 경우 에러발생, 부모 클래스의 인스턴스를 참고하여 인스턴스를 생성하기 때문
    private String grade;
}
