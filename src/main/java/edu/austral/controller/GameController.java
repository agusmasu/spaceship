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
import processing.core.PApplet;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AlumnosFI on 17/10/2017.
 */
public class GameController {
    public PlayerController playerController;
    public AsteroidController asteroidController;
    public BulletController bulletController = BulletController.getInstance();
    public DropController dropController = DropController.getInstance();
    public UIManager uiManager;
    private Board board;
    private CollisionEngine engine;
    private boolean isPaused = false;

    public void setBoard(Board board) {
        this.board = board;
    }

    private static GameController ourInstance = new GameController();

    public static GameController getInstance() {
        return ourInstance;
    }

    //Main update
    public void update(float time, PApplet graphics){

        if(isPaused){
            return;
        }

        asteroidController.update(board, graphics);
        playerController.update(time, board);
        bulletController.update(time, board);
        dropController.update(graphics, board);

        List<AbstractModel> toDraw = new ArrayList<>();
        toDraw.addAll(asteroidController.getAsteroidsOnScreen());
        toDraw.addAll(playerController.getSpaceShips());
        toDraw.addAll(bulletController.getBulletsOnScreen());
        toDraw.addAll(dropController.getAllPowerUps());

        //Adds alll lists to UIManager

        uiManager.setToDraw(toDraw);

        engine.checkCollisions(uiManager.getToDraw());

        graphics.text("Score Player 1: "+ playerController.getPlayer(1).getScore(), 0, 10);
    }

    //Occurs when a key is pressed
    public void onKeyPressed(int code, PApplet graphics){


        System.out.println(KeyEvent.VK_P);
        System.out.println(code);
        if(code == KeyEvent.VK_P){
            System.out.println("LALA");
            if(isPaused) resume(graphics);
            else pause(graphics);
            return;
        }

        if(isPaused) return;

        Player one = playerController.getPlayer(1);
        //Player two = playerController.getPlayer(2);

        KeyDictionary oneDict = one.getKeys();
        //KeyDictionary twoDict = two.getKeys();

        if(code == oneDict.getShoot()) shoot(one, graphics);

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

    private void shoot(Player player, PApplet graphics){
        if (!playerController.getPlayerHistory().contains(player)) return;
        System.out.println("Method shoot");
        Bullet bullet = new Bullet(player.getSpaceship().getPosition(), 10, player.getSpaceship().getDirection(), graphics, player.getSpaceship().getStandardWeapon().getDamage());
        bulletController.addBullet(bullet);
    }

    public void pause(PApplet graphics){
        graphics.pause();
        isPaused = true;
        System.out.println("PAUSED");
    }

    public void resume(PApplet graphics){
        graphics.resume();
        isPaused = false;
        System.out.println("RESUME");
    }

}
