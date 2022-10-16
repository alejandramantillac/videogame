
package model;

import java.util.Random;

/**
 *
 * @author Alejandra
 */
public class Level {
    public static final int MAX_TREASURES_SIZE = 50;
    public static final int TOTAL_TREASURES_SIZE = 550;
    public static final int TOTAL_TREASURES_INIT = 500;
    public static final int MAX_ENEMIES_SIZE = 30;
    public static final int TOTAL_ENEMIES_SIZE = 300;
    public static final int TOTAL_ENEMIES_INIT = 250;
    public static final int LEVEL_DIFFICULTIES = 3;
    public static final int MAX_LEVELS = 10;
       
    private int levelNum;
    private int levelScore;
    private String levelType;
    private int levelNameType;
    private int posAutoLvl;
    private int [] enemyAutoScore = new int [MAX_LEVELS];
    private int [] treasureAutoScore = new int [MAX_LEVELS];
    private int [] totalAutoScore = new int [MAX_LEVELS];
    
    private Enemy[] enemies;
    private Enemy enemy;
    private Treasure[] treasures;
    private Treasure treasure;

    public Level() {
        this.levelNum = levelNum;
        this.levelScore = levelScore;
        this.levelType = levelType;
        this.levelNameType = levelNameType;
        
        enemies = new Enemy[TOTAL_ENEMIES_SIZE];
        treasures = new Treasure[TOTAL_TREASURES_SIZE];
        
    }
    
    public Enemy getEnemy() {
        return enemy;
    }

    public void setEnemy(Enemy enemy) {
        this.enemy = enemy;
    }
    
    public Treasure getTreasure() {
        return treasure;
    }
    
    public void setTreasure(Treasure treasure) {
        this.treasure = treasure;
    }

    public int getLevelNum() {
        return levelNum;
    }

    public void setLevelNum(int levelNum) {
        this.levelNum = levelNum;
    }

    public int getLevelScore() {
        return levelScore;
    }

    public void setLevelScore(int levelScore) {
        this.levelScore = levelScore;
    }

    public String getLevelType() {
        return levelType;
    }

    public void setLevelType(String levelType) {
        this.levelType = levelType;
    }

    public int getLevelNameType() {
        return levelNameType;
    }

    public void setLevelNameType(int levelNameType) {
        this.levelNameType = levelNameType;
    }
   
    /**
     * validateEmptyEnemyPos validate if has an empty position on enemies object array of an specific level.
     * @param eLevel represents the enemy level.
     * @return enemyPosition represents the first enemy empty position.
     */
    public int validateEmptyEnemyPos(int eLevel) {
        int enemyPosition = -1;
        int count = 0;

        for(int i = 0; i < TOTAL_ENEMIES_SIZE; i++){
            if(enemies[i] != null && enemies[i].getEnemyLevel() == eLevel){
                count++;
                enemyPosition = i;
            }
        }
        
        if (count < MAX_ENEMIES_SIZE) {
            enemyPosition = enemyPosition;
        } else {
            enemyPosition = -1;
        }
    return enemyPosition;
    }
 
    /*
     * generateRandomId generates a random id to the enemy.
     * @return randomEnemyId represents the random enemy id generated.
     */
    public String generateRandomId() {  
        String randomEnemyId = "";
        
        String [] firstName = {"mini", "super", "small", "big", "huge", "tiny", "ligth", "heavy", "thick", "large"};
        
        String [] secondName = {"cronos", "tantalo", "sparta", "seth", "anteo", "morrigan", "ravana", "apofis", "keket", "urano"};
               
        String [] thirdName = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
                
        randomEnemyId = firstName[(int) (Math.floor(Math.random() * ((firstName.length - 1) - 0 + 1) + 0))] + secondName[(int) (Math.floor(Math.random() * ((secondName.length - 1) - 0 + 1) + 0))] + thirdName[(int) (Math.floor(Math.random() * ((thirdName.length - 1) - 0 + 1) + 0))] ;         
        
        return randomEnemyId;
        
    }
    
    /**
     * generateRandomPos generates a random number with reference a max range given by the user.
     * @param pos represents the max range to generate a random number.
     * @return randomPos represents the random number generated.
     */
    public int generateRandomPos(int pos) {
        int randomPos = (int)(Math.random()*pos+1);

        return randomPos;
    }

    /**
     * generateRandomPosition generates a random position between 720 and 1280.
     * @return randomEnemyPosition represents the random position generated.
     */
    public int generateRandomPosition() {
        int minRange, maxRange, randomEnemyPosition;
        Random rand = new Random();
        
        minRange = 720;
        maxRange = 1280;
        randomEnemyPosition = minRange + rand.nextInt((maxRange - minRange) + 1);
        
        return randomEnemyPosition;
    }
 
    /**
     * setNameToEnemy set the enemy name accordding to its type.
     * @param randomType represents the enemy type.
     * @return enemyNameType represents the name of the enemy.
     */
    public String setNameToEnemy(int randomType) {
    String enemyNameType = "";

        // Default: ogre
        switch (randomType) {
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
     * initEnemies initialize the first 250 enemies of the game.
     */
    public void initEnemies() {
        
        String randomId = "", randomNameType = "";
        int randomType = 0, randomScoreUp = 0, randomScoreDown = 0, randomPosX = 0, randomPosY = 0, initLevel = 0, times = 0;
        
        do {
            for (int i = 0; i < TOTAL_ENEMIES_INIT; i++) {
                try {
                    times++;
                    if (initLevel < 10) {
                        randomId = generateRandomId();
                        randomType = generateRandomPos(3);
                        randomNameType = setNameToEnemy(randomType);
                        randomScoreUp = generateRandomPos(99);
                        randomScoreDown = generateRandomPos(99);
                        randomPosX = generateRandomPosition();
                        randomPosY = generateRandomPosition();
                        
                        totalAutoScore[initLevel] += randomScoreUp;
                        enemyAutoScore[initLevel] += randomScoreUp;


                        addEnemyToLevelAutomatically(randomId, randomType, randomNameType, randomScoreUp, randomScoreDown, randomPosX, randomPosY, initLevel);
                    } else {
                        initLevel = 0;
                        randomId = generateRandomId();
                        randomType = generateRandomPos(3);
                        randomNameType = setNameToEnemy(randomType);
                        randomScoreUp = generateRandomPos(99);
                        randomScoreDown = generateRandomPos(99);
                        randomPosX = generateRandomPosition();
                        randomPosY = generateRandomPosition();

                        totalAutoScore[initLevel] += randomScoreUp;
                        enemyAutoScore[initLevel] += randomScoreUp;
                        
                        addEnemyToLevelAutomatically(randomId, randomType, randomNameType, randomScoreUp, randomScoreDown, randomPosX, randomPosY, initLevel);
                    }
                    initLevel++;                   
                } catch(NullPointerException e) {

                }
            }     
        } while (times < 250);
    }    
    
    /**
     * addEnemyToLevelAutomatically adds an enemy to a level.
     * @param randomId represents the enemy id.
     * @param randomType represents the enemy type.
     * @param randomNameType represents the enemy name according to the type.
     * @param randomScoreUp represents the score obtained by defeating the enemy.
     * @param randomScoreDown represents the score obtained when defeated by the enemy.
     * @param randomPosX represents the enemy X position.
     * @param randomPosY represents the enemy Y position.
     * @param initLevel represents the enemy level to add.
     * @return msj represents the register message.
     */
    public String addEnemyToLevelAutomatically(String randomId, int randomType, String randomNameType, int randomScoreUp, int randomScoreDown, int randomPosX, int randomPosY, int initLevel){
        String msj = ""; 

        Enemy newEnemy = new Enemy(randomId, randomType, randomNameType, randomScoreUp, randomScoreDown, randomPosX, randomPosY, initLevel); 

        boolean isEmpty = false; 
        for(int i = 0; i < TOTAL_ENEMIES_INIT && !isEmpty; i++){
            if(enemies[i] == null){
                enemies[i] = newEnemy;
                isEmpty = true; 
                msj = "Enemy added.";
            }
        }

        return msj; 
    }
    
    /**
     * searchEnemyById search for an enemy with the help of its id.
     * @param enemyId represents the enemy id.
     * @return pos represents the enemy position.
     */
    public int searchEnemyById(String enemyId){
        int pos = -1; 
        try {
            boolean isFound = false; 
            for(int i = 0; i < TOTAL_ENEMIES_SIZE && isFound == false; i++){
                if(enemies[i].getEnemyId().equals(enemyId)){
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
     * addEnemyWithObject adds a new enemy.
     * @param enemy represents the enemy object to add.
     * @return msj represents the register message.
     */
    public String addEnemyWithObject(Enemy enemy) {
        String msj = "Maximum capacity reached.";

        boolean isEmpty = false; 
        for(int i = 0; i < TOTAL_ENEMIES_SIZE && !isEmpty; i++){
            if(enemies[i] == null){
                enemies[i] = enemy; 
                isEmpty = true; 
                msj = "Enemy added.";
            }
        }

    return msj; 
    }

    /**
     * searchEnemiesLevel Look for the enemies that are in a specific level.
     * @param teLevel represents the level where we want to look for enemies.
     */
    public void searchEnemiesLevel(int teLevel) {
        boolean hasEnemy = false;
        int pos = 0;

        try {
            for (int i = 0; i < TOTAL_ENEMIES_SIZE; i++) {
                hasEnemy = enemies[i].getEnemyLevel() == teLevel;

                if (hasEnemy == true) {
                    pos++;
                    System.out.println(pos + ". Type: " + enemies[i].getEnemyNameType() + ". Id: " + enemies[i].getEnemyId());
                }
            }
        } catch (NullPointerException e) {
            System.out.println("");
        }
    }

    /**
     * totalAmountEnemies count the total amount of enemies found in all levels.
     * @param eTypeSearch represents the enemy type to search.
     * @return countEnemies save the total quantity of enemies.
     */
    public int totalAmountEnemies (int eTypeSearch) {
        boolean hasEnemy = false;
        int countEnemies = 0;

        try {
            for (int i = 0; i < TOTAL_ENEMIES_SIZE; i++) {
                hasEnemy = (enemies[i].getEnemyType() == eTypeSearch);

                if (hasEnemy == true) {
                    countEnemies += 1;
                }
            }
        } catch (NullPointerException e) {
            System.out.println("");
        }

        return countEnemies;
    }
    
    /**
     * getPositionEnemyHighestScore search for the enemy with the highest score on the game.
     * @return positionHighest represents the enemy's highest score position.
     */
    public int getPositionEnemyHighestScore() {
    	int maxScore = 0;
    	int forScore = 0;
    	int positionHighest = 0;

    	for (int i = 0; i < TOTAL_ENEMIES_SIZE; i++) {
            try {
                forScore = enemies[i].getEnemyScoreUp();

                if (forScore > maxScore) {
                        maxScore = forScore;
                        positionHighest = i;
                }
            } catch (NullPointerException e) {
                maxScore = maxScore;
            }
    	}

    	return positionHighest;
    }
    
    /**
     * infoEnemyHighestScore show the info of the enemy with highest score.
     * @return msj_highest_enemy represents the info of the enemy with highest score.
     */
    public String infoEnemyHighestScore() {
    	int positionHighest = getPositionEnemyHighestScore();

    	String msj_highest_enemy = "The enemy with highest score is a " + enemies[positionHighest].getEnemyNameType() + " on the level " + enemies[positionHighest].getEnemyLevel();

    	return msj_highest_enemy;
    }
    
    /**
     * getTotalConsonants get the total consonants on enemies' names.
     * @return totalConsonants represents the total consonants on names.
     */
    public int getTotalConsonants() {
        String enemyNameId = "";
        int totalConsonants = 0;
        
        char [] consonants = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l','m', 'n', 'o', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z'};
        
        for (int i = 0; i < TOTAL_ENEMIES_SIZE; i++) {
            if (enemies[i] != null) {
                enemyNameId = enemies[0].getEnemyId();
        
                for (int j = 0; j < enemyNameId.length(); j++) {

                    for (int k = 0; k < consonants.length; k++) {
                        if(enemyNameId.charAt(j) == consonants[k]) {
                            totalConsonants++;
                        }
                    }
                }
            }
        }
       
        return totalConsonants;
    }
    
    /**
     * getMostRepeatedTreasure get the most repeated treasure on the game.
     * @return mostRepeated represents the name of the most repeated treasure.
     */
    public String getMostRepeatedTreasure() {
        String mostRepeated = "";
        int diamonds = 0, golds = 0, silvers = 0;
        
        for (int i = 0; i < TOTAL_TREASURES_SIZE; i++) {
            try {
                if(treasures[i].getTreasureName().equals("DIAMOND")) {
                    diamonds++;
                } else if (treasures[i].getTreasureName().equals("GOLD")){
                    golds++;
                } else if(treasures[i].getTreasureName().equals("SILVER")) {
                    silvers++;
                }
            } catch (NullPointerException e) {
                
            }
        }
        
        if (diamonds > golds && diamonds > silvers) {
            mostRepeated = "DIAMOND";
        } else if (golds > diamonds && golds > silvers) {
            mostRepeated = "GOLD";
        } else {
            mostRepeated = "SILVER";
        }
        
        return mostRepeated;
    }
    
    /**
     * validateEmptyTreasurePos checks if has an empty position of an specific level to add a new treasure.
     * @param tLevel represents the level to add the treasure.
     * @return treasurePosition represents the first empty position to add the treasure.
     */
    public int validateEmptyTreasurePos(int tLevel) {
        int treasurePosition = -1;
        int count = 0;

        for(int i = 0; i < TOTAL_TREASURES_SIZE; i++){
            if(treasures[i] != null && treasures[i].getTreasureLevel() == tLevel){
                count++;
                treasurePosition = i;
            }
        }
        
        if (count < 60) {
            treasurePosition = treasurePosition;
        } else {
            treasurePosition = -1;
        }
    return treasurePosition;
    }

    /**
     * addTreasureWithObject adds a new treasure.
     * @param treasure represents the treasure object to add.
     * @return msj represents the register message.
     */
    public String addTreasureWithObject(Treasure treasure) {
        String msj = "Maximum capacity reached.";

        boolean isEmpty = false; 
        for(int i = 0; i < TOTAL_TREASURES_SIZE && !isEmpty; i++){
            if(treasures[i] == null){
                treasures[i] = treasure; 
                isEmpty = true; 
                msj = "Treasure added.";
            }
        }

    return msj; 
    }

    /**
     * initTreasures initializes the first 500 treasures of the game.
     */
    public void initTreasures() {
        
        String randomNameType = "", randomImage = "";
        int randomType = 0, randomUnits = 0, randomScore = 0, initLevel = 0, times = 0;
        
        do {
            for (int i = 0; i < TOTAL_TREASURES_INIT; i++) {
                try {
                    times++;
                    if (initLevel < 10) {
                        randomType = generateRandomPos(3);
                        randomNameType = getOptionTreasure(randomType);
                        randomImage = setImage(randomType);
                        randomUnits = generateRandomPos(3);
                        randomScore = generateRandomPos(99);
                        
                        int [] randomPosX = new int[randomUnits];
                        int [] randomPosY = new int[randomUnits];
                        for (int j = 0; j < randomPosX.length; j++) {
                            randomPosX[j] = generateRandomPosition();
                            randomPosY[j] = generateRandomPosition();
                        }

                        totalAutoScore [initLevel] += randomScore;
                        treasureAutoScore[initLevel] += randomScore;
                        addTreasureToLevelAutomatically(randomType, randomNameType, randomImage, randomUnits, randomScore, randomPosX, randomPosY, initLevel);
                    } else {
                        initLevel = 0;
                        
                        randomType = generateRandomPos(2);
                        randomNameType = getOptionTreasure(randomType);
                        randomImage = setImage(randomType);
                        randomUnits = generateRandomPos(3);
                        randomScore = generateRandomPos(99);
                        
                        int [] randomPosX = new int[randomUnits];
                        int [] randomPosY = new int[randomUnits];
                        for (int j = 0; i < randomPosX.length; j++) {
                            randomPosX[j] = generateRandomPosition();
                            randomPosY[j] = generateRandomPosition();
                        }
                        
                        totalAutoScore [initLevel] += randomScore;
                        treasureAutoScore[initLevel] += randomScore;
                        addTreasureToLevelAutomatically(randomType, randomNameType, randomImage, randomUnits, randomScore, randomPosX, randomPosY, initLevel);
                    }
                    initLevel++;                   
                } catch(NullPointerException e) {

                }
            }     
        } while (times < 250);
    }    
 
    /**
     * addTreasureToLevelAutomatically adds a new treasure.
     * @param randomType represents the treasure type.
     * @param randomNameType represents the treasure name.
     * @param randomImage represents the treasure url image.
     * @param randomUnits represents the treasure units.
     * @param randomScore represents the treasure score.
     * @param randomPosX represents the treasure X positions.
     * @param randomPosY represents the treasure Y positions.
     * @param initLevel represents the treasure level.
     * @return msj represents a register message.
     */    
    public String addTreasureToLevelAutomatically(int randomType, String randomNameType, String randomImage, int randomUnits, int randomScore, int [] randomPosX, int [] randomPosY, int initLevel){
        String msj = ""; 

        Treasure newTreasure = new Treasure(randomType, randomNameType, randomImage, randomUnits, randomScore, randomPosX, randomPosY, initLevel); 

        boolean isEmpty = false; 
        for(int i = 0; i < TOTAL_TREASURES_INIT && !isEmpty; i++){
            if(treasures[i] == null){
                treasures[i] = newTreasure; 
                isEmpty = true; 
                msj = "Enemy added.";
            }
        }

        return msj; 
    }

    /**
    * getOptionTreasure get the option given by the user and sets the treasure name.
    * @param tType represents the treasure chosen by the user.
    * @return treasureName represents the name of the treasure according to the previous selection.
    */
    public String getOptionTreasure(int randomType) {
        String treasureName = "";

        // Default: silver
        switch (randomType) {
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
     * setImage set an image to the treasure according to the random type.
     * @param randomType represents the treasure random type.
     * @return treasureImage represents the url of the treasures' image.
     */    
    public String setImage(int randomType) {
        String treasureImage = "";

        // Default: silver
        switch (randomType) {
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
     * searchTreasuresLevel Look for the treasures that are in a specific level.
     * @param teLevel represents the level where we want to look for treasures.
     */
    public void searchTreasuresLevel(int teLevel) {
        boolean hasTreasure = false;
        int pos = 0;

        try {
            for (int i = 0; i < TOTAL_TREASURES_SIZE; i++) {
                hasTreasure = treasures[i].getTreasureLevel() == teLevel;

                if (hasTreasure == true) {
                    pos++;
                    System.out.println(pos + ". Type: " + treasures[i].getTreasureName());
                }
            }
        } catch (NullPointerException e) {
            System.out.println("");
        }
    }

    /**
     * totalAmountTreasures count the total amount of treasures found in all levels.
     * @param tNameSearch represents the treasure name to search.
     * @return countTreasures save the total units of the treasure.
     */
    public int totalAmountTreasures (String tNameSearch) {
        boolean hasTreasure = false;
        int countTreasures = 0;
        int totalUnits = 0;

        try {
            for (int i = 0; i < MAX_TREASURES_SIZE; i++) {
                hasTreasure = treasures[i].getTreasureName().equals(tNameSearch);

                if (hasTreasure == true) {
                    totalUnits = treasures[i].getTreasureUnits();
                    countTreasures += totalUnits;
                }
            }
        } catch (NullPointerException e) {
            System.out.println("");
        }

        return countTreasures;
    }
    
    /**
     * getTreasuresTotalScore get the treasures total score of a specific level.
     * @param tLevel represents the treasures' level.
     * @return treasuresTotalScore represents the treasures' total score.
     */
    public int getTreasuresTotalScore(int tLevel) {
        int treasuresTotalScore = 0;
        
        for (int i = 0; i < TOTAL_TREASURES_SIZE; i++) {
            try {
                if (treasures[i].getTreasureLevel() == tLevel) {
                   treasuresTotalScore += treasures[i].getTreasureScore();
               }               
            } catch (NullPointerException e) {
                treasuresTotalScore += 0;
            }

        }
        return treasuresTotalScore;
    }
    
    /**
     * getEnemiesTotalScore get the enemies' total score of a specific level.
     * @param eLevel represents the level.
     * @return enemiesTotalScore represents the enemies' total score.
     */
    public int getEnemiesTotalScore(int eLevel) {
        int enemiesTotalScore = 0;
        
        for (int i = 0; i < TOTAL_ENEMIES_SIZE; i++) {
            try {
                if (enemies[i].getEnemyLevel() == eLevel) {
                enemiesTotalScore += enemies[i].getEnemyScoreUp();
                }
            } catch (NullPointerException e) {
                enemiesTotalScore += 0;
            }
            
        }
        return enemiesTotalScore;
    }
    
    /**
     * setLevelTotalScore set the total score of an specific level.
     * @param level represents the level.
     * @return totalScore represents the total score of the level.
     */
    public int setLevelTotalScore(int level) {
        int totalScore = 0;
        
        int enemiesScore = getEnemiesTotalScore(level);
        int treasuresScore = getTreasuresTotalScore(level);
        
        totalScore = enemiesScore + treasuresScore;
        
        return totalScore;
    }
    
    /**
     * enemyAutoScore sums the enemy score of the ramdonly enemy.
     * @param posAutoLvl represents the level.
     * @return enemySum represents the sum.
     */
    public int enemyAutoScore(int posAutoLvl) {
        int enemySum = enemyAutoScore[posAutoLvl];
        return enemySum;
    }
    
    /**
     * treasureAutoScore sums the treasure score of the ramdonly treasure.
     * @param posAutoLvl represents the level.
     * @return treasureSum represents the sum.
     */    
    public int treasureAutoScore(int posAutoLvl) {
        int treasureSum = treasureAutoScore[posAutoLvl];
        return treasureSum;
    }

    /**
     * totalAutoScore sums the total score of the ramdonly enemies and treasures.
     * @param posAutoLvl represents the level.
     * @return totalSum represents the total sum.
     */
    public int totalAutoScore(int posAutoLvl) {
        int totalSum = totalAutoScore[posAutoLvl];
        return totalSum;
    }
    
    /**
     * posAutoLevel returns the the level of the randomly enemy or treasure.
     * @return posAutoLevel represents the level of the randomly enemy or treasure.
     */
    public int posAutoLevel() {
        return posAutoLvl;
    }
    
    @Override
    public String toString() {
        return "Level{" + "levelNum=" + levelNum + ", levelScore=" + levelScore + ", levelType=" + levelType + ", levelNameType=" + levelNameType + '}';
    }


}
