package edu.austral.model;

import edu.austral.util.Collisionable;
import edu.austral.util.Vector2;

import java.awt.*;

/**
 * Created by AlumnosFI on 17/10/2017.
 */
public abstract class AbstractModel implements Collisionable<AbstractModel>{

    protected Vector2 position;
    protected String type;
    protected Shape shape;
    private String imagePath;
    protected boolean isAlive;

    public AbstractModel(Vector2 position, Shape shape, String imagePath) {
        this.position = position;
        this.shape = shape;
        this.imagePath = imagePath;
        isAlive = true;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void move(float x, float y){
        position = position.$plus(new Vector2(x,y));
    }


    @Override
    public Shape getShape() {
        return shape;
    }

    public String getType() {
        return type;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void kill(){isAlive = false;}

    public boolean isAlive() {
        return isAlive;
    }
}
