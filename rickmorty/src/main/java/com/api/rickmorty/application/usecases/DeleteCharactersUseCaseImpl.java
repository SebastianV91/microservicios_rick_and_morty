package com.api.rickmorty.application.usecases;

import com.api.rickmorty.domain.ports.in.DeleteCharactersUseCase;
import com.api.rickmorty.domain.ports.out.CharactersRepositoryPort;

public class DeleteCharactersUseCaseImpl implements DeleteCharactersUseCase {

    private final CharactersRepositoryPort charactersRepositoryPort;

    public DeleteCharactersUseCaseImpl(CharactersRepositoryPort charactersRepositoryPort) {
        this.charactersRepositoryPort = charactersRepositoryPort;
    }

    @Override
    public boolean deleteCharacters(Integer id) {
        return charactersRepositoryPort.deleteById(id);
    }
}
