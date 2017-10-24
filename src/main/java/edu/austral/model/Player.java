package edu.austral.model;

import edu.austral.model.key.KeyDictionary;
import edu.austral.model.key.KeyDirection;

/**
 * Created by AlumnosFI on 17/10/2017.
 */
public class Player {


    private String name, username, surname, password, email;
    private float score;
    private SpaceShip spaceship;
    private KeyDictionary keys;

    public Player(String name, String username, String surname, String password, String email, KeyDictionary keys) {
        this.name = name;
        this.username = username;
        this.surname = surname;
        this.password = password;
        this.email = email;
        this.keys = keys;
        this.score = 0;
    }

    public SpaceShip getSpaceship() {
        return spaceship;
    }

    public KeyDictionary getKeys() {
        return keys;
    }

    public void setSpaceship(SpaceShip spaceship) {
        this.spaceship = spaceship;
    }

    public String getName() {
        return name;
    }

    public float getScore() {
        return score;
    }

    public void addScore(float toAdd){
        score += toAdd;
    }
}
