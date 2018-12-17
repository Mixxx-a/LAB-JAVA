import java.util.ArrayList;
import java.util.List;

public class GenreNode {
    private String data;
    private GenreNode parent;
    private List<GenreNode> children;

    public GenreNode(String data) {
        this.data = data;
        this.children = new ArrayList<GenreNode>();
    }

    public void addChild(String childData, GenreNode parentNode) {
        GenreNode childNode = new GenreNode(childData);
        childNode.parent = parentNode;
        parentNode.children.add(childNode);
    }

    public GenreNode getChildI(int i) { //just for getting children from root, without search. for fast input of subgenres
        return this.children.get(i);
    }

    public List<GenreNode> getChildren() {
        return this.children;
    }

    public String getData() {
        return this.data;
    }

    public GenreNode searchNode(String name) {
        if (Character.isUpperCase(name.charAt(0))) {
            for(GenreNode node: children){
                if (node.data.equals(name)) {
                    return node;
                }
            }
        }
        else {
            for(GenreNode node: children){
                for (GenreNode childnode: node.children) {
                    if (childnode.data.equals(name))
                        return childnode;
                }
            }
        }
        return null;
    }
}
