package com.prf.demo.auths;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;


public class AuditorAwareImpl implements AuditorAware<String>{

	@Override
    public Optional<String> getCurrentAuditor() {
        //get security context
        //get authentication
        //get the principle
        //get the username
        return Optional.of("Kamesh");
    }
}
