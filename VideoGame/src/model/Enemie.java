package model;

import model.Game;

public class Enemie {

	// Atributes
    private int enemyLevel;
	private String enemyNameType;
	private int enemyType;
	private int enemyScoreDown;
	private int enemyScoreUp;
    private int enemyPositionX;
    private int enemyPositionY;
    private Game game;

	// Relations

	// Constructor
    public Enemie (int enemyLevel, String enemyNameType, int enemyType, int enemyScoreDown, int enemyScoreUp, int enemyPositionX, int enemyPositionY) {
        this.enemyLevel = enemyLevel;
        this.enemyNameType = enemyNameType;
        this.enemyType = enemyType;
        this.enemyScoreDown = enemyScoreDown;
        this.enemyScoreUp = enemyScoreUp;
        this.enemyPositionX = enemyPositionX;
        this.enemyPositionY = enemyPositionY;
    }


	// Getters and Setters Methods
    public int getEnemyLevel() {
        return enemyLevel;
    }

    public void setEnemyLevel(int enemyLevel) {
        this.enemyLevel = enemyLevel;
    }

    public String getEnemyNameType() {
        return enemyNameType;
    }

    public void setEnemyNameType(String enemyNameType) {
        this.enemyNameType = enemyNameType;
    }

    public int getEnemyType() {
        return enemyType;
    }

    public void setEnemyType(int enemyType) {
        this.enemyType = enemyType;
    }

    public int getEnemyScoreDown() {
        return enemyScoreDown;
    }

    public void setEnemyScoreDown(int enemyScoreDown) {
        this.enemyScoreDown = enemyScoreDown;
    }

    public int getEnemyScoreUp() {
        return enemyScoreUp;
    }

    public void setEnemyScoreUp(int enemyScoreUp) {
        this.enemyScoreUp = enemyScoreUp;
    }

    public int getEnemyPositionX() {
        return enemyPositionX;
    }

    public void setEnemyPositionX(int enemyPositionX) {
        this.enemyPositionX = enemyPositionX;
    }

    public int getEnemyPositionY() {
        return enemyPositionY;
    }

    public void setEnemyPositionY(int enemyPositionX) {
        this.enemyPositionY = enemyPositionY;
    }

    // toString
    @Override
    public String toString() {
        return ". Enemy Type: " + enemyType  + ". Enemy Name Type: " + enemyNameType + ". Enemy Level: " + enemyLevel;
    }    

	// Methods


}