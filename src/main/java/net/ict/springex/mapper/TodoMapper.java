package net.ict.springex.mapper;

import net.ict.springex.domain.TodoVO;
import net.ict.springex.dto.TodoDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TodoMapper {//TodoMapper.xml을 만들 때 이 클래스 이름과 xml이름을 정확하게 같게 만들어주어야 한다.
String getTime();//getTime이라는 이름을 가진 객체를 메소드를 생성
    void insert(TodoVO todoVO);
    List<TodoVO> selectAll(); //매퍼를 해주기 위해 인터페이스에 메서드를 생성해준다. 그리고 TodoMapper.xml에 가서 작성한다.
}
