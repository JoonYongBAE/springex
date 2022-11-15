package net.ict.springex.dto;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

//객체 자료형은 파라미터로 처리하기 위해서는 객체로 생성되고 setXXX() 이용해서 처리
@ToString
@Data
@Builder
@AllArgsConstructor // 모든 파라미터 값을 가진 생성자
@NoArgsConstructor // 파라미터값이 없는 기본 생성자
public class TodoDTO {
    private long tno;
    @NotEmpty //비어있는 상태가 될 수가 없다. implementation group: 'org.hibernate', name: 'hibernate-validator', version: '6.2.1.Final'에서 가져온다.
    private String title;
    @Future//현재보다 미래의 값이 맞는지 체크해준다.
    private LocalDate dueDate;
    private boolean finished;
    @NotEmpty
    private String writer; //작성자를 의미
}
