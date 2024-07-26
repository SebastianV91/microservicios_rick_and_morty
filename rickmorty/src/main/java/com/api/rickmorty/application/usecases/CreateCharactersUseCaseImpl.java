package com.api.rickmorty.application.usecases;

import com.api.rickmorty.domain.model.Characters;
import com.api.rickmorty.domain.ports.in.CreateCharactersUseCase;
import com.api.rickmorty.domain.ports.out.CharactersRepositoryPort;

public class CreateCharactersUseCaseImpl implements CreateCharactersUseCase {

    private final CharactersRepositoryPort charactersRepositoryPort;

    public CreateCharactersUseCaseImpl(CharactersRepositoryPort charactersRepositoryPort) {
        this.charactersRepositoryPort = charactersRepositoryPort;
    }

    @Override
    public Characters createCharacters(Characters characters) {
        return charactersRepositoryPort.save(characters);
    }

}
