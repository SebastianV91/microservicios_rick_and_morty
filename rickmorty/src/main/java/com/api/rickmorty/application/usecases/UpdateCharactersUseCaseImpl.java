package com.api.rickmorty.application.usecases;

import com.api.rickmorty.domain.model.Characters;
import com.api.rickmorty.domain.ports.in.UpdateCharactersUseCase;
import com.api.rickmorty.domain.ports.out.CharactersRepositoryPort;

import java.util.Optional;

public class UpdateCharactersUseCaseImpl implements UpdateCharactersUseCase {

    private final CharactersRepositoryPort charactersRepositoryPort;

    public UpdateCharactersUseCaseImpl(CharactersRepositoryPort charactersRepositoryPort) {
        this.charactersRepositoryPort = charactersRepositoryPort;
    }

    @Override
    public Optional<Characters> updateCharacters(Integer id, Characters characters) {
        return charactersRepositoryPort.update(characters);
    }

}
