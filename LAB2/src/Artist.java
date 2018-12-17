import java.util.ArrayList;
import java.util.List;

public class Artist {
    private String name;
    private List<Album> albumList;

    public Artist(String name) {
        this.name = name;
        this.albumList = new ArrayList<Album>();
    }

    public String getName() {
        return this.name;
    }

    public void addAlbum(Album album) {
        this.albumList.add(album);
    }

    public List<Album> getAlbums() {
        return this.albumList;
    }


}


