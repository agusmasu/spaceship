package edu.austral.controller;

import edu.austral.model.AbstractModel;
import edu.austral.model.Asteroid;
import edu.austral.model.Board;
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
        Asteroid asteroid = new Asteroid(new Vector2(randomX, randomY), graphics);
        asteroidsOnScreen.add(asteroid);
        //System.out.println("Created Ast at "+ randomX + ", "+randomY);
    }

    public void update(Board board, PApplet graphics){

        if (System.currentTimeMillis()%10 == 0) generateRandomASteroid(board.getWidth(), board.getHeight(), graphics);

        for(Asteroid aste: asteroidsOnScreen){
            if(!aste.isAlive()) asteroidsOnScreen.remove(aste);
        }
    }
}
