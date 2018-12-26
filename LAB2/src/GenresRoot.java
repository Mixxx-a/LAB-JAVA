import java.util.ArrayList;
import java.util.List;

public class GenresRoot {

    private String name;
    private List<GenreNode> genres;

    public GenresRoot(String name) {
        this.name = name;
        this.genres = new ArrayList<GenreNode>();
    }

    public void addGenre(GenreNode genre){
        this.genres.add(genre);
    }

    public GenreNode getGenreByString(String name) {
        for (GenreNode genre : genres) {
            if (genre.getName().equals(name)) {
                return genre;
            }
        }
        return null;
    }

    /* public GenresRoot searchNode(String name) {
        if (Character.isUpperCase(name.charAt(0))) {
            for(GenreNode node: genres){
                if (node.getName().equals(name)) {
                    return node;
                }
            }
        }
        else {
            for(GenresRoot node: children){
                for (GenresRoot childnode: node.children) {
                    if (childnode.data.equals(name))
                        return childnode;
                }
            }
        }
        return null;
    } */
}
