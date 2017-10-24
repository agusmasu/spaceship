package edu.austral.controller;

import edu.austral.model.AbstractModel;
import edu.austral.model.Board;
import edu.austral.model.Bullet;
import edu.austral.model.Player;
import edu.austral.model.key.KeyDictionary;
import edu.austral.model.key.KeyDirection;
import edu.austral.util.CollisionEngine;
import edu.austral.util.Collisionable;
import edu.austral.view.UIManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AlumnosFI on 17/10/2017.
 */
public class GameController {
    public PlayerController playerController;
    public AsteroidController asteroidController;
    public BulletController bulletController = BulletController.getInstance();
    public UIManager uiManager;
    private Board board;
    private CollisionEngine engine;

    public void setBoard(Board board) {
        this.board = board;
    }

    private static GameController ourInstance = new GameController();

    public static GameController getInstance() {
        return ourInstance;
    }

    //Main update
    public void update(float time){
        //Random to generate asteroids
        if (System.currentTimeMillis()%10 == 0) asteroidController.generateRandomASteroid(board.getWidth(), board.getHeight());

        asteroidController.update();
        playerController.update(time, board);
        bulletController.update(time, board.getWidth(), board.getHeight());

        List<AbstractModel> toDraw = new ArrayList<>();
        toDraw.addAll(asteroidController.getAsteroidsOnScreen());
        toDraw.addAll(playerController.getSpaceShips());
        toDraw.addAll(bulletController.getBulletsOnScreen());

        //Adds alll lists to UIManager

        uiManager.setToDraw(toDraw);

        engine.checkCollisions(uiManager.getToDraw());
    }

    //Occurs when a key is pressed
    public void onKeyPressed(int code){
        Player one = playerController.getPlayer(1);
        //Player two = playerController.getPlayer(2);

        KeyDictionary oneDict = one.getKeys();
        //KeyDictionary twoDict = two.getKeys();

        if(code == oneDict.getShoot()) shoot(one);

        //Moving player one spaceship
        one.getSpaceship().move(getIntentionFromKey(code, oneDict));

        //Moving player two spaceship
        //two.getSpaceship().move(getIntentionFromKey(code, twoDict));

    }

    //Reads key info, from a dictionary
    private KeyDirection getIntentionFromKey(int code, KeyDictionary dict){
        if(code == dict.getUp()) return KeyDirection.DOWN;
        else if(code == dict.getDown()) return KeyDirection.UP;
        else if(code == dict.getLeft()) return KeyDirection.LEFT;
        else if(code == dict.getRight()) return KeyDirection.RIGHT;
        else return KeyDirection.NONE;
    }

    private GameController() {
        playerController = PlayerController.getInstance();
        asteroidController = AsteroidController.getInstance();
        uiManager = UIManager.getInstance();
        engine = new CollisionEngine();
    }

    private void shoot(Player player){
        if (!playerController.getPlayerHistory().contains(player)) return;
        Bullet bullet = new Bullet(player.getSpaceship().getPosition(), 10, player.getSpaceship().getDirection());
        bulletController.addBullet(bullet);
    }

}
