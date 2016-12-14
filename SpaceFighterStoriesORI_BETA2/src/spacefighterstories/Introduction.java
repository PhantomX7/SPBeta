package spacefighterstories;

import java.util.Scanner;

public class Introduction {
    static Scanner inputNum=new Scanner(System.in);
    static Scanner inputString=new Scanner(System.in);
    
    //Start
    static String startnumber;

    public static String startGame() {
        do {
            System.out.println("Welcome to SpaceFighterStories! Press 1 to start.");
            startnumber = inputNum.nextLine();
            if (!startnumber.equals("1")) {
                System.out.println("Press 1 to start!!!");
            }
        } while (!startnumber.equals("1"));

        //Name Input
        System.out.println("First, input name.");
        String name = inputString.nextLine();
        return name;
    }
    
    //Introduction
    public static void intro1(String name) {
        //Introduction - Bedroom
        System.out.println("You wake up in your bedroom aboard the Space Cruiser Falcon.");
        SysBackbone.storyContinue();
        System.out.println("Athena : Good morning Pilot "+name+".");
        SysBackbone.storyContinue();
        System.out.println(name+": Good morning Athena...");
        System.out.println("Choose one.\n1. Where are we now?\n2. What time is it now?\n3. What are they serving for breakfast?");
        int choice1 = inputNum.nextInt();
        if (choice1 == 1) {
            System.out.println("Athena : We are floating just above Britain.");
        } else if (choice1 == 2) {
            System.out.println("Athena : It's 6 p.m. British Time");
        } else if (choice1 == 3) {
            System.out.println("Athena : Eggs benedict, Pilot.");
        } else {
            System.out.println("Please choose from 1 to 3");
        }
        
        //Introduction - Mess hall
        System.out.println("You head down to the mess hall after you prepared for your second day at space");
        SysBackbone.storyContinue();
        System.out.println("Arriving at the mess hall, you see someone familiar waving her hand at you.");
        SysBackbone.storyContinue();
        System.out.println("You apporach her, whose name is Nicole.");
        SysBackbone.storyContinue();
        System.out.println("Nicole : Hi, "+name+"! How are you?");
        System.out.println("Choose one.\n1. I'm excited for today!\n2. I'm fine.\n3. Get me outta here!");
        int choice2 =inputNum.nextInt();
        if (choice2 == 1) {
            System.out.println("Nicole : Me too! You should get the eggs benedict. It's great!");
        } else if (choice2 == 2) {
            System.out.println("Nicole : Good for you. You should get the eggs benedict. It's great!");
        } else if (choice2 == 3) {
            System.out.println("Nicole : Well, I can't help you there. You should get the eggs benedict. It's great!");
        } else {
            System.out.println("Please choose from 1 to 3. ");
        }
        System.out.println("You walk to get your breakfast. You went back after that, and ate with her.");
        SysBackbone.storyContinue();
        System.out.println("An hour later, you went with Nicole for roll call.");
        SysBackbone.storyContinue();
        System.out.println("You arrived, seeing only 5 other people and the Captain of your division.");
        SysBackbone.storyContinue();
        System.out.println("You and Nicole lined up at the front.");
        SysBackbone.storyContinue();
        System.out.println("Captain : You "+name+"? I heard great things about you during your time at the Academy. Don't let me down.");
        SysBackbone.storyContinue();
        System.out.println(name+" : Sir yes sir!");
        SysBackbone.storyContinue();
        System.out.println("Captain : I wanna see you fight. Go to the training room!");
        SysBackbone.storyContinue();
        System.out.println("You head to the training room, get a gun, and aim to a dummy target.");
}
    public static void intro2(String name) {
        System.out.println("Captain : Well done! Now hea-");
        SysBackbone.storyContinue();
        System.out.println("You hear a siren.");
        SysBackbone.storyContinue();
        System.out.println("Speaker : Warning. Alien ships are entering Earth's atmosphere.");
        SysBackbone.storyContinue();
        System.out.println("Captain : Just when we don't have the turrets to shoot them from space...");
        SysBackbone.storyContinue();
        System.out.println("Captain : Soldiers, get armed. We're heading down to Earth. The air force will deal with the airborne ships.");
        SysBackbone.storyContinue();
        System.out.println("After landing in London, you see rubble all around you.");
        SysBackbone.storyContinue();
        System.out.println("Suddenly, an platoon of aliens see your squad.");
    }
    
    public static void intro3(String name) {
        System.out.println("After dealing with the platoon, your squad roam around London to kill the remaining aliens.");
        SysBackbone.storyContinue();
        System.out.println("Going back to base, you have discovered that the alien race has settled on other planets.");
        SysBackbone.storyContinue();
        System.out.println("----------- System -----------");
        System.out.println("Now, you can choose your own way of gameplay.");
        System.out.println("You can choose Quests, where you can get money, peace points, and experience.");
        System.out.println("Or, you can Interact With Nicole to increase your relationship of her.");
        System.out.println("Keep in mind that Interacting With Nicole will decrease your Peace Points.");
        System.out.println("And, all Quests and Inteaction with Nicole will reduce your stamina.");
        System.out.println("Peace Points and Relationship Points affect your ending.");
        System.out.println("Don't get 0 Peace points, or the game will immediately end.");
        System.out.println("Inprove or decrease your Relationship Points to get different endings.");
        System.out.println("------------------------------");
    }
}
