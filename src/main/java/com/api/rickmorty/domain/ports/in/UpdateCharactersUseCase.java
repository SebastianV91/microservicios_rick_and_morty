package com.api.rickmorty.domain.ports.in;

import com.api.rickmorty.domain.model.Characters;

import java.util.Optional;

public interface UpdateCharactersUseCase {

    Optional<Characters> updateCharacters(Integer id, Characters characters);

}
