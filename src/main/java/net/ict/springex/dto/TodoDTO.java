package net.ict.springex.dto;

import lombok.*;

import java.time.LocalDate;

//객체 자료형은 파라미터로 처리하기 위해서는 객체로 생성되고 setXXX() 이용해서 처리
@ToString
@Data
@Builder
@AllArgsConstructor // 모든 파라미터 값을 가진 생성자
@NoArgsConstructor // 파라미터값이 없는 기본 생성자
public class TodoDTO {
    private long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;
    private String writer; //작성자를 의미
}
