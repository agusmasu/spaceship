package edu.austral.model;

import edu.austral.model.key.KeyDirection;
import edu.austral.util.Vector2;

import java.awt.*;

/**
 * Created by AlumnosFI on 17/10/2017.
 */
public class SpaceShip extends AbstractModel {
    private float health;
    private float speed;
    private float rotation;

    private Weapon primaryWeapon;
    private Weapon standardWeapon;
    private int primaryWeaponAmmo;

    public SpaceShip(Vector2 position, Weapon standart) {
        super(position, new Rectangle(Math.round(position.x()), Math.round(position.y()), 100, 100), "edu.austral.resources.spaceship.png");
        standardWeapon = standart;
        health = 100;
    }

    public float getHealth() {
        return health;
    }



    public float getSpeed() {
        return speed;
    }

    public Weapon getPrimaryWeapon() {
        return primaryWeapon;
    }

    public Weapon getStandardWeapon() {
        return standardWeapon;
    }

    public int getPrimaryWeaponAmmo() {
        return primaryWeaponAmmo;
    }

    public void move(KeyDirection toMove){
        switch(toMove){
            case UP:
                position.$plus(new Vector2(0, 1));
                return;
            case DOWN:
                position.$plus(new Vector2(0, -1));
                return;
            case RIGHT:
                position.$plus(new Vector2(1, 0));
                return;
            case LEFT:
                position.$plus(new Vector2(-1, 1));
                return;
        }
    }

    @Override
    public void collisionedWith(AbstractModel collisionable) {
        if (collisionable.getType() == "Asteroid"){
            health -= 20;
        }
        else if (collisionable.getType() == "Bullet"){
            health-= 10;
        }

    }
}
