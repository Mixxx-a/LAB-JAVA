import java.util.ArrayList;
import java.util.List;

public class MyNode {
    private String data;
    private MyNode parent;
    private List<MyNode> children;

    public MyNode(String data) {
        this.data = data;
        this.children = new ArrayList<MyNode>();
    }

    public void addChild(String childData, MyNode parentNode) {
        MyNode childNode = new MyNode(childData);
        childNode.parent = parentNode;
        parentNode.children.add(childNode);
    }

    public MyNode getChildI(int i) { //just for getting children from root, without search
        return this.children.get(i);
    }

    public List<MyNode> getChildren() {
        return this.children;
    }

    public String getData() {
        return this.data;
    }

    public MyNode searchNode(String name) {
        if (Character.isUpperCase(name.charAt(0))) {
            for(MyNode node: children){
                if (node.data.equals(name)) {
                    return node;
                }
            }
        }
        else {
            for(MyNode node: children){
                for (MyNode childnode: node.children) {
                    if (childnode.data.equals(name))
                        return childnode;
                }
            }
        }
        return null;
    }
}
