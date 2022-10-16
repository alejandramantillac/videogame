
package model;

/**
 *
 * @author Alejandra
 */
public class Treasure {
    
    private int treasureType;
    private String treasureName;
    private String treasureImage;
    private int treasureUnits;
    private int treasureScore;
    private int[] treasurePosX;
    private int[] treasurePosY;
    private int treasureLevel;

    public Treasure(int treasureType, String treasureName, String treasureImage, int treasureUnits, int treasureScore, int[] treasurePosX, int[] treasurePosY, int treasureLevel) {
        this.treasureType = treasureType;
        this.treasureName = treasureName;
        this.treasureImage = treasureImage;
        this.treasureUnits = treasureUnits;
        this.treasureScore = treasureScore;
        this.treasurePosX = treasurePosX;
        this.treasurePosY = treasurePosY;
        this.treasureLevel = treasureLevel;
    }


    public int getTreasureType() {
        return treasureType;
    }

    public void setTreasureType(int treasureType) {
        this.treasureType = treasureType;
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

    public int getTreasureUnits() {
        return treasureUnits;
    }

    public void setTreasureUnits(int treasureUnits) {
        this.treasureUnits = treasureUnits;
    }

    public int getTreasureScore() {
        return treasureScore;
    }

    public void setTreasureScore(int treasureScore) {
        this.treasureScore = treasureScore;
    }

    public int[] getTreasurePosX() {
        return treasurePosX;
    }

    public void setTreasurePosX(int[] treasurePosX) {
        this.treasurePosX = treasurePosX;
    }

    public int[] getTreasurePosY() {
        return treasurePosY;
    }

    public void setTreasurePosY(int[] treasurePosY) {
        this.treasurePosY = treasurePosY;
    }

    public int getTreasureLevel() {
        return treasureLevel;
    }

    public void setTreasureLevel(int treasureLevel) {
        this.treasureLevel = treasureLevel;
    }

    @Override
    public String toString() {
        return "Treasure{" + "treasureType=" + treasureType + ", treasureName=" + treasureName + ", treasureImage=" + treasureImage + ", treasureUnits=" + treasureUnits + ", treasureScore=" + treasureScore + ", treasurePosX=" + treasurePosX + ", treasurePosY=" + treasurePosY + ", treasureLevel=" + treasureLevel + '}';
    }
    
    
}
