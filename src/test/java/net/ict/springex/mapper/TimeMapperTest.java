package net.ict.springex.mapper;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class TimeMapperTest {
    @Autowired(required = false)//required설정시 null값이 나와도 예외 처리를 하지 않는다.
    private TimeMapper timeMapper;

    @Test
    public void testGetTime(){
    log.info(timeMapper.getTime());
    }

    @Autowired(required = false)//required설정시 null값이 나와도 예외 처리를 하지 않는다.
    private TimeMapper2 timeMapper2;

    @Test
    public void testNow(){
        log.info(timeMapper2.getNow());
    }
}
