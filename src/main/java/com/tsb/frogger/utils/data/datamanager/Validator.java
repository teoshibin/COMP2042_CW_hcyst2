package com.tsb.frogger.utils.data.datamanager;

import com.tsb.frogger.core.RuntimeData;
import com.tsb.frogger.utils.data.datastructure.Player;

import java.util.ArrayList;

/**
 * validation class for input validation
 */
class Validator {

    /**
     * validate new username
     *
     * @param name username
     * @return valid or invalid
     */
    static boolean validateUsername(String name){
        return !(name.equals("") || name.length() > 30 || duplicatedUsername(RuntimeData.gameData.allPlayers, name));
    }

    /**
     * validate selected index is in correct range
     *
     * @param all include or exclude guest in range
     * @param index selected index
     * @return valid and invalid
     */
    static boolean validateSelectedPlayer(boolean all, int index){
        if(all){
            return (index >= 0 && index < RuntimeData.gameData.allPlayers.size());
        } else {
            return (index > 0 && index < RuntimeData.gameData.allPlayers.size());
        }
    }

    /**
     * check duplicated name in username list
     *
     * @param players all players
     * @param name username
     * @return true when there is duplication
     */
    private static boolean duplicatedUsername(ArrayList<Player> players, String name){
        for (Player player : players) {
            if(player.getUsername().equals(name)){
                return true;
            }
        }
        return false;
    }
}
