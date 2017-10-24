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
        super(position, new Rectangle(Math.round(position.x()), Math.round(position.y()), 100, 100),
                "resources/spaceship.png", "SpaceShip");
        standardWeapon = standart;
        health = 100;
        width = 30;
        height = 30;
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
                position = position.$plus(new Vector2(0, 5));
                break;
            case DOWN:
                position = position.$plus(new Vector2(0, -5));
                break;
            case RIGHT:
                position = position.$plus(new Vector2(5, 0));
                break;
            case LEFT:
                position = position.$plus(new Vector2(-5, 1));
                break;
        }
        autoUpdateShape();
    }

    @Override
    public void collisionedWith(AbstractModel collisionable) {
        if (collisionable.getType() == "Asteroid"){
            health -= 20;
            System.out.println("Asteroid collided");
        }
        else if (collisionable.getType() == "Bullet"){
            health -= ((Bullet)collisionable).getDamage();
        }
    }

    private void autoUpdateShape(){
        shape = new Rectangle(Math.round(position.x()), Math.round(position.y()), width, height);
    }
}
