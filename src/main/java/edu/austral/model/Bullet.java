package edu.austral.model;

import edu.austral.model.key.KeyDirection;
import edu.austral.util.Vector2;

import java.awt.*;

/**
 * Created by Agustin on 19/10/2017.
 */
public class Bullet extends AbstractModel {
    private static final String imagePath = "";
    //Added variable
    private KeyDirection bulletDirection;
    private float speed;
    private float damage;

    public Bullet(Vector2 position, float speed, KeyDirection direction) {
        super(position, new Rectangle(100,100), imagePath, "Bullet");
        this.speed = speed;
        this.bulletDirection = direction;
    }

    @Override
    public void collisionedWith(AbstractModel collisionable) {
        kill();
    }

    public KeyDirection getBulletDirection() {
        return bulletDirection;
    }

    public float getSpeed() {
        return speed;
    }

    public float getDamage() {
        return damage;
    }
}
