public class Song {
    private String songName;
    private MyNode songGenre;
    private Artist artist;

    public Song (String name, MyNode genre, Artist artist) {
        this.songName = name;
        this.songGenre = genre;
        this.artist = artist;
    }

    public String getName() {
        return this.songName;
    }

    public String getGenreString() {
        return songGenre.getData();
    }


    public Artist getArtist() {
        return this.artist;
    }

}
