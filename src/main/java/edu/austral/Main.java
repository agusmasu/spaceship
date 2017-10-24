package edu.austral;
import edu.austral.controller.GameController;
import edu.austral.model.*;
import edu.austral.model.key.KeyDictionary;
import edu.austral.util.Vector2;
import processing.core.PApplet;
import processing.core.PImage;

import java.awt.event.KeyEvent;
import java.util.List;

import static java.awt.event.KeyEvent.*;

public class Main extends GameFramework {
    private static GameController gameController = GameController.getInstance();
    private boolean started = false;

    public static void main(String args[]) {
        PApplet.main("edu.austral.Main");
    }

    private static void defaultSettings(PApplet graphics){
        gameController.setBoard(new Board(500, 500));

        KeyDictionary playerOneDict = new KeyDictionary(VK_W, KeyEvent.VK_S, KeyEvent.VK_D, VK_A, KeyEvent.VK_SHIFT);

        Player one = new Player("Agustin", "masu", "Masuelli", "asd", "agus_masu@asd", playerOneDict);
        gameController.playerController.createPlayer(one);
        gameController.playerController.setFirstPlayer(one);

        Weapon weapon = new Weapon();
        SpaceShip ss = new SpaceShip(new Vector2(0,0), weapon, graphics);

        one.setSpaceship(ss);
        gameController.playerController.createPlayer(one);

    }

    @Override public void draw(float time, PApplet graphics) {
        if(!started){
            started = true;
            defaultSettings(graphics);
        }

        gameController.update(time, graphics);
        List<AbstractModel> models = gameController.uiManager.getToDraw();

        gameController.uiManager.draw(graphics);

        //image(loadImage("resources/bullet.jpg"), 10, 10 , 10, 10);

    }

    private void testing(){
        this.gameController.onKeyPressed(VK_D, this);
    }

    @Override
    public void keyPressed(KeyEvent event) {
        System.out.println("Pressed");
    }

    @Override
    public void keyPressed() {
        //System.out.println("X: "+ gameController.playerController.getPlayer(1).getSpaceship().getPosition().x()+ ", Y: "+ gameController.playerController.getPlayer(1).getSpaceship().getPosition().y());
        //System.out.println("hola");

        //System.out.println(keyCode);
        gameController.onKeyPressed(keyCode, this);

        draw();
    }
}
