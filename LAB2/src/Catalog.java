import java.util.LinkedHashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class Catalog {
    private List<Artist> artistsList;
    private List<Compilation> compilationsList;

    public Catalog() {
        this.artistsList = new ArrayList<>();
        this.compilationsList = new ArrayList<>();
    }

    public void addArtist(Artist artist) {
        this.artistsList.add(artist);
    }

    public void addCompilation(Compilation comp) {
        this.compilationsList.add(comp);
    }

    private ArrayList<Song> getSongsBySubgenre(String genre) {
        // поиск песни по поджанру
        ArrayList<Song> searchedSongs = new ArrayList<Song>();
        for (Artist currArtist : this.artistsList) {
            for (Album currAlbum : currArtist.getAlbums()) {
                for (Song currSong : currAlbum.getSongs()) {
                    if (currSong.getGenreString().equals(genre)) {
                        searchedSongs.add(currSong);
                    }
                }
            }
        }
        return searchedSongs;
    }

    public ArrayList<Song> getSongsByGenre(String genre, GenreNode treeGenres) {
        // если жанр начинается с большой буквы - то это жанр, и надо проверить его поджанры
        // иначе просто поиск песен по данному поджару
        if (Character.isUpperCase(genre.charAt(0))) {
            GenreNode parentGenre = treeGenres.searchNode(genre);
            ArrayList<Song> searchedSongs = getSongsBySubgenre(genre);
            for (GenreNode childgenre : parentGenre.getChildren()) {
                searchedSongs.addAll(getSongsBySubgenre(childgenre.getData()));
            }
            return searchedSongs;
        } else
            return getSongsBySubgenre(genre);
    }

    public ArrayList<Song> getSongsByYear(int year, GenreNode treeGenres) {
        ArrayList<Song> searchedSongs = new ArrayList<Song>();
        for (Artist currArtist : this.artistsList) {
            for (Album currAlbum : currArtist.getAlbums()) {
                for (Song currSong : currAlbum.getSongs()) {
                    if (currSong.getYear() == year) {
                        searchedSongs.add(currSong);
                    }
                }
            }
        }
        return searchedSongs;
    }

    private ArrayList<Artist> getArtistsBySubgenre(String genre) {
        ArrayList<Artist> searchedArtists = new ArrayList<Artist>();
        for (Artist currArtist : this.artistsList) {
            for (Album currAlbum : currArtist.getAlbums()) {
                for (Song currSong : currAlbum.getSongs()) {
                    if (currSong.getGenreString().equals(genre)) {
                        searchedArtists.add(currSong.getSongArtist());
                        break;
                    }
                }
            }
        }
        return searchedArtists;
    }

    public ArrayList<Artist> searchForArtists(String genre, GenreNode treeGenres) {
        ArrayList<Artist> searchedArtists = getArtistsBySubgenre(genre);
        if (Character.isUpperCase(genre.charAt(0))) {
            GenreNode parentGenre = treeGenres.searchNode(genre);
            for (GenreNode childgenre : parentGenre.getChildren()) {
                searchedArtists.addAll(getArtistsBySubgenre(childgenre.getData()));
            }
        }
        Set<Artist> setArtists = new LinkedHashSet<Artist>(searchedArtists);  //удалить повторяющихся исполнителей
        return new ArrayList<Artist>(setArtists);
    }
}
