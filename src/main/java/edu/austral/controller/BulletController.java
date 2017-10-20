package edu.austral.controller;

import edu.austral.model.Bullet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Agustin on 19/10/2017.
 */
public class BulletController {
    private static BulletController ourInstance = new BulletController();
    private List<Bullet> bulletsOnScreen;

    public static BulletController getInstance() {
        return ourInstance;
    }

    private BulletController() {
        bulletsOnScreen = new ArrayList<>();
    }

    //Added method
    public void update(float time, float maxX, float maxY){
        for (Bullet bullet: bulletsOnScreen){


            if(bullet.getPosition().x() > maxX) bullet.kill();
            if(bullet.getPosition().y() > maxY) bullet.kill();

            if(!bullet.isAlive()) bulletsOnScreen.remove(bullet);
        }
    }

    public void addBullet(Bullet bullet){
        bulletsOnScreen.add(bullet);
    }

    public void destroy(Bullet bullet){
        if (bulletsOnScreen.contains(bullet)) bulletsOnScreen.remove(bullet);
    }

}
