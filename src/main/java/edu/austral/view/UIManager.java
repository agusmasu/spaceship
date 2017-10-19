package edu.austral.view;

import edu.austral.model.AbstractModel;

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
}
