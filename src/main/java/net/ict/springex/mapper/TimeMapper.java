package net.ict.springex.mapper;

import org.apache.ibatis.annotations.Select;
//인터페이스로 해주어야 select가 시용 가능하다
public interface TimeMapper {
@Select("select now()")//매퍼 인터페이스
    String getTime();
}
