import java.util.List;
import java.util.ArrayList;

public class Catalog {
    private List<Album> albumsList;
    private List<Compilation> compilationsList;

    public Catalog() {
        this.albumsList = new ArrayList<>();
        this.compilationsList = new ArrayList<>();
    }

    public void addAlbum(Album album) {
        this.albumsList.add(album);
    }

    public void addCompilation(Compilation comp) {
        this.compilationsList.add(comp);
    }

    private ArrayList<Song> searchSongsSpecifiedGenre(String genre) {
        ArrayList<Song> searchedSongs = new ArrayList<Song>();

        for (Album albumfromlist : this.albumsList) {
            for (Song currsong : albumfromlist.getSongs()){
                if (currsong.getGenreString().equals(genre))
                    searchedSongs.add(currsong);
            }
    }

        return searchedSongs;
    }

    public ArrayList<Song> searchForSongs(String genre, MyNode treeGenres) {
        if (Character.isUpperCase(genre.charAt(0))) {
            MyNode parentGenre = treeGenres.searchNode(genre);
            ArrayList<Song> searchedSongs = searchSongsSpecifiedGenre(genre);
            for (MyNode childgenre : parentGenre.getChildren()) {
                searchedSongs.addAll(searchSongsSpecifiedGenre(childgenre.getData()));
            }
            return searchedSongs;
        }
        else
            return searchSongsSpecifiedGenre(genre);
    }


    public ArrayList<Artist> searchForArtists(String genre) {
        ArrayList<Artist> artistList = new ArrayList<Artist>();
        for (Album albumfromlist : this.albumsList) {
            for (Song currsong : albumfromlist.getSongs()) {
                if (currsong.getGenreString().equals(genre)) {
                    artistList.add(currsong.getArtist());
                    break;
                }
            }
        }

        return artistList;
    }
}
