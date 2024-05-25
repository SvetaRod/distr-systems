package lab.BD;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import lab.BD.entity.Friend;
import lab.BD.models.CharacterAddDTO;
import lab.BD.entity.Character;

import java.util.List;
import java.util.stream.Collectors;


@ApplicationScoped
public class ServicePE {

    @Transactional
    public void addCharacter(CharacterAddDTO characterAddDTO) {
        Character character = new Character();

        character.setName(characterAddDTO.getName());
        character.setAge(characterAddDTO.getAge());
        character.setGender(characterAddDTO.getGender());

        character.persist();
    }

    public List<Character> getAllCharacters() {
        return Character.listAll();
    }

    @Transactional
    public void deleteCharacter(int id) {
        Character.deleteById(id);
    }

    @Transactional
    public Character changeCharacter(Character newCharacter) {
        Character character = Character.findById(newCharacter.id);

        if (character != null) {
            character.setName(newCharacter.getName());
            character.setGender(newCharacter.getGender());
            character.setAge(newCharacter.getAge());
            return character;
        }
        return null;
    }

    public Character getCharacterById(int id) {
        Character character = Character.findById(id);

        return character;
    }

    public List<Character> getCharactersByGender(String gender) {
        List<Character> characters = Character.find("gender", gender).list();
        return characters;
    }

    @Transactional
    public List<String> addFriend(int id, String friend) {
        Character character = getCharacterById(id);
        if (character != null) {
            Friend friendEntity = new Friend();
            friendEntity.setFriendName(friend);
            friendEntity.setCharacterID(character.id);
            friendEntity.persist();
            return getFriendNames(id);
        }
        return null;
    }

    @Transactional
    public List<String> addFriends(int id, List<String> friends) {
        Character character = getCharacterById(id);
        if (character != null) {
            for (String friend : friends) {
                Friend friendEntity = new Friend();
                friendEntity.setFriendName(friend);
                friendEntity.setCharacterID(character.id);
                friendEntity.persist();
            }
            return getFriendNames(id);
        }
        return null;
    }

    public List<String> getFriendNames(int id) {
        List<Friend> friends = Friend.find("characterID", id).list();
        return friends.stream().map(friend -> friend.getFriendName()).collect(Collectors.toList());
    }
}
