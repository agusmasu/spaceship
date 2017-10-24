package edu.austral.model;

import edu.austral.model.key.KeyDirection;
import edu.austral.util.Vector2;
import processing.core.PApplet;

import java.awt.*;

/**
 * Created by AlumnosFI on 17/10/2017.
 */
public class Asteroid extends AbstractModel {
    private float health;
    private float rotation;

    public Asteroid(Vector2 position, PApplet graphics, KeyDirection direction) {
        super(position, new Rectangle(Math.round(position.x()), Math.round(position.y()), 40, 40) ,"resources/asteroid.png", "Asteroid", graphics);
        width = 30;
        height = 30;
        this.direction = direction;
        autoUpdateShape();
    }


    public void move(){
        switch(direction){
            case UP:
                position = position.$plus(new Vector2(0, 1));
                break;
            case DOWN:
                position = position.$plus(new Vector2(0, -1));
                break;
            case RIGHT:
                position = position.$plus(new Vector2(1, 0));
                break;
            case LEFT:
                position = position.$plus(new Vector2(-1, 0));
                break;
        }
        autoUpdateShape();
    }


    @Override
    public void collisionedWith(AbstractModel collisionable) {
        kill();
    }

    private void autoUpdateShape(){
        shape = new Rectangle(Math.round(position.x()), Math.round(position.y()), width, height);
    }
}
