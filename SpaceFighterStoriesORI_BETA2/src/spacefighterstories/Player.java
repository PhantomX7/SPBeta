package spacefighterstories;

public class Player {

    //Basic
    private String name;
    //Determinant
    private int Stamina = 100;
    private boolean alive = true;
    //Battle
    private int health = 100;
    private int strength = 2, defaultStrength = 2;
    private int defence = 2, defaultDefence = 2;
    private int experience = 0;
    private int expCap = 50;
    private int healthCap = 100;
    private int staminaCap = 100;
    private int level = 1;
    //Stories
    private int relationship = 60;
    private int peace = 60;
    //Economy
    private int money = 99999;
    //Training
    private int trainpoints = 100;
    private int[] trainLevel = {1, 1, 1, 1};

    //Weapon Variables
    private int[] weaponPosessionCounter = {0, 0, 0, 0, 0, 0, 0, 0};
    /*
    index 0 = Handgun
    index 1 = SMG
    index 2 = Assault rifle
    index 3 = RPG
    index 4 = Minigun
     */
    private int weaponEquipped = 0;
    private int[] weaponDamageDone = {10, 15, 20, 25, 30, 0, 0, 0};
    /*
    index 0 = Handgun = 1
    index 1 = SMG = 2
    index 2 = Assualt rifle = 3
    index 3 = RPG = 4
    index 4 = Minigun = 5
     */

    //Armor Variables
    private int[] armorPosessionCounter = {0, 0, 0, 0, 0, 0, 0, 0};
    /*
    index 0 = No armor
    index 1 = Basic Space Combat Suit (SCS)
    index 2 = Fortified SCS
    index 3 = SCS with Force Field
    index 4 = Enhanced SCS
    index 5 = Enhanced NanoSCS
     */
    private int armorEquipped = 0;
    private int[] armorDefenceDone = {0, 2, 4, 6, 8, 10, 0, 0, 0};
    /*
    index 0 = No armor
    index 1 = Basic SCS
    index 2 = Fortified SCS
    index 3 = SCS with Force Field
    index 4 = Enhanced SCS
    index 5 = Enhanced NanoSCS
     */

    //Item Variables
    private int[] itemPosessionCounter = {2, 1, 1, 1, 0, 0, 0, 0};

    /*
    index 0 = MediKit
    index 1 = NanoKit
    index 2 = EnhancedSteroids
    index 3 = SkinShield
     */

    //Player Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setPeace(int peace) {
        this.peace = peace;
    }

    public void setStamina(int Stamina) {
        this.Stamina = Stamina;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public void setExpCap(int expCap) {
        this.expCap = expCap;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setRelationship(int relationship) {
        this.relationship = relationship;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setStaminaCap(int staminaCap) {
        this.staminaCap = staminaCap;
    }

    public void setTrainpoints(int trainpoints) {
        this.trainpoints = trainpoints;
    }

    public void setHealthCap(int healthCap) {
        this.healthCap = healthCap;
    }
    
    //Weapons Setters
    public void setWeaponPosessionCounter(int index, int number) {
        this.weaponPosessionCounter[index] = number;
    }

    public void setWeaponEquipped(int weaponEquipped) {
        this.weaponEquipped = weaponEquipped;
    }

    //Armor Setters
    public void setArmorPosessionCounter(int index, int number) {
        this.armorPosessionCounter[index] = number;
    }

    public void setArmorEquipped(int armorEquipped) {
        this.armorEquipped = armorEquipped;
    }

    //Item Setters
    public void setItemPosessionCounter(int index, int number) {
        this.itemPosessionCounter[index] = number;
    }

    public void setDefaultStrength(int defaultStrength) {
        this.defaultStrength = defaultStrength;
    }

    public void setDefaultDefence(int defaultDefence) {
        this.defaultDefence = defaultDefence;
    }

    //Training Setter

    public void setTrainLevel(int index, int number) {
        this.trainLevel[index] = number;
    }
    
    //Getters
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public int getDefence() {
        return defence;
    }

    public int getExperience() {
        return experience;
    }

    public int getExpCap() {
        return expCap;
    }

    public int getLevel() {
        return level;
    }

    public int getRelationship() {
        return relationship;
    }

    public int getPeace() {
        return peace;
    }

    public int getStamina() {
        return Stamina;
    }

    public boolean isAlive() {
        return alive;
    }

    public int getHealthCap() {
        return healthCap;
    }

    public int getWeaponPosessionCounter(int index) {
        return weaponPosessionCounter[index];
    }

    public int getWeaponEquipped() {
        return weaponEquipped;
    }

    public int getWeaponDamageDone(int index) {
        return weaponDamageDone[index];
    }

    public int getItemPosessionCounter(int index) {
        return itemPosessionCounter[index];
    }

    public int getDefaultStrength() {
        return defaultStrength;
    }

    public int getDefaultDefence() {
        return defaultDefence;
    }

    public int getMoney() {
        return money;
    }

    public int getArmorPosessionCounter(int index) {
        return armorPosessionCounter[index];
    }

    public int getArmorDefenceDone(int index) {
        return armorDefenceDone[index];
    }

    public int getArmorEquipped() {
        return armorEquipped;
    }

    public int getStaminaCap() {
        return staminaCap;
    }

    public int getTrainpoints() {
        return trainpoints;
    }

    public int getTrainLevel(int index) {
        return trainLevel[index];
    }
    
    

}
