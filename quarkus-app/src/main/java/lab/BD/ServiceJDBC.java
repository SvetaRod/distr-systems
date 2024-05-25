package lab.BD;

import jakarta.enterprise.context.ApplicationScoped;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import lab.BD.entity.Character;

import lab.BD.models.CharacterAddDTO;

@ApplicationScoped
public class ServiceJDBC {

    private Connection connection;

    public ServiceJDBC() {
        initConnection();
    }

    public void initConnection() {
        String url = "jdbc:postgresql://bd:5432/characters";
        String username = "user";
        String password = "password";

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.out.println("Не удалось подключиться к базе. " + e.getMessage());
        }
    }

    public List<Character> getAllCharacters() {
        List<Character> characters = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM character");


            while (result.next()) {
                Character character = new Character();
                character.id = result.getLong("id");
                character.setName(result.getString("name"));
                character.setAge(result.getInt("age"));
                character.setGender(result.getString("gender"));
                characters.add(character);
            }
        } catch (Exception e) {
            System.out.println("Запрос не выполнен. " + e.getMessage());
        }
        return characters;
    }

    public boolean addCharacter(CharacterAddDTO character) {
        try {
            String sql = "INSERT INTO character (name, age, gender) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, character.getName());
            preparedStatement.setInt(2, character.getAge());
            preparedStatement.setString(3, character.getGender());

            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Запрос не выполнен." + e.getMessage());
            return false;
        }
    }

    public boolean changeCharacter(Character character) {
        try {
            String sql = "UPDATE character SET name = ?, age = ?, gender = ? WHERE id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, character.getName());
            preparedStatement.setInt(2, character.getAge());
            preparedStatement.setString(3, character.getGender());
            preparedStatement.setLong(4, character.id);

            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Запрос не выполнен." + e.getMessage());
            return false;
        }
    }

    public boolean deleteCharacter(Long id) {
        try {
            String sql = "DELETE FROM character WHERE id = " + id;
            Statement statement = connection.createStatement();

            statement.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            System.out.println("Запрос не выполнен." + e.getMessage());
            return false;
        }
    }
}
