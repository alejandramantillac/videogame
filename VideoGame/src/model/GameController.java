package model;

import model.*;
import java.util.Random;

/**
 *
 * @author Alejandra
 */
public class GameController {
    public static final int MAX_LEVELS_SIZE = 10;
    public static final int MAX_PLAYERS_SIZE = 300;
    public static final int MAX_PLAYERS_EMPTY = 50;
    public static final int TOTAL_PLAYERS_INIT = 250;
    public static final int MAX_ENEMIES_SIZE = 300;
    public static final int TOP_FIVE = 5;
    
    private int resolutionGame;

    private Level[] levels;
    private Player[] players;
    private Level level;

    public GameController() {
        levels = new Level [MAX_LEVELS_SIZE];
        players = new Player [MAX_PLAYERS_SIZE];
        level = new Level();
  
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
    
    /**
     * validatePos validate if the variable entered is different to -1.
     * @param var represents the variable that saves the integer value.
     * @return isOk represents the result of the validation (true or false).
     */
    public boolean validatePos(int var) {
        boolean isOk = false;
        
        if(var !=-1) {
            isOk = true;
        }
        
        return isOk;
    }
    
    /**
     * validateLvl validates if the level entered is on the range (1-10).
     * @param lvl represents the level entered to validate.
     * @return isOnRange represents the result of the validation (true or false).
     */
    public boolean validateLvl(int lvl) {
        boolean isOnRange = false;
        
        if(lvl > 0 && lvl < 10 ) {
            isOnRange = true;
        }
        
        return isOnRange;
    }
    
    /**
     * invalidLvl show an error message regarding the out of range level entered.
     */
    public void invalidLvl() {
        System.out.println("You selected an invalid level. The range is 1 to 10.");
    }
    
    /**
     * getScreenResolution generates a position (resolution).
     * @return resolutionGame represents the game screen resolution.
     */
    public int getScreenResolution() {
        int minRange, maxRange;
        Random rand = new Random();
        
        minRange = 720;
        maxRange = 1280;
        resolutionGame = minRange + rand.nextInt((maxRange - minRange) + 1);

        return resolutionGame;
    }
    
    /**
     * initializeLevels initializes the ten levels at the beginning of the game execution.
     */
    public void initializeLevels() {
        for (int i = 0; i < MAX_LEVELS_SIZE; i++) {
	levels[i] = new Level();
        }
    }
    
    /**
     * searchPlayerByNickname informs if a player nickname already exists.
     * @param pNickname represents the nickname of the player.
     * @return pos represents the position of the nickname.
     */
    public int searchPlayerByNickname(String pNickname){
        int pos = -1; 
        try {
            boolean isFound = false; 
            for(int i = 0; i < MAX_PLAYERS_SIZE && isFound == false; i++){
                if(players[i].getPlayerNickname().equals(pNickname)){
                    pos = i; 
                    isFound = true; 
                }
            }
        } catch (NullPointerException e) {
            pos = -1;
        } 

        return pos; 
    }
    
    /**
     * addPlayerToGame add a player to the game according to the given information.
     * @param pNickname represents the player nickname.
     * @param pName represents the player name.
     * @param pScore represents the player score.
     * @param pLives represents the player lives.
     * @param pLevel represents the player level.
     * @return msj represents the message to show if the player has been successfully added.
     */
    public String addPlayerToGame(String pNickname, String pName, int pScore, int pLives, int pLevel){
        String msj = ""; 

        Player newPlayer = new Player(pNickname, pName, pScore, pLives, pLevel); 

        boolean isEmpty = false; 
        for(int i = 0; i < MAX_PLAYERS_SIZE && !isEmpty; i++){
            if(players[i] == null){
                players[i] = newPlayer; 
                isEmpty = true; 
                msj = "Player added.";
            }
        }

        return msj; 
    }    
 
    /**
     * addPlayerToGameAutomatically add a player to the game according to the random information (250 new players generated).
     * @param pNickname represents the player nickname.
     * @param pName represents the player name.
     * @param pScore represents the player score.
     * @param pLives represents the player lives.
     * @param pLevel represents the player level.
     * @return msj represents the message to show if the player has been successfully added.
     */    
    public String addPlayerToGameAutomatically(String pNickname, String pName, int pScore, int pLives, int pLevel){
        String msj = ""; 

        Player newPlayer = new Player(pNickname, pName, pScore, pLives, pLevel); 

        boolean isEmpty = false; 
        for(int i = 0; i < TOTAL_PLAYERS_INIT && !isEmpty; i++){
            if(players[i] == null){
                players[i] = newPlayer; 
                isEmpty = true; 
                msj = "Player added.";
            }
        }

        return msj; 
    }    
    
    /**
     * generateRandomNum generates a random number with reference a max range given by the user.
     * @param pos represents the max range to generate a random number.
     * @return randomNum represents the random number generated.
     */
    public int generateRandomNum(int pos) {
        int randomNum = (int)(Math.random()*pos+1);

        return randomNum;
    }
    
    /**
     * generateRandomNickname generates a random nickname to the player.
     * @return randomPlayerNickname represents the random nickname generated.
     */
    public String generateRandomNickname() {  
        String randomPlayerNickname = "";
        
        String [] firstName = {"fi", "nos", "as", "ra", "mek", "foz", "tag", "lou", "guz", "mik"};
        
        String [] secondName = {"hu", "fan", "tru", "ha", "ca", "zi", "ki", "dan", "xa", "lo"};
        
        String [] thirdName = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
                
        randomPlayerNickname = firstName[(int) (Math.floor(Math.random() * ((firstName.length - 1) - 0 + 1) + 0))] + secondName[(int) (Math.floor(Math.random() * ((secondName.length - 1) - 0 + 1) + 0))] + thirdName[(int) (Math.floor(Math.random() * ((thirdName.length - 1) - 0 + 1) + 0))] ;         
        
        return randomPlayerNickname;        
    }
   
    /**
     * generateRandomName generates a random name to the player.
     * @return randomPlayerName represents the random name generated.
     */
    public String generateRandomName() {  
        String randomPlayerName = "";
        
        String [] firstName = {"Sam", "Dan", "Juan", "Mel", "Sofia", "Dani", "Miguel", "Dianne", "Jack", "Caroline"};
        
        String [] secondName = {"Johns", "Smet", "Miller", "Saez", "Will", "Ander", "Tay", "Brown", "Fenz", "Mads"};        
        
        randomPlayerName = firstName[(int) (Math.floor(Math.random() * ((firstName.length - 1) - 0 + 1) + 0))] + " " + secondName[(int) (Math.floor(Math.random() * ((secondName.length - 1) - 0 + 1) + 0))] + " " ;         
                
       return randomPlayerName;
        
    }
    
    /**
     * initPlayers creates the first 250 players of the game.
     */
    public void initPlayers() {
        int initScore = 10, initLives = 5, initLevel = 0, randomScore = 0;
        String randomNickName = "";
        String randomName = "";
        int times = 0;
        
        do {
            for (int i = 0; i < TOTAL_PLAYERS_INIT; i++) {
                try {
                    times++;
                    if (initLevel < 11) {
                        randomNickName = generateRandomNickname();
                        randomName = generateRandomName();
                        randomScore = generateRandomNum(99);
                        addPlayerToGameAutomatically(randomNickName, randomName, randomScore, initLives, initLevel);
                    } else {
                        initLevel = 0;
                        randomNickName = generateRandomNickname();
                        randomName = generateRandomName();
                        randomScore = generateRandomNum(99);
                        addPlayerToGameAutomatically(randomNickName, randomName, randomScore, initLives, initLevel);
                    }
                    initLevel++;                   
                } catch(NullPointerException e) {

                }
            }     
        } while (times < 250);
    }
    
    /**
     * searchPlayerById search for a specific player with his nickname and return his position.
     * @param pNickname represents the player's nickname.
     * @return pos represents the player's position.
     */
    public int searchPlayerById(String pNickname){
        int pos = -1; 
        boolean isFound = false; 
        for(int i = 0; i < MAX_PLAYERS_SIZE && !isFound; i++){
            if(players[i] != null) {
                if(players[i].getPlayerNickname().equals(pNickname)){
                    pos = i; 
                    isFound = true; 
                }                
            }
        }
        return pos; 
    }

    /**
     * setNewPlayerScore assign a new score to a specific player.
     * @param posSearch represents the player's position.
     * @param pNewScore represents the player's new score.
     * @return msj_new_score represents the message that shows the players' new score.
     */
    public String setNewPlayerScore(int posSearch, int pNewScore) {

        System.out.println("Current player score: " + players[posSearch].getPlayerScore());
        players[posSearch].setPlayerScore(pNewScore);
        String msj_new_score = "New player score: " + players[posSearch].getPlayerScore();

        return msj_new_score;
    } 
    
    /**
     * getPlayerCurrentLevel gets the current position of a specific player.
     * @param posSearchNick represents the position of the player.
     * @return pCurrentLevel represents the current level of the player.
     */
    public int getPlayerCurrentLevel(int posSearchNick) {
        int pCurrentLevel = players[posSearchNick].getPlayerLevel();

        return pCurrentLevel;
    }

    /**
     * getPlayerCurrentScore gets the current score of a specific player.
     * @param posSearchNick represents the position of the player.
     * @return pCurrentScore represents the current score of the player.
     */
    public int getPlayerCurrentScore(int posSearchNick) {
        int pCurrentScore = players[posSearchNick].getPlayerScore();

        return pCurrentScore;
    }
	
    /**
     * getScoreRequiredToLevelUp gets the necessary score required to be in a specific level.
     * @param pNextLevel represents the next level to which the player could rise.
     * @return pNextLevelScoreRequired represents the score required to be at a specific level.
     */
    public int getScoreRequiredToLevelUp(int pNextLevel) {
        int pNextLevelScoreRequired = levels[pNextLevel].getLevelScore();

        return pNextLevelScoreRequired;
    }

    /**
     * compareScores compares whether or not the player's current score is good enough to advance to the next level.
     * @param pCurrentScore represents the current score of the player.
     * @param pNextLevelScoreRequired represents the score required to be at a specific level.
     * @return isValid represents the answer as to whether or not the player can level up.
     */
    public boolean compareScores(int pCurrentScore, int pNextLevelScoreRequired) {
        boolean isValid = false;

        if(pCurrentScore >= pNextLevelScoreRequired) {
            isValid = true;
        }

        return isValid;
    }

    /**
     * setLevelUp sets the player's new level.
     * @param posSearchNick represents the position of the player.
     * @param pNextLevel represents the next level to which the player could rise.
     * @return msj_level_up represents the successful level update response.
     */
    public String setLevelUp(int posSearchNick, int pNextLevel) {
        players[posSearchNick].setPlayerLevel(pNextLevel);

        String msj_level_up = "Successful level up. The player's" + players[posSearchNick].getPlayerNickname() + " new level is: " + players[posSearchNick].getPlayerLevel();

        return msj_level_up;
    }
    
    /**
     * getTopFivePlayers gets the top five players positions.
     */
    public void getTopFivePlayers() {
        int firstPlayer = 0, secondPlayer = 0, thirdPlayer = 0, fourthPlayer = 0, fifthPlayer = 0;
        int firstPos = 0, secondPos = 0, thirdPos = 0, fourthPos = 0, fifthPos = 0;
        
        for(int i = 0; i < MAX_PLAYERS_SIZE; i++) {
            if(players[i] != null && players[i].getPlayerScore() > firstPlayer) {
                firstPlayer = players[i].getPlayerScore();
                firstPos = i;
            } 
        }
        
        for(int i = 0; i < MAX_PLAYERS_SIZE; i++) {
            if(players[i] != null && i != firstPos && players[i].getPlayerScore() > secondPlayer) {
                secondPlayer = players[i].getPlayerScore();
                secondPos = i;
            } 
        }

        for(int i = 0; i < MAX_PLAYERS_SIZE; i++) {
            if(players[i] != null && i != firstPos && i != secondPos && players[i].getPlayerScore() > thirdPlayer) {
                thirdPlayer = players[i].getPlayerScore();
                thirdPos = i;
            } 
        }
        
        for(int i = 0; i < MAX_PLAYERS_SIZE; i++) {
            if(players[i] != null && i != firstPos && i != secondPos && i != thirdPos && players[i].getPlayerScore() > fourthPlayer) {
                fourthPlayer = players[i].getPlayerScore();
                fourthPos = i;
            } 
        }
        
        for(int i = 0; i < MAX_PLAYERS_SIZE; i++) {
            if(players[i] != null && i != firstPos && i != secondPos && i != thirdPos && i != fourthPos && players[i].getPlayerScore() > fifthPlayer) {
                fifthPlayer = players[i].getPlayerScore();
                fifthPos = i;
            } 
        }
        
        String topPlayers = showTopFivePlayers(firstPos, secondPos, thirdPos, fourthPos, fifthPos);
        System.out.println(topPlayers);
        
    }
    
    /**
     * showTopFivePlayers shows the top five players of the game.
     * @param firstPos represents the position of the first player on the top.
     * @param secondPos represents the position of the second player on the top.
     * @param thirdPos represents the position of the third player on the top.
     * @param fourthPos represents the position of the fourth player on the top.
     * @param fifthPos represents the position of the fifth player on the top.
     * @return topPlayers shows the top five players with its nicknames and scores.
     */
    public String showTopFivePlayers(int firstPos, int secondPos, int thirdPos, int fourthPos, int fifthPos) {
        String topPlayers = 
            "1. Nickname: " + players[firstPos].getPlayerNickname() + ". Score: " + players[firstPos].getPlayerScore() + "\n" +
            "2. Nickname: " + players[secondPos].getPlayerNickname() + ". Score: " + players[secondPos].getPlayerScore() + "\n" +
            "3. Nickname: " + players[thirdPos].getPlayerNickname() + ". Score: " + players[thirdPos].getPlayerScore() + "\n" +
            "4. Nickname:  " + players[fourthPos].getPlayerNickname() + ". Score: " + players[fourthPos].getPlayerScore() + "\n" +
            "5. Nickname:  " + players[fifthPos].getPlayerNickname() + ". Score: " + players[fifthPos].getPlayerScore();
        
        return topPlayers;
    }        
 
     /**
     * showOptionEnemyType show enemies type to choose.
     * @return optionEnemies represents the list of enemies to choose.
     */
    public String showOptionEnemyType() {
        String optionEnemies = 
        ("1. Ogro \n" +
        "2. Abstracto \n" +
        "3. Jefe \n" +
        "4. Mágico");

        return optionEnemies;
    }
    
    /**
    * getOptionEnemyType get the option given by the user and sets the enemy name.
    * @param enemyType represents the enemy chosen by the user.
    * @return enemyNameType represents the name of the enemy according to the previous.
    */
    public String getOptionEnemyType(int enemyType) {
        String enemyNameType = "";

        // Default: ogre
        switch (enemyType) {
            case 1:
                enemyNameType = EnemyType.OGRE.toString();
                break;
            case 2:
                enemyNameType = EnemyType.ABSTRACT.toString();
                break;
            case 3:
                enemyNameType = EnemyType.BOSS.toString();
                break;
            case 4:
                enemyNameType = EnemyType.MAGIC.toString();
                break;
            default:
                enemyNameType = EnemyType.OGRE.toString();
                break;
        }

        return enemyNameType;
    }
    
    /**
     * getEnemyPosition get the position of the enemy.
     * @param enemyId represents the enemy's name id.
     * @return enemyPos represents the enemy's position.
     */
    public int getEnemyPosition(String enemyId) {
        int enemyPos;
        enemyPos = level.searchEnemyById(enemyId);
                
        return enemyPos;
    }
       
    /**
     * registerEnemy checks if there is an empty position to add a new enemy and adds an enemy.
     * @param enemyId represents the enemy id.
     * @param eType represents the enemy type.
     * @param eNameType represents the enemy name according to the type.
     * @param eScoreUp represents the score obtained by defeating the enemy.
     * @param eScoreDown represents the score obtained when defeated by the enemy.
     * @param ePositionX represents the enemy X position.
     * @param ePositionY represents the enemy Y position.
     * @param eLevel represents the enemy level to add.
     * @return msj represents an error message.
     */
    public String registerEnemy(String enemyId, int eType, String eNameType, int eScoreUp, int eScoreDown, int ePositionX, int ePositionY, int eLevel) {
        String msj = "";

        Enemy newEnemy = new Enemy(enemyId, eType, eNameType, eScoreUp, eScoreDown, ePositionX, ePositionY, eLevel); 
        
        int enemyPosition = level.validateEmptyEnemyPos(eLevel);
        if (enemyPosition != -1) {
            msj = level.addEnemyWithObject(newEnemy);
        } else {
            msj = "Error on enemy registration.";
        }
        
        return msj; 

    }
    
    /**
     * showEnemiesOnLevel show the enemies of a specific level.
     * @param teLevel represents the level to show enemies.
     */
    public void showEnemiesOnLevel(int teLevel) {
        level.searchEnemiesLevel(teLevel);
    }
    
    /**
     * showTreasuresOnLevel show the treasures of a specific level.
     * @param teLevel represents the level to show treasures.
     */
    public void showTreasuresOnLevel(int teLevel) {
        level.searchTreasuresLevel(teLevel);
    }
    
    /**
     * showTotalConsonants show the total consonants found on enemies names.
     * @return totalConsonants represents the total consonants found.
     */
    public String showTotalConsonants() {
        String totalConsonants = "Total consonants on enemies names: " + level.getTotalConsonants();
        return totalConsonants;
    }
   
     /**
     * showOptionTreasure show a list of treasures.
     * @return optionTreasures represents the list of treasures to choose.
     */
    public String showOptionTreasure() {
        String optionTreasures = 
        ("1. Diamonds \n" +
        "2. Gold \n" +
        "3. Silver");

        return optionTreasures;
    }
    
    /**
    * getOptionTreasure get the option given by the user and sets the treasure name.
    * @param tType represents the treasure chosen by the user.
    * @return treasureName represents the name of the treasure according to the previous selection.
    */
    public String getOptionTreasure(int tType) {
        String treasureName = "";

        // Default: silver
        switch (tType) {
            case 1:
                treasureName = TreasureType.DIAMOND.toString();
                break;
            case 2:
                treasureName = TreasureType.GOLD.toString();
                break;
            case 3:
                treasureName = TreasureType.SILVER.toString();
                break;
            default:
                treasureName = TreasureType.SILVER.toString();
                break;
        }

        return treasureName;
    }
    
    /**
     * setImage set an image to the treasure according to the type.
     * @param tType represents the treasure type.
     * @return treasureImage represents the url of the treasures' image.
     */
    public String setImage(int tType) {
        String treasureImage = "";

        // Default: silver
        switch (tType) {
            case 1:
                treasureImage = "https://tinyurl.com/4kfzr254";
                break;
            case 2:
                treasureImage = "https://tinyurl.com/mr2j7uts";
                break;
            case 3:
                treasureImage = "https://tinyurl.com/5h48r6x8";
                break;
            default:
                treasureImage = "https://tinyurl.com/5h48r6x8";
                break;
        }

        return treasureImage;
    }
    
    /**
     * registerTreasure checks if there is an empty position to add a new treasure and adds an treasure.
     * @param tType represents the treasure type.
     * @param tName represents the treasure name.
     * @param tImage represents the treasure url image.
     * @param tUnits represents the treasure units.
     * @param tScore represents the treasure score.
     * @param tPositionXList represents the treasure X positions.
     * @param tPositionYList represents the treasure Y positions.
     * @param tLevel represents the treasure level.
     * @return msj represents an error message.
     */
    public String registerTreasure(int tType, String tName, String tImage, int tUnits, int tScore, int [] tPositionXList, int [] tPositionYList, int tLevel) {
        String msj = "";

        Treasure newTreasure = new Treasure(tType, tName, tImage, tUnits, tScore, tPositionXList, tPositionYList, tLevel); 
        
        int treasurePosition = level.validateEmptyTreasurePos(tLevel);
        if (treasurePosition != -1) {
            msj = level.addTreasureWithObject(newTreasure);
        } else {
            msj = "Error on treasure registration";
        }
        
        return msj; 

    }
    
    /**
     * initTheEnemies initializes the first 250 enemies of the game.
     */
    public void initTheEnemies() {
        level.initEnemies();
        
    }
    
    /**
     * initializes the first 500 treasures of the game.
     */
    public void initTheTreasures() {
        level.initTreasures();
        
    }
    
    /**
     * showTotalAmountOfTreasures show the total of treasures at all levels.
     * @param tNameSearch represents the name of the treasure to search.
     * @return totalAmount represents treasures' total amount.
     */
    public int showTotalAmountOfTreasures(String tNameSearch) {
        int totalAmount = level.totalAmountTreasures(tNameSearch);
        
        return totalAmount;
    }

    /**
     * showTotalAmountEnemies show the total of an specific enemy at all levels.
     * @param eTypeSearch represents the type of the enemy to search.
     * @return totalAmount represents enemies' total amount.
     */    
    public int showTotalAmountEnemies(int eTypeSearch) {
        int totalAmount = level.totalAmountEnemies(eTypeSearch);
        
        return totalAmount;
    }
    
    /**
     * showInfoEnemyHighestScore show the enemy with the highest score.
     * @return infoEnemy represents the info of the enemy with the highest score.
     */
    public String showInfoEnemyHighestScore() {
        String infoEnemy = level.infoEnemyHighestScore();
        
        return infoEnemy;
    }
    
    /**
     * showMostRepeatedTreasure show the most repeated treasure at all levels.
     * @return mostRepeated represents the most repeated treasure.
     */
    public String showMostRepeatedTreasure() {
        String mostRepeated = "The most repeated treasure is: " + level.getMostRepeatedTreasure();
        
        return mostRepeated;
    }

    /**
     * getAndSetLevelTotalScore set the total score of a specific level.
     * @param theLevel represents the level.
     */
    public void getAndSetLevelTotalScore(int theLevel) {
        int totalScore = level.setLevelTotalScore(theLevel);   
        levels[theLevel].setLevelScore(totalScore);
    }
    
    /**
     * setLvlDifficulty set the level difficulty of a specific level.
     * @param aLevel represents the level.
     */
    public void setLvlDifficulty(int aLevel) {
        int enemyScore = level.getEnemiesTotalScore(aLevel);
        int treasureScore = level.getTreasuresTotalScore(aLevel);
        
        if (treasureScore > enemyScore) {
            levels[aLevel].setLevelType("EASY");
        } else if (treasureScore == enemyScore) {
            levels[aLevel].setLevelType("MEDIUM");
        } else {
            levels[aLevel].setLevelType("HARD");
        }
    }
    
    /**
     * getAndSetLevelTotalScore sets the total score of all levels (this is for randomly generated enemies and treasures).
     */
    public void getAndSetAutoLvlTotalScore() {
        int scoreTotal;
        for (int i = 0;  i < 10; i++) {
            scoreTotal = level.totalAutoScore(i);
            levels[i].setLevelScore(scoreTotal);
            setAutoLvlDifficulty(i);

        }        
    }
  
    /**
     * setAutoLvlDifficulty sets the level difficulty of all levels (this is for randomly generated enemies and treasures).
     * @param pos represents the level.
     */
    public void setAutoLvlDifficulty(int pos) {
        int scoreEnemies = level.enemyAutoScore(pos);
        int scoreTreasures = level.treasureAutoScore(pos);
        
        if (scoreTreasures > scoreEnemies) {
            levels[pos].setLevelType("EASY");
        } else if (scoreTreasures == scoreEnemies) {
            levels[pos].setLevelType("MEDIUM");
        } else {
            levels[pos].setLevelType("HARD");
        }
    }
}
