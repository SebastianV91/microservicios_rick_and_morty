package com.api.rickmorty.domain.ports.in;

import com.api.rickmorty.domain.model.Characters;

public interface CreateCharactersUseCase {

    Characters createCharacters(Characters characters);

}
