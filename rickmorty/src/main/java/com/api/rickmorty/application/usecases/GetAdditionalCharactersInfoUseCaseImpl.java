package com.api.rickmorty.application.usecases;

import com.api.rickmorty.domain.ports.in.GetAdditionalCharactersInfoUseCase;
import com.api.rickmorty.domain.ports.out.CharactersRepositoryPort;
import com.api.rickmorty.domain.ports.out.ExternalServicePort;
import com.api.rickmorty.infrastructure.dto.CharacterDTO;

public class GetAdditionalCharactersInfoUseCaseImpl implements GetAdditionalCharactersInfoUseCase {

    private final ExternalServicePort externalServicePort;

    public GetAdditionalCharactersInfoUseCaseImpl(ExternalServicePort externalServicePort) {
        this.externalServicePort = externalServicePort;
    }

    @Override
    public CharacterDTO getAdditionalCharactersInfo() {
        return externalServicePort.getAdditionalCharacterInfo();
    }
}
