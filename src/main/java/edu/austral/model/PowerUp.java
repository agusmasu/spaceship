package edu.austral.model;

import edu.austral.model.AbstractModel;
import edu.austral.util.Vector2;

import java.awt.*;

/**
 * Created by Agustin on 19/10/2017.
 */
public class PowerUp extends AbstractModel {

    private static final String imagePath = "";
    private float speedMultiplicator;

    public PowerUp(Vector2 position, Shape shape, float speedMultiplicator) {
        super(position, shape, imagePath, "PowerUp");
        this.speedMultiplicator = speedMultiplicator;

    }

    @Override
    public void collisionedWith(AbstractModel collisionable) {
        kill();
    }
}
