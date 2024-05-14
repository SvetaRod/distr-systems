package lab;

import jakarta.enterprise.context.ApplicationScoped;
import lab.objects.CharacterAddDTO;
import lab.objects.Character;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@ApplicationScoped
public class Controller {
    private List<Character> characters = new ArrayList<>();
    private int lastId = 0;

    public void addCharacter(CharacterAddDTO characterAddDTO) {
        Character character = new Character();

        character.setName(characterAddDTO.getName());
        character.setAge(characterAddDTO.getAge());
        character.setGender(characterAddDTO.getGender());

        lastId++;
        character.setId(lastId);
        characters.add(character);
    }

    public List<Character> getAllCharacters() {
        return characters;
    }

    public void deleteCharacter(int id) {
        characters.removeIf(character -> character.getId() == id);
    }

    public Character changeCharacter(Character newCharacter) {
        Character character = characters.stream()
                .filter(i -> i.getId() == newCharacter.getId())
                .findFirst()
                .orElse(null);

        if (character != null){
            character.setName(newCharacter.getName());
            character.setGender(newCharacter.getGender());
            character.setAge(newCharacter.getAge());
            return character;
        }
        return null;
    }

    public Character getCharacterById(int id) {
        Character character = characters.stream()
                .filter(i -> i.getId() == id)
                .findFirst()
                .orElse(null);

        return character;
    }

    public List<Character> getCharactersByGender(String gender) {
        return characters.stream()
                .filter(character -> character.getGender().contains(gender))
                .collect(Collectors.toList());
    }

    public List<String> addFriend(int id, String friend) {
        Character character = getCharacterById(id);
        if (character != null){
            character.getFriends().add(friend);
            return character.getFriends();
        }
        return null;
    }

    public Character addFriends(int id, List<String> friends) {
        Character character = getCharacterById(id);
        if (character != null){
            character.getFriends().addAll(friends);
            return character;
        }
        return null;
    }
}
