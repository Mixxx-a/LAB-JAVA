public class Song {
    private String songName;
    private GenreNode songGenre;
    private Artist songArtist;
    private int year;

    public Song (String name, GenreNode genre, Artist songArtist, int year) {
        this.songName = name;
        this.songGenre = genre;
        this.songArtist = songArtist;
        this.year = year;
    }

    public String getName() {
        return this.songName;
    }

    public String getGenreString() {
        return songGenre.getData();
    }

    public Artist getSongArtist() {
        return this.songArtist;
    }

    public int getYear() {
        return this.year;
    }

}
