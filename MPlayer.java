/* OOP ASSGINMENT #2
NAME: M.Hassaan Atif
Roll no: 0147-BSCS-2019 (Section C)

 */


import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.FactoryRegistry;
import javazoom.jl.player.advanced.AdvancedPlayer;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Scanner;

public class MPlayer {
  //field declaration
    AdvancedPlayer playMp3;


  /**CONSTRUCTOR**/
 MPlayer () {
     playMp3 = null;
 }

 /**MAIN FUNCTION**/
  public static void main (String args []) throws InterruptedException {


       /*  FileInputStream fis = new FileInputStream("C:/Users/Retroaristocrat/desktop/jpeh.mp3");
         Player playMp3 = new Player(fis);
         playMp3.play();*/
      /**TESTS FOR MY MAIN PLAYER **/
      MPlayer personalPlayer = new MPlayer();
      int choice;
      Scanner scan = new Scanner(System.in);
      personalPlayer.playSong("src/myAssignment02OOP/Songs/rasputin.mp3");
      choice = scan.nextInt();
      if(choice == 0)
          personalPlayer.stop();
      Thread.sleep(1200);
      personalPlayer.playSong("src/myAssignment02OOP/Songs/Unity.mp3");




  }

/**  Previously I had used a different (perhaps more of a "primitive" approach towards this audio player.
  I had the used the "Player" class from javazoom library in-lieu of the Advanced Player library, however,
 I was having trouble with having to stop the music, and to enhance my project even further, I had then decided
 to take the idea from the javazoom's "Music Player" class in which they had used an Advanced Player, and I no longer
 have to deal with the same issues.
 My previous code has been commentated below
 **/
/*
public void playSong (String filePath)  {
     try {
        FileInputStream fis = new FileInputStream(filePath);
        Player playMp3 = new Player(fis);
        playMp3.play();
    }
    catch (FileNotFoundException e ) {
        System.out.println("Sorry, your file was not found");
    }
     catch (JavaLayerException e) {
         System.out.println("Some error occurred ");
         System.out.println("Error name: " + e);
     }


     }
*/

/**NEW IMPLEMENTATION **/

public void playSong(final String filePath)
{
    try {
 //So here, instead of all the method calling, I decided to implement everything within a single method
        //the filePath here will always going to be a String value, even if I pass a File object from the MOrganizer class
        var stream = new BufferedInputStream(new FileInputStream(filePath));
        playMp3 = new AdvancedPlayer(stream,  FactoryRegistry.systemRegistry().createAudioDevice());


        Thread playerThread = new Thread() {
            public void run()
            {
                try {
                    playMp3.play();
                }
                catch(JavaLayerException e) {
                    System.out.println("An error occured: " + e);
                    killPlayer();
                 }

            }
        };
        playerThread.start();
    }
    catch (Exception ex) {
         killPlayer();
    }
}


    private void killPlayer()
    {
        synchronized(this) {
            if(playMp3 != null) {
                playMp3.stop();
                playMp3 = null;
            }
        }
    }
    public void stop () {
    killPlayer();
    }


}
