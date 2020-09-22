package az.maqa.microservices.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanFactory {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
