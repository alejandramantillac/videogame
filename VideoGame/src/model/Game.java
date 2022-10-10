package model;

import java.lang.Math;
import java.util.Random;
import java.util.Scanner;
import model.*;

public class Game {
	// Objects Size
	public static final int MAX_PLAYERS_SIZE = 20;
	public static final int MAX_TREASURES_SIZE = 50;
	public static final int MAX_ENEMIES_SIZE = 25;
	public static final int TYPE_ENEMIES_SIZE = 4;
	public static final int MAX_LEVELS_SIZE = 10;

	private int resolutionGame;

	// save players
	private int posToAdd = 0;

	// Atributes
	private String gameName;

	//
	private int typeScore = 0;
    private int enemyScore = 0;
    private int treasureScore = 0;

	// Relations
	private Player player;
	private Player[] players;
	private Level[] levels;
	private Level level;
    private Treasure[] treasures;
    private Enemie[] enemies;
    private Enemie[] totalEnemies;
    private Enemie enemie;

	// Constructor
	public Game (String gameName){
		this.gameName = gameName;
		levels = new Level[MAX_LEVELS_SIZE];
        players = new Player[MAX_PLAYERS_SIZE];
        enemies = new Enemie [TYPE_ENEMIES_SIZE];
        totalEnemies = new Enemie[MAX_ENEMIES_SIZE];
        treasures = new Treasure [MAX_TREASURES_SIZE];
	}

	// Getters and setters Methods
	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	// Methods	
    public Enemie [] getEnemies() {
        return enemies;
    }

    public void setEnemies(Enemie [] enemies) {
        this.enemies = enemies;
    }

    public Enemie [] getTotalEnemies() {
        return totalEnemies;
    }

    public void setTotalEnemies(Enemie [] totalEnemies) {
        this.totalEnemies = totalEnemies;
    }

	public Level[] getLevels(){
		return levels; 
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Player[] getPlayers(){
		return players; 
	}

	public void setPlayers(Player[] players){
		this.players = players; 
	}

	public Enemie getEnemy(){
		return enemie; 
	}

	public int verifiedLevelAvailability(int pLevel){
		int pos = -1; 
		boolean isFound = false; 
		for(int i = 0; i < MAX_LEVELS_SIZE && !isFound; i++ ){
			if(levels[i].getLevelId() == pLevel){
				pos = i; 
				isFound = true; 
			}
		}
		return pos; 
	}

	// -----------------------------------------------All time---------------------------------------//

	public void enemyLvlDifficulty(int eLevel, int eScoreDown) {
		int currentLvl = levels[eLevel].getLevelScoreRequired();

		levels[eLevel].setLevelScoreRequired(currentLvl+eScoreDown);

		assignLevelDifficulty(eLevel);
	}

	public void treasureLvlDifficulty(int tLevel, int tScore) {
		int currentLvl = levels[tLevel].getLevelScoreRequired();

		levels[tLevel].setLevelScoreRequired(currentLvl+tScore);

		assignLevelDifficulty(tLevel);
	}  

	public void assignLevelDifficulty(int level) {
		int enemySum = 0;
		int treasureSum = 0;
		int enemyScore = 0;
		int treasureScore = 0;

		for(int i = 0; i < MAX_ENEMIES_SIZE; i++) {
			try {
				if (totalEnemies[i].getEnemyLevel() == level) {
					try {
						enemyScore = totalEnemies[i].getEnemyScoreDown();
						enemySum += enemyScore;
					} catch (NullPointerException g) {
						enemySum += 0;
					}
				}
			} catch (NullPointerException e) {
				enemySum += 0;
			}
		}

		for(int i = 0; i < MAX_TREASURES_SIZE; i++) {
			try {
				if (treasures[i].getTreasureLevel() == level) {
					try {
						treasureScore = treasures[i].getTreasureScore();
						treasureSum += treasureScore;
					} catch (NullPointerException h) {
						treasureSum += 0;
					}
				}
			} catch (NullPointerException f) {
				treasureSum += 0;
			}
		}

		// compare
		if (treasureSum > enemySum) {
			levels[level].setLevelType("EASY");
		} else if (treasureSum == enemySum) {
			levels[level].setLevelType("MEDIUM");
		} else if (treasureSum < enemySum) {
			levels[level].setLevelType("HARD");
		} else {
			System.out.println("Default level: Easy");
			levels[level].setLevelType("EASY");
		}
	}

	//-------------------------------------------------Init------------------------------------------//

	/**
	 * initializeLevels iniatilize the ten levels at the init of the execution's game.
	 * **/
	public void initializeLevels() {
		for (int i = 0; i < MAX_LEVELS_SIZE; i++) {
			levels[i] = new Level();
		}
	}

	/**
	 * showScreenResolutionOptions show the screen resolution options.
	 * **/
	public void showScreenResolutionOptions() {
		System.out.println("Choose a screen resolution: \n"+
		"1. SD -> 640x480 pixels \n" +
		"2. QHD -> 960x540 pixels \n" +
		"3. HD -> 1280x720 pixels \n" +
		"4. FHD -> 1920x1080 pixels \n" +
		"5. QHD -> 2560x1140 pixels \n" +
		"6. UHD -> 3840x2160 pixels \n" +
		"7. UHD 8K -> 7680x4320 pixels)");
	}

	/**
	 * getScreenResolution get the resolution option chosen by the user and generates a position (resolution).
	 * @param screenResolution represents the screen resolution.
	 * @return resolutionGame represents the game screen resolution.
	 * **/
	public int getScreenResolution(int screenResolution) {
        int minRange, maxRange;
        Random rand = new Random();

		switch(screenResolution) {
			case 1:
		        minRange = 480;
		        maxRange = 640;
                resolutionGame = minRange + rand.nextInt((maxRange - minRange) + 1);
		        System.out.println("Position Generated: "+ resolutionGame);
				break;

			case 2:
		        minRange = 540;
		        maxRange = 960;
                resolutionGame = minRange + rand.nextInt((maxRange - minRange) + 1);
		        System.out.println("Position Generated "+ resolutionGame);
				break;

			case 3:
		        minRange = 720;
		        maxRange = 1280;
                resolutionGame = minRange + rand.nextInt((maxRange - minRange) + 1);
		        System.out.println("Position Generated "+ resolutionGame);
				break;

			case 4:
		        minRange = 1080;
		        maxRange = 1920;
                resolutionGame = minRange + rand.nextInt((maxRange - minRange) + 1);
		        System.out.println("Position Generated "+ resolutionGame);
				break;

			case 5:
		        minRange = 1140;
		        maxRange = 2560;
                resolutionGame = minRange + rand.nextInt((maxRange - minRange) + 1);
		        System.out.println("Position Generated "+ resolutionGame);
				break;

			case 6:
		        minRange = 2160;
		        maxRange = 3840;
                resolutionGame = minRange + rand.nextInt((maxRange - minRange) + 1);
		        System.out.println("Position Generated "+ resolutionGame);
				break;

			case 7: 
		        minRange = 4320;
		        maxRange = 7680;
                resolutionGame = minRange + rand.nextInt((maxRange - minRange) + 1);
		        System.out.println("Position Generated "+ resolutionGame);
				break;

			default:
				System.out.println("Invalid option. A default resolution will be assigned (480 pixels)");
				resolutionGame = 480;
				break;
		}

		return resolutionGame;
	}

	//------------------------------------------------Case 1-----------------------------------------//

	/**
	 * addPlayerToGame add a player to the game according to the given information.
	 * @param pNickname represents the player nickname.
	 * @param pName represents the player name.
	 * @param pScore represents the player score.
	 * @param pLives represents the player lives.
	 * @param pLevel represents the player level.
	 * @return msj represents the message to show if the player has been successfully added.
	 * **/
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
;
		posToAdd += 1;	

		return msj; 
	}

	// only to see players - DELETE
	public void showPlayers() {
		for (int i = 0; i < MAX_PLAYERS_SIZE; i++) {
			System.out.println(players[i]);
		}
	}

	/**
	 * searchPlayerByNickname informs if a player nickname already exists.
	 * @param pNickname represents the nickname of the player.
	 * @return pos represents the position of the nickname.
	 * **/
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



   //------------------------------------------------Case 2------------------------------------------//


    /**
     * addEnemieToLevel add an enemie to a specific level.
     * @param eLevel represents the enemie level to add.
     * @param eNameId represents the enemie name (id).
     * @param eNameType represents the enemie name type.
     * @param eType represents the enemy type.
     * @param eScoreDown represents the enemy's score to subtract from the player's score.
     * @param eScoreUp represents the enemy's score to add to the player's score.
     * @param ePositionX represents the enemy position in X.
     * @param ePositionY represents the enemy position in Y.
     * @return msj represents the message to show if the player has been successfully added.
     * **/
    public String addEnemieToLevel(int eLevel, String eNameType, int eType, int eScoreDown, int eScoreUp, int ePositionX, int ePositionY){
        String msj = ""; 
        int pos = 0;

        Enemie newEnemie = new Enemie(eLevel, eNameType, eType, eScoreDown, eScoreUp, ePositionX, ePositionY); 
        
        boolean isEmpty = false; 

        boolean canAdd = false;
        for(int j = 0; j < MAX_ENEMIES_SIZE; j++){
            if(totalEnemies[j] == null){
                canAdd = true;

                if (canAdd == true) {
                    for(int i = 0; i < TYPE_ENEMIES_SIZE && !isEmpty; i++){
                        if(enemies[i] == null){
                            enemies[i] = newEnemie; 
                            totalEnemies[j] = newEnemie;
                            pos = j;
                            typeScore = 1;
                            isEmpty = true; 
                            msj = "Enemie added.";    
                            enemyLvlDifficulty(eLevel, eScoreDown);
                            enemyScore += eScoreDown;
                        }
                    }
                }
            }
        }

        return msj; 
    }

    public void showEnemies() {
        for (int i = 0; i < MAX_ENEMIES_SIZE; i++) {
            System.out.println(totalEnemies[i]);
        }
    }

    /**
     * showOptionEnemyType show enemies type to choose.
     * @return optionEnemies represents the list of enemies to choose.
     * **/
    public String showOptionEnemyType() {
        String optionEnemies = ("1. Ogro \n" +
        "2. Abstracto \n" +
        "3. Jefe \n" +
        "4. Mágico");

        return optionEnemies;
    }

    /**
     * getOptionEnemyType get the option given by the user and sets the enemy name.
     * @param enemyType represents the enemy chosen by the user.
     * @return enemyNameType represents the name of the enemy according to the previous.
     * **/
    public String getOptionEnemyType(int enemyType) {
        String enemyNameType = "";

        // Default: ogro
        if(enemyType == 1) {
            enemyNameType = "Ogro";
        } else if (enemyType == 2) {
            enemyNameType = "Abstracto";
        } else if (enemyType == 3) {
            enemyNameType = "Jefe";
        } else if (enemyType == 4) {
            enemyNameType = "Mágico";
        } else {
            enemyNameType = "Ogro";
        }

        return enemyNameType;
    }

    //------------------------------------------------Case 3------------------------------------------//
  
    /**
     * addTreasureToLevel adds treasures to a specific level.
     * @param tUnits represents the units of the treasure.
     * @param tLevel represents the level where the treasure will be added.
     * @param tName represents the treasure's name.
     * @param tImage represents the treasure's url image.
     * @param tScore represents the treasure's score.
     * @param tPositionXList represents the treasure's x position.
     * @param tPositionYList represents the treasure's y position.
     * @return msj represents the result when the treasure is added.
     * **/
    public String addTreasureToLevel(int tUnits, int tLevel, String tName, String tImage, int tScore, int [] tPositionXList, int [] tPositionYList) {
        Treasure newTreasure = new Treasure(tUnits, tLevel, tName, tImage, tScore, tPositionXList, tPositionYList); 
        int pos = 0;

        String msj = "Maximun capacity reached."; 
        boolean isEmpty = false; 
        for(int i = 0; i <MAX_TREASURES_SIZE && !isEmpty; i++){
            if(treasures[i] == null){
                treasures[i] = newTreasure; 
                isEmpty = true; 
                typeScore = 2;
                pos = i;
                msj = "Treasure added."; 
                treasureLvlDifficulty(tLevel, tScore);
                treasureScore += tScore;
            }
        }

        return msj; 
    }

	//------------------------------------------------Case 4------------------------------------------//

	/**
	 * searchPlayerById search for a specific player with his nickname and return his position.
	 * @param pNickname represents the player's nickname.
	 * @return pos represents the player's position.
	 * **/
	public int searchPlayerById(String pNickname){
		int pos = -1; 
		boolean isFound = false; 
		for(int i = 0; i < MAX_PLAYERS_SIZE && !isFound; i++){
			if(players[i].getPlayerNickname().equals(pNickname)){
				pos = i; 
				isFound = true; 
			}
		}
		return pos; 
	}

	/**
	 * setNewPlayerScore assign a new score to a specific player
	 * @param posSearch represents the player's position.
	 * @param pNewScore represents the player's new score.
	 * **/
	public String setNewPlayerScore(int posSearch, int pNewScore) {

		System.out.println("Current player score: " + players[posSearch].getPlayerScore());
		players[posSearch].setPlayerScore(pNewScore);
		String msj_new_score = "New player score: " + players[posSearch].getPlayerScore();

		return msj_new_score;
	} 

	//------------------------------------------------Case 5------------------------------------------//

	/**
	 * getPlayerCurrentLevel gets the current position of a specific player.
	 * @param posSearchNick represents the position of the player.
	 * @return pCurrentLevel represents the current level of the player.
	 * */
	public int getPlayerCurrentLevel(int posSearchNick) {
		int pCurrentLevel = players[posSearchNick].getPlayerLevel();

		return pCurrentLevel;
	}

	/**
	 * getPlayerCurrentScore gets the current score of a specific player.
	 * @param posSearchNick represents the position of the player.
	 * @return pCurrentScore represents the current score of the player.
	 * **/
	public int getPlayerCurrentScore(int posSearchNick) {
		int pCurrentScore = players[posSearchNick].getPlayerScore();

		return pCurrentScore;
	}
	
	/**
	 * getScoreRequiredToLevelUp gets the necessary score required to be in a specific level.
	 * @param pNextLevel represents the next level to which the player could rise.
	 * @return pNextLevelScoreRequired represents the score required to be at a specific level.
	 * **/
	public int getScoreRequiredToLevelUp(int pNextLevel) {
		int pNextLevelScoreRequired = levels[pNextLevel].getLevelScoreRequired();

		return pNextLevelScoreRequired;
	}

	/**
	 * compareScores compares whether or not the player's current score is good enough to advance to the next level.
	 * @param pCurrentScore represents the current score of the player.
	 * @param pNextLevelScoreRequired represents the score required to be at a specific level.
	 * @return isValid represents the answer as to whether or not the player can level up.
	 * **/
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
	 * **/
	public String setLevelUp(int posSearchNick, int pNextLevel) {
		players[posSearchNick].setPlayerLevel(pNextLevel);

		String msj_level_up = "Successful level up. The player's" + players[posSearchNick].getPlayerNickname() + " new level is: " + players[posSearchNick].getPlayerLevel();

		return msj_level_up;
	}

	

	//------------------------------------------------Case 6------------------------------------------//


	//------------------------------------------------Case 7------------------------------------------//


    //------------------------------------------------Case 6------------------------------------------//
    
    /**
     * searchEnemiesLevel Look for the enemies that are in a specific level.
     * @param teLevel represents the level where we want to look for enemies.
     * **/
    public void searchEnemiesLevel (int teLevel) {
        boolean hasEnemy = false;

        try {
            for (int i = 0; i < MAX_ENEMIES_SIZE; i++) {
                hasEnemy = totalEnemies[i].getEnemyLevel() == teLevel;

                if (hasEnemy == true) {
                    System.out.println(totalEnemies[i].getEnemyNameType());
                }
            }
        } catch (NullPointerException e) {
            System.out.println("");
        }
    }

    /**
     * searchTreasuresLevel Look for the treasures that are in a specific level.
     * @param teLevel represents the level where we want to look for treasures.
     * **/
    public void searchTreasuresLevel (int teLevel) {
        boolean hasTreasure = false;

        try {
            for (int i = 0; i < MAX_TREASURES_SIZE; i++) {
                hasTreasure = treasures[i].getTreasureLevel() == teLevel;

                if (hasTreasure == true) {
                    System.out.println(treasures[i].getTreasureName());
                }
            }
        } catch (NullPointerException e) {
            System.out.println("");
        }
    }

    //------------------------------------------------Case 7------------------------------------------//

    /**
     * totalAmountTreasures count the total amount of treasures found in all levels.
     * @param tNameSearch represents the treasure name to search.
     * @return countTreasures save the total units of the treasure.
     * **/
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

    //------------------------------------------------Case 8------------------------------------------//

    /**
     * totalAmountEnemies count the total amount of enemies found in all levels.
     * @param eTypeSearch represents the enemy type to search.
     * @return countEnemies save the total quantity of enemies.
     * **/
    public int totalAmountEnemies (int eTypeSearch) {
        boolean hasEnemy = false;
        int countEnemies = 0;

        try {
            for (int i = 0; i < MAX_TREASURES_SIZE; i++) {
                hasEnemy = (totalEnemies[i].getEnemyType() == eTypeSearch);

                if (hasEnemy == true) {
                    countEnemies += 1;
                }
            }
        } catch (NullPointerException e) {
            System.out.println("");
        }

        return countEnemies;
    }
	//------------------------------------------------Case 9------------------------------------------//

    public int getPositionEnemyHighestScore() {
    	int maxScore = 0;
    	int forScore = 0;
    	int positionHighest = 0;

    	for (int i = 0; i < MAX_ENEMIES_SIZE; i++) {
    		try {
	    		forScore = totalEnemies[i].getEnemyScoreDown();

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

    public String showEnemyHighestScore() {
    	int positionHighest = getPositionEnemyHighestScore();

    	String msj_highest_enemy = "The enemy with highest score is a " + totalEnemies[positionHighest].getEnemyNameType() + " on the level " + totalEnemies[positionHighest].getEnemyLevel();

    	return msj_highest_enemy;
    }

	//------------------------------------------------Case 10------------------------------------------//


	//------------------------------------------------Case 11------------------------------------------//


	//------------------------------------------------Case 12------------------------------------------//
    public String getTopFivePlayers() {
    	int count = 0;
    	int firstPlayer = 0;
    	int secondPlayer = 0;
    	int thirdPlayer = 0;
    	int fourthPlayer = 0;
    	int fifthPlayer = 0;

    	try {
	    	for (int i = 0; i < MAX_PLAYERS_SIZE; i++) {
	    		if(players[i].getPlayerNickname() != null) {
	    			count ++;
	    		}
	    	}
    	} catch (NullPointerException e) {
    		count += 0;	
    	}

    	int [] playersList = new int[count];

    	int PLAYERS_LIST_SIZE = count;


    	// first
    	for (int i = 0; i < PLAYERS_LIST_SIZE; i++) {
    		if (players[i].getPlayerScore() > firstPlayer) {
    			firstPlayer = i;
    		}
    	}

    	// second
    	for (int i = 0; i < PLAYERS_LIST_SIZE; i++) {
    		if (players[i].getPlayerScore() == firstPlayer) {
    			firstPlayer = firstPlayer;
    		} else {
	    		if (players[i].getPlayerScore() > secondPlayer) {
	    			secondPlayer = i;
	    		}    			
    		}
    	}

    	// third
    	for (int i = 0; i < PLAYERS_LIST_SIZE; i++) {
    		if (players[i].getPlayerScore() == firstPlayer || players[i].getPlayerScore() == secondPlayer) {
    			firstPlayer = firstPlayer;
    			secondPlayer = secondPlayer;
    		} else {
	    		if (players[i].getPlayerScore() > thirdPlayer) {
	    			thirdPlayer = i;
	    		}    			
    		}
    	}

    	// fourth
    	for (int i = 0; i < PLAYERS_LIST_SIZE; i++) {
    		if (players[i].getPlayerScore() == firstPlayer || players[i].getPlayerScore() == secondPlayer || players[i].getPlayerScore() == thirdPlayer) {
    			firstPlayer = firstPlayer;
    			secondPlayer = secondPlayer;
    			thirdPlayer = thirdPlayer;
    		} else {
	    		if (players[i].getPlayerScore() > fourthPlayer) {
	    			fourthPlayer = i;
	    		}    			
    		}
    	}

    	// fifth    	
    	for (int i = 0; i < PLAYERS_LIST_SIZE; i++) {
    		if (players[i].getPlayerScore() == firstPlayer || players[i].getPlayerScore() == secondPlayer || players[i].getPlayerScore() == thirdPlayer || players[i].getPlayerScore() == fourthPlayer) {
    			firstPlayer = firstPlayer;
    			secondPlayer = secondPlayer;
    			thirdPlayer = thirdPlayer;
    			fourthPlayer = fourthPlayer;
    		} else {
	    		if (players[i].getPlayerScore() > fifthPlayer) {
	    			fifthPlayer = i;
	    		}    			
    		}
    	}

    	String top_five = "1. " + players[firstPlayer].getPlayerNickname() + "\n" +
    	"2. " + players[secondPlayer].getPlayerNickname() + "\n" +
    	"3. " + players[thirdPlayer].getPlayerNickname() + "\n" +
    	"4. " + players[fourthPlayer].getPlayerNickname() + "\n" +
    	"5. " + players[fifthPlayer].getPlayerNickname();

    	return top_five;
    }

}