package com.prf.demo.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.prf.demo.auths.AuditorAwareImpl;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "getAuditorAware")  // here in auditorAwareRef we have to pass the method name that is used to create AuditorAware interface bean
public class MapperConfig {

	@Bean
    ModelMapper getMapper(){
        return new ModelMapper();
    }
	
	
	 @Bean
	    AuditorAware<String> getAuditorAware(){return new AuditorAwareImpl();
	    }
}
