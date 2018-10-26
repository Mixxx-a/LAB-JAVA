public class LAB2 {
    public static void main(String[] args) {

        Song songEminem1 = new Song("Venom");
        Song songEminem2 = new Song ("Berzerk");
        Song songRammstein1 = new Song("Sonne");
        Song songRammstein2 = new Song("Ohne dich");

        Artist artistEminem = new Artist("Eminem");
        Artist artistRammstein = new Artist("Rammstein");

        Album albumEminem1 = new Album("Kamikadze", artistEminem);
        albumEminem1.addSong(songEminem1);
        albumEminem1.addSong(songEminem2);

        Album albumRammstein1 = new Album("Sonne", artistRammstein);
        albumRammstein1.addSong(songRammstein1);
        albumRammstein1.addSong(songRammstein2);

        Catalog catalog = new Catalog();
        catalog.addAlbum(albumEminem1);
        catalog.addAlbum(albumRammstein1);

    }
}
