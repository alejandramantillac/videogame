package model;

public class Player {
    public static final int MAX_PLAYERS_SIZE = 20;


	// Atributes
	private String playerNickname;
	private String playerName;
	private int playerScore;
	private int playerLives;
	private int playerLevel;

	// Relations

	// Constructor
	public Player(String playerNickname, String playerName, int playerScore, int playerLives, int playerLevel) {
		this.playerNickname = playerNickname;
		this.playerName = playerName;
		this.playerScore = playerScore;
		this.playerLives = playerLives;
		this. playerLevel = playerLevel;
	}
    // toString
    @Override
    public String toString() {
        return playerNickname+ ", " + playerName;
    }

	// Getters and Setters Methods
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
    
	// Methods


}