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

    public static void main(String args[]) {
        PApplet.main("edu.austral.Main");
        defaultSettings();
    }

    private static void defaultSettings(){
        gameController.setBoard(new Board(500, 500));

        KeyDictionary playerOneDict = new KeyDictionary(VK_W, KeyEvent.VK_S, KeyEvent.VK_D, VK_A, KeyEvent.VK_SHIFT);

        Player one = new Player("Agustin", "masu", "Masuelli", "asd", "agus_masu@asd", playerOneDict);
        gameController.playerController.createPlayer(one);
        gameController.playerController.setFirstPlayer(one);

        Weapon weapon = new Weapon();
        SpaceShip ss = new SpaceShip(new Vector2(0,0), weapon);

        one.setSpaceship(ss);
        gameController.addPlayer(one);

    }

    @Override public void draw(float time, PApplet graphics) {
        //System.out.println("Running at "+ frameRate+ " FPS");
        gameController.update(time);
        List<AbstractModel> models = gameController.uiManager.getToDraw();
        //System.out.println(models.size());
        for(AbstractModel model: models){
            if(model.getType() == "Asteroid") ellipse(model.getPosition().x(), model.getPosition().y(), 27,27);
            if(model.getType() == "SpaceShip") rect(model.getPosition().x(), model.getPosition().y(), 27,27);
        }
        //testing();



    }

    private void testing(){
        this.gameController.onKeyPressed(VK_D);
    }

    @Override
    public void keyPressed(KeyEvent event) {
        System.out.println("Pressed");
    }

    @Override
    public void keyPressed() {
        System.out.println("X: "+ gameController.playerController.getPlayer(1).getSpaceship().getPosition().x()+ ", Y: "+ gameController.playerController.getPlayer(1).getSpaceship().getPosition().y());
        System.out.println("hola");

        switch (key) {
            case 'w':
                gameController.onKeyPressed(VK_W);
                break;
            case 'a':
                gameController.onKeyPressed(VK_A);
                break;
            case 's':
                gameController.onKeyPressed(VK_S);
                break;
            case 'd':
                gameController.onKeyPressed(VK_D);
                break;
        }
        draw();
    }
}
