package com.api.rickmorty.domain.ports.in;

import com.api.rickmorty.domain.model.Characters;

import java.util.List;
import java.util.Optional;

public interface RetrieveCharactersUseCase {

    Optional<Characters> getCharactersById(Integer id);

    List<Characters> getAllCharacters();

}
