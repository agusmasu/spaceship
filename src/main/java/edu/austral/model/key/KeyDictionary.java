package edu.austral.model.key;

import static java.awt.event.KeyEvent.VK_Q;

/**
 * Created by Agustin on 19/10/2017.
 */
public class KeyDictionary {
    private int up, down, right, left, shoot;

    public KeyDictionary(int up, int down, int right, int left, int shoot) {
        this.up = up;
        this.down = down;
        this.right = right;
        this.left = left;
        this.shoot = shoot;
    }

    public int getUp() {
        return up;
    }

    public int getDown() {
        return down;
    }

    public int getRight() {
        return right;
    }

    public int getLeft() {
        return left;
    }

    public int getShoot() {
        return shoot;
    }
}
