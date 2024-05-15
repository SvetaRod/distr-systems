package lab;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lab.entity.Friend;
import lab.objects.CharacterAddDTO;
import lab.entity.Character;

import java.util.List;

@Path("/characters")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Web {

    @Inject
    Controller controller;

    @GET
    public List<Character> getALL() {
        return controller.getAllCharacters();
    }

    @GET
    @Path("/{id}")
    public Character getCharacterById(@PathParam("id") int id) {
        return controller.getCharacterById(id);
    }

    @GET
    @Path("/filter")
    public List<Character> getByGender(@QueryParam("gender") String gender) {
        return controller.getCharactersByGender(gender);
    }

    @POST
    public String addCharacter(CharacterAddDTO characterAddDTO) {
        controller.addCharacter(characterAddDTO);
        return "Персонаж добавлен";
    }

    @PUT
    public Character changeCharacter(Character character) {
        return controller.changeCharacter(character);
    }

    @DELETE
    @Path("/{id}")
    public String deleteCharacter(@PathParam("id") int id) {
        controller.deleteCharacter(id);
        return "Персонаж удалён";
    }

    @POST
    @Path("/{id}/friend")
    @Consumes(MediaType.TEXT_PLAIN)
    public List<String> addFriends(@PathParam("id") int id, String friend) {
        return controller.addFriend(id, friend);
    }

    @POST
    @Path("/{id}/friends")
    public List<String> addFriends(@PathParam("id") int id, List<String> friends) {
        return controller.addFriends(id, friends);
    }

    @GET
    @Path("/{id}/friends")
    public List<String> getFriends(@PathParam("id") int id) {
        return controller.getFriendNames(id);
    }
}
