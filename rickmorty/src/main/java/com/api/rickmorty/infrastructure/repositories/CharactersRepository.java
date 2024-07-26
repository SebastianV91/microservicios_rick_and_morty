package com.api.rickmorty.infrastructure.repositories;

import com.api.rickmorty.infrastructure.entities.CharactersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharactersRepository extends JpaRepository<CharactersEntity, Integer> {

}
