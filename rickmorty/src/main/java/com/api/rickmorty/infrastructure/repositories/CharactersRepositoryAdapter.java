package com.api.rickmorty.infrastructure.repositories;

import com.api.rickmorty.domain.model.Characters;
import com.api.rickmorty.domain.ports.out.CharactersRepositoryPort;
import com.api.rickmorty.infrastructure.entities.CharactersEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CharactersRepositoryAdapter implements CharactersRepositoryPort {

    private final CharactersRepository charactersRepository;

    public CharactersRepositoryAdapter(CharactersRepository charactersRepository) {
        this.charactersRepository = charactersRepository;
    }

    @Override
    public Characters save(Characters characters) {
        CharactersEntity charactersEntity = CharactersEntity.fromDomainModel(characters);
        CharactersEntity savedCharactersEntity = charactersRepository.save(charactersEntity);
        return savedCharactersEntity.toDomainModel();
    }

    @Override
    public Optional<Characters> findById(Integer id) {
        return charactersRepository.findById(id).map(CharactersEntity::toDomainModel);
    }

    @Override
    public List<Characters> findAll() {
        return charactersRepository.findAll().stream()
                .map(CharactersEntity::toDomainModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Characters> update(Characters characters) {
        if(charactersRepository.existsById(characters.getId())){
            CharactersEntity charactersEntity = CharactersEntity.fromDomainModel(characters);
            CharactersEntity updatedCharactersEntity = charactersRepository.save(charactersEntity);
            return Optional.of(updatedCharactersEntity.toDomainModel());
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteById(Integer id) {
        if(charactersRepository.existsById(id)){
            charactersRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
