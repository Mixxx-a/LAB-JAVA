public class SubgenreNode {

    private String name;
    private GenreNode parent;

    public SubgenreNode(String name, GenreNode parent)
    {
        this.name = name;
        this.parent = parent;
    }

    public String getName() {
        return this.name;
    }



}
