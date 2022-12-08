package com.example.demo.config;

import com.example.demo.repository.DaysRepository;
import com.example.demo.domain.Days;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DaysConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            DaysRepository repository
    ){
        return args -> {
            Days Monday = new Days ("Monday");
            Days Tuesday = new Days("Tuesday");
            Days Wednesday = new Days("Wednesday");
            Days Thursday = new Days("Thursday");
            Days Friday = new Days("Friday");
            Days Saturday = new Days("Saturday");
            Days Sunday = new Days("Sunday");
            repository.saveAll(
                    List.of(Monday, Tuesday, Wednesday, Thursday, Friday,
                            Saturday, Sunday));

        };
    }
}
