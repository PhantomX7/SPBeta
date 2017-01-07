package storyline;

import entities.Enemy;
import entities.Player;
import java.awt.AWTException;
import java.awt.Robot;
import java.security.SecureRandom;
import java.util.Scanner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import maincommand.SysBackbone;

public class NicoleStories {

    private static SecureRandom random = new SecureRandom();
    private static Count cnt;
    private static Scanner inputChoice = new Scanner(System.in);
    private static int timeLimit = 18;
    Player player1 = new Player();
    static Enemy enemy1 = null;


    /*
    Scenarios - Goes like 1 - 2 - 3 - 4 - 5 - (Special) ... - 1 ...
    Special - unlockable only when RP > 90
    Default RP given - 20
    With each choice, the RP rises and drops (even to negative), and the total RP is awarded
    at the end of each scenario.
     */
 /*
    Template for choice reactions:
            do {
                storyChoice = inputChoice.nextLine();
                if (!storyChoice.equals("1") && !storyChoice.equals("2") && !storyChoice.equals("3")) {
                    System.out.println("invalid choice!!!");
                }
            } while (!storyChoice.equals("1") && !storyChoice.equals("2") && !storyChoice.equals("3"));
            if (storyChoice.equals("1")) {
                System.out.println("Nicole :");
                relationPoints += ;
                //storyCheckpoint = ;
            } else if (storyChoice.equals("2")) {
                System.out.println("Nicole :");
                relationPoints += ;
                //storyCheckpoint = ;
            } else {
                System.out.println("Nicole :");
                relationPoints -= ;
                //storyCheckpoint = ;
            }
     */
    public static void scenario(Player player1) throws InterruptedException {
        int x = random.nextInt(4);
        //Enable minigame  when able to do so.
        //int x = 0;
        // Change (3) to (5) when scenarios are done!
        int storyCheckpoint;
        int relationPoints = 0;
        String storyChoice;
        //Disarm when in scenario
        int tempWeaponEq, tempArmorEq, tempItemOwned1, tempItemOwned2, tempItemOwned3, tempItemOwned4;
        tempWeaponEq = player1.getWeaponEquipped();
        tempArmorEq = player1.getArmorEquipped();
        tempItemOwned1 = player1.getItemPosessionCounter(0);
        tempItemOwned2 = player1.getItemPosessionCounter(1);
        tempItemOwned3 = player1.getItemPosessionCounter(2);
        tempItemOwned4 = player1.getItemPosessionCounter(3);

        player1.setWeaponEquipped(0);
        player1.setArmorEquipped(0);
        player1.setItemPosessionCounter(0, 0);
        player1.setItemPosessionCounter(1, 0);
        player1.setItemPosessionCounter(2, 0);
        player1.setItemPosessionCounter(3, 0);
        if (x == 3) {
            if (player1.getRelationship() >= 90) {
                //This only plays if RP >= 90
                //This scenario will include a normal battle
                //Scenario Special - Near Nicole's room
                System.out.println("You are walking to Nicole's room to visit her.");
                SysBackbone.storyContinue();
                System.out.println("When near, you witness a man near Nicole.");
                SysBackbone.storyContinue();
                System.out.println("He was placing his hand on the wall, and he's almost leaning towards her.");
                SysBackbone.storyContinue();
                System.out.println("Man : So... Wanna go inside your room?");
                SysBackbone.storyContinue();
                System.out.println("Nicole : No! Now let me go!");
                SysBackbone.storyContinue();
                System.out.println("Man : I won't, unless you say yes.");
                SysBackbone.storyContinue();
                System.out.println("Nicole : I won't be part of your fantasy!");
                SysBackbone.storyContinue();
                System.out.println("Man : Yes you will...");
                SysBackbone.storyContinue();
                System.out.println("The man is now holding her arm.");
                SysBackbone.storyContinue();
                System.out.println("He opens the door, and tries to get her inside it.");
                SysBackbone.storyContinue();
                System.out.println(player1.getName() + " : Choose an action... \n"
                        + "   (1. Charge to the man.) \n"
                        + "   (2. Sneak to the man.) \n"
                        + "   (3. Approach the man without violence)");
                do {
                    storyChoice = inputChoice.nextLine();
                    if (!storyChoice.equals("1") && !storyChoice.equals("2") && !storyChoice.equals("3")) {
                        System.out.println("invalid choice!!!");
                    }
                } while (!storyChoice.equals("1") && !storyChoice.equals("2") && !storyChoice.equals("3"));
                if (storyChoice.equals("1")) {
                    System.out.println("You charge to the man, and he holds your collar, and pushes you back.");
                    SysBackbone.storyContinue();
                    System.out.println(player1.getName() + " : Oh, you wanna do that? Let's get ready to rumble!");
                    int battleHealth = 90;
                    player1.setHealth(battleHealth);
                } else if (storyChoice.equals("2")) {
                    System.out.println("You sneak to the man, and successfully dropped him on the ground..");
                    SysBackbone.storyContinue();
                    System.out.println("The man rises up and steps away from you.");
                    SysBackbone.storyContinue();
                    System.out.println("Man : You wanna go?! Let's do this!");
                    int battleHealth = 100;
                    player1.setHealth(battleHealth);
                } else {
                    System.out.println(player1.getName() + " : Yo, dude, don't do that.");
                    SysBackbone.storyContinue();
                    System.out.println("Man : I don't care.");
                    SysBackbone.storyContinue();
                    System.out.println("He pushes you back, causing you to slam on a metal wall.");
                    SysBackbone.storyContinue();
                    System.out.println(player1.getName() + " : You want the hard way? Well, I'll give you the hard way!");
                    int battleHealth = 90;
                    player1.setHealth(battleHealth);
                }

                enemy1 = Enemy.EncounterEnemy(8);
                while (player1.isAlive() && enemy1.isAlive()) {
                    SysBackbone.battle(player1, enemy1);
                }
                if (player1.isAlive() == true) {
                    System.out.println("The man drops to the floor.");
                    SysBackbone.storyContinue();
                    System.out.println(player1.getName() + " : Nicole! Are you okay?");
                    SysBackbone.storyContinue();
                    System.out.println("Nicole, still shaken, attempts to calm down.");
                    SysBackbone.storyContinue();
                    System.out.println("Eventually, she calms down.");
                    SysBackbone.storyContinue();
                    System.out.println("Nicole : Yeah, I'm okay now. Thanks.");
                    SysBackbone.storyContinue();
                    System.out.println(player1.getName() + " : No problem.");
                    player1.setRelationship(player1.getRelationship() + 10);
                    player1.setStamina(player1.getStamina());

                    //End of Scenario
                } else if (player1.isAlive() == false) {
                    System.out.println("You drop on the floor.");
                    SysBackbone.storyContinue();
                    System.out.println("The man brings Nicole to her room.");
                    SysBackbone.storyContinue();
                    System.out.println("Long story short, she didn't have a good time.");
                    SysBackbone.storyContinue();
                    System.out.println("Disappointed with yourself, you stay away from her for a couple weeks.");
                    player1.setRelationship(player1.getRelationship() - 40);
                    player1.setStamina(player1.getStamina() - 20);
                    player1.setPeace(player1.getPeace() - 15);
                    //End of Scenario
                }
            } else {
                x = random.nextInt(3);
            }
        }

        //Scenario 1 - At the space cruiser
        if (x == 0) {
            storyCheckpoint = 1;
            relationPoints = 20;
            System.out.println("You and Nicole roam around the cruiser, which is still in space.");
            SysBackbone.storyContinue();
            System.out.println("Nicole : It's a nice day, isn't it?");
            System.out.println(player1.getName() + " : (1. Yeah, it is.) \n"
                    + "   (2. Not with aliens all around us.)");
            do {
                storyChoice = inputChoice.nextLine();
                if (!storyChoice.equals("1") && !storyChoice.equals("2")) {
                    System.out.println("invalid choice!!!");
                }
            } while (!storyChoice.equals("1") && !storyChoice.equals("2"));
            if (storyChoice.equals("1")) {
                System.out.println("Nicole : Glad that you agree, " + player1.getName() + "!");
                relationPoints += 5;
            } else {
                System.out.println("Nicole : Come on, cheer up!");
                relationPoints -= 5;
            }
            SysBackbone.storyContinue();
            System.out.println(player1.getName() + " : Now what?");
            SysBackbone.storyContinue();
            System.out.println("Nicole : Admire at the stars.");
            SysBackbone.storyContinue();
            System.out.println("Nicole holds your left wrist, and brings you to a panoramic view of the stars.");
            SysBackbone.storyContinue();
            System.out.println("Nicole : It's beautiful, isn't it?");
            SysBackbone.storyContinue();
            System.out.println(player1.getName() + " : Yeah.");
            SysBackbone.storyContinue();
            System.out.println("Nicole : But someday it would be boring.");
            SysBackbone.storyContinue();
            System.out.println("She seems down now.");
            SysBackbone.storyContinue();
            System.out.println("Tip : She is very eager to hold a printed object.");
            System.out.println(player1.getName() + " : Hey, let's go to the ... ");
            System.out.println("        (1. The library)\n"
                    + "        (2. The mini-garden)\n"
                    + "        (3. The Skydome)");

            do {
                storyChoice = inputChoice.nextLine();
                if (!storyChoice.equals("1") && !storyChoice.equals("2") && !storyChoice.equals("3")) {
                    System.out.println("invalid choice!!!");
                }
            } while (!storyChoice.equals("1") && !storyChoice.equals("2") && !storyChoice.equals("3"));
            if (storyChoice.equals("1")) {
                System.out.println("Nicole : They have a library? Great!");
                relationPoints += 7;
                storyCheckpoint = 11;
            } else if (storyChoice.equals("2")) {
                System.out.println("Nicole : That would be nice.");
                relationPoints += 5;
                storyCheckpoint = 11;
            } else {
                System.out.println("Nicole : It's almost the same thing as this. Let's ask people instead.");
                relationPoints -= 5;
                storyCheckpoint = 12;
            }
            SysBackbone.storyContinue();

            //-Scenario 1a(Library or Skydome)
            if (storyCheckpoint == 11) {
                System.out.println("You and Nicole go to the library. It's fairly big, considering that this is inside a cruiser.");
                SysBackbone.storyContinue();
                System.out.println("Nicole : I wonder what's in store.");
                SysBackbone.storyContinue();
                System.out.println("You and Nicole walk around to find a book.");
                SysBackbone.storyContinue();
                System.out.println("After a few minutes, she stops, and looks at a book.");
                SysBackbone.storyContinue();
                System.out.println("Her eyes sparkle. She grabs a book named 1984 and shows it to you.");
                SysBackbone.storyContinue();
                System.out.println("Nicole : This was our favorite book during 9th grade!");
                SysBackbone.storyContinue();
                System.out.println(player1.getName() + " : Yes, it was.");
                SysBackbone.storyContinue();
                System.out.println("Nicole : Do you still remember the first sentence?");
                System.out.println(player1.getName() + "it is : \n"
                        + "   (1. A squat grey building of only 34 stories...) \n"
                        + "   (2. It was a bright cold day in April...)\n"
                        + "   (3. The books were burnt, so did the house...)");
                do {
                    storyChoice = inputChoice.nextLine();
                    if (!storyChoice.equals("1") && !storyChoice.equals("2") && !storyChoice.equals("3")) {
                        System.out.println("invalid choice!!!");
                    }
                } while (!storyChoice.equals("1") && !storyChoice.equals("2") && !storyChoice.equals("3"));
                if (storyChoice.equals("1")) {
                    System.out.println("Nicole : That was Brave New World.");
                    relationPoints -= 3;
                    //storyCheckpoint = ;
                } else if (storyChoice.equals("2")) {
                    System.out.println("Nicole : Yeah, that's it. Surprised that you remembered!");
                    relationPoints += 5;
                    //storyCheckpoint = ;
                } else {
                    System.out.println("Nicole : What's that? -5");
                    relationPoints -= 5;
                    //storyCheckpoint = ;
                }
                SysBackbone.storyContinue();
                System.out.println("Nicole : So what will you read?");
                SysBackbone.storyContinue();
                System.out.println(player1.getName() + " : I'll just read beside you.");
                SysBackbone.storyContinue();
                System.out.println("You sit right beside her, and read the book.");
            }
            //--End of scenario--

            //- Scenario 1b(Mini - garden)
            if (storyCheckpoint == 12) {
                System.out.println("Nicole : Look at those roses!");
                SysBackbone.storyContinue();
                System.out.println(player1.getName() + " : They're beautiful.");
                SysBackbone.storyContinue();
                System.out.println("Nicole : Yeah.");
                SysBackbone.storyContinue();
                System.out.println("Tip : She exclaims when she sees her favorite or somethring relevant to someone near her.");
                System.out.println(player1.getName() + " : (1. Hey, your favorite flower is a sunflower, right?) \n +"
                        + "   (2. Did we do something with those?) \n +"
                        + "   (3.Those are your favorite, right?)");
                do {
                    storyChoice = inputChoice.nextLine();
                    if (!storyChoice.equals("1") && !storyChoice.equals("2") && !storyChoice.equals("3")) {
                        System.out.println("invalid choice!!!");
                    }
                } while (!storyChoice.equals("1") && !storyChoice.equals("2") && !storyChoice.equals("3"));
                if (storyChoice.equals("1")) {
                    System.out.println("Nicole : No, roses are. Did you forget already?");
                    relationPoints -= 5;
                    //storyCheckpoint = ;
                } else if (storyChoice.equals("2")) {
                    System.out.println("Nicole : These are my favorite type of flowers");
                    //storyCheckpoint = ;
                } else {
                    System.out.println("Nicole : Yeah! Glad you remember!");
                    relationPoints += 5;
                    //storyCheckpoint = ;
                }
                SysBackbone.storyContinue();
                System.out.println("Hey, let's sit here");
                SysBackbone.storyContinue();
                System.out.println(player1.getName() + " : Sure, why not?");
                SysBackbone.storyContinue();
                System.out.println("You and her sit down on a bench, and sit there until dinner time.");
            }
            //--End of Scenario
            player1.setRelationship(player1.getRelationship() + (20 + relationPoints));
            player1.setStamina(player1.getStamina() - 10);
            player1.setPeace(player1.getPeace() - 10);
        } else if (x == 1) {
            relationPoints = 20;
            System.out.println("You and Nicole go to the gym in preperation for a intensive drill.");
            SysBackbone.storyContinue();
            System.out.println("Nicole : Just why do we have to do a test? We're out from the Academy.");
            System.out.println(player1.getName() + " : Aliens, ... \n"
                    + "   (1. obviously) \n"
                    + "   (2. the military has to prepare us for another attack) \n"
                    + "   (3. Look at the bright side, at least we can game some muscles.)");
            do {
                storyChoice = inputChoice.nextLine();
                if (!storyChoice.equals("1") && !storyChoice.equals("2") && !storyChoice.equals("3")) {
                    System.out.println("invalid choice!!!");
                }
            } while (!storyChoice.equals("1") && !storyChoice.equals("2") && !storyChoice.equals("3"));
            if (storyChoice.equals("1")) {
                System.out.println("Nicole : Hey, don't be cocky!");
                relationPoints -= 5;
                //storyCheckpoint = ;
            } else if (storyChoice.equals("2")) {
                System.out.println("Nicole : You do have a point, but come on.");
                relationPoints += 3;
                //storyCheckpoint = ;
            } else {
                System.out.println("Nicole : Yeah, at least there are advantages. Thanks!");
                relationPoints += 5;
                //storyCheckpoint = ;
            }
            SysBackbone.storyContinue();
            System.out.println("You and her enter the gym.");
            SysBackbone.storyContinue();
            System.out.println("Nicole : Which one do we want to exercise on?");
            SysBackbone.storyContinue();
            System.out.println("Tip : She is Sonic the Hedgehog.");
            System.out.println("Player : (1. The treadmill.) \n"
                    + "         (2. The weight machine.) \n"
                    + "         (3. The pull up bars.)");
            do {
                storyChoice = inputChoice.nextLine();
                if (!storyChoice.equals("1") && !storyChoice.equals("2") && !storyChoice.equals("3")) {
                    System.out.println("invalid choice!!!");
                }
            } while (!storyChoice.equals("1") && !storyChoice.equals("2") && !storyChoice.equals("3"));
            if (storyChoice.equals("1")) {
                System.out.println("Nicole : Yeah! You know me so well! +4");
                relationPoints += 4;
                //storyCheckpoint = ;
            } else if (storyChoice.equals("2")) {
                System.out.println("Nicole : No! They're tiring.");
                relationPoints -= 5;
                //storyCheckpoint = ;
            } else {
                System.out.println("Nicole : Okay. But, I wanna go on the treadmill.");
                relationPoints -= 3;
                //storyCheckpoint = ;
            }
            SysBackbone.storyContinue();
            System.out.println("You and her go on the treadmill.");
            SysBackbone.storyContinue();
            System.out.println("At last, you and Nicole enjoy being together at the gym.");
            //--End of scenario--
            player1.setRelationship(player1.getRelationship() + (20 + relationPoints));
            player1.setStamina(player1.getStamina() - 10);
            player1.setPeace(player1.getPeace() - 10);
        } else if (x == 2) {
            //Scenario 3 - At one of Britain's resaturants

            System.out.println("Your squad got a day free, and what's great is that you and Nicole can go down to Earth.");
            SysBackbone.storyContinue();
            System.out.println("After an hour of Earth conditioning, you and Nicole go to a steakhouse.");
            SysBackbone.storyContinue();
            System.out.println("Nicole : This is great! Finally, we can eat real food.");
            System.out.println(player1.getName() + " : (1. I think both are the same.) \n"
                    + "   (2. What's wrong with space food?) \n"
                    + "   (3. Yeah, I see what you mean.) \n");
            do {
                storyChoice = inputChoice.nextLine();
                if (!storyChoice.equals("1") && !storyChoice.equals("2") && !storyChoice.equals("3")) {
                    System.out.println("invalid choice!!!");
                }
            } while (!storyChoice.equals("1") && !storyChoice.equals("2") && !storyChoice.equals("3"));
            if (storyChoice.equals("1")) {
                System.out.println("Nicole : Your preferences and mine are different.");
                //storyCheckpoint = ;
            } else if (storyChoice.equals("2")) {
                System.out.println("Nicole : You know what's wrong!");
                relationPoints -= 3;
                //storyCheckpoint = ;
            } else {
                System.out.println("Nicole : Yeah you do!");
                relationPoints += 4;
                //storyCheckpoint = ;
            }
            SysBackbone.storyContinue();
            System.out.println("The waiter approaches your table.");
            SysBackbone.storyContinue();
            System.out.println("Nicole : I have to go to the restroom. You know what I like best!");
            SysBackbone.storyContinue();
            System.out.println("Tip : She likes a red centered steak, which name has a name similar with T-shirt.");
            System.out.println(player1.getName() + " : One medium rare Ribeye and one ... \n"
                    + "  (1. medium rare Tenderloin) \n"
                    + "  (2. well done Tenderloin) \n"
                    + "  (3. medium rare T-Bone)");
            do {
                storyChoice = inputChoice.nextLine();
                if (!storyChoice.equals("1") && !storyChoice.equals("2") && !storyChoice.equals("3")) {
                    System.out.println("invalid choice!!!");
                }
            } while (!storyChoice.equals("1") && !storyChoice.equals("2") && !storyChoice.equals("3"));
            if (storyChoice.equals("1")) {
                System.out.println("The waiter leaves and Nicole comes back a minute later.");
                System.out.println("Nicole : What did you ordered for me?");
                System.out.println(player1.getName() + " : One medium rare Tenderloin.");
                System.out.println("Nicole : Okay. I'll accept it");
                relationPoints += 3;
                //storyCheckpoint = ;
            } else if (storyChoice.equals("2")) {
                System.out.println("The waiter leaves and Nicole comes back a minute later.");
                System.out.println("Nicole : What did you ordered for me?");
                System.out.println(player1.getName() + " : One well done Tenderloin.");
                System.out.println("Nicole : What!? *sighs* I though you knew.");
                relationPoints -= 3;
                //storyCheckpoint = ;
            } else {
                System.out.println("The waiter leaves and Nicole comes back a minute later.");
                System.out.println("Nicole : What did you ordered for me?");
                System.out.println(player1.getName() + " : One medium rare T-Bone");
                System.out.println("Nicole : Yeah! Thanks a lot!");
                relationPoints -= 5;
                //storyCheckpoint = ;
            }
            SysBackbone.storyContinue();
            System.out.println("You and Nicole eat steak with black pepper sauce once it arrives.");
            SysBackbone.storyContinue();
            System.out.println("Once you and her are finished eating, Nicole asks soomething.");
            SysBackbone.storyContinue();
            System.out.println("Nicole : Who will pay for this?");
            System.out.println(player1.getName() + " : (1. You. You recommended to eat here.) \n"
                    + "   (2. I'll pay it.) \n"
                    + "   (3. Did you bring your wallet?)");
            do {
                storyChoice = inputChoice.nextLine();
                if (!storyChoice.equals("1") && !storyChoice.equals("2") && !storyChoice.equals("3")) {
                    System.out.println("invalid choice!!!");
                }
            } while (!storyChoice.equals("1") && !storyChoice.equals("2") && !storyChoice.equals("3"));
            if (storyChoice.equals("1")) {
                System.out.println("Nicole : Hey! I thought you will pay! You still owe me!");
                relationPoints -= 5;
                //storyCheckpoint = ;
            } else if (storyChoice.equals("2")) {
                System.out.println("Nicole : Yay! Thanks!");
                relationPoints += 6;
                //storyCheckpoint = ;
            } else {
                System.out.println("Nicole : No. I'm sorry.");
                //storyCheckpoint = ;
            }
            SysBackbone.storyContinue();
            System.out.println("You pay the money, and leave the steakhouse.");
            //End of scenario
            player1.setRelationship(player1.getRelationship() + (20 + relationPoints));
            player1.setStamina(player1.getStamina() - 10);
            player1.setPeace(player1.getPeace() - 10);
        } else if (x == 4) {
            //Scenario 4 - At the computer simulation room
            System.out.println("You and Nicole head to the computer simulation room to do something they hadn't done after the Academy.");
            System.out.println("Nicole : Yeah! Let's do some hacking!");
            System.out.println(player1.getName() + " : (1. You sure about this?)"
                    + "   (2. Yeah!)"
                    + "   (3. I'm blaming you if we get caught messing some stuff.");
            do {
                storyChoice = inputChoice.nextLine();
                if (!storyChoice.equals("1") && !storyChoice.equals("2") && !storyChoice.equals("3")) {
                    System.out.println("invalid choice!!!");
                }
            } while (!storyChoice.equals("1") && !storyChoice.equals("2") && !storyChoice.equals("3"));
            if (storyChoice.equals("1")) {
                System.out.println("Nicole : Chill dude, it's a simulation. Are you dumb now?");
                relationPoints -= 3;
                //storyCheckpoint = ;
            } else if (storyChoice.equals("2")) {
                System.out.println("Nicole : *smiles at you*");
                relationPoints += 4;
                //storyCheckpoint = ;
            } else {
                System.out.println("Nicole : It's a simulation, and yikes, a little bit harsh right there.");
                relationPoints -= 5;
                //storyCheckpoint = ;
            }
            System.out.println("You head to one of the computers, and initialise the hacking simulation.");
            SysBackbone.storyContinue();
            System.out.println("System : You think this is all about making choices. Well think again! *evil laugh and chuckle* ");
            SysBackbone.storyContinue();
            System.out.println("System : But for real, this is done so you won't always press 1.");
            SysBackbone.storyContinue();
            System.out.println("System : This is going to be like Typer Shark.");
            SysBackbone.storyContinue();
            System.out.println("System : You are going to be given several real Java commands.");
            SysBackbone.storyContinue();
            System.out.println("System : And, you are given several seconds to type the word(s) given.");
            SysBackbone.storyContinue();
            System.out.println("System : Impress Nicole with your pro skillz, ");
            System.out.println("         or be beaten by her (done by not finishing when there's no time.)");
            SysBackbone.storyContinue();
            System.out.println("System : Good luck. By the way, Java is case-sensitive,");
            System.out.println("         which means your command must be exactly be the same (eg. capitals and lowercases, dots, etc)");
            SysBackbone.storyContinue();
            System.out.println("Prepare your eyes and fingers in 5");
            System.out.println("4");
            System.out.println("3");
            System.out.println("2");
            System.out.println("1");
            System.out.println("START!");
            System.out.println("");

            ActionListener actListner = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {

                    timeLimit--;
                    System.out.println(timeLimit);
                    if (timeLimit < 1) {
                        System.out.println("Nicole : Too slow boi!");
                    }
                }
            };

            Timer timer = new Timer(1000, actListner);
            //Competition starts
            competition();
            //Competition ends
            System.out.println("Nicole : Good game, mate. Well played.");
            player1.setRelationship(player1.getRelationship() + (20 + relationPoints));
            player1.setStamina(player1.getStamina() - 10);
            player1.setPeace(player1.getPeace() - 10);
            //End of Scenario
        } else {
            //Do int x = random.nextInt(5);
            //if x == 0 ... to if x == 4
            //NO x == 6 anymore until player presses Interaction again after scenario chosen is done
            //Program will check again
        }

        //equip back the equipment and item
        player1.setWeaponEquipped(tempWeaponEq);
        player1.setArmorEquipped(tempArmorEq);
        player1.setItemPosessionCounter(0, tempItemOwned1);
        player1.setItemPosessionCounter(1, tempItemOwned2);
        player1.setItemPosessionCounter(2, tempItemOwned3);
        player1.setItemPosessionCounter(3, tempItemOwned4);
    }

    public static void competition() throws InterruptedException {
        int done = 0;
        String answerToType = "";

        System.out.println("TYPE 'System.out.println();' IN 15 SECONDS!"); // If done, relationPoint +3
        cnt = new Count(15);
        while (cnt.isAlive() && done == 0) {
            answerToType = JOptionPane.showInputDialog(done);
            if (answerToType.equals("System.out.println();")) {
                //relationPoint += 3;
                done = 1;
                cnt.interrupt();
                System.out.println(cnt.isAlive());
            }
        }
        if (cnt.isAlive() && done == 1) {
            System.out.println("success");
        } else {
            //realtionPoint -= 2
            System.out.println("Nicole : Too slow boi!");
        }

        System.out.println("TYPE 'Scanner input = new Scanner(System.in);' IN 18 SECONDS!"); // If done, relationPoint +4
        cnt = new Count(18);
        done = 0;
        while (cnt.isAlive() && done == 0) {
            answerToType = inputChoice.nextLine();
            if (answerToType.equals("Scanner input = new Scanner(System.in);")) {
                //relationPoint += 3;
                done = 1;
                cnt.interrupt();
            }
        }
        System.out.println(cnt.isAlive() + " & " + done);

        if (cnt.isAlive() && done == 1) {
            System.out.println("success");
        } else {
            //realtionPoint -= 2
            System.out.println("Nicole : Too slow boi!");
        }

        System.out.println("TYPE 'public static void method() {' IN 18 SECONDS!"); // If done, relationPoint +4
        cnt = new Count(18);
        done = 0;
        while (cnt.isAlive() && done == 0) {
            answerToType = inputChoice.nextLine();
            if (answerToType.equals("public static void method() {")) {
                //relationPoint += 3;
                done = 1;
                cnt.interrupt();
            }
        }
        if (cnt.isAlive() && done == 1) {
            System.out.println("success");
        } else {
            //realtionPoint -= 2
            System.out.println("Nicole : Too slow boi!");
        }

        System.out.println("TYPE 'class.method();' IN 10 SECONDS!"); // If done, relationPoint +3
        cnt = new Count(10);
        done = 0;
        while (cnt.isAlive() && done == 0) {
            answerToType = inputChoice.nextLine();
            if (answerToType.equals("class.method();")) {

                done = 1;
                cnt.interrupt();
            }
        }
        if (cnt.isAlive() && done == 1) {
            System.out.println("success");
        } else {
            //realtionPoint -= 2
            System.out.println("Nicole : Too slow boi!");
        }

        System.out.println("TYPE 'program_name.java' IN 10 SECONDS!"); // IF done, relationPoint +3
        cnt = new Count(10);
        done = 0;

        while (cnt.isAlive() && done == 0) {
            answerToType = inputChoice.nextLine();
            if (answerToType.equals("program_name.java")) {
                //relationPoint += 3;
                done = 1;
                cnt.interrupt();
            }
        }
        if (cnt.isAlive() && done == 1) {
            System.out.println("success");
        } else {
            //realtionPoint -= 2
            System.out.println("Nicole : Too slow boi!");
        }

    }

}

class Count extends Thread {

    int time;

    Count(int time) {
        super();
        this.time = time;
        start();
    }

    public void run() {
        try {
            for (int i = 0; i < time; i++) {
                System.out.println(i);
                Thread.sleep(1000);
            }
            System.out.println("");
            Robot robot = new Robot();

            robot.keyPress(KeyEvent.VK_ENTER);

            robot.keyRelease(KeyEvent.VK_ENTER);
            System.out.println("done");
        } catch (InterruptedException e) {
//            System.out.println("my thread interrupted");
        } catch (AWTException ex) {
            Logger.getLogger(Count.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
