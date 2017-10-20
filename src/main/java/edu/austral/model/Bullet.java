package edu.austral.model;

import edu.austral.util.Vector2;

import java.awt.*;

/**
 * Created by Agustin on 19/10/2017.
 */
public class Bullet extends AbstractModel {
    private static final String imagePath = "";
    private float speed;

    public Bullet(Vector2 position, float speed) {
        super(position, new Rectangle(100,100), imagePath);
        this.speed = speed;
    }

    @Override
    public void collisionedWith(AbstractModel collisionable) {
        kill();
    }
}
