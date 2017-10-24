package edu.austral.model;

import edu.austral.util.Vector2;
import processing.core.PApplet;

import java.awt.*;

/**
 * Created by Agustin on 19/10/2017.
 */
public class WeaponDrop extends AbstractModel {
    private static final String imagePath = "";
    private Weapon weapon;

    public WeaponDrop(Vector2 position, Shape shape, Weapon weapon, PApplet graphics) {
        super(position, shape, imagePath, "WeaponDrop", graphics);
        this.weapon = weapon;
    }

    @Override
    public void collisionedWith(AbstractModel collisionable) {

    }

    public Weapon getWeapon() {
        return weapon;
    }
}
