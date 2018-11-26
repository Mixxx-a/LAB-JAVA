import java.util.List;
import java.util.ArrayList;

public class Compilation {
    private String compilationName;
    private List<Song> songList;

    public Compilation (String name) {
        this.compilationName = name;
        this.songList = new ArrayList<>();
    }

    public void addSong (Song song) {
        this.songList.add(song);
    }
}
