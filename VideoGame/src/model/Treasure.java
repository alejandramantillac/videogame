package model;

public class Treasure {

	// Atributes
    private int treasureUnits;
    private int treasureLevel;
	private String treasureName;
	private String treasureImage;
	private int treasureScore;
	private int[] treasurePositionX;
    private int[] treasurePositionY;


	// Relations

	// Constructor
	public Treasure(int treasureUnits, int treasureLevel, String treasureName, String treasureImage, int treasureScore, int [] treasurePositionX, int [] treasurePositionY) {
        this.treasureUnits = treasureUnits;
        this.treasureLevel = treasureLevel;
        this.treasureName = treasureName;
        this.treasureImage = treasureImage;
        this.treasureScore = treasureScore;
        this.treasurePositionX = treasurePositionX;
        this.treasurePositionY = treasurePositionY;

	}

	// Getters and Setters Methods
    public int getTreasureLevel() {
        return treasureLevel;
    }

    public void setTreasureLevel(int treasureLevel) {
        this.treasureLevel = treasureLevel;
    }
    public String getTreasureName() {
        return treasureName;
    }

    public void setTreasureName(String treasureName) {
        this.treasureName = treasureName;
    }

    public String getTreasureImage() {
        return treasureImage;
    }

    public void setTreasureImage(String treasureImage) {
        this.treasureImage = treasureImage;
    }

    public int getTreasureScore() {
        return treasureScore;
    }

    public void setTreasureScore(int treasureScore) {
        this.treasureScore = treasureScore;
    }

    public int [] getTreasurePositionX() {
        return treasurePositionX;
    }

    public void setTreasurePositionX(int [] treasurePositionX) {
        this.treasurePositionX = treasurePositionX;
    }
    
    public int [] getTreasurePositionY() {
        return treasurePositionY;
    }

    public void setTreasurePositionY(int [] treasurePositionY) {
        this.treasurePositionY = treasurePositionY;
    }

    public int getTreasureUnits() {
        return treasureUnits;
    }

    public void setTreasureUnits(int treasureUnits) {
        this.treasureUnits = treasureUnits;
    }

	// Methods
}