package edu.austral.model;

import edu.austral.util.Vector2;

import java.awt.*;

/**
 * Created by AlumnosFI on 17/10/2017.
 */
public class Asteroid extends AbstractModel {
    private float health;
    private float rotation;
    private static final String imagePath = "";

    public Asteroid(Vector2 position) {
        super(position, new Rectangle(Math.round(position.x()), Math.round(position.y()), 40, 40) ,imagePath, "Asteroid");
    }

    @Override
    public void collisionedWith(AbstractModel collisionable) {

    }
}
