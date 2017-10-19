package edu.austral;
import edu.austral.controller.GameController;
import edu.austral.model.AbstractModel;
import edu.austral.model.Player;
import edu.austral.model.SpaceShip;
import edu.austral.model.Weapon;
import edu.austral.model.key.KeyDictionary;
import edu.austral.util.Vector2;
import processing.core.PApplet;
import processing.core.PImage;

import java.awt.event.KeyEvent;
import java.util.List;

public class Main extends GameFramework {
    private static GameController gameController = GameController.getInstance();

    public static void main(String args[]) {
        PApplet.main("edu.austral.Main");
        defaultSettings();
    }

    private static void defaultSettings(){

        KeyDictionary playerOneDict = new KeyDictionary(KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D, KeyEvent.VK_SHIFT);

        Player one = new Player("Agustin", "masu", "Masuelli", "asd", "agus_masu@asd", playerOneDict);
        gameController.playerController.createPlayer(one);
        gameController.playerController.setFirstPlayer(one);

        Weapon weapon = new Weapon();
        SpaceShip ss = new SpaceShip(new Vector2(0,0), weapon);

        one.setSpaceship(ss);
        gameController.addPlayer(one);

    }

    @Override public void draw(float time, PApplet graphics) {
        gameController.update(time);
        List<AbstractModel> models = gameController.uiManager.getToDraw();
        //System.out.println(models.size());
        for(AbstractModel model: models){
            if(model.getType() == "Asteroid") ellipse(model.getPosition().x(), model.getPosition().y(), 27,27);
        }

        PImage image = loadImage("spaceship.png");
        image(image, 100, 100);

    }

    @Override
    public void keyPressed(KeyEvent event) {

    }
}
