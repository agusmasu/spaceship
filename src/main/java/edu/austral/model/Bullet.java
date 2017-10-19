package edu.austral.model;

import edu.austral.util.Vector2;

import java.awt.*;

/**
 * Created by Agustin on 19/10/2017.
 */
public class Bullet extends AbstractModel {

    public Bullet(Vector2 position) {
        super(position, new Rectangle(100,100), "");
    }

    @Override
    public void collisionedWith(AbstractModel collisionable) {

    }
}
