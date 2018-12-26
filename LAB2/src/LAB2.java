import java.util.ArrayList;
import java.util.stream.Collectors;

public class LAB2 {
    public static void main(String[] args) {

        //Ограничение: Жанры начинаются с большой буквы, а поджанры - с маленькой
        // Также нельзя задать жанры песням, только поджанры

        // Создание корня
        GenresRoot genresRoot = new GenresRoot("Genres");

        // Создание жанров
        GenreNode genrePop = new GenreNode("Pop");
        GenreNode genreRock = new GenreNode("Rock");
        GenreNode genreRap = new GenreNode("Rap");
        GenreNode genreClassical = new GenreNode("Classical");
        // Создание поджанров
        SubgenreNode subgenreNative_rap = new SubgenreNode("Native_rap", genreRap);

        SubgenreNode subgenreDance_Pop = new SubgenreNode("dance_pop", genrePop);
        SubgenreNode subgenreElectro_Pop = new SubgenreNode("electro_pop", genrePop);

        SubgenreNode subgenreMetal = new SubgenreNode("metal", genreRock);
        SubgenreNode subgenreHard_Rock = new SubgenreNode("hard_rock", genreRock);
        SubgenreNode subgenreAlternative_Rock = new SubgenreNode("alternative_rock", genreRock);

        SubgenreNode subgenreOpera = new SubgenreNode("opera", genreClassical);
        SubgenreNode subgenreMedieval = new SubgenreNode("medieval", genreClassical);
        SubgenreNode subgenreBaroque = new SubgenreNode("baroque", genreClassical);

        //Добавление к жанрам поджарнов
        genreRap.addSubgenre(subgenreNative_rap);

        genrePop.addSubgenre(subgenreDance_Pop);
        genrePop.addSubgenre(subgenreElectro_Pop);

        genreRock.addSubgenre(subgenreMetal);
        genreRock.addSubgenre(subgenreHard_Rock);
        genreRock.addSubgenre(subgenreAlternative_Rock);

        genreClassical.addSubgenre(subgenreOpera);
        genreClassical.addSubgenre(subgenreMedieval);
        genreClassical.addSubgenre(subgenreBaroque);

        // Добавление жанров в root
        genresRoot.addGenre(genreRap);
        genresRoot.addGenre(genrePop);
        genresRoot.addGenre(genreRock);
        genresRoot.addGenre(genreClassical);

        // Создание исполнителей
        Artist artistEminem = new Artist("Eminem");
        Artist artistRammstein = new Artist("Rammstein");
        Artist artistEisbrecher = new Artist("Eisbrecher");

        // Создание песен
        Song songEminem1 = new Song("Venom", subgenreNative_rap, artistEminem, 2018);
        Song songEminem2 = new Song ("Berzerk", subgenreNative_rap, artistEminem, 2013);
        Song songRammstein1 = new Song("Sonne",  subgenreMetal, artistRammstein, 2005);
        Song songRammstein2 = new Song("Ohne dich", subgenreHard_Rock, artistRammstein, 2013);
        Song songEisbrecher1 = new Song("Verruckt", subgenreHard_Rock, artistEisbrecher, 2015);

        // Создание альбомов и добавление в них песен
        Album albumEminem1 = new Album("Kamikadze");
        albumEminem1.addSong(songEminem1);
        albumEminem1.addSong(songEminem2);

        Album albumRammstein1 = new Album("Sonne");
        albumRammstein1.addSong(songRammstein1);
        albumRammstein1.addSong(songRammstein2);

        Album albumEisbrecher = new Album("Eiskalt");
        albumEisbrecher.addSong(songEisbrecher1);

        // Добавление к исполнителям альбома
        artistEminem.addAlbum(albumEminem1);
        artistRammstein.addAlbum(albumRammstein1);
        artistEisbrecher.addAlbum(albumEisbrecher);

        // Создание каталога и добавление в него исполнителей
        Catalog catalog = new Catalog();
        catalog.addArtist(artistEminem);
        catalog.addArtist(artistRammstein);
        catalog.addArtist(artistEisbrecher);

        ArrayList<Song> ans1 = catalog.getSongsByGenre("Rap", genresRoot);    // 2 songs
        System.out.println(ans1.stream().map(Song::getName).collect(Collectors.joining(", ")));
        //for (Song item: ans1)
       //     System.out.print(item.getName() + ", ");
       // System.out.println();

        ArrayList<Song> ans2 = catalog.getSongsByGenre("metal", genresRoot);  // 1 song
        for (Song item: ans2)
            System.out.print(item.getName() + ", ");
        System.out.println();

        ArrayList<Song> ans3 = catalog.getSongsByGenre("hard_rock", genresRoot);  // 2 song
        for (Song item: ans3)
            System.out.print(item.getName() + ", ");
        System.out.println();

        ArrayList<Song> ans4 = catalog.getSongsByGenre("Rock", genresRoot);  // 3 songs
        for (Song item: ans4)
            System.out.print(item.getName() + ", ");
        System.out.println();
        System.out.println();

        ArrayList<Song> ans5 = catalog.getSongsByYear(2005, genresRoot);  // 1 song
        for (Song item: ans5)
            System.out.print(item.getName() + ", ");
        System.out.println();

        ArrayList<Song> ans6 = catalog.getSongsByYear(2013, genresRoot);  // 2 songs
        for (Song item: ans6)
            System.out.print(item.getName() + ", ");
        System.out.println();
        System.out.println();

        ArrayList<Artist> ans7 = catalog.searchForArtists("Rap", genresRoot);  // 1 artist
        for (Artist item: ans7)
            System.out.print(item.getName() + ", ");
        System.out.println();

        ArrayList<Artist> ans8 = catalog.searchForArtists("metal", genresRoot);  // 1 artist
        for (Artist item: ans8)
            System.out.print(item.getName() + ", ");
        System.out.println();

        ArrayList<Artist> ans9 = catalog.searchForArtists("hard_rock", genresRoot);  // 2 artists
        for (Artist item: ans9)
            System.out.print(item.getName() + ", ");
        System.out.println();

        ArrayList<Artist> ans10 = catalog.searchForArtists("Rock", genresRoot);  // 2 artists
        for (Artist item: ans10)
            System.out.print(item.getName() + ", ");
        System.out.println();

    }
}
