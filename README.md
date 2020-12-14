# Frogger :frog:

[frogger](https://en.wikipedia.org/wiki/Frogger) is an arcade game developed in the 1980s by [Konami](https://en.wikipedia.org/wiki/Konami) a japanese company.
This will be a refurbished version of frogger.
The focus of this repo will mainly be improving gameplay and adding features to the game while still keeping the original theme intact.

<p align="center">
  <img src="screenshots/game_picture.png"  alt="In Game Screenshots"/>
</p>

## Content
- [Installation](#installation)
- [Usage](#usage)
    - [How to play](#how-to-play)
        - [Controls](#controls)
    - [How to create new level](#how-to-create-new-level)
- [Features](#features)
    - [Gameplay](#gameplay)
    - [Modifications](#modifications)
- [Implementations](#implementations)
    - [Views](#views)
        - [GUI Hierarchy](#gui-hierarchy)
    - [Controllers](#controllers)
        - [Controllers Hierarchy](#controllers-hierarchy)
    - [Changes](#changes)
    - [Fixes](#fixes)
- [Design Patterns](#design-patterns)
- [Credits](#credits)
- [License](#license)

## Installation
### Method 1
1. Clone this repo
2. Unzip the folder
3. In command prompt use `cd $YOUR_PATH` navigate into cloned folder
4. type in `gradlew run` to build and run the game
### Method 2
1. Download Released jar
2. Download JavaFx
3. In command prompt use `cd $YOUR_PATH` navigate into folder
4. Run this code where specifying your own javafx/lib folder path into `$PATH_TO_JavaFX`:
   ```shell
   java --module-path {$PATH_TO_JavaFX} --add-modules javafx.controls,javafx.fxml,javafx.media -jar frogger-1.0.jar
   ```

[Back to content](#content)  

## Usage

### How to play
- Your main objective is to bring the frog back to its home, while not being run over by trucks or drowned on its way home.
- Numbers of respawn chances will be given.
- Different score will be awarded based on time spent of each frog.

    #### Controls
    keys | actions
    ----|--------
    W | UP
    A | LEFT
    S | DOWN
    D | RIGHT
    
[Back to content](#content)  
    
### How to create new level
1. Find [com.tsb.frogger.graphics.levels](src/main/java/com/tsb/frogger/world/levels) package.  
2. Create a new class e.g. Level_999.java in this package
   This class implements LevelBase, and the level designing will be written in this loadLevel method
    ```java
    package com.tsb.frogger.graphics.levels;
    
    import com.tsb.frogger.core.ConstantData;
    import com.tsb.frogger.utils.game.ActorLoader;
    
    public class Level_999 implements LevelBase{
    
        @Override
        public void loadLevel() {
            // <- load components here
        }
    }
    ```
3. Now add some actors. For example adding a long log.  
   
    ```java
    // LoadComponents.addActor(layout x, layout y, moving direction & speed);
    LoadComponents.addLongLog(0, ConstantData.LAYOUT_Y_ACTOR[0][1], -0.75);
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
   
4. Now navigate to [com.tsb.frogger.graphics.world](src/main/java/com/tsb/frogger/world) open [LevelSelector](src/main/java/com/tsb/frogger/world/LevelSelector.java).
    ```java
    public class LevelSelector {
    
        public static final int MAX_LEVEL = 5; // <- add one into this value 
                                               // e.g. 6
    
        public static void selectLevel(MyStage gamePane, int level) throws LevelNotFoundException {
            LevelBase myLevel;
            switch (level) {
                case 1 -> myLevel = new Level_001();
                case 2 -> myLevel = new Level_002();
                case 3 -> myLevel = new Level_003();
                case 4 -> myLevel = new Level_004();
                case 5 -> myLevel = new Level_005();
                // <- add your level here 
                // e.g. case 6 -> myLevel = new Level_999();
                default -> throw new LevelNotFoundException("Level not found or Unlinked level, please check linking in LevelSelector");
            }
            Objects.requireNonNull(myLevel).loadLevel(gamePane);
        }
    }
    ```
5. Done !  

6. For better understanding  
   [See Example level](src/main/java/com/tsb/frogger/world/levels/Level_001.java)  
   [See LevelSelector](src/main/java/com/tsb/frogger/world/LevelSelector.java)
   
   >**Note** : Removing levels might corrupt the save file, when it does simply remove the old `saveGame.ser` save file
    
[Back to content](#content)  

## Features
### Gameplay
- Create personal account username for high score storing
- Browse personal high score
- Show game info
- Change Game settings
- 5 levels are available
- The higher the level is the harder the difficultly is
- Timer count down for extra fun
- Extra points will be added based on time taken every round
- Able to proceed to the next level after completing each level

### Modifications
- Create new level easily by extending class   

[Back to content](#content)

## Implementations
### Views
Interactive screens are added using fxml and controllers to adhere MVC pattern.
#### GUI Hierarchy
- Username managing screen
    - Main menu screen
        - Game info screen
        - High score screen
        - Option settings screen
        - Level selection screen
            - game screen
            - victory screen

### Controllers
ScreenController class and ControlledScreen interface are introduced to eliminate many to many relationships between screens so that screens are handled in a centralized form with a relation of one to many.
This framework allows new fxml screens to be added easily.
#### Controllers Hierarchy
- Launcher (application)
    - ScreenController (main controller)
        - ControlledScreens (interface)
            - Controller1 (fxml controllers)
            - Controller2
            - ...

### Changes
- Removed Digit actor
- Removed Background actor and move its functionality to LoadComponents
- Added ConstantData class for game constants
- Added RuntimeData class for data references (game saves are loaded here)
- Added Game, LoadComponents, LevelSelector and Launcher, refactored from the original main class.
- Added LevelBase interface for linking up all custom-made levels.
- Added LevelNotFoundException a custom Exception class for error handling
- Added Sound class for audio clip playing and music playing
- Added SaveGameManager that extends FileManager for the use of loading and storing save file
- Added Player, SavedGame, settings as serializable data object 
- Added data access objects (DAO) for Player and assets
- Added assets.properties as central assets' path storage
- Categorized classes into package of controllers, core, utils and worlds
- Categorized asset files into directories of images, sounds, views (fxml assets) and styles (css)
- Refactored Actor class into IntersectingActor class, ActingActor class, AnimatingActor Interface
- Refactored Turtle, WetTurtle and Frog to extends ActingActor and implements AnimatingActor
- Refactored End actor to extends IntersectingActor and remove inherited unused methods
- Refactored the rest of the actors extend from ActingActor
- Refactored in game score display from image view appending to label updating
- Added GodAnimal actor that wins instantly for debugging purposes
- Added several fxml screens with its controller controlled by an instance of ScreenController in Launcher
- Slightly shrink down the size of the window

### Fixes
- Fixed actor image view inconsistent shifting due to different image size of different actors
- Fixed fast frog movement bug for long pressed key
- Fixed a bug where all wet turtles sink into water at the same time

[Back to content](#content)  

## Design Patterns

<p align="center">
  <img src="UML/Package_frogger.png"  alt="Class Diagram"/>
</p>   

- **MVC Pattern**  
  Using models, views(fxml,css), controllers for the entire GUI

- **Front Controller Pattern**  
  ScreensController act as a centralized views request handling class and all other controllers are requested through ControlledClass Interface

- **Factory Pattern**  
  Used in level base (interface) and levels (class) where the interface act as the general level and levelSelector instantiate one of the level (sub-class) and cast it to level base

- **Singleton Pattern**  
  Used across this project such as Sound class, Convertor, Validator class etc.

- **Facade Pattern**  
  Used in the LoadComponents class, where it wraps a complicated subsystem (actors) with a simpler interface.
  
- **DAO Pattern**  
  SaveGame Data structure Loaded from save file act as the data, uses PlayerDao implemented by PlayerDaoImpl to fetch data from SavedGame Data Structure

[Back to content](#content)

## Credits
- Icons made by <a href="https://www.flaticon.com/authors/freepik" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/" title="Flaticon"> www.flaticon.com </a>
- Icons made by <a href="https://www.flaticon.com/authors/vectors-market" title="Vectors Market">Vectors Market</a> from <a href="https://www.flaticon.com/" title="Flaticon"> www.flaticon.com </a>

## License
All code found in this repository is licensed under

[Back to content](#content)  
