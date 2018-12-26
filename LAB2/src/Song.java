public class Song {
    private String name;
    private SubgenreNode genre;
    private Artist artist;
    private int year;

    public Song (String name, SubgenreNode genre, Artist artist, int year) {
        this.name = name;
        this.genre = genre;
        this.artist = artist;
        this.year = year;
    }

    public String getName() {
        return this.name;
    }

    public String getGenreString() {
        return this.genre.getName();
    }

    public Artist getArtist() {
        return this.artist;
    }

    public int getYear() {
        return this.year;
    }

}
