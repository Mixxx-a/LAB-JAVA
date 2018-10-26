import java.util.ArrayList;

public class Catalog {
    private ArrayList<Album> albums;
    private ArrayList<Compilation> compilations;

    public Catalog() {
        this.albums = new ArrayList<>();
        this.compilations = new ArrayList<>();
    }

    void addAlbum(Album album) {
        this.albums.add(album);
    }

    void addCompilation(Compilation comp) {
        this.compilations.add(comp);
    }
}
