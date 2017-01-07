package maincommand;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RpgUtil {
    // constanta variable untuk FOREGROUND COLOR CLI    
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = " \u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    
    // constanta variable untuk BACKGROUND COLOR CLI    
    public static final String ANSI_BG_RED = "\u001B[41m";
    public static final String ANSI_BG_GREEN = "\u001B[42m";
    public static final String ANSI_BG_YELLOW = "\u001B[43m";
    public static final String ANSI_BG_BLUE = "\u001B[44m";
    public static final String ANSI_BG_PURPLE = "\u001B[45m";
    public static final String ANSI_BG_CYAN = "\u001B[46m";    
    public static final String ANSI_BG_WHITE = "\u001B[47m";

    public static boolean chanceOver100(int percentageOfChance) {
        Random rn = new Random();
        int d = 1 + rn.nextInt(100);     // random value in range 1-100
        if (d <= percentageOfChance) {
            return true;
        } else {
            return false;
        }
    }

    public static int randInt(int min, int max) {
        return ((int) (Math.random() * ((max - min) + 1)) + min);
    }

    // untuk mengembalikan nilai random dari rentang double min - max
    public static double randDouble(double min, double max) {
        return (Math.random() * ((max - min) + 1) + min);
    }

    //for all
    public static void clearScreen() throws InterruptedException {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }

            // for support clear screen in NetBeans Output Window    
            Robot pressbot = new Robot();
            pressbot.keyPress(17); // Holds CTRL key.
            pressbot.keyPress(76); // Holds L key.
            pressbot.keyRelease(17); // Releases CTRL key.
            pressbot.keyRelease(76); // Releases L key.

        } catch (Exception e) {
        }
        Thread.sleep(450);
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_L);
            robot.keyRelease(KeyEvent.VK_L);
            robot.keyRelease(KeyEvent.VK_CONTROL);
        } catch (AWTException ex) {
            Logger.getLogger("Error").log(Level.SEVERE, null, ex);
        }
        Thread.sleep(100);
    }

    public static void delay(long milisec) {
        try {
            Thread.sleep(milisec);
        } catch (InterruptedException ex) {
        }
    }
    //for netbeans only
    /*
    
    public static void clrscr() throws InterruptedException, AWTException{
        
            Thread.sleep(500);
            try {
            Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_L);
                robot.keyRelease(KeyEvent.VK_L);
                robot.keyRelease(KeyEvent.VK_CONTROL);
            } catch (AWTException ex) {
                Logger.getLogger("Error").log(Level.SEVERE, null, ex);
            }
    }
     */
}
