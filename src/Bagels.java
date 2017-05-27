/**
 * In this game, the computer picks a 3-digit secret number using the digits 0 to 9,
 * and you attempt to guess what it is. You're allowed up to twenty guesses. No digit
 * is repeated. After each guess, the computer will give you clues about your guess as follows:
 * PICO      One digit is correct, but in the wrong place
 * FERMI     One digit is in the correct place
 * BAGELS    No digit is correct
 *
 * You will learn to draw inferences from the clues and, with practice, you'll learn
 * to improve your score. There are several good strategies for playing Bagels.
 * After you have found a good strategy, see if you can improve it. Or try a different
 * strategy altogether and see if it is any better. While the program allows up to twenty
 * guesses, if you use a good strategy, it should not take more than eight guesses to gey any
 * number.
 * The original authors of this program are D. Resek and P. Row of the Lawrence Hall of Science, Berkley, California
 * This is the Java conversion of that code.
 */
public class Bagels {

    public static void butter() {
        System.out.println("                 Bagels");
        System.out.println("Creative Computing  Morristown, New Jersey");
        System.out.println();
        System.out.println("I am thinking of a three-digit number.");
        System.out.println("Try to guess my number, and I will give you clues as follows");
        System.out.println("   PICO     - One digit correct, but in the wrong position");
        System.out.println("   FERMI    - One digit correct and in the right position");
        System.out.println("   BAGELS   - No digits correct");
        System.out.println();

        int[] arrayA1 = new int[6];
        int[] arrayA = new int[3];
        int[] arrayB = new int[3];

        int y = 0, t = 255;
        for(int i = 0; i < arrayA.length; i++) {
            arrayA[i] = rndNum();
        }

        for(int i = 0; i < arrayA.length; i++) {
            int[] neighbors = checkNeighbor(i);
            arrayA = uniqueNum(arrayA, i, neighbors);
        }



        /*
        while(arrayA[0] == arrayA[1] || arrayA[0] == arrayA[2]) {
            arrayA[0] = rndNum();
        }

        while(arrayA[1] == arrayA[2] || arrayA[1] == arrayA[0]) {
            arrayA[1] = rndNum();
        }

        while(arrayA[2] == arrayA[0] || arrayA[2] == arrayA[1]) {
            arrayA[2] = rndNum();
        } */


        System.out.println("OK. I have a number in mind");
        for(int index : arrayA) {
            System.out.println(index);
        }
    }

    private static int rndNum() {
        int randomNum = (int)(Math.random() * 10);
        return randomNum;
    }

    private static int[] checkNeighbor(int i) {
        int[] neighbors = new int[2];
        if(i == 0) {
            neighbors[i] = i + 1;
            neighbors[i+1] = i + 2;
        }
        else if(i == 1) {
            neighbors[i-1] = i + 1;
            neighbors[i] = i - 1;
        }
        else if(i == 2) {
            neighbors[i-i] = i - i;
            neighbors[i-1] = i - 1;
        }
        return neighbors;
    }

    private static int[] uniqueNum(int[] arrayA, int index, int[] neighbors) {
        int n1 = neighbors[0];
        int n2 = neighbors[1];
        System.out.println(index+"  " + n1 + "  " + n2);
        while(arrayA[index] == arrayA[n1] || arrayA[index] == arrayA[n2]) {
            arrayA[index] = rndNum();
        }
        return arrayA;
    }
}
