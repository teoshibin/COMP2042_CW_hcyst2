
# Adding new levels

1. Find [com.tsb.frogger.generation.levels](src/main/java/com/tsb/frogger/world/levels) package.
2. Create a new class e.g. Level_999.java in this package
   This class implements LevelBase, and the level designing will be written in this loadLevel method
    ```java
    package com.tsb.frogger.generation.levels;
    
    import com.tsb.frogger.core.ConstantData;
    import com.tsb.frogger.utils.game.ActorLoader;
    
    public class Level_999 implements LevelBase{
    
        @Override
        public ActorLoader loadLevel(ActorLoader al) {
            // <- load components here
        }
    }
    ```
3. Now add some actors. For example adding a long log.

    ```java
    // ActorLoader.addActor(layout x, layout y, moving direction & speed);
    al.addLongLog(0, ConstantData.LAYOUT_Y_ACTOR[0][1], -0.75);
    ```
   Layout x is fully customizable, however layout y is defined in constant as
    ```java
    ConstantData.LAYOUT_Y_ACTOR[0][index]
    ```
   Here is all the available actors in table 1, simply replace above method with one of these e.g. addShortLog.  
   All possible index and corresponding location in the game is in table 2, assign shown index to above constant array for position.

   <table align="center">
   <tr>
    <th>Table 1</th>
    <th>Table 2</th>
   </tr>
   <tr>
   <td>

   | Actors     | Type     |
      |------------|----------|
   | ShortLog   | pathway  |
   | MediumLog  | pathway  |
   | LongLog    | pathway  |
   | WetTurtle  | both     |
   | Turtle     | pathway  |
   | Car        | obstacle |
   | ShortTruck | obstacle |
   | LongTruck  | obstacle |

   </td>
   <td>

   | Index | Position |
      |-------|----------|
   | 0     | End      |
   | 1~5   | River    |
   | 6     | Grass    |
   | 7~11  | Road     |
   | 12    | Start    |

   </td>
   </tr>
   </table>

4. Now navigate to [com.tsb.frogger.generation.world](src/main/java/com/tsb/frogger/world) open [LevelSelector](src/main/java/com/tsb/frogger/world/LevelSelector.java).
    ```java
    public class LevelSelector {
    
        public static final int MAX_LEVEL = 5; // <- add one into this value 
                                               // e.g. 6
    
        public static ActorLoader selectLevel(ActorLoader actorLoader, int level) throws LevelNotFoundException {
            LevelBase myLevel;
            switch (level) {
                case 1 -> myLevel = new Level_001();
                case 2 -> myLevel = new Level_002();
                case 3 -> myLevel = new Level_003();
                case 4 -> myLevel = new Level_004();
                case 5 -> myLevel = new Level_005();
                default -> throw new LevelNotFoundException("Level not found or Unlinked level, please check linking in LevelSelector");
            }
            return myLevel.loadLevel(actorLoader);
        }
    ```
5. Done !

6. For better understanding  
   [See Example level](src/main/java/com/tsb/frogger/world/levels/Level_001.java)  
   [See LevelSelector](src/main/java/com/tsb/frogger/world/LevelSelector.java)

   >**Note** : Removing levels might corrupt the save file, when it does simply remove the old `saveGame.ser` save file

   >**Addition** : This method of loading levels can be further implemented using JSON to store levels instead of classes

[Back to content](README.md#content)
