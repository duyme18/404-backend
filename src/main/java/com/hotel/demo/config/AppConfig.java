package com.hotel.demo.config;


import com.hotel.demo.security.service.UserDetailsServiceImpl;
import com.hotel.demo.security.service.UserPrinciple;
import com.hotel.demo.service.*;
import com.hotel.demo.service.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc

public class AppConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/assets/**")
                .addResourceLocations("/assets/");

        registry
                .addResourceHandler("/uploads/**")
                .addResourceLocations("file:/home/duyhd/Documents/project/project-404/photo/");
    }

//    @Bean
//    public HomeService homeService() {
//        return new HomeServiceImpl();
//    }
//
//    @Bean
//    public StatusHomeService statusHomeService() {
//        return new StatusHomeServiceImpl();
//    }
//
//    @Bean
//    public CategoryHomeService categoryHomeService() {
//        return new CategoryHomeServiceImpl();
//    }
//
//    @Bean
//    public CategoryRoomService categoryRoomService() {
//        return new CategoryRoomServiceImpl();
//    }
//
//    @Bean
//    public BookingService bookingService() {
//        return new BookingServiceImpl();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return new UserDetailsServiceImpl();
//    }
//
//    @Bean
//    public CommentService commentService() {
//        return new CommentServiceImpl();
//    }
}

