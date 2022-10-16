
package model;

/**
 *
 * @author Alejandra
 */
public class Player {
    
    private String playerNickname;
    private String playerName;
    private int playerScore;
    private int playerLives;
    private int playerLevel;

    public Player(String playerNickname, String playerName, int playerScore, int playerLives, int playerLevel) {
        this.playerNickname = playerNickname;
        this.playerName = playerName;
        this.playerScore = playerScore;
        this.playerLives = playerLives;
        this.playerLevel = playerLevel;
    }

    public String getPlayerNickname() {
        return playerNickname;
    }

    public void setPlayerNickname(String playerNickname) {
        this.playerNickname = playerNickname;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public int getPlayerLives() {
        return playerLives;
    }

    public void setPlayerLives(int playerLives) {
        this.playerLives = playerLives;
    }

    public int getPlayerLevel() {
        return playerLevel;
    }

    public void setPlayerLevel(int playerLevel) {
        this.playerLevel = playerLevel;
    }

    @Override
    public String toString() {
        return "Player{" + "playerNickname=" + playerNickname + ", playerName=" + playerName + ", playerScore=" + playerScore + ", playerLives=" + playerLives + ", playerLevel=" + playerLevel + '}';
    }
    
    
}
