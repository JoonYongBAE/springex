package net.ict.springex.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//이 클래스를 이용하여 모델맵퍼를 사용하는 이유는 VO 를 DTO로, DTO를  VO로 자동으로 변환시켜주기 위해 사용한다.
//이 클래스를 빈 객체로 사용하기 위해서는 root-context.xml에 빈등록을 추가해주어야 한다.
@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper getMapper(){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)//이것을 우선처리해라
                .setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;
    }
}
