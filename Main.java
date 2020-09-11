/* OOP ASSGINMENT #2
NAME: M.Hassaan Atif
Roll no: 0147-BSCS-2019 (Section C)

 */
 

import java.util.Scanner;

public class Main {
    public static void main (String args[])  {

        /**INTRO**/
        System.out.println("----DIGITAL MUSIC ORGANIZER----");
         MOrganizer musicOrganizer = new MOrganizer();

        /** PUTTING CUSTOM SONGS IN HERE **/
       /* musicOrganizer.addSong("src/myAssignment02OOP/Songs/jpeh.mp3");
        musicOrganizer.addSong("src/myAssignment02OOP/Songs/desktop/cable.mp3");
        musicOrganizer.addSong("src/myAssignment02OOP/Songs/judas.mp3"); */
        //00: Badmoon
        //02: Dj Snake
        //03: Laura
        //08: Time to wake up

       // songNames();

    /**FIELDS DECLARATIONS AND INITIALIZATIONS*/
        int input;
        String choice = "i";
         int stop = 1;
        var scanner = new Scanner(System.in);

        /**ACTUAL PROGRAM**/
        while (!(choice.equalsIgnoreCase("no"))) {
            System.out.println("Please enter any number from 0 to 10 to play a song: ");
            input = scanner.nextInt();
           /** EDGE CASE HANDLING **/
            if (input > 10) {
                input = 0;
            }

            musicOrganizer.play(input);

            //implementing a stop function
            System.out.println("Please press the zero key at any instance to stop the song permanently");
           do {
               stop = scanner.nextInt();
           }
           while (stop!=0);

           musicOrganizer.stop();

            System.out.println("Would you like to continue? Type no to exit, type another word to continue");
                choice = scanner.next();

        }



    }
/**This method was previously used to display the names of the songs **/
    private static void songNames() {
        System.out.println("00: Bad Moon Rising \n01:Sci-Fi Song \n02: You know You like it by DJ Snake \n03: Theme of Laura \n4: Hope County \n05: Viviladi \n06:British Grenediers \n07: Mera Laung Gawach");
        System.out.println("08: Time to Wake Up by Cactii  \n09: Milo na tum \n10: Ra Ra Rasputin by Boney\n");
    }
}




   