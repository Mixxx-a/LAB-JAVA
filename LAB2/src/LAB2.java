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
        Artist artistEisbrecher = new Artist("Eisbrecher");

        Song songEminem1 = new Song("Venom", GenresTree.searchNode("RAP"), artistEminem, 2018);
        Song songEminem2 = new Song ("Berzerk", GenresTree.searchNode("RAP"), artistEminem, 2013);
        Song songRammstein1 = new Song("Sonne",  GenresTree.searchNode("metal"), artistRammstein, 2005);
        Song songRammstein2 = new Song("Ohne dich", GenresTree.searchNode("hard_rock"), artistRammstein, 2013);
        Song songEisbrecher1 = new Song("Verruckt", GenresTree.searchNode("hard_rock"), artistEisbrecher, 2015);

        Album albumEminem1 = new Album("Kamikadze", artistEminem);
        albumEminem1.addSong(songEminem1);
        albumEminem1.addSong(songEminem2);

        Album albumRammstein1 = new Album("Sonne", artistRammstein);
        albumRammstein1.addSong(songRammstein1);
        albumRammstein1.addSong(songRammstein2);

        Album albumEisbrecher = new Album("Eiskalt", artistEisbrecher);
        albumEisbrecher.addSong(songEisbrecher1);

        Catalog catalog = new Catalog();
        catalog.addAlbum(albumEminem1);
        catalog.addAlbum(albumRammstein1);
        catalog.addAlbum(albumEisbrecher);

        ArrayList<Song> ans1 = catalog.searchForSongs("RAP", GenresTree);    // 2 songs
        for (Song item: ans1)
            System.out.print(item.getName() + ", ");
        System.out.println();

        ArrayList<Song> ans2 = catalog.searchForSongs("metal", GenresTree);  // 1 song
        for (Song item: ans2)
            System.out.print(item.getName() + ", ");
        System.out.println();

        ArrayList<Song> ans3 = catalog.searchForSongs("hard_rock", GenresTree);  // 2 song
        for (Song item: ans3)
            System.out.print(item.getName() + ", ");
        System.out.println();

        ArrayList<Song> ans4 = catalog.searchForSongs("ROCK", GenresTree);  // 3 songs
        for (Song item: ans4)
            System.out.print(item.getName() + ", ");
        System.out.println();
        System.out.println();

        ArrayList<Song> ans5 = catalog.searchForSongs(2005, GenresTree);  // 1 song
        for (Song item: ans5)
            System.out.print(item.getName() + ", ");
        System.out.println();

        ArrayList<Song> ans6 = catalog.searchForSongs(2013, GenresTree);  // 2 songs
        for (Song item: ans6)
            System.out.print(item.getName() + ", ");
        System.out.println();
        System.out.println();

        ArrayList<Artist> ans7 = catalog.searchForArtists("RAP", GenresTree);  // 1 artist
        for (Artist item: ans7)
            System.out.print(item.getName() + ", ");
        System.out.println();

        ArrayList<Artist> ans8 = catalog.searchForArtists("metal", GenresTree);  // 1 artist
        for (Artist item: ans8)
            System.out.print(item.getName() + ", ");
        System.out.println();

        ArrayList<Artist> ans9 = catalog.searchForArtists("hard_rock", GenresTree);  // 2 artists
        for (Artist item: ans9)
            System.out.print(item.getName() + ", ");
        System.out.println();

        ArrayList<Artist> ans10 = catalog.searchForArtists("ROCK", GenresTree);  // 2 artists
        for (Artist item: ans10)
            System.out.print(item.getName() + ", ");
        System.out.println();

    }
}
