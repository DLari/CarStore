package ru.reksoft.interns.carstore.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static org.modelmapper.config.Configuration.AccessLevel.PRIVATE;

@Configuration
public class BeenConfig
        //extends WebMvcConfigurerAdapter
        {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
//        mapper.getConfiguration()
//                .setMatchingStrategy(MatchingStrategies.STRICT)
//                .setFieldMatchingEnabled(true)
//                .setSkipNullEnabled(true)
//                .setFieldAccessLevel(PRIVATE);
        return mapper;
    }
  //  @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("login");
    }
}
