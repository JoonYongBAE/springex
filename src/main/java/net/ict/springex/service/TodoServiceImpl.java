package net.ict.springex.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.ict.springex.domain.TodoVO;
import net.ict.springex.dto.TodoDTO;
import net.ict.springex.mapper.TodoMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

//데이터베이스를 처리하는 TodoMapper와 DTO와 VO변환을 처리하는 ModelMapper주입
@Service
@Log4j2
//의존성 주입이 필요한 객체의 타입을 final로 고정하고 생성자 @RequiredArgsConstructor 를 이용하여 생성자를 생성하는 방식 사용.
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{
    private final TodoMapper todoMapper;
    private final ModelMapper modelMapper;

    @Override
    public void register(TodoDTO todoDTO) {
    log.info(modelMapper);
        TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
        log.info(todoVO);
        todoMapper.insert(todoVO);
    }

    @Override
    public List<TodoDTO> getAll() {
        List<TodoDTO> dtoList = todoMapper.selectAll().stream()
                .map(vo->modelMapper.map(vo, TodoDTO.class))
                .collect(Collectors.toList());
        return dtoList; //매퍼를 통해서 selectAll()을 통해서 나온 정보들은 각각 다른 TodoVO들이기 때문에 이 각각의 정보들을 vo를 DTO로 변환을 시켜 묶어준다.
        //List<TodoVO>를 List<TodoDTO>로 변환하는 작업을 stream을 이용하여 각 TodoVO는 map()을 통해서 TodoDTO로 바꾸고 collect()을 이용하여 List<TodoDTO>로 묶어준다.
    }
}
