import java.util.LinkedHashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class Catalog {
    private List<Artist> artists;
    private List<Compilation> compilations;

    public Catalog() {
        this.artists = new ArrayList<>();
        this.compilations = new ArrayList<>();
    }

    public void addArtist(Artist artist) {
        this.artists.add(artist);
    }

    public void addCompilation(Compilation comp) {
        this.compilations.add(comp);
    }


    private ArrayList<Song> getSongsBySubgenre(String genreName) {
        // поиск песни по поджанру
        ArrayList<Song> searchedSongs = new ArrayList<Song>();
        for (Artist currArtist : this.artists) {
            for (Album currAlbum : currArtist.getAlbums()) {
                for (Song currSong : currAlbum.getSongs()) {
                    if (currSong.getGenreString().equals(genreName)) {
                        searchedSongs.add(currSong);
                    }
                }
            }
        }
        return searchedSongs;
    }

    public ArrayList<Song> getSongsByGenre(String genreName, GenresRoot treeGenres) {
        // если жанр начинается с большой буквы - то это жанр, и надо проверить его поджанры
        // иначе просто поиск песен по данному поджару
        if (Character.isUpperCase(genreName.charAt(0))) {
            GenreNode parentGenre = treeGenres.getGenreByString(genreName);
            ArrayList<Song> searchedSongs = getSongsBySubgenre(genreName);
            for (SubgenreNode childgenre : parentGenre.getSubgenres()) {
                searchedSongs.addAll(getSongsBySubgenre(childgenre.getName()));
            }
            return searchedSongs;
        } else
            return getSongsBySubgenre(genreName);
    }

    public ArrayList<Song> getSongsByYear(int year, GenresRoot treeGenres) {
        ArrayList<Song> searchedSongs = new ArrayList<Song>();
        for (Artist currArtist : this.artists) {
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
        for (Artist currArtist : this.artists) {
            for (Album currAlbum : currArtist.getAlbums()) {
                for (Song currSong : currAlbum.getSongs()) {
                    if (currSong.getGenreString().equals(genre)) {
                        searchedArtists.add(currSong.getArtist());
                        break;
                    }
                }
            }
        }
        return searchedArtists;
    }

    public ArrayList<Artist> searchForArtists(String genreName, GenresRoot treeGenres) {
        ArrayList<Artist> searchedArtists = getArtistsBySubgenre(genreName);
        if (Character.isUpperCase(genreName.charAt(0))) {
            GenreNode parentGenre = treeGenres.getGenreByString(genreName);
            for (SubgenreNode childgenre : parentGenre.getSubgenres()) {
                searchedArtists.addAll(getArtistsBySubgenre(childgenre.getName()));
            }
        }
        Set<Artist> setArtists = new LinkedHashSet<Artist>(searchedArtists);  //удалить повторяющихся исполнителей
        return new ArrayList<Artist>(setArtists);
    }
}
