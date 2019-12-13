package com.hotel.demo.config;


import com.hotel.demo.formatter.LocalDateFormatter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc

public class AppConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new LocalDateFormatter());
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

