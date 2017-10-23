package edu.austral.model;

import edu.austral.util.Vector2;

/**
 * Created by Agustin on 20/10/2017.
 */
public class Board {
    private int height;
    private int width;

    public Board(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    //Added method
    public boolean isInside(AbstractModel model){
        Vector2 position = model.getPosition();
        if (position.x() > width ||
                position.x() < 0 ||
                position.y() > height ||
                position.y() < 0){
            return false;
        }
        else return true;
    }
}
