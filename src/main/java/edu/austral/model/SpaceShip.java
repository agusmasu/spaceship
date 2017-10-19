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
        //switch con las directions
    }

    @Override
    public void collisionedWith(AbstractModel collisionable) {
        if (collisionable.getType() == "Asteroid"){
            //TODO should harm spaceship
        }
        else if (collisionable.getType() == "Drop"){

        }
    }
}
