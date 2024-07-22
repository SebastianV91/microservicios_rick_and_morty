package com.api.rickmorty.domain.ports.in;

import com.api.rickmorty.infrastructure.dto.CharacterDTO;

public interface GetAdditionalCharactersInfoUseCase {

    CharacterDTO getAdditionalCharactersInfo();

}
