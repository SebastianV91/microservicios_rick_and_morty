package com.api.rickmorty.application.usecases;

import com.api.rickmorty.domain.model.Characters;
import com.api.rickmorty.domain.ports.in.RetrieveCharactersUseCase;
import com.api.rickmorty.domain.ports.out.CharactersRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetrieveCharactersUseCaseImpl implements RetrieveCharactersUseCase {

    private final CharactersRepositoryPort charactersRepositoryPort;

    public RetrieveCharactersUseCaseImpl(CharactersRepositoryPort charactersRepositoryPort) {
        this.charactersRepositoryPort = charactersRepositoryPort;
    }

    @Override
    public Optional<Characters> getCharactersById(Integer id) {
        return charactersRepositoryPort.findById(id);
    }

    @Override
    public List<Characters> getAllCharacters() {
        return charactersRepositoryPort.findAll();
    }

}
