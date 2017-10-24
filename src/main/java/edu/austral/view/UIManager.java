package edu.austral.view;

import edu.austral.model.AbstractModel;
import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Agustin on 19/10/2017.
 */
public class UIManager {
    private static UIManager ourInstance = new UIManager();
    private List<AbstractModel> toDraw;
    private PImage img;

    public static UIManager getInstance() {
        return ourInstance;
    }

    private UIManager() {
        toDraw = new ArrayList<>();
    }

    public void addModel(AbstractModel model){
        toDraw.add(model);
    }

    public List<AbstractModel> getToDraw() {
        return toDraw;
    }

    public void appendsListToDrawables(List<AbstractModel> drawables){
        toDraw.addAll(drawables);
    }


    public void setToDraw(List<AbstractModel> toDraw) {
        this.toDraw = toDraw;
    }

    public void draw(PApplet game){
        if (img == null) img = game.loadImage("resources/spaceship.png");
        System.out.println(toDraw.size());
        for (AbstractModel model: toDraw){
            if (model.getType() == "Bullet") game.ellipse(model.getPosition().x(), model.getPosition().y(), model.getWidth(), model.getHeight());
            else{
                if (model.isAlive()) {
                    game.image(model.getImg(), model.getPosition().x(), model.getPosition().y(), model.getWidth(), model.getHeight());
                }
            }
        }
    }
}
