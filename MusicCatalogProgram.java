//library statements for improving readability of code
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//parent class (houses Album information)
class Album {
    private String albumName;
    private String genre;

    //constructor
    public Album(String albumName, String genre) {
        this.albumName = albumName;
        this.genre = genre;
    }

    //helper functions (getter and setter)
    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName; 
    }

    public String getGenre() { 
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void displayInfo() {
        System.out.printf("%-25s %-25s%n", "// Album: " + getAlbumName(), "// Genre: " + getGenre() + " //");
    }
}

//child class (inherits from Album class and adds Song attributes)
class Song extends Album {
    private String songName;
    private int rating;

    //constructor
    public Song(String songName, String albumName, String genre, int rating) {
        super(albumName, genre); //super function to initialize attributes from album class 
        this.songName = songName;
        this.rating = rating;
    }

    //helper functions (getter and setter)
    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating; 
    }

    @Override //ensures the displayInfo function from Album class is overriden
    public void displayInfo() {
        //printf allows us to make sure our output aligns properly
        System.out.printf("%-25s %-25s %-25s %-15s%n", "// Song: " + songName, "// Album: " + getAlbumName(), "// Genre: " + getGenre(), "// Rating: " + getRating() + " //");
    }
}

//Class that organizes Song and Album information for output
class MusicCatalog {
    private List<Song> songs = new ArrayList<>();

    public void addSong(Song song) {
        songs.add(song);
    }

    public void displayCatalog() {
        System.out.println("\n                          //     Music  Catalog     //");
        if (songs.isEmpty()) {
            System.out.println("No songs in the catalog.");
        } else {
            for (Song i : songs) {
                i.displayInfo();
            }
        }
    }
}

//main
public class MusicCatalogProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MusicCatalog catalog = new MusicCatalog();

        boolean addingSongs = true;

        while (addingSongs) {
            System.out.print("Enter song name: ");
            String songName = scanner.nextLine();

            System.out.print("Enter album name: ");
            String albumName = scanner.nextLine();

            System.out.print("Enter genre: ");
            String genre = scanner.nextLine();

            System.out.print("Enter rating from 1 to 10: ");
            int rating = Integer.parseInt(scanner.nextLine());

            Song newSong = new Song(songName, albumName, genre, rating);
            catalog.addSong(newSong);

            System.out.print("Add another song?: (y/n)");
            String response = scanner.nextLine();
            if (response.equals("n")) {
                addingSongs = false;
            }
        }

        catalog.displayCatalog();
        scanner.close();
    }
}
