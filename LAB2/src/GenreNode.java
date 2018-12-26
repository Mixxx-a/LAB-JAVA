import java.util.ArrayList;
import java.util.List;

public class GenreNode {

    private String name;
    private List<SubgenreNode> subgenres;

    public GenreNode(String name) {
        this.name = name;
        this.subgenres = new ArrayList<SubgenreNode>();
    }

    void addSubgenre(SubgenreNode subgenre) {
        this.subgenres.add(subgenre);
    }

    public String getName() {
        return this.name;
    }

    public List<SubgenreNode> getSubgenres() {
        return this.subgenres;
    }
}
