package edu.austral.model;

import edu.austral.model.key.KeyDirection;
import edu.austral.util.Collisionable;
import edu.austral.util.Vector2;
import processing.core.PApplet;
import processing.core.PImage;

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
    protected KeyDirection direction;
    private PImage img;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    protected int width, height;

    public AbstractModel(Vector2 position, Shape shape, String imagePath, String type, KeyDirection direction, PApplet graphics) {
        this.position = position;
        this.shape = shape;
        this.imagePath = imagePath;
        this.type = type;
        isAlive = true;
        this.direction = direction;
        img = graphics.loadImage(imagePath);
    }

    public AbstractModel(Vector2 position, Shape shape, String imagePath, String type, PApplet graphics) {
        this.position = position;
        this.shape = shape;
        this.imagePath = imagePath;
        this.type = type;
        isAlive = true;
        this.direction = KeyDirection.RIGHT;
        img = graphics.loadImage(imagePath);
    }

    public Vector2 getPosition() {
        return position;
    }

    public void move(float x, float y){
        position = position.$plus(new Vector2(x,y));
        if (x > 0 ) direction = KeyDirection.RIGHT;
        else if (x < 0) direction = KeyDirection.LEFT;
        else if (y > 0) direction = KeyDirection.UP;
        else if(y > 0 ) direction = KeyDirection.DOWN;
    }

    public void moveTo(float x, float y){
        position = new Vector2(x,y);
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

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public KeyDirection getDirection() {
        return direction;
    }

    public void setDirection(KeyDirection direction) {
        this.direction = direction;
    }

    public PImage getImg() {
        return img;
    }
}
