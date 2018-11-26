import java.util.LinkedHashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

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
            for (Song currsong : albumfromlist.getSongs()) {
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
        } else
            return searchSongsSpecifiedGenre(genre);
    }

    public ArrayList<Song> searchForSongs(int year, MyNode treeGenres) {
        ArrayList<Song> songList = new ArrayList<Song>();
        for (Album albumfromlist : this.albumsList) {
            for (Song currsong : albumfromlist.getSongs()) {
                if (currsong.getYear() == year) {
                    songList.add(currsong);
                }
            }
        }
        return songList;
    }

    private ArrayList<Artist> searchArtistsSpecifiedGenre(String genre) {
        ArrayList<Artist> searchedArtists = new ArrayList<Artist>();
        for (Album albumfromlist : this.albumsList) {
            for (Song currsong : albumfromlist.getSongs()) {
                if (currsong.getGenreString().equals(genre)) {
                    searchedArtists.add(currsong.getSongArtist());
                    break;
                }
            }
        }
        return searchedArtists;
    }

    public ArrayList<Artist> searchForArtists(String genre, MyNode treeGenres) {
        ArrayList<Artist> searchedArtists = searchArtistsSpecifiedGenre(genre);
        if (Character.isUpperCase(genre.charAt(0))) {
            MyNode parentGenre = treeGenres.searchNode(genre);
            for (MyNode childgenre : parentGenre.getChildren()) {
                searchedArtists.addAll(searchArtistsSpecifiedGenre(childgenre.getData()));
            }
        }
        Set<Artist> setArtists = new LinkedHashSet<Artist>(searchedArtists);  //удалить повторяющихся исполнителей
        return new ArrayList<Artist>(setArtists);
    }
}
