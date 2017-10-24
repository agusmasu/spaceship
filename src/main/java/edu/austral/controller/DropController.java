package edu.austral.controller;

import edu.austral.model.AbstractModel;
import edu.austral.model.Asteroid;
import edu.austral.model.Board;
import edu.austral.model.PowerUp;
import edu.austral.util.Vector2;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by Agustin on 24/10/2017.
 */
public class DropController {
    private static DropController ourInstance = new DropController();

    private List<PowerUp> powerUps;

    public static DropController getInstance() {
        return ourInstance;
    }

    private DropController() {
        powerUps = new ArrayList<>();
    }

    public void update(PApplet graphics, Board board){
        if(graphics.frameCount % 500 == 0) generateRandomPowerUp(board.getWidth(), board.getHeight(), graphics);
    }

    private void generateRandomPowerUp(int boundX, int boundY, PApplet graphics){
        float randomX = (float)Math.random()*boundX;
        float randomY = (float)Math.random()*boundY;
        PowerUp powerUp = new PowerUp(new Vector2(randomX, randomY), 1.005f ,graphics);
        powerUps.add(powerUp);
    }

    public List<AbstractModel> getAllPowerUps(){
        return (List<AbstractModel>) (Object) powerUps;
    }

}
