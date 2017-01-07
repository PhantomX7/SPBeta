package maincommand;

import storyline.Endings;
import entities.Enemy;
import entities.Player;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SysBackbone {

    //Objects and Tools
    static Player player1 = null;
    static Enemy enemy1 = null;
    static Scanner inputString = new Scanner(System.in);
    static Scanner inputChoice = new Scanner(System.in);
    //Items Potency
    private static int[] itemTurnsLeftCounter = {0, 0, 0, 0, 0, 0, 0};

    /*
    index 0 = EnhancedSteroids
    index 1 = SkinShield
     */
    public static void getPlayer(Player player) {
        player1 = player;
    }

    //Battle Method
    public static void battle(Player player, Enemy enemy) throws InterruptedException {

        int checkpoint = 0;

        do {
            player1 = player;
            enemy1 = enemy;

            if (player1.getExperience() >= player1.getExpCap()) {
                player1.setExperience(player1.getExperience() - player1.getExpCap());
                player1.setLevel(player1.getLevel() + 1);
            }
            if (enemy1.getHealth() <= 0) {
                enemy1.setHealth(0);
                enemy1.setAlive(false);
            }
            if (player1.getHealth() <= 0) {
                player1.setHealth(0);
                player1.setAlive(false);
            }
            itemTurnLeftCheck();
            if (player1.isAlive() && enemy1.isAlive()) {
                System.out.println(player1.getName() + "                       " + enemy1.getName());
                System.out.println("Level      :" + player1.getLevel() + "\t\t|" + " Enemy Level  :" + enemy1.getLevel());
                System.out.println("HP         :" + player1.getHealth() + "/" + player1.getHealthCap() + "\t|" + " Health       :" + enemy1.getHealth());
                System.out.println("Strength   :" + player1.getStrength() + "\t\t| Strength     :" + enemy1.getStrength());
                System.out.println("Defense    :" + player1.getDefence() + "\t\t|" + " Defence     :" + enemy1.getDefence());
                System.out.println("Accuracy   :" + player1.getAccuracy() + "\t\t|" + " Accuracy     :" + enemy1.getAccuracy());
                System.out.println("Evasionv   :" + player1.getEvasion() + "\t\t|" + " Evasion     :" + enemy1.getEvasion());
                if (itemTurnsLeftCounter[0] > 0) {
                    System.out.println("| EnhancedSteroids' effect will diminish at " + itemTurnsLeftCounter[0] + " turns. |");
                }
                if (itemTurnsLeftCounter[1] > 0) {
                    System.out.println("| SkinShield's effect will diminish at " + itemTurnsLeftCounter[1] + " turns. |");
                }
                String choice;
                do {
                    System.out.println("Choose an action:");
                    System.out.println("1. Attack");
                    System.out.println("2. Defend");
                    System.out.println("3. Choose item");
                    System.out.println("4. Evade");
                    choice = inputString.nextLine();
                    if (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4")) {
                        System.out.println("Input 1-4!!!");
                    }
                } while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4"));
                if (choice.equals("1")) {
                    attack();
                } else if (choice.equals("2")) {
                    defense();
                } else if (choice.equals("3")) {
                    chooseItem();
                } else if (choice.equals("4")) {
                    /*
                     Evading
                     When pressed, the player keeps health, and loses 10 stamina, doesn't gain any experience, and Peace Points is reduced by 20.
                     */
                    if (Enemy.getEnemyType1() == 1) {
                        checkpoint = 0;
                        System.out.println("Captain : Really? Shoot it!");
                    } else {
                        enemy1.setAlive(false);
                        checkpoint = 1;
                        player1.setStamina(player1.getStamina() - 10);
                        player1.setPeace(player1.getPeace() - 20);
                    }
                }
            } else if (enemy1.isAlive() == false) {
                checkpoint = 1;
                System.out.println("-------Results------");
                System.out.println("You have killed the " + enemy1.getName() + ".");
                System.out.println("You have gained " + enemy1.getXpGain() + " exp.");
                System.out.println("You have also recieved " + enemy1.getMoneyDropped() + " money.");
                System.out.println("Your stamina is reduced by " + enemy1.getStaminaLost() + " stamina points.");
                if (enemy1.getPeaceGain() > 0) {
                    System.out.println("Also, you have gained " + enemy1.getPeaceGain() + " peace points.");
                }
                System.out.println("But, you have lost 10 Relationship Points.");
                System.out.println("--------------------");
                // levelUp();
                player1.setExperience(player1.getExperience() + enemy1.getXpGain());
                player1.setPeace(player1.getPeace() + enemy1.getPeaceGain());
                player1.setStamina(player1.getStamina() - enemy1.getStaminaLost());
                player1.setRelationship(player1.getRelationship() - 10);
                player1.setMoney(player1.getMoney() + enemy1.getMoneyDropped());
            } else if (player1.isAlive() == false) {
                checkpoint = 1;
                System.out.println("-------Results------");
                System.out.println("You are defeated.");
                System.out.println("Your stamina is reduced by" + (enemy1.getStaminaLost() * 2) + " stamina points.");
                if (enemy1.getPeaceLost() > 0) {
                    System.out.println("Also, during your recovery, you have lost " + enemy1.getPeaceLost() + " Peace Points.");
                }
                System.out.println("You have lost 10 Relationship Points.");
                System.out.println("--------------------");
                // levelUp();
                player1.setPeace(player1.getPeace() - enemy1.getPeaceLost());
                player1.setStamina(player1.getStamina() - (enemy1.getStaminaLost() * 2));
                player1.setRelationship(player1.getRelationship() - 10);
            }
        } while (checkpoint == 0);
    }

    /*
    Attack Method
    HP reduced : (Player strength - Enemy Defense) + Weapon Attack
     */
    public static void attack() {
        int damageTakenByEnemy = 0;
        if (itemTurnsLeftCounter[0] > 0) {
            itemTurnsLeftCounter[0]--;
        }
        if (itemTurnsLeftCounter[1] > 0) {
            itemTurnsLeftCounter[1]--;
        }
        if (player1.getAccuracy() - enemy1.getEvasion() > 100) {
            if (RpgUtil.chanceOver100((player1.getAccuracy() - enemy1.getEvasion()) - 100)) {
                //CRITICAL
                if ((player1.getStrength() - enemy1.getDefence()) > 0) {
                    damageTakenByEnemy = 2 * (player1.getStrength() - enemy1.getDefence()) + player1.getWeaponDamageDone(player1.getWeaponEquipped());
                } else {
                    damageTakenByEnemy = 2 * (1 + player1.getWeaponDamageDone(player1.getWeaponEquipped()));
                }
            } else {
                //NORMAL
                if ((player1.getStrength() - enemy1.getDefence()) > 0) {
                    damageTakenByEnemy = (player1.getStrength() - enemy1.getDefence()) + player1.getWeaponDamageDone(player1.getWeaponEquipped());
                } else {
                    damageTakenByEnemy = 1 + player1.getWeaponDamageDone(player1.getWeaponEquipped());
                }
            }
        } else {
            if (RpgUtil.chanceOver100(player1.getAccuracy() - enemy1.getEvasion())) {
                //NORMAL
                if ((player1.getStrength() - enemy1.getDefence()) > 0) {
                    damageTakenByEnemy = (player1.getStrength() - enemy1.getDefence()) + player1.getWeaponDamageDone(player1.getWeaponEquipped());
                } else {
                    damageTakenByEnemy = 1 + player1.getWeaponDamageDone(player1.getWeaponEquipped());
                }
            } else {
                //MISS
                System.out.println("You missed...");
            }
        }
        System.out.println("The enemy loses " + damageTakenByEnemy + " hp");
        enemy1.setHealth((enemy1.getHealth() - damageTakenByEnemy));
        if (Enemy.getEnemyType1() == 1) {
            dummyEnemyAttack();
        } else {
            enemyAttack();
        }
    }

    public static void enemyAttack() {
        int damageTakenByPlayer;
        if ((enemy1.getStrength() - player1.getDefence()) > 0) {
            damageTakenByPlayer = enemy1.getStrength() - player1.getDefence();
        } else {
            damageTakenByPlayer = 1;
        }
        //
        if (enemy1.getAccuracy() - player1.getEvasion() > 100) {
            if (RpgUtil.chanceOver100((enemy1.getAccuracy() - player1.getEvasion()) - 100)) {
                //CRITICAL
                if ((enemy1.getStrength() - player1.getDefence()) > 0) {
                    damageTakenByPlayer = 2 * (enemy1.getStrength() - player1.getDefence());
                } else {
                    damageTakenByPlayer = 2;
                }
            } else {
                //NORMAL
                if ((enemy1.getStrength() - player1.getDefence()) > 0) {
                    damageTakenByPlayer = enemy1.getStrength() - player1.getDefence();
                } else {
                    damageTakenByPlayer = 1;
                }
            }
        } else {
            if (RpgUtil.chanceOver100(player1.getAccuracy() - enemy1.getEvasion())) {
                if ((enemy1.getStrength() - player1.getDefence()) > 0) {
                    damageTakenByPlayer = enemy1.getStrength() - player1.getDefence();
                } else {
                    damageTakenByPlayer = 1;
                }
            } else {
                //MISS
                System.out.println("Luckily, it missed...");
            }
        }
        System.out.println("You have taken " + damageTakenByPlayer + "HP.");
        player1.setHealth(player1.getHealth() - damageTakenByPlayer);
    }

    public static void dummyEnemyAttack() {
        System.out.println("Nothing happens, since, duh, it's a dummy.");
    }

    /*
    Defense Method
    HP Reduced with Defense = (Enemy Strength - (Player Defense * 2)) + Armor Defence
     */
    public static void defense() {
        int damageTakenByPlayer;
        if ((enemy1.getStrength() - (player1.getDefence() * 2) + player1.getArmorDefenceDone(player1.getArmorEquipped())) > 0) {
            damageTakenByPlayer = enemy1.getStrength() - (player1.getDefence() * 2);
        } else {
            damageTakenByPlayer = 0;
        }
        System.out.println("You have sucessfully defended yourself, and lost " + damageTakenByPlayer + " HP.");
        player1.setHealth(player1.getHealth() - damageTakenByPlayer);
    }

    /*
    Choosing Items 
    When pressed, it will show your inventory.
    MediKit - Gives 20 HP
    NanoKit - Gives full HP
    EnhancedSteroid- Multiplies Strength by 2 for 2 turns
    SkinShield - Multiplies Defence by 2 for 2 turns
     */
    public static void chooseItem() {
        System.out.println("Choose items");
        System.out.println("1. MediKit(+20HP) - you have " + player1.getItemPosessionCounter(0));
        System.out.println("2. NanoKit(Full HP) - you have " + player1.getItemPosessionCounter(1));
        System.out.println("3. EnhancedSteroids(Strength*2 for 2 turns) - you have " + player1.getItemPosessionCounter(2));
        System.out.println("4. SkinShield(Defence*2 for 2 turns) - you have " + player1.getItemPosessionCounter(3));
        System.out.println("5. Go back.");
        String choice;
        do {
            choice = inputString.nextLine();
            if (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4") && !choice.equals("5")) {
                System.out.println("Input 1-5!!!");
            }
        } while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4") && !choice.equals("5"));

        if (choice.equals("1")) {
            mediKit();
        } else if (choice.equals("2")) {
            nanoKit();
        } else if (choice.equals("3")) {
            enhancedSteroids();
        } else if (choice.equals("4")) {
            skinShield();
        } else if (choice.equals("5")) {

        }
    }

    //Item Methods
    private static void mediKit() {
        if (player1.getItemPosessionCounter(0) > 0) {
            if (player1.getHealth() == player1.getHealthCap()) {
                System.out.println("Your health is full!!!");
            } else {
                player1.setHealth(player1.getHealth() + 20);
                if (player1.getHealth() > player1.getHealthCap()) {
                    player1.setHealth(player1.getHealthCap());
                    player1.setItemPosessionCounter(0, player1.getItemPosessionCounter(0) - 1);
                }
                if (Enemy.getEnemyType1() == 1) {
                    dummyEnemyAttack();
                } else {
                    enemyAttack();
                }
            }
        } else {
            System.out.println("This item is not in your possession");
        }
    }

    private static void nanoKit() {
        if (player1.getItemPosessionCounter(1) > 0) {
            if (player1.getHealth() == player1.getHealthCap()) {
                System.out.println("Your health is full!!!");
            } else {
                player1.setHealth(player1.getHealthCap());
                player1.setItemPosessionCounter(1, player1.getItemPosessionCounter(1) - 1);
                if (Enemy.getEnemyType1() == 1) {
                    dummyEnemyAttack();
                } else {
                    enemyAttack();
                }
            }
        } else {
            System.out.println("This item is not in your possession...");
        }
    }

    private static void enhancedSteroids() {
        if (player1.getItemPosessionCounter(2) > 0) {
            if (itemTurnsLeftCounter[0] > 0) {
                System.out.println("Item still in effect. Please wait until it expires...");
            } else {
                itemTurnsLeftCounter[0] = 2;
                player1.setItemPosessionCounter(2, player1.getItemPosessionCounter(2) - 1);
                if (Enemy.getEnemyType1() == 1) {
                    dummyEnemyAttack();
                } else {
                    enemyAttack();
                }
            }
        } else {
            System.out.println("This item is not in your possesion...");
        }
    }

    private static void skinShield() {
        if (player1.getItemPosessionCounter(3) > 0) {
            if (itemTurnsLeftCounter[1] > 0) {
                System.out.println("Item still in effect. Please wait until it expires...");
            } else {
                itemTurnsLeftCounter[1] = 2;
                player1.setItemPosessionCounter(3, player1.getItemPosessionCounter(3) - 1);
                if (Enemy.getEnemyType1() == 1) {
                    dummyEnemyAttack();
                } else {
                    enemyAttack();
                }
            }
        } else {
            System.out.println("This item is not in your possesion...");
        }
    }

    private static void itemTurnLeftCheck() {
        if (itemTurnsLeftCounter[0] == 0) {
            player1.setStrength(player1.getDefaultStrength());
        }
        if (itemTurnsLeftCounter[0] > 0) {
            player1.setStrength(player1.getDefaultStrength() * 2);
        }

        if (itemTurnsLeftCounter[1] == 0) {
            player1.setDefence(player1.getDefaultDefence());
        }
        if (itemTurnsLeftCounter[1] > 0) {
            player1.setDefence(player1.getDefaultDefence() * 2);
        }
    }

    public static void levelUp() {
        if (player1.getExperience() >= player1.getExpCap()) {
            player1.setLevel(player1.getLevel() + 1);
            player1.setExperience(player1.getExperience() - player1.getExpCap());
            player1.setExpCap(player1.getExpCap() + 25);
            player1.setAccuracy(player1.getAccuracy() + 10);
            player1.setEvasion(player1.getEvasion() + 10);
        }
        if (itemTurnsLeftCounter[0] == 0) {
            player1.setStrength(player1.getDefaultStrength());
        }
        if (itemTurnsLeftCounter[1] == 0) {
            player1.setDefence(player1.getDefaultDefence());
        }
    }

    /*
    Main Menu
        | STATS |
        Quests
        Interaction with Nicole
        Armory
        Training/Improve Stats
        Rest
     */
    public static void relationshipCheck() {
        if (player1.getRelationship() <= 0) {
            player1.setRelationship(0);
        } else if (player1.getRelationship() >= 100) {
            player1.setRelationship(100);
        }
    }

    public static void staminaCheck() {
        if (player1.getStamina() <= 0) {
            player1.setStamina(0);
        }
    }

    public static void peacecheck() {
        if (player1.getPeace() <= 0) {
            player1.setPeace(0);
        } else if (player1.getPeace() <= 0) {
            player1.setPeace(100);
        }
        if (player1.getPeace() >= 100) {
            player1.setPeace(100);
        }
    }

    public static String mainMenu() {
        //Checkers
        levelUp();
        relationshipCheck();
        peacecheck();
        staminaCheck();
        LvlUpAndTrainResult();

        //Ending 5 Trigger
        if (player1.getPeace() == 0) {
            Endings.endingSelector(player1);
        }
        if (player1.getQuestCounter(0) == 1 && player1.getQuestCounter(1) == 1 && player1.getQuestCounter(2) == 1 && player1.getQuestCounter(3) == 1 && player1.getQuestCounter(4) == 1 && player1.getQuestCounter(5) == 1) {
            Endings.endingSelector(player1);
        }

        System.out.println("| " + player1.getName() + " |");
        System.out.println("Level        : " + player1.getLevel() + "   Experience : " + player1.getExperience() + " / " + player1.getExpCap());
        System.out.println("HP           : " + player1.getHealth()+"/"+player1.getHealthCap());
        System.out.println("Strength     : " + player1.getStrength() + "    | Defense     :" + player1.getDefence());
        System.out.println("Accuracy     : " + player1.getAccuracy() + " | Evasion : " + player1.getEvasion());
        System.out.println("Stamina      : " + player1.getStamina());
        System.out.println("Money        : " + player1.getMoney());
        System.out.println("Peace Points : " + player1.getPeace() + " | Relationship Points : " + player1.getRelationship());
        System.out.println(" | MAIN MENU |");
        System.out.println("1. Quests");
        System.out.println("2. Interaction With Nicole");
        System.out.println("3. Armory");
        System.out.println("4. Training / Improve Stats");
        System.out.println("5. Rest");
        System.out.println("6. Save");
        System.out.println("7. Load");
        System.out.println("8. Exit");
        System.out.println(" | Don't forget to save! |");
        String choice;
        do {
            choice = inputString.nextLine();
            if (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4") && !choice.equals("5") && !choice.equals("6") && !choice.equals("7") && !choice.equals("8")) {
                System.out.println("Input 1-8!!!");
            }
        } while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4") && !choice.equals("5") && !choice.equals("6") && !choice.equals("7") && !choice.equals("8"));
        return choice;
    }

    public static String questMenu() {
        System.out.println(" | QUEST MENU |");
        System.out.println("1. OPERATION SWEEPER");
        System.out.println("2. OPERATION DROP EM");
        System.out.println("3. OPERATION UPROAR");
        System.out.println("4. OPERATION APOCALYSIS");
        System.out.println("5. OPERATION FURIOSA");
        System.out.println("6. OPERATION EXTINCTION");
        System.out.println("7. Go back");
        System.out.println(" | FINISH ALL MISSIONS TO REACH ENDINGS |");
        String choice;
        do {
            choice = inputString.nextLine();
            if (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4") && !choice.equals("5") && !choice.equals("6") && !choice.equals("7")) {
                System.out.println("Input 1-7!!!");
            }
        } while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4") && !choice.equals("4") && !choice.equals("5") && !choice.equals("6") && !choice.equals("7"));
        return choice;
    }

    public static String armoryMenu() {
        System.out.println(" | ARMORY |");
        System.out.println("1. Weapons");
        System.out.println("2. Armor");
        System.out.println("3. Supplies Shop");
        System.out.println("4. Skill");
        System.out.println("5. Go back");
        String choice;
        do {
            choice = inputString.nextLine();
            if (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4")&& !choice.equals("5")) {
                System.out.println("Input 1-5!!!");
            }
        } while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4") && !choice.equals("4")&& !choice.equals("5"));
        return choice;
    }

    public static String weaponsMenu() {
        System.out.println("Money : " + player1.getMoney());
        System.out.println(" | Weapons | ");
        System.out.print("1. Handgun");

        if (player1.getWeaponPosessionCounter(1) == 0) {
            System.out.print(" (buy for free) ");
        } else {
            if (player1.getWeaponEquipped() == 1) {
                System.out.print(" (equipped) ");
            } else {
                System.out.print(" (unequipped) ");
            }
        }
        System.out.println("");
        System.out.println("2. SMG");
        if (player1.getWeaponPosessionCounter(2) == 0) {
            System.out.print(" (buy for $200) ");
        } else {
            if (player1.getWeaponEquipped() == 2) {
                System.out.print(" (equipped) ");
            } else {
                System.out.print(" (unequipped) ");
            }
        }
        System.out.println("");
        System.out.println("3. Assault Rifle");
        if (player1.getWeaponPosessionCounter(3) == 0) {
            System.out.print(" (buy for $350) ");
        } else {
            if (player1.getWeaponEquipped() == 3) {
                System.out.print(" (equipped) ");
            } else {
                System.out.print(" (unequipped) ");
            }
        }
        System.out.println("");
        System.out.println("4. RPG");
        if (player1.getWeaponPosessionCounter(4) == 0) {
            System.out.print(" (buy for $500) ");
        } else {
            if (player1.getWeaponEquipped() == 4) {
                System.out.print(" (equipped) ");
            } else {
                System.out.print(" (unequipped) ");
            }
        }
        System.out.println("");
        System.out.println("5. Gatling Gun");
        if (player1.getWeaponPosessionCounter(5) == 0) {
            System.out.print(" (buy for $600) ");
        } else {
            if (player1.getWeaponEquipped() == 5) {
                System.out.print(" (equipped) ");
            } else {
                System.out.print(" (unequipped) ");
            }
        }
        System.out.println("");
        System.out.println("6. Go back");
        String choice;
        do {
            choice = inputString.nextLine();
            if (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4") && !choice.equals("5") && !choice.equals("6")) {
                System.out.println("Input 1-6!!!");
            }
        } while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4") && !choice.equals("5") && !choice.equals("6"));
        return choice;
    }

    public static String armorMenu() {
        System.out.println("Money : " + player1.getMoney());
        System.out.println(" | Armor | ");
        System.out.print("1. Basic Space Combat Suit (SCS) ");
        if (player1.getArmorPosessionCounter(1) == 0) {
            System.out.print(" (buy for $100) ");
        } else {
            if (player1.getArmorEquipped() == 1) {
                System.out.print(" (equipped) ");
            } else {
                System.out.print(" (unequipped) ");
            }
        }
        System.out.println("");
        System.out.println("2. Fortified SCS");
        if (player1.getArmorPosessionCounter(2) == 0) {
            System.out.print(" (buy for $175) ");
        } else {
            if (player1.getArmorEquipped() == 2) {
                System.out.print(" (equipped) ");
            } else {
                System.out.print(" (unequipped) ");
            }
        }
        System.out.println("");
        System.out.println("3. SCS with Force Field");
        if (player1.getArmorPosessionCounter(3) == 0) {
            System.out.print(" (buy for $250) ");
        } else {
            if (player1.getArmorEquipped() == 3) {
                System.out.print(" (equipped) ");
            } else {
                System.out.print(" (unequipped) ");
            }
        }
        System.out.println("");
        System.out.println("4. Enhanced SCS");
        if (player1.getArmorPosessionCounter(4) == 0) {
            System.out.print(" (buy for $375) ");
        } else {
            if (player1.getArmorEquipped() == 4) {
                System.out.print(" (equipped) ");
            } else {
                System.out.print(" (unequipped) ");
            }
        }
        System.out.println("");
        System.out.println("5. Enhanced NanoSCS");
        if (player1.getArmorPosessionCounter(5) == 0) {
            System.out.print(" (buy for $500) ");
        } else {
            if (player1.getArmorEquipped() == 5) {
                System.out.print(" (equipped) ");
            } else {
                System.out.print(" (unequipped) ");
            }
        }
        System.out.println("");
        System.out.println("6. Go back");
        String choice;
        do {
            choice = inputString.nextLine();
            if (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4") && !choice.equals("5") && !choice.equals("6")) {
                System.out.println("Input 1-6!!!");
            }
        } while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4") && !choice.equals("5") && !choice.equals("6"));
        return choice;
    }
    public static String skillMenu() {
        System.out.println("Money : " + player1.getMoney());
        System.out.println(" | Skill | ");
        System.out.print("1. Jetpack");

        if (player1.getSkillPosessionCounter(1) == 0) {
            System.out.print(" (buy for free) ");
        } else {
            if (player1.getSkillEquipped1() == 1 || player1.getSkillEquipped2() == 1) {
                System.out.print(" (equipped) ");
            } else {
                System.out.print(" (unequipped) ");
            }
        }
        System.out.println("");
        System.out.println("2. Ambush");
        if (player1.getSkillPosessionCounter(2) == 0) {
            System.out.print(" (buy for $200) ");
        } else {
            if (player1.getSkillEquipped1() == 2 || player1.getSkillEquipped2() == 2) {
                System.out.print(" (equipped) ");
            } else {
                System.out.print(" (unequipped) ");
            }
        }
        System.out.println("");
        System.out.println("3. Lightning Velocity");
        if (player1.getSkillPosessionCounter(3) == 0) {
            System.out.print(" (buy for $350) ");
        } else {
            if (player1.getSkillEquipped1() == 3 || player1.getSkillEquipped2() == 3) {
                System.out.print(" (equipped) ");
            } else {
                System.out.print(" (unequipped) ");
            }
        }
        System.out.println("");
        System.out.println("4. Smart Targetting");
        if (player1.getSkillPosessionCounter(4) == 0) {
            System.out.print(" (buy for $500) ");
        } else {
            if (player1.getSkillEquipped1() == 4 || player1.getSkillEquipped2() == 4) {
                System.out.print(" (equipped) ");
            } else {
                System.out.print(" (unequipped) ");
            }
        }
        System.out.println("");
        System.out.println("5. Near Death");
        if (player1.getSkillPosessionCounter(5) == 0) {
            System.out.print(" (buy for $600) ");
        } else {
            if (player1.getSkillEquipped1() == 5 || player1.getSkillEquipped2() == 5) {
                System.out.print(" (equipped) ");
            } else {
                System.out.print(" (unequipped) ");
            }
        }
        System.out.println("");
        System.out.println("6. Go back");
        String choice;
        do {
            choice = inputString.nextLine();
            if (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4") && !choice.equals("5") && !choice.equals("6")) {
                System.out.println("Input 1-6!!!");
            }
        } while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4") && !choice.equals("5") && !choice.equals("6"));
        return choice;
    }

    public static String supplyMenu() {
        System.out.println("Money :" + player1.getMoney());
        System.out.println(" | ARMORY |");
        System.out.println("1. MediKit(+20HP) ($35) - you have " + player1.getItemPosessionCounter(0));
        System.out.println("2. NanoKit(Full HP) ($100) - you have " + player1.getItemPosessionCounter(1));
        System.out.println("3. EnhancedSteroids(Strength*2 for 2 turns) ($150) - you have " + player1.getItemPosessionCounter(2));
        System.out.println("4. SkinShield(Defence*2 for 2 turns) ($150) - you have " + player1.getItemPosessionCounter(3));
        System.out.println("5. Go back");
        String choice;
        do {
            choice = inputString.nextLine();
            if (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4") && !choice.equals("5")) {
                System.out.println("Input 1-4!!!");
            }
        } while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4") && !choice.equals("5"));
        return choice;
    }

    public static void weaponBuyOrEquip(int index, int price) {
        if (player1.getWeaponPosessionCounter(index) == 0) {
            if (player1.getMoney() - price >= 0) {
                player1.setWeaponPosessionCounter(index, 1);
                player1.setMoney(player1.getMoney() - price);
            } else {
                System.out.println("Not enough money to buy");
            }
        } else {
            player1.setWeaponEquipped(index);
        }
    }
    
    public static void skillBuyOrEquip(int index, int price) {
        if (player1.getSkillPosessionCounter(index) == 0) {
            if (player1.getMoney() - price >= 0) {
                player1.setSkillPosessionCounter(index, 1);
                player1.setMoney(player1.getMoney() - price);
            } else {
                System.out.println("Not enough money to buy");
            }
        } else {
            if(player1.getSkillLoopCounter()){
            player1.setSkillEquipped1(index);
            player1.setSkillLoopCounter(false);
            }else {
            player1.setSkillEquipped2(index);
            player1.setSkillLoopCounter(true);
            }
        }
    }

    public static void itemBuy(int index, int price) {

        if (player1.getMoney() - price >= 0) {
            player1.setItemPosessionCounter(index, player1.getItemPosessionCounter(index) + 1);
            player1.setMoney(player1.getMoney() - price);
        } else {
            System.out.println("Not enough money to buy");
        }

    }

    public static void armorBuyOrEquip(int index, int price) {
        if (player1.getArmorPosessionCounter(index) == 0) {
            if (player1.getMoney() - price >= 0) {
                player1.setArmorPosessionCounter(index, 1);
                player1.setMoney(player1.getMoney() - price);
            } else {
                System.out.println("Not enough money to buy");
            }
        } else {
            player1.setArmorEquipped(index);
        }

    }

    /*
    Training
    When training, trainpoints will be deducted.
    Training depends on player level
     */
    public static String trainingMenu() {
        System.out.println("-----Stats-----");
        showStats();
        System.out.println("TrainPoints : " + player1.getTrainpoints());
        System.out.println(" | TRAINING MENU |");
        System.out.println("1. Intensive Training (increase Health by 10) - Level " + player1.getTrainLevel(0));
        System.out.println("2. Run at the treadmill (increase Stamina by 10)- Level " + player1.getTrainLevel(1));
        System.out.println("3. Lift some weights (increase Strength by 1)- Level " + player1.getTrainLevel(2));
        System.out.println("4. Learn defensive measures (increase Defense by 1)- Level " + player1.getTrainLevel(3));
        System.out.println("5. Shoot at the range (increases Accuracy by 10)- Level " + player1.getTrainLevel(4));
        System.out.println("6. Learn to dodge (increases Evasion by 10)- Level " + player1.getTrainLevel(5));
        System.out.println("7. Go back");
        String choice;
        do {
            choice = inputString.nextLine();
            if (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4") && !choice.equals("5") && !choice.equals("6") && !choice.equals("7")) {
                System.out.println("Input 1-7!!!");
            }
        } while (!choice.equals("1") && !choice.equals("2") && !choice.equals("3") && !choice.equals("4") && !choice.equals("4") && !choice.equals("5") && !choice.equals("6") && !choice.equals("7"));
        return choice;
    }

    public static void trainDetermine(int index) {
        System.out.print("Training");
        RpgUtil.delay(200);
        System.out.print(".");
        RpgUtil.delay(200);
        System.out.print(".");
        RpgUtil.delay(200);
        System.out.print(".");
        RpgUtil.delay(200);
        System.out.println(".");

        if (RpgUtil.chanceOver100((int) ((double) (player1.getLevel() / player1.getTrainLevel(index)) * 100))) {
            System.out.println("You have sucessfully trained.");
            System.out.print("Your ");
            if (index == 0) {
                System.out.println("health has increased by 10.");
                player1.setTrainpoints(player1.getTrainpoints() - player1.getTrainLevel(0));
            } else if (index == 1) {
                System.out.println("stamina has increased by 10.");
                player1.setTrainpoints(player1.getTrainpoints() - player1.getTrainLevel(1));
            } else if (index == 2) {
                System.out.println("strength has increased by 1.");
                player1.setTrainpoints(player1.getTrainpoints() - player1.getTrainLevel(2));
            } else if (index == 3) {
                System.out.println("defence has increased by 1.");
                player1.setTrainpoints(player1.getTrainpoints() - player1.getTrainLevel(3));
            } else if (index == 4) {
                System.out.println("accuracy has increased by 10.");
                player1.setTrainpoints(player1.getTrainpoints() - player1.getTrainLevel(4));
            } else if (index == 5) {
                System.out.println("evasion has increased by 10.");
                player1.setTrainpoints(player1.getTrainpoints() - player1.getTrainLevel(5));
            }
            player1.setTrainLevel(index, player1.getTrainLevel(index) + 1);
        } else {
            System.out.println("Unfortunately, you have failed training.");
            System.out.println("Hence, your stamina is depleted to zero. :p");
            player1.setStamina(0);
        }
    }

    public static void LvlUpAndTrainResult() {
        player1.setHealthCap(100 + ((player1.getLevel() - 1) * 10) + ((player1.getTrainLevel(0) - 1) * 10));
        player1.setStaminaCap(100 + ((player1.getLevel() - 1) * 10) + ((player1.getTrainLevel(1) - 1) * 10));
        player1.setDefaultStrength(2 + ((player1.getLevel() - 1) * 1) + ((player1.getTrainLevel(2) - 1) * 1));
        player1.setDefaultDefence(2 + ((player1.getLevel() - 1) * 1) + ((player1.getTrainLevel(3) - 1) * 1));
    }

    public static void rest() {
        player1.setHealth(player1.getHealthCap());
        player1.setStamina(player1.getStaminaCap());
        player1.setPeace(player1.getPeace() - 10);
        System.out.println("While resting, your peace points have decreased by 10 points.");
    }

    public static void storyContinue() {
        try {
//            String continuenumber;
//        do {
//            System.out.println(" | Press 1 to continue. |");
//            continuenumber = inputString.nextLine();
//            if (!continuenumber.equals("1")) {
//                System.out.println(" | Press 1 to continue!!! |");
//            }
//        } while (!continuenumber.equals("1"));
            System.out.print("press enter... \n");
            System.in.read();

        } catch (Exception ex) {

        }
    }

    public static void showStats() {

        //Checkers
        relationshipCheck();
        peacecheck();
        staminaCheck();
        LvlUpAndTrainResult();

        System.out.println("Level      :" + player1.getLevel());
        System.out.println("HP         :" + player1.getHealth());
        System.out.println("Strength   :" + player1.getStrength());
        System.out.println("Defense     :" + player1.getDefence());
        System.out.println("Stamina : " + player1.getStamina());
        System.out.println("Money : " + player1.getMoney());
    }

    public static String startMenu() {
        // Replace Introduction.startGame() with this.
        String startChoice;
        System.out.println("       || Version 0.1.1 ||");
        System.out.println(" | Welcome to SpaceFighterStories |");
        System.out.println("1. New Game");
        System.out.println("2. Continue Game");
        System.out.println("3. ChangeLog");
        System.out.println("4. Exit");
        do {
            startChoice = inputChoice.nextLine();
            if (!startChoice.equals("1") && !startChoice.equals("2") && !startChoice.equals("3") && !startChoice.equals("4")) {
                System.out.println("Please choose 1 - 4!!!");
            }
        } while (!startChoice.equals("1") && !startChoice.equals("2") && !startChoice.equals("3") && !startChoice.equals("4"));
        return startChoice;

    }

    //Saving
    static final String fileName = "Savedata.sav";

    public static void save(Serializable objectToSerialize) throws InterruptedException {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(fileName);// can be anything

            //Byte Stream creation
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(objectToSerialize);

            //flush (write) the stream
            oos.flush();
            //close the stream
            oos.close();
            System.out.print("Saving");
            Thread.sleep(300);
            System.out.print(".");
            Thread.sleep(300);
            System.out.print(".");
            Thread.sleep(300);
            System.out.print(".");
            Thread.sleep(300);
            System.out.print(".");
            System.out.println(" Save Success");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Loading
    public static Player load() throws InterruptedException {
        // check if file exist or not
        if (checkFileExist()) {
            // if exist create a new Stream
            FileInputStream fis = null;
            try {// initialize fis
                fis = new FileInputStream(fileName);
                //create ois from fis
                ObjectInputStream ois = new ObjectInputStream(fis);
                //create object from the stream
                //Cast it to the type of object that we need
                Player player1 = (Player) ois.readObject();
                ois.close();
                System.out.print("Loading");
                Thread.sleep(300);
                System.out.print(".");
                Thread.sleep(300);
                System.out.print(".");
                Thread.sleep(300);
                System.out.print(".");
                Thread.sleep(300);
                System.out.print(".");
                System.out.println("Load Success");
                return player1;
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
            }
            return null;
        } else {
            System.out.print("Loading");
            Thread.sleep(300);
            System.out.print(".");
            Thread.sleep(300);
            System.out.print(".");
            Thread.sleep(300);
            System.out.print(".");
            Thread.sleep(300);
            System.out.print(".");
            System.out.println("Save File Not Found");
            Thread.sleep(1000);
            return null;
        }

    }

    public static boolean checkFileExist() {
        // check if the file exist with the name of "filename" in given directory
        return new File(fileName).isFile();
    }
}
