import java.util.ArrayList;

public class Album {
    private String name;
    private Artist artist;
    private ArrayList<Song> songs;

    public Album (String name, Artist artist) {
        this.name = name;
        this.artist = artist;
        songs = new ArrayList<Song>();
    }

    void addSong(Song song) {
        songs.add(song);
    }


}
