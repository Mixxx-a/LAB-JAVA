import java.util.ArrayList;
import java.util.List;

public class Album {
    private String nameAlbum;
    private Artist artist;
    private List<Song> songs;

    public Album (String name, Artist artist) {
        this.nameAlbum = name;
        this.artist = artist;
        songs = new ArrayList<Song>();
    }

    void addSong(Song song) {
        songs.add(song);
    }

    public List<Song> getSongs() {
        return this.songs;
    }


}
