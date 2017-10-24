package edu.austral.controller;

import edu.austral.model.AbstractModel;
import edu.austral.model.Asteroid;
import edu.austral.model.Board;
import edu.austral.model.key.KeyDirection;
import edu.austral.util.Vector2;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Agustin on 19/10/2017.
 */
public class AsteroidController {
    private static AsteroidController ourInstance = new AsteroidController();
    private List<Asteroid> asteroidsOnScreen;

    public static AsteroidController getInstance() {
        return ourInstance;
    }

    private AsteroidController() {
        asteroidsOnScreen = new ArrayList<Asteroid>();
    }

    public void deleteasteroid(Asteroid asteroid){
        asteroidsOnScreen.remove(asteroid);
    }

    public List<AbstractModel> getAsteroidsOnScreen() {
        return (List<AbstractModel>) (Object)asteroidsOnScreen;
    }

    public void generateRandomASteroid(int boundX, int boundY, PApplet graphics){
        float randomX = (float)Math.random()*boundX;
        float randomY = (float)Math.random()*boundY;
        //Asteroid asteroid = new Asteroid(new Vector2(randomX, randomY), graphics);
        int option = (int) (Math.random()*4);
        Asteroid asteroid;
        switch (option){
            case 0:
                asteroid = new Asteroid(new Vector2(randomX, randomY), graphics, KeyDirection.UP);
                break;
            case 1:
                asteroid = new Asteroid(new Vector2(randomX, randomY), graphics, KeyDirection.DOWN);
                break;
            case 2:
                asteroid = new Asteroid(new Vector2(randomX, randomY), graphics, KeyDirection.RIGHT);
                break;
            case 3:
                asteroid = new Asteroid(new Vector2(randomX, randomY), graphics, KeyDirection.LEFT);
                break;
            default:
                asteroid = new Asteroid(new Vector2(randomX, randomY), graphics, KeyDirection.DOWN);
                break;
        }
        asteroidsOnScreen.add(asteroid);


    }

    public void update(Board board, PApplet graphics){

        if (graphics.frameCount % 200 == 0) generateRandomASteroid(board.getWidth(), board.getHeight(), graphics);

        for (int i = 0; i< asteroidsOnScreen.size(); i++){
            Asteroid asteroid = asteroidsOnScreen.get(i);
            if(!asteroid.isAlive()) asteroidsOnScreen.remove(asteroid);
            else asteroid.move();
        }
    }
}
