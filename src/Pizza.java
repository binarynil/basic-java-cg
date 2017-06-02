/**
 * In this game, you take orders for pizzas from people living in Hyattsville.
 * Armed with a map of the city, you must then tell your delivery boy the
 * address where the pizza is to be delivered. If the pizza is delivered to
 * the correct address, the customer phones you and thanks you; if not, you
 * must give the driver the correct address until the pizza gets delivered.
 * Some interesting amodifications suggest themselves for this program such
 * as pizzas getting cold after two incorrect delivery attemps or taking
 * three or more orders at a time and figuring the shortest delivery route.
 * Send us your modifications!
 * This program seems to have surfaced originally at the University of Georgia
 * in Athens, Georga. The author is unknown.
 * This is the Java conversion of that code.
 */
import java.util.Scanner;
public class Pizza {

    public static void slice() {
        Scanner keyboard = new Scanner(System.in);
        char[][] map = new char[26][31];
        String neighborhood = "ABCDEFGHIJKLMNOP";
        System.out.println("Pizza Delivery Game");
        System.out.print("What is your first name? ");
        String name = keyboard.nextLine();
        System.out.printf("\nHi, %s. In this game you are to take orders for pizzas.\n", name);
        System.out.println("Then you are to tell a delivery boy where to deliver the ordered pizzas.");
        System.out.println("\nMap of the City of Hyattsville\n");
        /*
         rows = 5, 10, 15, 20
         cols = 7, 13, 19, 25
         */
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                map[i][j] = setXY(i, j);
            }
        }

        for(char[] e : map) {
            for(char f : e) {
                System.out.print(f);
            }
            System.out.println();
        }

        printDirections(name);
        int count = 0;
        boolean deliver = true;
        do {
            int location = (int)((Math.random() * 15) + 1);
            String house = neighborhood.substring(location-1, location);
            System.out.printf("\nHello %s's Pizza. This is %s. Please send a pizza.\n", name, house);
            System.out.println(location + " " + house);
            int t;
            do {
                System.out.printf("   Driver to %s. Where does %s live? ", name, house);
                String coordinates = keyboard.nextLine();
                Scanner scanXY = new Scanner(coordinates).useDelimiter(",");
                int col = scanXY.nextInt();
                int row = scanXY.nextInt();
                scanXY.close();
                t = col+(row-1)*4;
                if(t == location) {
                    System.out.printf("Hello %s. This is %s, Thanks for the pizza.\n", name, house);
                }
                else {
                    String notHouse = neighborhood.substring(t-1, t);
                    System.out.printf("This is %s. I did not order a pizza.\n", notHouse);
                    System.out.printf("I live at %s\n", coordinates);
                }
                System.out.println(t);
            } while(t != location);

            if(count == 5) {
                deliver = morePizza(keyboard, name);
            }

            count++;
        } while(deliver);
    }

    private static boolean morePizza(Scanner keyboard, String name) {
        boolean pizza = true;
        boolean invalid;
        do {
            System.out.print("Do you want to deliver more pizzas? ");
            String input = keyboard.nextLine();
            if(input.equalsIgnoreCase("no") || input.equalsIgnoreCase("n")) {
                pizza = false;
                System.out.printf("\nO.K. %s, see you later!\n", name);
                invalid = false;
            }
            else if(input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("y")) {
                pizza = true;
                invalid = false;
            }
            else {
                System.out.println("Enter y or n");
                invalid = true;
            }
        } while(invalid);

        return pizza;
    }

    private static char setXY(int row, int col) {
        char xy = ' ';
        if(col == 0 || col == 30) {
            if(row == 5){
                xy = '4';
            }
            else if(row == 10) {
                xy = '3';
            }
            else if(row == 15) {
                xy = '2';
            }
            else if(row == 20) {
                xy = '1';
            }
            else {
                xy = '-';
            }
        }
        if(row == 0 || row == 25) {
            if(col == 6) {
                xy = '1';
            }
            else if(col == 12) {
                xy = '2';
            }
            else if(col == 18) {
                xy = '3';
            }
            else if(col == 24) {
                xy = '4';
            }
            else {
                xy = '-';
            }
        }
        else if(row == 5) {
            if(col == 6) {
                xy = 'M';
            }
            else if(col == 12) {
                xy = 'N';
            }
            else if(col == 18) {
                xy = 'O';
            }
            else if(col == 24) {
                xy = 'P';
            }
        }
        else if(row == 10) {
            if(col == 6) {
                xy = 'I';
            }
            else if(col == 12) {
                xy = 'J';
            }
            else if(col == 18) {
                xy = 'K';
            }
            else if(col == 24) {
                xy = 'L';
            }
        }
        else if(row == 15) {
            if(col == 6) {
                xy = 'E';
            }
            else if(col == 12) {
                xy = 'F';
            }
            else if(col == 18) {
                xy = 'G';
            }
            else if(col == 24) {
                xy = 'H';
            }
        }
        else if(row == 20) {
            if(col == 6) {
                xy = 'A';
            }
            else if(col == 12) {
                xy = 'B';
            }
            else if(col == 18) {
                xy = 'C';
            }
            else if(col == 24) {
                xy = 'D';
            }
        }

        return xy;
    }

    private static void printDirections(String name) {
        System.out.println("\nThe above is a map of the homes where you are to send pizzas.");
        System.out.println("Your job is to give a truck driver the location or coordinates");
        System.out.println("of the hone ordering the pizza.");
        System.out.println("Somebody will ask for a pizza to be delivered.");
        System.out.println("Then a delivery boy will ask you for the location.");

        System.out.println("      Example:");
        System.out.println("This is J. Please send a Pizza.");
        System.out.printf("Driver to %s. Where does J live?\n", name);
        System.out.println("Your answer would be 2,3");
        System.out.println("You are now ready to start taking orders.\n");
        System.out.println("Good Luck!!!");
    }
}