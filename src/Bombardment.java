import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * Bombardment is played on two 5x5 grids or boards with 25 outpost locations numbered 1 - 25.
 * Both you and the computer have four platoons of troops that can be located at any four outposts
 * on your respective grids. At the start of the game, you can locate or hide your four platoons on
 * your grid. The computer does the same on its grid. You then take turns firing missles or bombs
 * at each other's outposts trying to destroy all four playoons. The one who finds all four opponents'
 * platoons first, wins. This program was slightly modified from the original written by Martin
 * Burdash of Parlin, New Jersey.
 * This is the JAva conversion of that code.
 */
public class Bombardment {

    public static void platoon() {
        Scanner keyboard = new Scanner(System.in);
        ArrayList<Integer> cpuOutpost = new ArrayList<>();
        ArrayList<Integer> cpuGuesses = new ArrayList<>();
        ArrayList<Integer> myOutpost = new ArrayList<>();
        printIntro();
        printMatrix();
        int iGotCPU = 0;
        boolean gameOver = false;
        boolean isMyTurn = true;
        genCPUOutpost(cpuOutpost);
        /*for(int e : cpuOutpost) {
            System.out.println(e);
        }*/
        int turns = 0;
        do {
            if(turns == 0) {
                setMyOutposts(myOutpost, keyboard);
                /*for(int e : myOutpost) {
                    System.out.println(e);
                }*/
            }

            if(isMyTurn) {
                iGotCPU = myTurn(cpuOutpost, myOutpost, iGotCPU, keyboard);
                isMyTurn = false;
            }
            else {
                cpuTurn(cpuOutpost, myOutpost, cpuGuesses);
                isMyTurn = true;
            }
            turns++;

            if(myOutpost.isEmpty() || cpuOutpost.isEmpty()) {
                gameOver = true;
            }
        } while(!gameOver);
    }

    private static void printIntro() {
        System.out.println("You are on a battlefield with 4 platoons and you");
        System.out.println("have 25 outposts available where they may be placed.");
        System.out.println("You can only place one platoon at any one outpost.");
        System.out.println("The computer does the same with its four platoons\n");
        System.out.println("The object of the game is to fire missiles at the");
        System.out.println("outposts of the computer. It will do the same to you.");
        System.out.println("The one who destroys all four of the enemy's platoons first is the winner.\n");
        System.out.println("Good luck... and tell us where you want the bodies sent!\n");
        System.out.println("Tear off matrix and use it to check off the numbers.\n\n");
    }

    private static void printMatrix() {
        for(int i = 0; i < 5; i++) {
            int j = i*5+1;
            if(j > 10) {
                System.out.printf(" %d      %d      %d      %d      %d\n", j, j+1, j+2, j+3, j+4);
            }
            else {
                System.out.printf(" %d       %d       %d       %d       %d\n", j, j+1, j+2, j+3, j+4);
            }
        }
    }

    private static void genCPUOutpost(ArrayList<Integer> cpuOutpost) {
        int cpu1 = (int)((Math.random() * 25) + 1);
        int cpu2 = (int)((Math.random() * 25) + 1);
        int cpu3 = (int)((Math.random() * 25) + 1);
        int cpu4 = (int)((Math.random() * 25) + 1);

        do {
            if(cpu1 == cpu2) {
                cpu2 = (int)((Math.random() * 25) + 1);
            }
            else if(cpu1 == cpu3 || cpu2 == cpu3) {
                cpu3 = (int)((Math.random() * 25) + 1);
            }
            else if(cpu1 == cpu4 || cpu2 == cpu4 || cpu3 == cpu4) {
                cpu4 = (int)((Math.random() * 25) + 1);
            }
        } while(cpu1 == cpu2 || cpu1 == cpu3 || cpu1 == cpu4 || cpu2 == cpu3 || cpu2 == cpu4 || cpu3 == cpu4);

        cpuOutpost.add(cpu1);
        cpuOutpost.add(cpu2);
        cpuOutpost.add(cpu3);
        cpuOutpost.add(cpu4);
    }

    private static void setMyOutposts(ArrayList<Integer> myOutpost, Scanner keyboard) {
        System.out.print("\n\nWhat are your four positions (Ex: 1,2,3,4)? ");
        String input = keyboard.nextLine();
        Scanner scanInput = new Scanner(input).useDelimiter(",");
        for(int i = 0; i < 4; i++) {
            int mine = scanInput.nextInt();
            myOutpost.add(mine);
        }
    }

    private static void cpuTurn(ArrayList<Integer> cpuOutpost, ArrayList<Integer> myOutpost, ArrayList<Integer> cpuGuesses) {
        int cpuTurn = (int)((Math.random() * 25) + 1);

        while(cpuGuesses.contains(cpuTurn)) {
            cpuTurn = (int)((Math.random() * 25) + 1);
        }
        cpuGuesses.add(cpuTurn);

        /*do {
            if(cpuOutpost.contains(cpuTurn)) {
                cpuTurn = (int)((Math.random() * 25) + 1);
            }
        } while(cpuOutpost.contains(cpuTurn)); */

        if(myOutpost.contains(cpuTurn)) {
            int remove = myOutpost.indexOf(cpuTurn);
            myOutpost.remove(remove);
            checkMyOutpost(myOutpost, cpuTurn);
        }
        else {
            System.out.printf("I missed you, you dirty rat. I picked %d. Your turn.\n\n", cpuTurn);
        }
    }

    private static void checkMyOutpost(ArrayList<Integer> myOutpost, int cpuTurn) {
        if(myOutpost.isEmpty()) {
            System.out.printf("You're dead. Your last outpost was at %d. Ha, Ha, Ha.\n", cpuTurn);
            System.out.println("Better luck next time.\n\n");
        }
        else {
            System.out.printf("I got you. It won't be long now. Post %d was hit.\n", cpuTurn);
            System.out.printf("You only have %d outposts left.\n\n", myOutpost.size());
        }
    }

    private static int myTurn(ArrayList<Integer> cpuOutpost, ArrayList<Integer> myOutpost, int iGotCPU, Scanner keyboard) {
        int input;

        do {
            System.out.print("Where do you wish to fire your missile? ");
            while(!keyboard.hasNextInt()) {
                System.out.print("Where do you wish to fire your missile? ");
                keyboard.next();
            }
            input = keyboard.nextInt();
            keyboard.nextLine();

        } while(input < 1 || input > 25);

        if(cpuOutpost.contains(input)) {
            iGotCPU++;
            int remove = cpuOutpost.indexOf(input);
            cpuOutpost.remove(remove);
            checkCPUOutpost(cpuOutpost, iGotCPU);
        }
        else {
            System.out.println("Ha, ha you missed. My turn now.\n");
        }

        return iGotCPU;
    }

    private static void checkCPUOutpost(ArrayList<Integer> cpuOutpost, int iGotCPU) {
        if(cpuOutpost.isEmpty()) {
            System.out.println("You got me. I'm going fast, but I'll get you when ..");
            System.out.println("my transisto&s recup%ra*e!\n");
        }
        else {
            System.out.println("You got one of my outposts.");
            System.out.printf("%d down, %d to go.\n\n", iGotCPU, cpuOutpost.size());
        }
    }
}