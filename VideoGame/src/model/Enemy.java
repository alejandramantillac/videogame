
package model;

/**
 *
 * @author Alejandra
 */
public class Enemy {
    
    private String enemyId;
    private int enemyType;
    private String enemyNameType;
    private int enemyScoreUp;
    private int enemyScoreDown;
    private int enemyPosX;
    private int enemyPosY;
    private int enemyLevel;

    public Enemy(String enemyId, int enemyType, String enemyNameType, int enemyScoreUp, int enemyScoreDown, int enemyPosX, int enemyPosY, int enemyLevel) {
        this.enemyId = enemyId;
        this.enemyType = enemyType;
        this.enemyNameType = enemyNameType;
        this.enemyScoreUp = enemyScoreUp;
        this.enemyScoreDown = enemyScoreDown;
        this.enemyPosX = enemyPosX;
        this.enemyPosY = enemyPosY;
        this.enemyLevel = enemyLevel;
    }

    public String getEnemyId() {
        return enemyId;
    }

    public void setEnemyId(String enemyId) {
        this.enemyId = enemyId;
    }

    public int getEnemyType() {
        return enemyType;
    }

    public void setEnemyType(int enemyType) {
        this.enemyType = enemyType;
    }

    public String getEnemyNameType() {
        return enemyNameType;
    }

    public void setEnemyNameType(String enemyNameType) {
        this.enemyNameType = enemyNameType;
    }

    public int getEnemyScoreUp() {
        return enemyScoreUp;
    }

    public void setEnemyScoreUp(int enemyScoreUp) {
        this.enemyScoreUp = enemyScoreUp;
    }

    public int getEnemyScoreDown() {
        return enemyScoreDown;
    }

    public void setEnemyScoreDown(int enemyScoreDown) {
        this.enemyScoreDown = enemyScoreDown;
    }

    public int getEnemyPosX() {
        return enemyPosX;
    }

    public void setEnemyPosX(int enemyPosX) {
        this.enemyPosX = enemyPosX;
    }

    public int getEnemyPosY() {
        return enemyPosY;
    }

    public void setEnemyPosY(int enemyPosY) {
        this.enemyPosY = enemyPosY;
    }

    public int getEnemyLevel() {
        return enemyLevel;
    }

    public void setEnemyLevel(int enemyLevel) {
        this.enemyLevel = enemyLevel;
    }

    @Override
    public String toString() {
        return "Enemy{" + "enemyId=" + enemyId + ", enemyType=" + enemyType + ", enemyNameType=" + enemyNameType + ", enemyScoreUp=" + enemyScoreUp + ", enemyScoreDown=" + enemyScoreDown + ", enemyPosX=" + enemyPosX + ", enemyPosY=" + enemyPosY + ", enemyLevel=" + enemyLevel + '}';
    }


    
    
}
