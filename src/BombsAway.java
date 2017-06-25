/**
 * In this program you fly a World War II bomber for one of the four protagonists of the war.
 * You then pick your target or the type of plane you are flying. Depending upon your flying experience
 * and the quality of the enemy defenders, you may accomplish your mission, get shot down,
 * or make it back through enemy fire. In any case, you get a chance to fly again.
 * David Ahl modified the original program which was created by David Sherman while a student
 * at Curtis Jr. High School, Sudbury, Massachusetts.
 * This is the Java conversion of that code.
 */
import java.util.Scanner;
public class BombsAway {

    public static void boom() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("You are a pilot in a World War II bomber.");
        int missions = 100;
        //System.out.println(Math.random()*160);
        boolean gameOver = false;
        do {
            pickSide(keyboard);
            gameOver = playAgain(keyboard);

        } while(!gameOver);
    }

    private static boolean playAgain(Scanner keyboard) {
        String input;
        boolean endLoop = false;
        boolean gameOver = false;
        do {
            System.out.printf("Another mission (Y or N)? ");
            input = keyboard.next();
            if(input.equalsIgnoreCase("y")) {
                gameOver = false;
                endLoop = true;
            }
            else if(input.equalsIgnoreCase("n")) {
                System.out.println("Chicken !!!\n");
                gameOver = true;
                endLoop = true;
            }
            else {
                System.out.println("Choose y/n");
            }
        } while(!endLoop);

        return gameOver;
    }

    private static void pickSide(Scanner keyboard) {
        int input;

        do {
            System.out.print("What side -- [1] Italy, [2] Allies, [3] Japan, [4] Germany: ");
            input = keyboard.nextInt();
            keyboard.nextLine();
            if(input < 1 || input > 4) {
                System.out.println("Try again...");
            }
            else if(input == 1) {
                italyTarget(keyboard);
            }
            else if(input == 2) {
                alliesAircraft(keyboard);
            }
            else if(input == 3) {
                System.out.println("You're flying a kamikaze mission over the USS Lexington.");
                kamikaze(keyboard);
            }
            else if(input == 4) {
                nazi(keyboard);
            }

        } while(input < 1 || input > 4);

    }

    private static void nazi(Scanner keyboard) {
        int input;
        do {
            System.out.print("A Nazi, eh? Oh well. Are you going for [1] Russia, [2] England, [3] France? ");
            input = keyboard.nextInt();
            keyboard.nextLine();
            if(input == 1) {
                System.out.println("You're nearing Stalingrad.\n");
                missionsFlown(keyboard);
            }
            else if(input == 2) {
                System.out.println("Nearing London. Be careful, they've got radar.\n");
                missionsFlown(keyboard);
            }
            else if(input == 3) {
                System.out.println("Bearing Versailles. Duck soup. They're nearly defenseless.\n");
                missionsFlown(keyboard);
            }
            else {
                System.out.println("Try again...");
            }

        } while(input < 1 || input > 3);
    }

    private static void alliesAircraft(Scanner keyboard) {
        int input;
        do {
            System.out.print("Aircraft -- [1] Liberator, [2] B-29, [3] B-17, [4] Lancaster: ");
            input = keyboard.nextInt();
            keyboard.nextLine();
            if(input == 1) {
                System.out.println("You've got 2 tons of bombs flying for Ploesti.\n");
                missionsFlown(keyboard);
            }
            else if(input == 2) {
                System.out.println("You're dumping the A-Bomb on Hiroshima.\n");
                missionsFlown(keyboard);
            }
            else if(input == 3) {
                System.out.println("You're chasing the Bismark in the North Sea.\n");
                missionsFlown(keyboard);
            }
            else if(input == 4) {
                System.out.println("You're busting a German heavy water plant in the Ruhr.\n");
                missionsFlown(keyboard);
            }
            else {
                System.out.println("Try again...");
            }

        } while(input < 1 || input > 4);
    }

    private static void kamikaze(Scanner keyboard) {
        String input;
        boolean endLoop = false;
        do {
            System.out.print("Your first kamikaze mission (Y or N)? ");
            input = keyboard.next();
            if(input.equalsIgnoreCase("y") || input.equalsIgnoreCase("n")) {
                calcKamikaze(input);
                endLoop = true;
            }
            else {
                System.out.println("Choose y/n");
            }

        } while(!endLoop);
    }

    private static void calcKamikaze(String input) {
        double kamikazedmg;
        if(input.equalsIgnoreCase("y")) {
            kamikazedmg = Math.random();
        }
        else {
            kamikazedmg = 999;
        }

        if (kamikazedmg > .65) {
            int killed = (int)(Math.random()*100);
            System.out.printf("\nDirect hit!!! %d killed.\n", killed);
            System.out.println("Mission successful.\n");
        }
        else {
            System.out.println();
            shotDown();
        }
    }

    private static void italyTarget(Scanner keyboard) {
        int input;

        do {
            System.out.print("Your target -- [1] Albania, [2] Greece, [3] North Africa: ");
            input = keyboard.nextInt();
            keyboard.nextLine();
            if(input == 1) {
                System.out.println("Should be easy -- You're flying a Nazi-made plane.\n");
                missionsFlown(keyboard);
            }
            else if(input == 2) {
                System.out.println("Be careful!!!\n");
                missionsFlown(keyboard);
            }
            else if(input == 3){
                System.out.println("You're going for the oil, eh?\n");
                missionsFlown(keyboard);
            }
            else {
                System.out.println("Try again...");
            }

        } while(input < 0 || input > 3);

    }

    private static void missionsFlown(Scanner keyboard) {
        int input;
        do {
            System.out.print("How many missions have you flown? ");
            input = keyboard.nextInt();
            keyboard.nextLine();
            if(input >= 160) {
                System.out.println("Missions not miles...");
                System.out.printf("%d missions is high even for old-timers.\n", input);
                System.out.println("Now then, ");
            }
            else if(input >= 100 && input < 160) {
                System.out.println("That's pushing the odds!");
                calcDamage(input, keyboard);
            }
            else if(input < 25) {
                System.out.println("Fresh out of training, eh?");
                calcDamage(input, keyboard);
            }
            else {
                calcDamage(input, keyboard);
            }

        } while(input >= 160);
    }

    private static void calcDamage(int missions, Scanner keyboard) {
        double hitOrMiss = Math.random() * 160;

        if(missions < hitOrMiss) {
            int missed = (int)((Math.random() * 30) + 2);
            System.out.printf("\nMissed target by %d miles!\n", missed);
            System.out.println("Now you're really in for it !!\n");
            enemyGuns(keyboard);
        }
        else {
            int killed = (int)(Math.random()*100);
            System.out.printf("\nDirect hit!!! %d killed.\n", killed);
            System.out.println("Mission successful.\n");
        }
    }

    private static void enemyGuns(Scanner keyboard) {
        int input;
        int dmgPlus = 0;

        do {
            System.out.print("Does the enemy have [1] Guns, [2] Missiles, [3] Both? ");
            input = keyboard.nextInt();
            keyboard.nextLine();
            if(input > 1 && input < 4) {
                dmgPlus = 35;
            }

            if(input == 1 || input == 3) {
                System.out.print("What's the percent hit rate of enemy gunners (10 to 50)? ");
                int percent = keyboard.nextInt();
                keyboard.nextLine();
                if(percent < 10) {
                    System.out.println("You lie, but you'll pay...\n");
                    shotDown();
                }
                else {
                    calcCPUShot(percent+dmgPlus);
                }
            }
            else {
                calcCPUShot(dmgPlus);
            }

        } while(input < 1 || input > 3);
    }

    private static void calcCPUShot(int dmg) {
        double calcPerc = (Math.random() * 100);

        if(dmg > calcPerc) {
            shotDown();
        }
        else {
            System.out.println("You made it through tremendous flak!!\n");
        }
    }

    private static void shotDown() {
        System.out.println("* * * * BOOM * * * *");
        System.out.println("You have been show down.....");
        System.out.println("Dearly beloved, ");
        System.out.println("We are gathered here today to pay our last tribute...\n");
    }
}