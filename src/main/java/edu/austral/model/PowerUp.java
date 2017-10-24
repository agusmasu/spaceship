package edu.austral.model;

import edu.austral.model.AbstractModel;
import edu.austral.util.Vector2;
import processing.core.PApplet;

import java.awt.*;

/**
 * Created by Agustin on 19/10/2017.
 */
public class PowerUp extends AbstractModel {

    private static final String imagePath = "resources/powerup.png";
    private float speedMultiplicator;

    public PowerUp(Vector2 position, float speedMultiplicator, PApplet graphics) {
        super(position, new Rectangle(Math.round(position.x()), Math.round(position.y()), 50, 50), imagePath, "PowerUp", graphics);
        width = 50;
        height = 50;
        this.speedMultiplicator = speedMultiplicator;

    }

    @Override
    public void collisionedWith(AbstractModel collisionable) {
        kill();
    }

    private void autoUpdateShape(){
        shape = new Rectangle(Math.round(position.x()), Math.round(position.y()), width, height);
    }

    public float getSpeedMultiplicator() {
        return speedMultiplicator;
    }
}
