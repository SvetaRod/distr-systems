package lab.objects;

import java.util.ArrayList;
import java.util.List;

public class Character {
    private int id;
    private String name;
    private String gender;
    private int age;
    private List<String> friends = new ArrayList<>();


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getFriends(){return friends;}
    public void setFriends(List<String> friends)
    {
        this.friends = friends;
    }
}
