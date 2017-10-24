package edu.austral.controller;


import edu.austral.model.AbstractModel;
import edu.austral.model.Board;
import edu.austral.model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Spliterators;

/**
 * Created by AlumnosFI on 17/10/2017.
 */
public class PlayerController {
    private static PlayerController ourInstance = new PlayerController();
    private List<Player> playerHistory;
    private int playerOneListPosition;
    private int playerTwoListPosition;



    public static PlayerController getInstance() {
        return ourInstance;
    }

    private PlayerController() {
        playerHistory = new ArrayList<>();
    }

    //Updates Spaceship position and
    public void update(float time, Board board){
        Player one = playerHistory.get(playerOneListPosition);
        Player two = playerHistory.get(playerTwoListPosition);

        if (!board.isInside(one.getSpaceship())){
            System.out.println("ITS OUTSIDE");
            one.getSpaceship().moveTo(0,0);
        }



    }

    public Player getPlayer(int playerNumber){
        if (playerNumber > 2) throw new NoSuchElementException("There isnt such player");
        switch (playerNumber){
            case 1:
                return playerHistory.get(playerOneListPosition);
            case 2:
                return playerHistory.get(playerTwoListPosition);
            default:
                throw new NoSuchElementException("There isnt such player");
        }
    }

    public void createPlayer(Player player){
        playerHistory.add(player);
    }

    public void setFirstPlayer(Player player){
        playerOneListPosition = playerHistory.indexOf(player);
    }

    public void setSecondPlayer(Player player){
        playerTwoListPosition = playerHistory.indexOf(player);
    }

    public List<AbstractModel> getSpaceShips(){
        List<AbstractModel> result = new ArrayList<>();
        result.add(getPlayer(1).getSpaceship());

        return result;
    }

    public List<Player> getPlayerHistory() {
        return playerHistory;
    }
}
