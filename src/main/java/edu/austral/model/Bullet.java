package edu.austral.model;

import edu.austral.model.key.KeyDirection;
import edu.austral.util.Vector2;
import processing.core.PApplet;

import java.awt.*;

/**
 * Created by Agustin on 19/10/2017.
 */
public class Bullet extends AbstractModel {
    private float speed;
    private float damage;

    public Bullet(Vector2 position, float speed, KeyDirection direction, PApplet graphics, float damage) {
        super(position, new Rectangle(100,100), "resources/bullet.png", "Bullet", graphics);
        this.speed = speed;
        this.direction = direction;
        width = 10;
        height = 10;
        isAlive = true;
        this.damage = damage;
    }

    public void move(){
        switch(direction){
            case UP:
                position = position.$plus(new Vector2(0, 5));
                break;
            case DOWN:
                position = position.$plus(new Vector2(0, -5));
                break;
            case RIGHT:
                position = position.$plus(new Vector2(5, 0));
                break;
            case LEFT:
                position = position.$plus(new Vector2(-5, 0));
                break;
        }
        autoUpdateShape();
    }

    @Override
    public void collisionedWith(AbstractModel collisionable) {
        if(collisionable.getType() == "Asteroid") kill();
    }

    public float getDamage() {
        return damage;
    }

    private void autoUpdateShape(){
        shape = new Rectangle(Math.round(position.x()), Math.round(position.y()), width, height);
    }
}
