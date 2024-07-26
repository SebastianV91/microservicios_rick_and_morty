package com.api.rickmorty.domain.ports.out;


import com.api.rickmorty.domain.model.Characters;

import java.util.List;
import java.util.Optional;

public interface CharactersRepositoryPort {

    Characters save(Characters characters);
    Optional<Characters> findById(Integer id);
    List<Characters> findAll();
    Optional<Characters> update(Characters characters);
    boolean deleteById(Integer id);

}
