package ui;

import java.util.Scanner;
import model.*;
import java.util.InputMismatchException;

/**
 *
 * @author Alejandra
 */
public class Main {
        
    private Scanner scan;
    private GameController game; 
    
    private int screenResolution = 0;
    private boolean isUsed = false;

    public Main() {
        scan = new Scanner(System.in); 
        game = new GameController(); 
    }

    public Scanner getScan(){
        return scan;
    }

    public GameController getGame(){
        return game; 
    }

    public static void main(String[] args){
        Main main = new Main(); 

        int option = -1; 

            do{
                option = main.getOptionShowMenu(); 
                main.executeOption(option);

            } while(option != 0);

        main.getScan().close();
    }

    /**
     * initGame automatically creates the initial levels, players, enemies and treasures.
     */
    public void initGame() {
        screenResolution = game.getScreenResolution();
        game.initializeLevels();
        game.initPlayers();
        game.initTheEnemies();
        game.initTheTreasures();
        game.getAndSetAutoLvlTotalScore();

        isUsed = true;		
    }

    /**
    * getOptionShowMenu prints the menu and receives the option given by the user.
    * @return option save the option chosen.
    */
    public int getOptionShowMenu(){
        if (isUsed == false) {
            initGame();
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
        option = validateIntegerOption(); 

        return option; 
    }

    /**
     * executeOption executes the program's functionalities according to the user's choice.
     * @param option saves the user's choice.
     */
    public void executeOption(int option){
        boolean isOk, validLevel;

        switch(option){
            case 1: 
                System.out.println("<< Player registration >>");

                String pNickname = "", pName = "";
                int pScore = 10, pLives = 5, pLevel = 0;

                System.out.println("Type the nickname: "); 
                pNickname = scan.next(); 
                pNickname = pNickname.toLowerCase();
                int pos = game.searchPlayerByNickname(pNickname); 
                if(pos == -1){
                    System.out.println("Type the player name: "); 
                    pName = scan.next(); 
                    String msj = game.addPlayerToGame(pNickname, pName, pScore, pLives, pLevel); 
                    System.out.println(msj); 
                }
                else{
                    System.out.println("Error. This nickname is already in use."); 
                }

                break; 

            case 2: 	
                System.out.println("<< Enemy registration >>");
                
                String eNameType = "", enemyId = ""; 
                int eLevel = 0, eType = 0, eScoreDown = 0, eScoreUp = 0, ePositionX = 0, ePositionY = 0, enemyPos = 0;

                System.out.println("Type the enemy id: ");
                enemyId = scan.next();
                enemyId = enemyId.toLowerCase();
                enemyPos = game.getEnemyPosition(enemyId);
                
                if (enemyPos == -1) {
                    System.out.println("Type the level to add enemy: "); 
                    eLevel = scan.nextInt();
                    eLevel =(eLevel-1);
                    validLevel = game.validateLvl(eLevel);
                    
                    if(validLevel) {
                        System.out.println("Choose an enemy type: ");
                        System.out.println(game.showOptionEnemyType());
                        eType = scan.nextInt();
                        eNameType = game.getOptionEnemyType(eType);				
                        System.out.println("Type the subtracting score:");
                        eScoreDown = scan.nextInt();
                        System.out.println("Type the score that adds up: ");
                        eScoreUp = scan.nextInt();
                        ePositionX = game.getScreenResolution();
                        ePositionY = game.getScreenResolution();
                        
                        String msj = game.registerEnemy(enemyId, eType, eNameType, eScoreUp, eScoreDown, ePositionX, ePositionY, eLevel); 
                        game.getAndSetLevelTotalScore(eLevel);
                        game.setLvlDifficulty(eLevel);
                        System.out.println(msj);                          
                    } else {
                        game.invalidLvl();
                    }
                  
                } else {
                    System.out.println("Error. This enemy id already exists.");
                }

                break; 

            case 3: 
                System.out.println("<< Treasure registration >>");
                
                String tName = "", tImage = "";
                int tType = 0, tUnits = 0, tLevel = 0, tScore = 0, tPositionX = 0, tPositionY = 0;

                System.out.println("Choose a treasure type: ");
                System.out.println(game.showOptionTreasure());
                tType = scan.nextInt();
                tName = game.getOptionTreasure(tType);
                tImage = game.setImage(tType);
                System.out.println("Type the units of the treasure: ");
                tUnits = scan.nextInt();
                System.out.println("Type the treasure score: ");
                tScore = scan.nextInt();
                System.out.println("Type the level to register treasures: ");
                tLevel = scan.nextInt();
                tLevel = (tLevel-1);
                int [] tPositionXList = new int[tUnits];
                int [] tPositionYList = new int[tUnits];
                
                validLevel = game.validateLvl(tLevel);
                
                if (validLevel) {
                    // array position treasures
                    for (int i = 0; i < tUnits; i++) {
                        tPositionX = game.getScreenResolution();
                        tPositionXList[i] = tPositionX;
                        tPositionY = game.getScreenResolution();		
                        tPositionYList[i] = tPositionY;			
                    }

                    String msj_treasure = game.registerTreasure(tType, tName, tImage, tUnits, tScore, tPositionXList, tPositionYList, tLevel);
                    System.out.println(msj_treasure);
                    game.getAndSetLevelTotalScore(tLevel);
                    game.setLvlDifficulty(tLevel);
                } else {
                    game.invalidLvl();
                }
                
                break;                    

            case 4: 
                System.out.println("<< Modifying player score >>");
                String pSearch = "", msj_new_score = "";
                int pNewScore = 0;

                System.out.println("Type the player nickname: ");
                pSearch = scan.next();

                int posSearch = game.searchPlayerById(pSearch);
                System.out.println(posSearch);

                if (posSearch != -1) {
                    System.out.println("Type the new score to assign: ");
                    pNewScore = validateIntegerOption();
                    
                    isOk = game.validatePos(pNewScore);
                    
                    if (isOk) {
                        msj_new_score = game.setNewPlayerScore(posSearch, pNewScore);
                        System.out.println(msj_new_score);                        
                    }

                } else {
                    System.out.println("Error. Player not found.");
                }
                break; 

            case 5:
                System.out.println("<< Increasing player level >>");
                
                String pSearchNick = "", msj_level_up = "";
                int posSearchNick = 0, pCurrentLevel = 0,  pCurrentScore = 0, pNextLevel = 0, pNextLevelScoreRequired = 0;
                boolean isValid = false;

                System.out.println("Type the player nickname: ");
                pSearchNick = scan.next();

                posSearchNick = game.searchPlayerById(pSearchNick);
                
                if (posSearchNick == -1) {
                    System.out.println("Nickname entered doesn't exists.");
                } else {
                   // get the player current level
                   pCurrentLevel = game.getPlayerCurrentLevel(posSearchNick);
                   System.out.println("Current player level: " + (pCurrentLevel+1));

                   // get the player current score
                   pCurrentScore = game.getPlayerCurrentScore(posSearchNick);
                   System.out.println("Current player score: " + pCurrentScore);

                   
                   if (pCurrentLevel == 9) {
                       System.out.println("The player has reached the maximum level.");
                   } else {
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
                   }
               
                }

                break; 

            case 6: 
                System.out.println("<< Treasures and enemies >>");
                
                int teLevel = 0;

                System.out.println("Type the level to search: ");
                teLevel = validateIntegerOption();
                
                isOk = game.validatePos(teLevel);
                
                if(isOk) {
                    teLevel = (teLevel-1);
                    
                    isValid = game.validateLvl(teLevel);
                    
                    if (isValid) {
                        System.out.println("Enemies: ");
                        game.showEnemiesOnLevel(teLevel);

                        System.out.println("Treasures: ");
                        game.showTreasuresOnLevel(teLevel);                           
                    }                
                }

                break;

            case 7: 
                System.out.println("<< Total amount of treasures >>");
                
                String tNameSearch = "";
                int countTreasures, tTypeToSearch = 0;

                System.out.println("Choose a treasure type to search: ");
                System.out.println(game.showOptionTreasure());
                tTypeToSearch = validateIntegerOption();
                
                isOk = game.validatePos(tTypeToSearch);
                
                if (isOk) {
                    tNameSearch = game.getOptionTreasure(tTypeToSearch);

                    countTreasures = game.showTotalAmountOfTreasures(tNameSearch);
                    System.out.println("Total units of " + tNameSearch + " at all levels: " + countTreasures);                    
                }

                break; 

            case 8: 	
                System.out.println("<< Total amount of enemies >>");
                int eTypeSearch = 0, countEnemies;

                System.out.println("Choose the enemy type to search: ");
                System.out.println(game.showOptionEnemyType());
                eTypeSearch = validateIntegerOption();
                
                isOk = game.validatePos(eTypeSearch);
                
                if(isOk) {
                    countEnemies = game.showTotalAmountEnemies(eTypeSearch);
                    System.out.println("Total enemies of type " + eTypeSearch + " at all levels: " + countEnemies);                    
                }
			
                break; 

            case 9: 
                System.out.println("<< Most repeated treasure >>");
                
                String mostRepeated = game.showMostRepeatedTreasure();
                System.out.println(mostRepeated);
                
                break;

            case 10: 
                    System.out.println("<< Enemy with highest score >>");
                    
                    String msj_highest_enemy = game.showInfoEnemyHighestScore();
                    System.out.println(msj_highest_enemy);
                break; 

            case 11: 		
                System.out.println("<< Total consonants on enemy names >>");
                
                String totalConsonants = game.showTotalConsonants();
                System.out.println(totalConsonants);
                break; 

            case 12: 
		System.out.println("<< Top 5 players >>");
                game.getTopFivePlayers();
                break;

            case 0: 
                System.out.println("Closed session. Thank you for playing this game.");
                break; 

            default: 
                System.out.println("You selected an invalid option.");
                break; 
            }
    }

    /**
     * validateIntegerOption validates integer entries entered by the user.
     * @return option represents the validation (if return -1 means that is not an integer).
     */
    public int validateIntegerOption(){
        int option = 0; 

        if(scan.hasNextInt()){
            option = scan.nextInt(); 
        }
        else{
            scan.nextLine(); 
            System.out.println("Error. You entered a non-numeric value.");
            option = -1; 
        }

        return option; 
    }
}
