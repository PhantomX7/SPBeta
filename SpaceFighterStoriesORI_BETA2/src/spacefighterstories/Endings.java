/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacefighterstories;

import static spacefighterstories.SysBackbone.player1;

/**
 *
 * @author Toshiba
 */
public class Endings {
    /*
        Endings - Will be initialised once all quests are complete
        PP = peace points | RP = Relationship Points
        Ending 1 :  shown if PP >= 50 and RP >= 50         => All is Well Ending
        Earth is safe and Player and Nicole become more than friends.
        Ending 2 :  shown if PP >= 50 and RP < 50          => Serving Your Country Ending
        Earth is safe but Nicole leaves Player because of less interaction.
        Ending 3 :  shown if PP <= 50 and RP >= 50         => Devoted to You Ending
        Captain discharges Nicole and Player due to not being able to focus, but they become more than friends.
        Ending 4 :  shown if PP <= 50 and RP < 50          => Left Alone Ending
        You receive a dishonorable discharge, and Nicole doesn't care about you anymore.
        But if PP equals to 0, before all quests are complete, then ...
        Ending 5 :  shown if PP = 0                        => Doomed Ending
        Earth is controlled by the alien race, and everyone is executed.   
        
        Go back to start menu (welcome to ...).
     */
    
    public static void credits() {
        System.out.println("");
        //Yeah, there's also player stats.
        System.out.println("---Final Player Stats---");
        SysBackbone.showStats();
        System.out.println("Peace Points : " + player1.getPeace() + " | Relationship Points : " + player1.getRelationship());
        System.out.println("------------------------");
        System.out.println("");
        System.out.println("---Credits---");
        System.out.println("Made in Java by Oracle. (not JavaScript, just Java.)");
        System.out.println("Head Programmer : PhantomX7 (https://github.com/PhantomX7)");
        System.out.println("Assistant/Apprentice Programmer: FalconPunch (no GitHub)");
        System.out.println("Storymaker and Game Director : FalconPunch");
        System.out.println("Thank you, PhantomX7, for teaching FalconPunch Java while programming the game, and giving your time for development! :D");
        System.out.println("And thank you, " + player1.getName() + ", for playing SpaceFighterStories!");
        System.out.println("----");
        System.out.println("In later updates (yes, there are more things to impliment), PhantomX7 and FalconPunch will make a detailed explaination of this game.");
        System.out.println("It will comprise of techniques used in this game. This is made so that FalconPunch and you can understand what's happening inside.");
        System.out.println("----");
    }
    
    public static void endingSelector() {
        //Ending 1
        System.out.println("With the aliens supressed/extinct, your squad head back to celebrate.");
        SysBackbone.storyContinue();
        System.out.println("Inside the space cruiser was a rad party, with an atmosphere of relief and celebration.");
        SysBackbone.storyContinue();
        System.out.println("You and Nicole enter together.");
        SysBackbone.storyContinue();
        System.out.println("Nicole : Yeah! Party!");
        SysBackbone.storyContinue();
        System.out.println("She takes your hand, and rushes to the dance floor.");
        SysBackbone.storyContinue();
        System.out.println("You both dance in the dance floor, under the black blanket of space.");
        SysBackbone.storyContinue();
        System.out.println("In a livestream, several cities release fireworks to the sky, causing colourful stirngs to come out.");
        SysBackbone.storyContinue();
        System.out.println("After an hour, the DJ made a change.");
        SysBackbone.storyContinue();
        System.out.println("DJ : I know that at least one couple is in the dance floof, so here's a slow song. Enjoy.");
        SysBackbone.storyContinue();
        System.out.println("The DJ played a slow romantic song.");
        SysBackbone.storyContinue();
        System.out.println("Nicole looks at you.");
        SysBackbone.storyContinue();
        System.out.println("Nicole : Well, we have to blend in, so yeah. Do it.");
        SysBackbone.storyContinue();
        System.out.println(player1.getName() + " : Okay then.");
        SysBackbone.storyContinue();
        System.out.println("You hold her by the hips, and sway together.");
        SysBackbone.storyContinue();
        System.out.println("Suddenly, you feel something wrong at your heart.");
        SysBackbone.storyContinue();
        System.out.println("At the same time, you see Nicole's faint blush.");
        SysBackbone.storyContinue();
        System.out.println("Once the song ends, Nicole speaks.");
        SysBackbone.storyContinue();
        System.out.println("Nicole : Hey, can we talk in private?");
        SysBackbone.storyContinue();
        System.out.println(player1.getName() + " : Sure.");
        SysBackbone.storyContinue();
        System.out.println("You two evenutally found the SkyDome, which is deserted.");
        SysBackbone.storyContinue();
        System.out.println("You and Nicole sit together at a bench under the stars.");
        SysBackbone.storyContinue();
        System.out.println("Nicole : So... How do I say this...");
        SysBackbone.storyContinue();
        System.out.println("Nicole : Okay, here I go.");
        SysBackbone.storyContinue();
        System.out.println("Nicole : Ever since the alien attack, I though that we'll never talk like friends anymore.");
        SysBackbone.storyContinue();
        System.out.println("Nicole : But somehow, you managed to keep in touch with me.");
        SysBackbone.storyContinue();
        System.out.println("Nicole : Thanks for being with me.");
        SysBackbone.storyContinue();
        System.out.println(player1.getName() + " : It's okay, that's what friends are for.");
        SysBackbone.storyContinue();
        System.out.println("Nicole : One last thing.");
        SysBackbone.storyContinue();
        System.out.println(player1.getName() + " : What is it?");
        SysBackbone.storyContinue();
        System.out.println("Nicole : Can we be more than friends?");
        SysBackbone.storyContinue();
        System.out.println(player1.getName() + " : Sure, Nicole. Why not. I'm not busy anymore.");
        SysBackbone.storyContinue();
        System.out.println("");
        System.out.println("---END OF GAME---");
        System.out.println("Ending 1/5 - All is Well ending.");
        System.out.println("Ending 1 is shown because PP >= 50 and RP >= 50.");
        System.out.println("Achievement get : A role model.");
        credits();
        
        //Ending 2
        System.out.println("As a celebration for the aliens' defeat, a party is held.");
        SysBackbone.storyContinue();
        System.out.println("You party for an hour before realising something.");
        SysBackbone.storyContinue();
        System.out.println(player1.getName() +" : Where's Nicole?");
        SysBackbone.storyContinue();
        System.out.println("You walk to her room, where you see that her door is open.");
        SysBackbone.storyContinue();
        System.out.println("You open the room, finding Nicole crying.");
        SysBackbone.storyContinue();
        System.out.println("Nicole : Finally you realised.");
        SysBackbone.storyContinue();
        System.out.println("Nicole : Was I nothing to you?");
        SysBackbone.storyContinue();
        System.out.println("You try to deny it, but Nicole interrupts.");
        SysBackbone.storyContinue();
        System.out.println("Nicole : Was I nothing to you while you served for your country?");
        SysBackbone.storyContinue();
        System.out.println("Nicole : You rarely hanged out with me.");
        SysBackbone.storyContinue();
        System.out.println("Nicole : I thought we were friends. But now I don't.");
        SysBackbone.storyContinue();
        System.out.println("Nicole : Leave. Your country is first, not me.");
        SysBackbone.storyContinue();
        System.out.println("You leave her room, broken by what you've done.");
        SysBackbone.storyContinue();
        System.out.println("");
        System.out.println("---END OF GAME---");
        System.out.println("Ending 2/5 - Serving Your Country ending.");
        System.out.println("Ending 2 happened because PP >= 50 and RP < 50.");
        System.out.println("Achivement get : Disappointment");
        credits();
        
        //Ending 3
        System.out.println("There's a party being held at the Space Cruiser. But, your Captain calls you and Nicole.");
        SysBackbone.storyContinue();
        System.out.println("Nicole : What's going on? Maybe a promotion? Ooooh, that'll be sweet!");
        SysBackbone.storyContinue();
        System.out.println("You knock at the Captain's office.");
        SysBackbone.storyContinue();
        System.out.println("Captain : Enter.");
        SysBackbone.storyContinue();
        System.out.println("You both enter the room.");
        SysBackbone.storyContinue();
        System.out.println("Captain : Sit down. Let's get to business.");
        SysBackbone.storyContinue();
        System.out.println("You and Nicole sit down.");
        SysBackbone.storyContinue();
        System.out.println("Captain : You both are receiving dishonorable discharges.");
        SysBackbone.storyContinue();
        System.out.println("You are shocked. Nicole is too.");
        SysBackbone.storyContinue();
        System.out.println("Captain : This is due to you both not being able to focus on the mission, especially with that lovey dovey stuff.");
        SysBackbone.storyContinue();
        System.out.println("Capatin : You both leave tommorow. Pack your bags.");
        SysBackbone.storyContinue();
        System.out.println("You and Nicole exit the room.");
        SysBackbone.storyContinue();
        System.out.println("Nicole : Well, that's a bummer. At least he got something right.");
        SysBackbone.storyContinue();
        System.out.println(player1.getName() + " : What is it?");
        SysBackbone.storyContinue();
        System.out.println("Nicole : The lovey dovey stuff.");
        SysBackbone.storyContinue();
        System.out.println("You realise that she loves you.");
        SysBackbone.storyContinue();
        System.out.println("And you do too.");
        SysBackbone.storyContinue();
        System.out.println(player1.getName() + " : Yeah, he got that right.");
        SysBackbone.storyContinue();
        System.out.println("Nicole smiles at you. You both hold hands.");
        System.out.println("");
        System.out.println("---END OF GAME---");
        System.out.println("Ending 3/5 - Devoted to You ending");
        System.out.println("Ending 3 occured because PP <= 50 and RP >= 50.");
        System.out.println("Achievement get : Loyalty Till Love Comes");
        credits();
        
        //Ending 4
        System.out.println("There's a party being held at the Space Cruiser. But, your Captain calls you.");
        SysBackbone.storyContinue();
        System.out.println("You knock at the Captain's office.");
        SysBackbone.storyContinue();
        System.out.println("Captain : Enter.");
        SysBackbone.storyContinue();
        System.out.println("You enter the room.");
        SysBackbone.storyContinue();
        System.out.println("Captain : Sit down. Let's get to business.");
        SysBackbone.storyContinue();
        System.out.println("You sit down.");
        SysBackbone.storyContinue();
        System.out.println("Captain : You are receiving dishonorable discharges.");
        SysBackbone.storyContinue();
        System.out.println("You are shocked.");
        SysBackbone.storyContinue();
        System.out.println("Captain : This is due to you both not being able to focus on the mission.");
        SysBackbone.storyContinue();
        System.out.println("Capatin : You leave tommorow. Pack your bags.");
        SysBackbone.storyContinue();
        System.out.println("You exit the room.");
        SysBackbone.storyContinue();
        System.out.println("You then walk to the party to tell Nicole.");
        SysBackbone.storyContinue();
        System.out.println("But she isn't there.");
        SysBackbone.storyContinue();
        System.out.println(player1.getName() +" : Where's Nicole?");
        SysBackbone.storyContinue();
        System.out.println("You walk to her room, where you see that her door is open.");
        SysBackbone.storyContinue();
        System.out.println("You open the room, finding Nicole crying.");
        SysBackbone.storyContinue();
        System.out.println("Nicole : Finally you realised.");
        SysBackbone.storyContinue();
        System.out.println("Nicole : Was I nothing to you?");
        SysBackbone.storyContinue();
        System.out.println("You try to deny it, but Nicole interrupts.");
        SysBackbone.storyContinue();
        System.out.println("Nicole : Was I nothing to you while you served for your country? Oh wait, you neglected your country also.");
        SysBackbone.storyContinue();
        System.out.println("Nicole : You rarely hanged out with me. I wonder what you did while I thought that you're doing missions.");
        SysBackbone.storyContinue();
        System.out.println("Nicole : I thought we were friends. But now I don't. I'm happy that you're out of my sights.");
        SysBackbone.storyContinue();
        System.out.println("Nicole : Leave.");
        SysBackbone.storyContinue();
        System.out.println("You leave.");
        SysBackbone.storyContinue();
        System.out.println("As you depart from the space cruiser, you don't see Nicole waving her hand. You cry at the plane.");
        System.out.println("");
        System.out.println("---END OF GAME---");
        System.out.println("Ending 4/5 - Left Alone ending");
        System.out.println("Ending 4 is initialised because PP <= 50 and RP < 50.");
        System.out.println("Achivement not get. Try harder next time.");
        credits();
        
        //Ending 5
        System.out.println("While on the space cruiser, you look out at the window at your room.");
        SysBackbone.storyContinue();
        System.out.println("In a blink of an eye, a fleet of alien ships appear.");
        SysBackbone.storyContinue();
        System.out.println("And in another blink, a alien ship fires lasers to your room, leading to an explosion.");
        SysBackbone.storyContinue();
        System.out.println("Hence, you died.");
        System.out.println("");
        System.out.println("---END OF GAME---");
        System.out.println("Ending 4/5 - Left Alone ending");
        System.out.println("Ending 4 is initialised because PP = 0");
        System.out.println("Achivement not get. Try harder next time.");
        credits();
    }
}
