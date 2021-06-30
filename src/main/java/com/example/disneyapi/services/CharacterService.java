package com.example.disneyapi.services;

import com.example.disneyapi.entities.Character;
import com.example.disneyapi.repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {
    private final CharacterRepository characterRepository;

    @Autowired
    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public List<Character> getCharacters() { return characterRepository.findAll(); }

    public void save(Character character) { characterRepository.save(character); }
}
