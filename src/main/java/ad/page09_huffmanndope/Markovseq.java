package ad.page09_huffmanndope;

/**
 * The {@code markovseq} class provides static methods for generating a random sequence bases on a Markov system.
 *
 * @author Michael Köhler-Bussmeier
 */

public class Markovseq {


    public static void main(String[] args) {

        int numberOfGeneratedBits = 10;
        if (args.length == 1) {
            numberOfGeneratedBits = Integer.parseInt(args[0]);
        }


        double matrix[][] = {
                {0.25, 0.25, 0.25, 0.25},
                {0.25, 0.2, 0.35, 0.2},
                {0.10, 0.15, 0.25, 0.50},
                {0.25, 0.35, 0.2, 0.2}
        };

     /*
     double matrix1[][] = {
	 { 0.25, 0.25, 0.25, 0.25 },
	 { 0.25, 0.25, 0.25, 0.25 },
	 { 0.25, 0.25, 0.25, 0.25 },
	 { 0.25, 0.25, 0.25, 0.25 }

     };
     */
     /*
     double matrix2[][] = {
	 { 0.0, 1.0, 0.0, 0.0 },
	 { 0.0, 0.0, 1.0, 0.0 },
	 { 0.0, 0.0, 0.0, 1.0 },
	 { 1.0, 0.0, 0.0, 0.0 }
     };
     */

        // deterministischer Startzustand
        int state = 0;

        for (int i = 0; i < numberOfGeneratedBits; i++) {
            state = StdRandom.discrete(matrix[state]);

            // Moore-Ausgabe: State --> 0 oder 1
            System.out.print(state % 2);
        }
        System.out.println("");
    }//end-of-main

}

