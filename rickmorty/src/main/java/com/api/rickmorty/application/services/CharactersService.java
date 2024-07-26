package com.api.rickmorty.application.services;

import com.api.rickmorty.domain.model.Characters;
import com.api.rickmorty.domain.ports.in.CreateCharactersUseCase;
import com.api.rickmorty.domain.ports.in.RetrieveCharactersUseCase;
import com.api.rickmorty.domain.ports.in.UpdateCharactersUseCase;
import com.api.rickmorty.domain.ports.in.DeleteCharactersUseCase;
import com.api.rickmorty.domain.ports.in.GetAdditionalCharactersInfoUseCase;
import com.api.rickmorty.infrastructure.dto.CharacterDTO;

import java.util.List;
import java.util.Optional;

public class CharactersService implements CreateCharactersUseCase, RetrieveCharactersUseCase, UpdateCharactersUseCase, DeleteCharactersUseCase, GetAdditionalCharactersInfoUseCase {

    private final CreateCharactersUseCase createCharactersUseCase;
    private final RetrieveCharactersUseCase retrieveCharactersUseCase;
    private final UpdateCharactersUseCase updateCharactersUseCase;
    private final DeleteCharactersUseCase deleteCharactersUseCase;
    private final GetAdditionalCharactersInfoUseCase getAdditionalCharactersInfoUseCase;

    public CharactersService(CreateCharactersUseCase createCharactersUseCase, RetrieveCharactersUseCase retrieveCharactersUseCase,
                             UpdateCharactersUseCase updateCharactersUseCase, DeleteCharactersUseCase deleteCharactersUseCase,
                             GetAdditionalCharactersInfoUseCase getAdditionalCharactersInfoUseCase) {
        this.createCharactersUseCase = createCharactersUseCase;
        this.retrieveCharactersUseCase = retrieveCharactersUseCase;
        this.updateCharactersUseCase = updateCharactersUseCase;
        this.deleteCharactersUseCase = deleteCharactersUseCase;
        this.getAdditionalCharactersInfoUseCase = getAdditionalCharactersInfoUseCase;
    }


    @Override
    public Characters createCharacters(Characters characters) {
        return createCharactersUseCase.createCharacters(characters);
    }

    @Override
    public boolean deleteCharacters(Integer id) {
        return deleteCharactersUseCase.deleteCharacters(id);
    }

    @Override
    public CharacterDTO getAdditionalCharactersInfo() {
        return getAdditionalCharactersInfoUseCase.getAdditionalCharactersInfo();
    }

    @Override
    public Optional<Characters> getCharactersById(Integer id) {
        return retrieveCharactersUseCase.getCharactersById(id);
    }

    @Override
    public List<Characters> getAllCharacters() {
        return retrieveCharactersUseCase.getAllCharacters();
    }

    @Override
    public Optional<Characters> updateCharacters(Integer id, Characters characters) {
        return updateCharactersUseCase.updateCharacters(id, characters);
    }

}
