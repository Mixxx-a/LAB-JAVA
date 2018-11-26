import java.util.ArrayList;

public class LAB2 {
    public static void main(String[] args) {

        //Limitation: songs can be only in albums
        //Genre starts with capital letter, subgenre - with small letter

        // Creating genres DB
        MyNode GenresTree = new MyNode("Genres");
        GenresTree.addChild("POP", GenresTree);
        GenresTree.addChild("ROCK", GenresTree);
        GenresTree.addChild("RAP", GenresTree);
        GenresTree.addChild("CLASSICAL", GenresTree);

        GenresTree.addChild("dance_pop", GenresTree.getChildI(0));
        GenresTree.addChild("electro_pop", GenresTree.getChildI(0));

        GenresTree.addChild("metal", GenresTree.getChildI(1));
        GenresTree.addChild("hard_rock", GenresTree.getChildI(1));
        GenresTree.addChild("alternative_rock", GenresTree.getChildI(1));

        GenresTree.addChild("opera", GenresTree.getChildI(3));
        GenresTree.addChild("medieval", GenresTree.getChildI(3));
        GenresTree.addChild("baroque", GenresTree.getChildI(3));


        Artist artistEminem = new Artist("Eminem");
        Artist artistRammstein = new Artist("Rammstein");


        Song songEminem1 = new Song("Venom", GenresTree.searchNode("RAP"), artistEminem);
        Song songEminem2 = new Song ("Berzerk", GenresTree.searchNode("RAP"), artistEminem);
        Song songRammstein1 = new Song("Sonne",  GenresTree.searchNode("metal"), artistRammstein);
        Song songRammstein2 = new Song("Ohne dich", GenresTree.searchNode("hard_rock"), artistRammstein);

        Album albumEminem1 = new Album("Kamikadze", artistEminem);
        albumEminem1.addSong(songEminem1);
        albumEminem1.addSong(songEminem2);

        Album albumRammstein1 = new Album("Sonne", artistRammstein);
        albumRammstein1.addSong(songRammstein1);
        albumRammstein1.addSong(songRammstein2);

        Catalog catalog = new Catalog();
        catalog.addAlbum(albumEminem1);
        catalog.addAlbum(albumRammstein1);

        ArrayList<Song> ans1 = catalog.searchForSongs("RAP", GenresTree);    // 2 songs
        System.out.println(ans1);
        ArrayList<Song> ans2 = catalog.searchForSongs("metal", GenresTree);  // 1 song
        ArrayList<Song> ans3 = catalog.searchForSongs("hard_rock", GenresTree);  // 1 song
        ArrayList<Song> ans4 = catalog.searchForSongs("ROCK", GenresTree);  // 2 songs

        ArrayList<Artist> ans5 = catalog.searchForArtists("RAP");
        ArrayList<Artist> ans6 = catalog.searchForArtists("metal");
        ArrayList<Artist> ans7 = catalog.searchForArtists("hard_rock");
        ArrayList<Artist> ans8 = catalog.searchForArtists("ROCK");

    }
}
