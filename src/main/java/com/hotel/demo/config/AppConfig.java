package com.hotel.demo.config;


import com.hotel.demo.service.CategoryHomeService;
import com.hotel.demo.service.CategoryRoomService;
import com.hotel.demo.service.HomeService;
import com.hotel.demo.service.StatusHomeService;
import com.hotel.demo.service.impl.CategoryHomeServiceImpl;
import com.hotel.demo.service.impl.CategoryRoomServiceImpl;
import com.hotel.demo.service.impl.HomeServiceImpl;
import com.hotel.demo.service.impl.StatusHomeServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc

public class AppConfig implements WebMvcConfigurer {

    @Bean
    public HomeService homeService() {
        return new HomeServiceImpl();
    }

    @Bean
    public StatusHomeService statusHomeService() {
        return new StatusHomeServiceImpl();
    }

    @Bean
    public CategoryHomeService categoryHomeService() {
        return new CategoryHomeServiceImpl();
    }

    @Bean
    public CategoryRoomService categoryRoomService() {
        return new CategoryRoomServiceImpl();
    }

}

