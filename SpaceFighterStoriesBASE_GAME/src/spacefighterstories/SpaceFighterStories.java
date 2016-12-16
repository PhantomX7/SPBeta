/*
OFFICIAL CHANGELOG:
Alpha 0.0.1 - Not finished base game shared to PhantomX7 for testing further (testing has occured before sharing of code.)
Alpha 0.0.2 - Added LvlUpandTrainResult()
Alpha 0.0.3 - Added saving and loading, and finished ending.
Alpha 0.0.4 - Finished other scenarios.
Closed Beta 0.0.5 - Finishing touches and more linking stuff.
*Version 0.1.0 - Base game finished.*
 */

// Nessecsary : Pop ups!

/*
Wlll be added after Base Game is formed

Accuracy and Evasion
When player attacks enemy, 3 results will happen..
MISS, NORMAL, CRITICAL
Results depend on player's accuracy and enemy's evasion
when enemy attacks player, same thing happens...
It depends on player's evasion and enemy's accuracy

Enemies with Weapons
Enemy has random weapons (armory same with players)

Player and Enemy Technologies
Player and enemy has technologies/skills...
However, to get technologies, the player will have to sacrifice his stamina and money (to get skills)
- Jetpack : Receiver's accuracy is cut in half, unless receiver uses jetpack too 
- Ambush : Receiver receives double the doer's damage
- LightningVelocity : Doer's evasion is doubled
- SmartTargeting : Doer's accuracy is doubled
2 can only be equipped only at main menu
To use technologies requires stamina (all uses 25 stamina) (if player's stamina is 0, player loses)

Enemies will various levels
Levels affect enemy stats

Level Restrictor (to stop underleveled players from doing certain quests)

Colours....

More Scenarios and Quests
 */
package spacefighterstories;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static spacefighterstories.SysBackbone.inputString;

public class SpaceFighterStories {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        int startCheckpoint = 0;
        Player player1 = null;
        Enemy enemy1 = null;
        do {
            Scanner inputString = new Scanner(System.in);
            String startChoice = SysBackbone.startMenu();
            if (startChoice.equals("1")) {
                System.out.println("Are you sure that you want to start a new game?");
                System.out.println("Make sure that you hadn't started a game or will not regret overwritting the old save file.");
                
                String newGameDecider;
                do {
                    System.out.print("Are you sure? (Y/N):");
                    newGameDecider = inputString.nextLine();
                    if (!newGameDecider.equalsIgnoreCase("y") && !newGameDecider.equalsIgnoreCase("n") ) {
                        System.out.println("  error!!!");
                    }
                } while (!newGameDecider.equalsIgnoreCase("y") && !newGameDecider.equalsIgnoreCase("n"));
                if (newGameDecider.equalsIgnoreCase("y")) {
                    startCheckpoint=1;
                } else if (newGameDecider.equalsIgnoreCase("n")) {
                    //Return back
                }
            } else if (startChoice.equals("2")) {
                player1=SysBackbone.load();
                SysBackbone.getPlayer(player1);
                startCheckpoint=2;
            } else if (startChoice.equals("3")) {
                System.out.println("Alpha 0.0.1 - Not finished base shared to PhantomX7 for testing further (testing has occured before sharing of code.).");
                System.out.println("Alpha 0.0.2 - Added LvlUpandTrainResult()");
                System.out.println("Alpha 0.0.3 - Added saving and loading, and finished ending.");
                System.out.println("Alpha 0.0.4 - Finished other scenarios.");
                System.out.println("Closed Beta 0.0.4 -Finishing touches and more linking stuff.");
                System.out.println("Version 0.1.0 - Base game finished.");
                System.out.println("Version 0.1.1 - Major bug fix.");
                System.out.println("And more to come!");
            } else if (startChoice.equals("4")) {
                //Is it like this?
                /*
            do {
                    System.out.print("Are you sure? (Y/N):");
                    exitConfirm = inputString.nextLine();
                    if (!exitConfirm.equals("Y") && !exitConfirm.equals("y") && !exitConfirm.equals("n") && !exitConfirm.equals("N")) {
                        System.out.println("  error!!!");
                    }
                } while (!exitConfirm.equals("Y") && !exitConfirm.equals("y") && !exitConfirm.equals("n") && !exitConfirm.equals("N"));
                if (exitConfirm.equals("Y") || exitConfirm.equals("y")) {
                    checkpoint = 1;
                } else {
                    checkpoint = 0;
                }
                 */
            }
        } while (startCheckpoint == 0);

        

        if (startCheckpoint == 1) {
            //Objects
            player1 = new Player();

            //Introduction pt. 1
            player1.setName(Introduction.startGame());
            Introduction.intro1(player1.getName());
            //Intro - Fight1
            enemy1 = Enemy.EncounterEnemy(1);
            player1.setWeaponPosessionCounter(1, 1);
            while (player1.isAlive() && enemy1.isAlive()) {
                SysBackbone.battle(player1, enemy1);
            }
            //Introduction pt.2
            Introduction.intro2(player1.getName());
            //Intro - Fight2
            enemy1 = Enemy.EncounterEnemy(2);
            while (player1.isAlive() && enemy1.isAlive()) {
                SysBackbone.battle(player1, enemy1);
            }
            player1.setRelationship(player1.getRelationship() + 10);
            //Introduction pt.3
            Introduction.intro3(player1.getName());
            startCheckpoint = 2;
        }
        if (startCheckpoint == 2) {
            //Main Menu Choices - Start at SysBackbone.java
            String choice;
            int checkpoint = 0;
            do {
                choice = SysBackbone.mainMenu();
                if (choice.equals("1")) {
                    choice = SysBackbone.questMenu();
                    player1.setAlive(true);
                    if (choice.equals("1")) {
                        if (player1.getStamina() == 0) {
                            System.out.println("Not enough Stamina. Rest.");
                        } else {
                            enemy1 = Enemy.EncounterEnemy(2);
                            while (player1.isAlive() && enemy1.isAlive()) {
                                SysBackbone.battle(player1, enemy1);
                            }
                            if(!enemy1.isAlive()){
                                player1.setQuestCounter(0, 1);
                            }
                        }
                    } else if (choice.equals("2")) {
                        if (player1.getStamina() == 0) {
                            System.out.println("Not enough Stamina. Rest.");
                        } else {
                            enemy1 = Enemy.EncounterEnemy(3);
                            while (player1.isAlive() && enemy1.isAlive()) {
                                SysBackbone.battle(player1, enemy1);
                            }
                            if(!enemy1.isAlive()){
                                player1.setQuestCounter(1, 1);
                            }
                        }
                    } else if (choice.equals("3")) {
                        if (player1.getStamina() == 0) {
                            System.out.println("Not enough Stamina. Rest.");
                        } else {
                            enemy1 = Enemy.EncounterEnemy(4);
                            while (player1.isAlive() && enemy1.isAlive()) {
                                SysBackbone.battle(player1, enemy1);
                            }
                            if(!enemy1.isAlive()){
                                player1.setQuestCounter(2, 1);
                            }
                        }
                    } else if (choice.equals("4")) {
                        if (player1.getStamina() == 0) {
                            System.out.println("Not enough Stamina. Rest.");
                        } else {
                            enemy1 = Enemy.EncounterEnemy(5);
                            while (player1.isAlive() && enemy1.isAlive()) {
                                SysBackbone.battle(player1, enemy1);
                            }
                            if(!enemy1.isAlive()){
                                player1.setQuestCounter(3, 1);
                            }
                        }
                    } else if (choice.equals("5")) {
                        if (player1.getStamina() == 0) {
                            System.out.println("Not enough Stamina. Rest.");
                        } else {
                            enemy1 = Enemy.EncounterEnemy(6);
                            while (player1.isAlive() && enemy1.isAlive()) {
                                SysBackbone.battle(player1, enemy1);
                            }if(!enemy1.isAlive()){
                                player1.setQuestCounter(4, 1);
                            }
                        }
                    } else if (choice.equals("6")) {
                        if (player1.getStamina() == 0) {
                            System.out.println("Not enough Stamina. Rest.");
                        } else {
                            enemy1 = Enemy.EncounterEnemy(7);
                            while (player1.isAlive() && enemy1.isAlive()) {
                                SysBackbone.battle(player1, enemy1);
                            }
                            if(!enemy1.isAlive()){
                                player1.setQuestCounter(5, 1);
                            }
                        }
                    } else if (choice.equals("7")) {

                    }
                } else if (choice.equals("2")) {
                    try {
                        NicoleStories.scenario(player1);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(SpaceFighterStories.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else if (choice.equals("3")) {
                    checkpoint = 1;
                    do {
                        choice = SysBackbone.armoryMenu();
                        if (choice.equals("1")) {
                            checkpoint = 2;
                            do {
                                choice = SysBackbone.weaponsMenu();
                                if (choice.equals("1")) {
                                    SysBackbone.weaponBuyOrEquip(1, 0);
                                } else if (choice.equals("2")) {
                                    SysBackbone.weaponBuyOrEquip(2, 200);
                                } else if (choice.equals("3")) {
                                    SysBackbone.weaponBuyOrEquip(3, 350);
                                } else if (choice.equals("4")) {
                                    SysBackbone.weaponBuyOrEquip(4, 500);
                                } else if (choice.equals("5")) {
                                    SysBackbone.weaponBuyOrEquip(5, 600);
                                } else if (choice.equals("6")) {
                                    checkpoint = 1;
                                }
                            } while (checkpoint == 2);
                        } else if (choice.equals("2")) {
                            checkpoint = 2;
                            do {
                                choice = SysBackbone.armorMenu();
                                if (choice.equals("1")) {
                                    SysBackbone.armorBuyOrEquip(1, 100);
                                } else if (choice.equals("2")) {
                                    SysBackbone.armorBuyOrEquip(2, 175);
                                } else if (choice.equals("3")) {
                                    SysBackbone.armorBuyOrEquip(3, 250);
                                } else if (choice.equals("4")) {
                                    SysBackbone.armorBuyOrEquip(4, 375);
                                } else if (choice.equals("5")) {
                                    SysBackbone.armorBuyOrEquip(5, 500);
                                } else if (choice.equals("6")) {
                                    checkpoint = 1;
                                }
                            } while (checkpoint == 2);
                        } else if (choice.equals("3")) {
                            checkpoint = 2;
                            do {
                                choice = SysBackbone.supplyMenu();
                                if (choice.equals("1")) {
                                    SysBackbone.itemBuy(0, 35);
                                } else if (choice.equals("2")) {
                                    SysBackbone.itemBuy(1, 100);
                                } else if (choice.equals("3")) {
                                    SysBackbone.itemBuy(2, 150);
                                } else if (choice.equals("4")) {
                                    SysBackbone.itemBuy(3, 150);
                                } else if (choice.equals("5")) {
                                    checkpoint = 1;
                                }
                            } while (checkpoint == 2);
                        } else if (choice.equals("4")) {
                            checkpoint = 0;
                        }
                    } while (checkpoint == 1);

                } else if (choice.equals("4")) {
                    checkpoint = 2;
                    do {
                        choice = SysBackbone.trainingMenu();
                        if (choice.equals("1")) {
                            SysBackbone.trainDetermine(0);
                        } else if (choice.equals("2")) {
                            SysBackbone.trainDetermine(1);
                        } else if (choice.equals("3")) {
                            SysBackbone.trainDetermine(2);
                        } else if (choice.equals("4")) {
                            SysBackbone.trainDetermine(3);
                        } else {
                            checkpoint = 0;
                        }
                    } while (checkpoint == 2);

                } else if (choice.equals("5")) {
                    SysBackbone.rest();
                }else if (choice.equals("6")) {
                    SysBackbone.save(player1);
                }else if (choice.equals("7")) {
                    player1=SysBackbone.load();
                    SysBackbone.getPlayer(player1);
                } else if (choice.equals("8")) {
                    String exitConfirm;
                    do {
                        System.out.print("Are you sure? (Y/N):");
                        exitConfirm = inputString.nextLine();
                        if (!exitConfirm.equals("Y") && !exitConfirm.equals("y") && !exitConfirm.equals("n") && !exitConfirm.equals("N")) {
                            System.out.println("  error!!!");
                        }
                    } while (!exitConfirm.equals("Y") && !exitConfirm.equals("y") && !exitConfirm.equals("n") && !exitConfirm.equals("N"));
                    if (exitConfirm.equals("Y") || exitConfirm.equals("y")) {
                        checkpoint = 1;
                    } else {
                        checkpoint = 0;
                    }
                }
            } while (checkpoint == 0);

        }
    }
}
