package az.maqa.microservices.config;

import org.modelmapper.ModelMapper;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "az.maqa.microservices.repository")
@EnableElasticsearchRepositories(basePackages = "az.maqa.microservices.repository.es")
@EnableFeignClients(basePackages = "az.maqa.microservices")
public class TicketConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
