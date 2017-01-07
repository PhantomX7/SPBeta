package entities;

import maincommand.RpgUtil;

public class Enemy {

    //Enemy Attributes
    private String name;
    private int health;
    private int level;
    private int strength;
    private int defence;
    private int xpGain;
    private int peaceGain;
    private int staminaLost;
    private int peaceLost;
    private static int enemyType1;
    private boolean alive = true;
    private int moneyDropped;
    private int accuracy;
    private int evasion;

    //Enemy Setters
    //Enemy must be OP
    public static Enemy EncounterEnemy(int enemyType) {
        enemyType1 = enemyType;
        if (enemyType == 1) {
            return new Enemy("Dummy", 20, 1, 0, 0, 10, 0, 0, 0, 0, 0, 0);
        } else if (enemyType == 2) {
            return new Enemy("Unarmed Alien", 100, 2, 3, 3, 25, 10, 10, 10, 25, 100, 10);
        } else if (enemyType == 3) {
            return new Enemy("Armed Alien", 175, RpgUtil.randInt(5, 10), 9, 9, 50, 15, 15, 15, 35, 120, 20);
        } else if (enemyType == 4) {
            return new Enemy("Buff-ien", 250, RpgUtil.randInt(10, 20), 17, 17, 75, 20, 20, 20, 40, 140, 40);
        } else if (enemyType == 5) {
            return new Enemy("Behemoth", 375, RpgUtil.randInt(20, 30), 28, 28, 100, 25, 25, 25, 45, 160, 60);
        } else if (enemyType == 6) {
            return new Enemy("Flyer Venomer", 500, RpgUtil.randInt(30, 45), 35, 35, 150, 30, 30, 30, 50, 200, 100);
        } else if (enemyType == 7) {
            return new Enemy("Rektersaur", 700, RpgUtil.randInt(45, 65), 48, 48, 200, 35, 35, 35, 55, 240, 140);
        } else if (enemyType == 8) {
            //For Scenario Special
            return new Enemy("Unknown Wanna-Be Rapist", 300, 3, 3, 3, 80, 0, 30, 0, 70, 0, 0);
        } else {
            return null;
        }
    }

    //Constructor
    public Enemy(String name, int health, int level, int strength, int defence, int xpGain, int peaceGain, int staminaLost, int peaceLost, int moneyDropped, int accuracy, int evasion) {
        this.name = name;
        this.health = health + (level * 2);
        this.level = level;
        this.strength = strength + (level * 2);
        this.defence = defence + (level * 2);
        this.xpGain = xpGain + level;
        this.peaceGain = peaceGain;
        this.staminaLost = staminaLost;
        this.peaceLost = peaceLost;
        this.moneyDropped = moneyDropped + level;
        this.accuracy = accuracy;
        this.evasion = evasion;
    }
    //setters

    public void setHealth(int health) {
        this.health = health;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    //Getters
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getLevel() {
        return level;
    }

    public int getStrength() {
        return strength;
    }

    public int getDefence() {
        return defence;
    }

    public int getXpGain() {
        return xpGain;
    }

    public int getPeaceGain() {
        return peaceGain;
    }

    public int getStaminaLost() {
        return staminaLost;
    }

    public int getPeaceLost() {
        return peaceLost;
    }

    public boolean isAlive() {
        return alive;
    }

    public static int getEnemyType1() {
        return enemyType1;
    }

    public int getMoneyDropped() {
        return moneyDropped;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public int getEvasion() {
        return evasion;
    }
    
    public void skill(int skillNum){
        
    }
    
}
