package edu.austral.controller;

import edu.austral.model.AbstractModel;
import edu.austral.model.Bullet;

import java.awt.*;
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
        for (int i = 0; i< bulletsOnScreen.size(); i++){

            Bullet bullet = bulletsOnScreen.get(i);

            //if(bullet.getPosition().x() > maxX) bullet.kill();
            //if(bullet.getPosition().y() > maxY) bullet.kill();

            if(!bullet.isAlive()) bulletsOnScreen.remove(bullet);

            bullet.move();
        }
    }

    public void addBullet(Bullet bullet){
        bulletsOnScreen.add(bullet);
    }

    public void destroy(Bullet bullet){
        if (bulletsOnScreen.contains(bullet)) bulletsOnScreen.remove(bullet);
    }

    public List<AbstractModel> getBulletsOnScreen(){
        return (List<AbstractModel>)(Object)bulletsOnScreen;
    }

}
