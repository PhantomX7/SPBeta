/*
OFFICIAL CHANGELOG:
Alpha 0.0.1 - Not finished base game shared to PhantomX7 for testing further (testing has occured before sharing of code.)
Alpha 0.0.2 - Added LvlUpandTrainResult()
Alpha 0.0.3 - Added saving and loading, and finished ending.
Alpha 0.0.4 - Finished other scenarios.
Closed Beta 0.0.5 - Finishing touches and more linking stuff.
*Version 0.1.0 - Base game finished.*
*/

/*
Wlll be added after Base Game is formed
Accuracy - Miss, Usual, Critical and Evasion
Enemies with Weapons and Skills
Level Restrictor (to stop underleveled players from doing certain quests)
Colours....
More Scenarios
 */

/*
  Need to be done
 - Scenarios (s-4[minigame part] and s-S (check)) (located at NicoleStories, lines 366 - 531) 
 - Endings (initialisation) (located at Endings (whole thing))
 - Start menu (initialisation) (located at SysBackbone, lines 681 - 733, and Introduction's starGame())
 - Testing 
  After that it's done! (0.1.0)
*/

package spacefighterstories;

import java.util.logging.Level;
import java.util.logging.Logger;
import static spacefighterstories.SysBackbone.inputString;

public class SpaceFighterStories {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        //Objects
        Player player1 = new Player();
        Enemy enemy1 = null;

        //Introduction pt. 1
        player1.setName(Introduction.startGame());
        Introduction.intro1(player1.getName());
        //Intro - Fight1
        enemy1 = Enemy.EncounterEnemy(1);
        player1.setWeaponPosessionCounter(0, 1);
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
                    }
                } else if (choice.equals("2")) {
                    if (player1.getStamina() == 0) {
                        System.out.println("Not enough Stamina. Rest.");
                    } else {
                        enemy1 = Enemy.EncounterEnemy(3);
                        while (player1.isAlive() && enemy1.isAlive()) {
                            SysBackbone.battle(player1, enemy1);
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
                    }
                } else if (choice.equals("4")) {
                    if (player1.getStamina() == 0) {
                        System.out.println("Not enough Stamina. Rest.");
                    } else {
                        enemy1 = Enemy.EncounterEnemy(5);
                        while (player1.isAlive() && enemy1.isAlive()) {
                            SysBackbone.battle(player1, enemy1);
                        }
                    }
                } else if (choice.equals("5")) {
                    if (player1.getStamina() == 0) {
                        System.out.println("Not enough Stamina. Rest.");
                    } else {
                        enemy1 = Enemy.EncounterEnemy(6);
                        while (player1.isAlive() && enemy1.isAlive()) {
                            SysBackbone.battle(player1, enemy1);
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
                                SysBackbone.weaponBuyOrEquip(0, 0);
                            } else if (choice.equals("2")) {
                                SysBackbone.weaponBuyOrEquip(1, 200);
                            } else if (choice.equals("3")) {
                                SysBackbone.weaponBuyOrEquip(2, 350);
                            } else if (choice.equals("4")) {
                                SysBackbone.weaponBuyOrEquip(3, 500);
                            } else if (choice.equals("5")) {
                                SysBackbone.weaponBuyOrEquip(4, 600);
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
            } else if (choice.equals("6")) {
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
