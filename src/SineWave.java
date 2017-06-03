/**
 * Did you ever go to a computer show and see a bunch of CRT terminals just sitting there
 * waiting forlornly for someone to give a demo on them? It was one of those moments when
 * I was at DEC that I decided there should be a little bit of background activity. And
 * why not plot with words instead of unusual X's? Thus SINE WAVE was born and lives on
 * in dozens of different versions. At least those CRTs don't look so lifeless anymore.
 * This is the Java conversion of that code.
 */
public class SineWave {

    public static void wavey() {
        System.out.println("Remarkable program by David Ahl\n");
        int b = 0;
        for(double i = 0; i < 40; i+=.25) {
            int a = (int)(26+25*Math.sin(i));
            printTabs(a);
            if(b == 0) {
                System.out.println("Creative");
                b = 1;
            }
            else {
                System.out.println("Computing");
                b = 0;
            }
        }

    }

    private static void printTabs(int a) {
        // regular spaces work better than tabs
        for(int i = 0; i < a; i++) {
            System.out.print(" ");
        }
    }
}
