package edu.austral.controller;

import edu.austral.model.AbstractModel;
import edu.austral.model.Player;
import edu.austral.model.key.KeyDictionary;
import edu.austral.model.key.KeyDirection;
import edu.austral.view.UIManager;

import java.util.List;

/**
 * Created by AlumnosFI on 17/10/2017.
 */
public class GameController {
    public PlayerController playerController;
    public AsteroidController asteroidController;
    public UIManager uiManager;

    private static GameController ourInstance = new GameController();

    public static GameController getInstance() {
        return ourInstance;
    }

    //Main update
    public void update(float time){

        asteroidController.update(time);
        if (System.currentTimeMillis()%10 == 0) asteroidController.generateRandomASteroid(500,500);
        playerController.update(time);
        List<AbstractModel> asteroids = asteroidController.getAsteroidsOnScreen();
        List<AbstractModel> spaceShips = playerController.getSpaceShips();
        uiManager.appendsListToDrawables(asteroids);
        uiManager.appendsListToDrawables(spaceShips);
    }

    //Occurs when a key is pressed
    public void onKeyPressed(int code){
        Player one = playerController.getPlayer(1);
        //Player two = playerController.getPlayer(2);

        KeyDictionary oneDict = one.getKeys();
        //KeyDictionary twoDict = two.getKeys();

        //Moving player one spaceship
        one.getSpaceship().move(getIntentionFromKey(code, oneDict));

        //Moving player two spaceship
        //two.getSpaceship().move(getIntentionFromKey(code, twoDict));

    }

    //Reads key info, from a dictionary
    private KeyDirection getIntentionFromKey(int code, KeyDictionary dict){
        if(code == dict.getUp()) return KeyDirection.UP;
        else if(code == dict.getDown()) return KeyDirection.DOWN;
        else if(code == dict.getLeft()) return KeyDirection.LEFT;
        else if(code == dict.getRight()) return KeyDirection.RIGHT;
        else return KeyDirection.NONE;
    }

    private GameController() {
        playerController = PlayerController.getInstance();
        asteroidController = AsteroidController.getInstance();
        uiManager = UIManager.getInstance();
    }

    public void addPlayer(Player player){
        playerController.createPlayer(player);
    }
}
