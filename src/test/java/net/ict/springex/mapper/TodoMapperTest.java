package net.ict.springex.mapper;


import lombok.extern.log4j.Log4j2;
import net.ict.springex.domain.TodoVO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class TodoMapperTest {
    @Autowired(required = false)//required=false를 설정해 두면 빈이 존재하지 않아도 실행시켜준다.
    private TodoMapper todoMapper;

    @Test
    public void testTodoMapper(){

        log.info(todoMapper.getTime());
    }

    @Test
    public void testInsert(){
        TodoVO todoVO = TodoVO.builder()
                .title("spring Test")
                .dueDate(LocalDate.of(2022,11,14))
                .writer("ict06")
                .build();
        todoMapper.insert(todoVO);
    }

    @Test
    public void testSelectAll(){
        List<TodoVO> voList = todoMapper.selectAll();
        voList.forEach(vo -> log.info(vo));
    }

}
