package ui;

import java.util.Scanner;
import model.Game;
import model.Level;

public class Main {

	private Scanner scan;
	private Game game; 
	private Level level;

	private int screenResolution = 0;
	private int optionChosenResolution = 0;
	private boolean isUsed = false;

	public Main() {
		scan = new Scanner(System.in); 
		game = new Game("CodeGame"); 
		level = new Level();

	}

	public Scanner getScan(){
		return scan;
	}

	public Game getGame(){
		return game; 
	}

	public Level getLevel() {
		return level;
	}

	public static void main(String[] args){
		Main main = new Main(); 

		int option = 0; 

				do{

					option = main.getOptionShowMenu(); 
					main.executeOption(option);

				}while(option != 0);

				main.getScan().close();
	}

	/**
	 * getOptionShowMenu prints the menu and receives the option given by the user.
	 * @return option save the option chosen.
	 * */

	public void initResolution() {
		game.showScreenResolutionOptions();
		screenResolution = scan.nextInt();
		optionChosenResolution = screenResolution;
		screenResolution = game.getScreenResolution(screenResolution);
		game.initializeLevels();

		isUsed = true;		
	}

	public int getOptionShowMenu(){
		if (isUsed == false) {
			initResolution();
			game.initializeLevels();
		}

		int option = 0; 
		System.out.println("<<<<< Welcome to this CodeGame >>>>>");
		System.out.println(
				"1. Create a player \n" +
				"2. Register enemy on a level \n" +
				"3. Register treasure on a level \n" +
				"4. Modify a player's score \n" +
				"5. Increase the level of a player \n" +
				"6. Know the treasures and enemies of a specific level \n" +
				"7. Know the total amount of treasures in all the levels \n" +
				"8. Know the total amount of enemies in all the levels \n" +
				"9. Know the most repeated treasure at all levels \n" +
				"10. Know the enemy (and its level) that gives the highest score \n" +
				"11. Know the number of consonants found in enemie's names. \n" +
				"12. Get the top 5 players \n" +
				"0. Exit. ");
		option = scan.nextInt(); 

		return option; 
	}
	
	/**
	 * executeOption executes the program's functionalities according to the user's choice.
	 * @param option saves the user's choice.
	 * */
	public void executeOption(int option){

		switch(option){
			case 1: 
				System.out.println("<< Player registration >>");

				String pNickname = "";
				String pName = "";
				int pScore = 10;
				int pLives = 5;
				int pLevel = 0;

				System.out.println("Type the nickname: "); 
				pNickname = scan.next(); 
				pNickname = pNickname.toLowerCase();
				int pos = game.searchPlayerByNickname(pNickname); 
				if(pos == -1){
					System.out.println("Type the player name: "); 
					pName = scan.next(); 
					String msj = game.addPlayerToGame(pNickname, pName, pScore, pLives, pLevel); 
					System.out.println(msj); 

					// this is to verify the correct save of the player - DELETE 
					game.showPlayers();
				}
				else{
					System.out.println("Error. This nickname is already in use."); 
				}

				break; 

			case 2: 	
				System.out.println("<< Enemie registration >>");

				int eLevel = 0;
				String eNameType = ""; 
				int eType = 0;
				int eScoreDown = 0;
				int eScoreUp = 0;
				int ePositionX = 0;
				int ePositionY = 0;

				// add level authentication
				System.out.println("Type the level to add enemie: "); 
				eLevel = scan.nextInt();
				scan.nextLine();
				System.out.println("Choose an enemie type: ");
				System.out.println(game.showOptionEnemyType());
				eType = scan.nextInt();
				eNameType = game.getOptionEnemyType(eType);				
				System.out.println("Type the subtracting score:");
				eScoreDown = scan.nextInt();
				System.out.println("Type the score that adds up: ");
				eScoreUp = scan.nextInt();
				ePositionX = game.getScreenResolution(optionChosenResolution);
				ePositionY = game.getScreenResolution(optionChosenResolution);

				String msj = game.addEnemieToLevel(eLevel, eNameType, eType, eScoreDown, eScoreUp, ePositionX, ePositionY); 
				System.out.println(msj); 

				/*
				// this is to verify the correct save of the enemie - DELETE 
				game.showEnemies();
				*/

				break; 

			case 3: 
				System.out.println("<< Treasure registration >>");

				int tUnits = 0;
				int tLevel = 0;
				String tName = "";
				String tImage = "https://tinyurl.com/23zkzvtm";
				int tScore = 0;
				int tPositionX = 0;
				int tPositionY = 0;

				System.out.println("Type the treasure name: ");
				tName = scan.next();
				System.out.println("Type the units of the treasure: ");
				tUnits = scan.nextInt();
				System.out.println("Type the level to register treasures: ");
				tLevel = scan.nextInt();
				System.out.println("Type the treasure score: ");
				tScore = scan.nextInt();

				int [] tPositionXList = new int[tUnits];
				int [] tPositionYList = new int[tUnits];

				// array position treasures
				for (int i = 0; i < tUnits; i++) {
					tPositionX = game.getScreenResolution(optionChosenResolution);
					tPositionXList[i] = tPositionX;
					tPositionY = game.getScreenResolution(optionChosenResolution);		
					tPositionYList[i] = tPositionY;			
				}

				String msj_treasure = game.addTreasureToLevel(tUnits, tLevel, tName, tImage, tScore, tPositionXList, tPositionYList);
				System.out.println(msj_treasure);

				break;

			case 4: 
				System.out.println("<< Modifying player score >>");
				String pSearch = "";
				int pNewScore = 0;
				String msj_new_score = "";

				System.out.println("Type the player nickname: ");
				pSearch = scan.next();

				int posSearch = game.searchPlayerById(pSearch);
				System.out.println(posSearch);

				if (posSearch != -1) {
					System.out.println("Type the new score to assign: ");
					pNewScore = scan.nextInt();

					msj_new_score = game.setNewPlayerScore(posSearch, pNewScore);
					System.out.println(msj_new_score);

				} else {
					System.out.println("Error. Player not found.");
				}


				break; 

			case 5:
				System.out.println("<< Increasing player level >>");
				String pSearchNick = "";
				int posSearchNick = 0;
				int pCurrentLevel = 0;
				int pCurrentScore = 0;
				int pNextLevel = 0;
				int pNextLevelScoreRequired = 0;
				boolean isValid = false;
				String msj_level_up = "";

				System.out.println("Type the player nickname: ");
				pSearchNick = scan.next();

				posSearchNick = game.searchPlayerById(pSearchNick);
				System.out.println(posSearchNick);

				// get the player current level
				pCurrentLevel = game.getPlayerCurrentLevel(posSearchNick);
				System.out.println("Current player level: " + pCurrentLevel);

				// get the player current score
				pCurrentScore = game.getPlayerCurrentScore(posSearchNick);
				System.out.println("Current player score: " + pCurrentScore);

				// next level 
				pNextLevel = pCurrentLevel + 1;

				// next level score required
				pNextLevelScoreRequired = game.getScoreRequiredToLevelUp(pNextLevel);

				// make the comparison
				isValid = game.compareScores(pCurrentScore, pNextLevelScoreRequired);

				// make the increment
				if (isValid) {
					msj_level_up = game.setLevelUp(posSearchNick, pNextLevel);
					System.out.println(msj_level_up);
				} else {
					System.out.println("It's not possible to level up. The required score must be equal to or higher than " + pNextLevelScoreRequired);
				}
				
				break; 

			case 6: 
				System.out.println("<< Treasures and enemies >>");
				int teLevel = 0;

				// level to search
				System.out.println("Type the level to search: ");
				teLevel = scan.nextInt();

				// get enemies
				System.out.println("Enemies: ");
				game.searchEnemiesLevel(teLevel);

				// get treasures
				System.out.println("Treasures: ");
				game.searchTreasuresLevel(teLevel);

				break;

			case 7: 
				System.out.println("<< Total amount of treasures >>");
				String tNameSearch = "";
				int countTreasures;

				System.out.println("Type the treasure name to search: ");
				tNameSearch = scan.next();

				countTreasures = game.totalAmountTreasures(tNameSearch);
				System.out.println("Total units of " + tNameSearch + ": " + countTreasures);

				break; 

			case 8: 		
				System.out.println("<< Total amount of enemies >>");
				int eTypeSearch = 0;
				int countEnemies;

				System.out.println("Choose the enemy type to search: ");
				System.out.println(game.showOptionEnemyType());
				eTypeSearch = scan.nextInt();

				countEnemies = game.totalAmountEnemies(eTypeSearch);
				System.out.println("Total enemies of type " + eTypeSearch + ": " + countEnemies);
				break; 

			case 9: 
				System.out.println("<< Most repeated treasure >>");

				break;

			case 10: 
				System.out.println("<< Enemy with highest score >>");
				String msj_highest_enemy;

				msj_highest_enemy = game.showEnemyHighestScore();
				System.out.println(msj_highest_enemy);

				break; 

			case 11: 		
				System.out.println("<< Total consonants in enemy names >>");

				break; 

			case 12: 
				System.out.println("<< Top 5 players >>");

				String top_five = game.getTopFivePlayers();
				System.out.println(top_five);

				break;

			case 0: 
				System.out.println("Closed session. Thank you for playing this game.");
				break; 

			default: 
				System.out.println("You selected an invalid option.");
				break; 
		}
	}
}