package edu.austral.view;

import edu.austral.model.AbstractModel;
import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Agustin on 19/10/2017.
 */
public class UIManager {
    private static UIManager ourInstance = new UIManager();
    private List<AbstractModel> toDraw;

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
        System.out.println(toDraw.size());
        for (AbstractModel model: toDraw){
            if (model.isAlive()) {
                game.image(game.loadImage(model.getImagePath()), model.getPosition().x(), model.getPosition().y(), model.getWidth(), model.getHeight());
            }
        }
    }
}
