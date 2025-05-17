package com.api.NomNomCounter.config.usecases;

import com.api.NomNomCounter.adaptors.user.InsertUserAdapter;
import com.api.NomNomCounter.application.core.usecases.InsertUserCase;
import com.api.NomNomCounter.application.ports.in.InsertUserInputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCasesConfig {

    @Bean
    InsertUserInputPort insertUserInputPort(InsertUserAdapter insertUserAdapter){
        return new InsertUserCase(insertUserAdapter);
    }
}
