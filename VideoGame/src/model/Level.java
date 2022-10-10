package model;

import model.Game;

public class Level {
    public static final int MAX_TREASURES_SIZE = 50;
    public static final int MAX_ENEMIES_SIZE = 25;
    public static final int TYPE_ENEMIES_SIZE = 4;
    public static final int MAX_LEVELS_SIZE = 10;
    public static final int LEVEL_DIFFICULTIES = 3;


	// Atributes
	private int levelId;
	private int levelScoreRequired;
    private String levelType;

	// Relations
	private Player[] players;
    private Treasure[] treasures;
    private Enemie[] enemies;
    private Enemie[] totalEnemies;
    private Enemie enemie;
    private Game game;



	// Constructor
    public Level () {
        this.levelId = levelId;
        this.levelScoreRequired = 0;
        this.levelType = levelType;
    }

    public Game getGame(){
        return game; 
    }

	// Getters and Setters Methods
    public int getLevelId() {
        return levelId;
    }

    public void setLevelId(int levelId) {
        this.levelId = levelId;
    }

    public String getLevelType() {
        return levelType;
    }

    public void setLevelType(String levelType) {
        this.levelType = levelType;
    }

    public int getLevelScoreRequired() {
        return levelScoreRequired;
    }

    public void setLevelScoreRequired(int levelScoreRequired) {
        this.levelScoreRequired = levelScoreRequired;
    }



    public Enemie getEnemie() {
        return enemie;
    }

    public void setEnemie(Enemie enemie) {
        this.enemie = enemie;
    }


	// Methods






    
    @Override
    public String toString() {
        return "Enemies: " + totalEnemies;
    }
}