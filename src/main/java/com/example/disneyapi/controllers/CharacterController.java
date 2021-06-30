package com.example.disneyapi.controllers;

import com.example.disneyapi.entities.Character;
import com.example.disneyapi.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/characters")//Este me indica que todo los endpoints apuntan a characters
public class CharacterController {
    private final CharacterService characterService;

    @Autowired
    public CharacterController (CharacterService characterService){
        this.characterService = characterService;
    }

    @GetMapping()
    public List<Character> getCharacters(){
        return characterService.getCharacters();
    }

    @PostMapping(path="/save",consumes = "application/json")
    private void save(@RequestBody Character character){
        characterService.save(character);
    }

    @GetMapping(value="/characterAPI/{id}")
    public Character getCharacter(@PathVariable Integer id){
        RestTemplate apiDisney = new RestTemplate();
        ResponseEntity<Character> character = apiDisney.getForEntity("https://api.disneyapi.dev/characters/"+id+"/", Character.class);
        return character.getBody();
    }

}
