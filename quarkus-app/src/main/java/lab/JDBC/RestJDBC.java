package lab.JDBC;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import lab.JDBC.models.Character;
import lab.PanacheEntity.models.CharacterAddDTO;

import java.util.List;

@Path("jdbc/characters")
public class RestJDBC {

    @Inject
    private ServiceJDBC controller;

    @GET
    public List<Character> getALL() {
        return controller.getAllCharacters();
    }

    @POST
    public String addCharacter(CharacterAddDTO characterAddDTO) {
        if (controller.addCharacter(characterAddDTO))
            return "Запрос выполнен";
        else
            return "Запрос выполнен";
    }

    @PUT
    public String changeCharacter(Character character) {
        if (controller.changeCharacter(character))
            return "Запрос выполнен";
        else
            return "Запрос не выполнен";
    }

    @DELETE
    @Path("/{id}")
    public String deleteCharacter(@PathParam("id") long id) {
        if (controller.deleteCharacter(id))
            return "Запрос выполнен";
        else
            return "Запрос не выполнен";
    }
}
