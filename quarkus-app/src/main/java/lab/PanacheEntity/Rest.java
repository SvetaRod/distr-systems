package lab.PanacheEntity;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lab.PanacheEntity.models.CharacterAddDTO;
import lab.PanacheEntity.entity.Character;

import java.util.List;

@Path("/characters")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Rest {

    @Inject
    Service service;

    @GET
    public List<Character> getALL() {
        return service.getAllCharacters();
    }

    @GET
    @Path("/{id}")
    public Character getCharacterById(@PathParam("id") int id) {
        return service.getCharacterById(id);
    }

    @GET
    @Path("/filter")
    public List<Character> getByGender(@QueryParam("gender") String gender) {
        return service.getCharactersByGender(gender);
    }

    @POST
    public String addCharacter(CharacterAddDTO characterAddDTO) {
        service.addCharacter(characterAddDTO);
        return "Персонаж добавлен";
    }

    @PUT
    public Character changeCharacter(Character character) {
        return service.changeCharacter(character);
    }

    @DELETE
    @Path("/{id}")
    public String deleteCharacter(@PathParam("id") int id) {
        service.deleteCharacter(id);
        return "Персонаж удалён";
    }

    @POST
    @Path("/{id}/friend")
    @Consumes(MediaType.TEXT_PLAIN)
    public List<String> addFriends(@PathParam("id") int id, String friend) {
        return service.addFriend(id, friend);
    }

    @POST
    @Path("/{id}/friends")
    public List<String> addFriends(@PathParam("id") int id, List<String> friends) {
        return service.addFriends(id, friends);
    }

    @GET
    @Path("/{id}/friends")
    public List<String> getFriends(@PathParam("id") int id) {
        return service.getFriendNames(id);
    }
}
