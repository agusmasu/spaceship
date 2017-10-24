package edu.austral.model;

import edu.austral.util.Vector2;

import java.awt.*;

/**
 * Created by AlumnosFI on 17/10/2017.
 */
public class Asteroid extends AbstractModel {
    private float health;
    private float rotation;

    public Asteroid(Vector2 position) {
        super(position, new Rectangle(Math.round(position.x()), Math.round(position.y()), 40, 40) ,"resources/asteroid.png", "Asteroid");
        width = 30;
        height = 30;
        autoUpdateShape();
    }

    @Override
    public void collisionedWith(AbstractModel collisionable) {

    }

    private void autoUpdateShape(){
        shape = new Rectangle(Math.round(position.x()), Math.round(position.y()), width, height);
    }
}
