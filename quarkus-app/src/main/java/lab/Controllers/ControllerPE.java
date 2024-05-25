package lab.Controllers;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lab.BD.ServicePE;
import lab.BD.models.CharacterAddDTO;
import lab.BD.entity.Character;

import java.util.List;

@Path("/characters")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ControllerPE {

    @Inject
    ServicePE servicePE;

    @GET
    public List<Character> getALL() {
        return servicePE.getAllCharacters();
    }

    @GET
    @Path("/{id}")
    public Character getCharacterById(@PathParam("id") int id) {
        return servicePE.getCharacterById(id);
    }

    @GET
    @Path("/filter")
    public List<Character> getByGender(@QueryParam("gender") String gender) {
        return servicePE.getCharactersByGender(gender);
    }

    @POST
    public String addCharacter(CharacterAddDTO characterAddDTO) {
        servicePE.addCharacter(characterAddDTO);
        return "Персонаж добавлен";
    }

    @PUT
    public Character changeCharacter(Character character) {
        return servicePE.changeCharacter(character);
    }

    @DELETE
    @Path("/{id}")
    public String deleteCharacter(@PathParam("id") int id) {
        servicePE.deleteCharacter(id);
        return "Персонаж удалён";
    }

    @POST
    @Path("/{id}/friend")
    @Consumes(MediaType.TEXT_PLAIN)
    public List<String> addFriends(@PathParam("id") int id, String friend) {
        return servicePE.addFriend(id, friend);
    }

    @POST
    @Path("/{id}/friends")
    public List<String> addFriends(@PathParam("id") int id, List<String> friends) {
        return servicePE.addFriends(id, friends);
    }

    @GET
    @Path("/{id}/friends")
    public List<String> getFriends(@PathParam("id") int id) {
        return servicePE.getFriendNames(id);
    }
}
