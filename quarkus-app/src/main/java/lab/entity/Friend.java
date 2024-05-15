package lab.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Friend extends PanacheEntity {

    private long characterID;
    private String friendName;

    public long getCharacterID(){
        return characterID;
    }
    public void setCharacterID(long characterID){
        this.characterID = characterID;
    }
    public String getFriendName(){
        return friendName;
    }
    public void setFriendName(String friendName){
        this.friendName = friendName;
    }
}
