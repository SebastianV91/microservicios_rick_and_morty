package com.api.rickmorty.infrastructure.config;

import com.api.rickmorty.application.services.CharactersService;
import com.api.rickmorty.application.usecases.*;
import com.api.rickmorty.domain.ports.in.GetAdditionalCharactersInfoUseCase;
import com.api.rickmorty.domain.ports.out.CharactersRepositoryPort;
import com.api.rickmorty.domain.ports.out.ExternalServicePort;
import com.api.rickmorty.infrastructure.adapters.ExternalServiceAdapter;
import com.api.rickmorty.infrastructure.repositories.CharactersRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfigCharacters {

    @Bean
    public CharactersService charactersService(CharactersRepositoryPort charactersRepositoryPort, GetAdditionalCharactersInfoUseCase getAdditionalCharactersInfoUseCase){
        return new CharactersService(
                new CreateCharactersUseCaseImpl(charactersRepositoryPort),
                new RetrieveCharactersUseCaseImpl(charactersRepositoryPort),
                new UpdateCharactersUseCaseImpl(charactersRepositoryPort),
                new DeleteCharactersUseCaseImpl(charactersRepositoryPort),
                getAdditionalCharactersInfoUseCase
        );
    }

    @Bean
    public CharactersRepositoryPort charactersRepositoryPort(CharactersRepositoryAdapter charactersRepositoryAdapter){
        return charactersRepositoryAdapter;
    }

    @Bean
    public GetAdditionalCharactersInfoUseCase getAdditionalCharactersInfoUseCase(ExternalServicePort externalServicePort){
        return new GetAdditionalCharactersInfoUseCaseImpl(externalServicePort);
    }

}
