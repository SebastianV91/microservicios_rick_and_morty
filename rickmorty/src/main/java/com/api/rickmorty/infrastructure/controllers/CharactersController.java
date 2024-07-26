package com.api.rickmorty.infrastructure.controllers;

import com.api.rickmorty.application.services.CharactersService;
import com.api.rickmorty.domain.model.Characters;
import com.api.rickmorty.infrastructure.dto.CharacterDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/characters")
public class CharactersController {

    private final CharactersService charactersService;

    public CharactersController(CharactersService characterService) {
        this.charactersService = characterService;
    }

    @PostMapping("/")
    public ResponseEntity<Characters> createCharacters(@RequestBody Characters characters){
        Characters createdCharacters = charactersService.createCharacters(characters);
        return new ResponseEntity<>(createdCharacters, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Characters> getCharactersById(@PathVariable Integer id){
        return charactersService.getCharactersById(id)
                .map(characters -> new ResponseEntity<>(characters, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/getAllCharacters")
    public ResponseEntity<List<Characters>> getAllCharacters(){
        List<Characters> characters = charactersService.getAllCharacters();
        return new ResponseEntity<>(characters, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Characters> updateCharacters(@PathVariable Integer id, @RequestBody Characters updatedCharacters){
        return charactersService.updateCharacters(id,  updatedCharacters)
                .map(characters -> new ResponseEntity<>(characters, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCharactersById(@PathVariable Integer id){
        if(charactersService.deleteCharacters(id)){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/additional-info-character")
    public ResponseEntity<CharacterDTO> getAdditionalInfoCharacter(){
        CharacterDTO characterDTO = charactersService.getAdditionalCharactersInfo();
        return new ResponseEntity<>(characterDTO, HttpStatus.OK);
    }

}
