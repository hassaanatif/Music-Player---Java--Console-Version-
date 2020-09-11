/* OOP ASSGINMENT #2
NAME: M.Hassaan Atif
Roll no: 0147-BSCS-2019 (Section C)

 */ 

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

/**NOTE:  I HAD TAKEN SEVERAL APPROACHES THROUGHOUT THE CREATION OF THIS PROJECT. I ACTUALLY HAD DONE IT MORE THAN 3 TIMES,
 * EACH TIME USING A DIFFERENT APPROACH THAN WHAT I HAD USED PREVIOUSLY. AT THE END, I HAVE DECIDED TO SETTLE WITH WHAT I
 * THINK IS THE MOST EFFICIENT. SOME PORTION OF THIS APPROACH HAS BEEN BORROWED FROM THE EXAMPLE CODE OF THE javazoom LIBRARY
 * THE REST WAS DONE ALL ON MY OWN.
 */


public class MOrganizer {
    ArrayList<String> tracks = new ArrayList<String>();

    private MPlayer musicP= new MPlayer();

    //this below is the previously used playlist array. Elements were fed manually here using the path variable
   // private ArrayList<String> playlist = new ArrayList<>();
/** CONSTRUCTOR FROM WHERE WE CAN PUT ALL THE SONGS */

MOrganizer () {
    /**THESE ARE ALL THE SONGS THAT I HAD PREVIOUSLY ADDED TO MY LIST 'MANUALLY'**/
/*

    addSong(Paths.get("").toAbsolutePath().toString() + "\\Songs\\badmoon.mp3"); //0 --
    addSong(Paths.get("").toAbsolutePath().toString() + "\\Songs\\cable.mp3");//1
    addSong(Paths.get("").toAbsolutePath().toString() + "\\Songs\\djSnake.mp3"); //2 --
    addSong(Paths.get("").toAbsolutePath().toString() + "\\Songs\\laura.mp3"); //3 --
    addSong(Paths.get("").toAbsolutePath().toString() + "\\Songs\\hopecounty.mp3"); //4
    addSong(Paths.get("").toAbsolutePath().toString() + "\\Songs\\vivaldi.mp3"); //5
    addSong(Paths.get("").toAbsolutePath().toString() + "\\Songs\\brit.mp3"); //6
    addSong(Paths.get("").toAbsolutePath().toString() + "\\Songs\\laung.mp3");//7
    addSong(Paths.get("").toAbsolutePath().toString() + "\\Songs\\wakeUp.mp3");//8 --
    addSong(Paths.get("").toAbsolutePath().toString() + "\\Songs\\milo.mp3");//9
    addSong(Paths.get("").toAbsolutePath().toString() + "\\Songs\\rasputin.mp3");//10
*/
    //addListOfSongs();

    /**THIS IS AN ALTERNATIVE IMPLEMENTATION, IN WHICH I HAD TAKEN THE ADVANTAGE OF USING THE READTRACK FUNCTION
     * IT WAS SPECIFIED IN THE javazoom EXAMPLE CODE, AND I THINK IT'S QUITE EFFICIENT BECAUSE IT AUTOMATICALLY READS ALL
     * THE FILES FROM THE DIRECTORY.
     */

    readTracks("Songs", ".mp3");
    listOfSongs();


}
/******MAIN FUNCTION (FOR TESTING PURPOSES) *****/
public static void main (String args []) {
    MOrganizer musicOrganizer = new MOrganizer();
    var read = musicOrganizer.readTracks("Songs", ".mp3");
    //musicOrganizer.Play(0);
    musicOrganizer.listOfSongs();


}

/** METHODS **/
           //These commentated methods were previously used, when I had to insert the songs manually
   /* private void addSong (String filepath) {
       playlist.add(filepath);
    }
    private void addSong (File file) {
        playlist.add(file.toString());
    } */

/**DISPLAYING THE LIST OF SONGS IN OUR PLAYLIST**/
    public void listOfSongs() {
        File file;
       for(int i = 0; i<11; i++) {
           file = new File(tracks.get(i));
        System.out.println(i + ":" + file.getName());

       }
    }



    public void play(int index) {
        var ind = tracks.get(index);
        musicP.playSong(ind);
    }
    public void stop ()  {
        musicP.stop();
    }


    public ArrayList<String> readTracks(String folder, final String suffix)
    {
        File audioFolder = new File(folder);
       // ArrayList<String> tracks = new ArrayList<String>();
        File[] audioFiles = audioFolder.listFiles(new FilenameFilter() {

            public boolean accept(File dir, String name)
            {
                return name.toLowerCase().endsWith(suffix);
            }
        });
        for (File c : audioFiles)
            tracks.add(c.toString());
        return  tracks;


    }

}





