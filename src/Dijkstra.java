import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Dijkstra {

    public static void main(String[] args) {
        Node v1 = new Node("v1");
        Node v2 = new Node("v2");
        Node v3 = new Node("v3");
        Node v4 = new Node("v4");
        Node v5 = new Node("v5");
        Node v6 = new Node("v6");

        v1.list = List.of(
                new bian(9, v3),
                new bian(7, v2),
                new bian(16, v6));
        v3.list = List.of(
                new bian(11, v4),
                new bian(2, v6));
        v2.list = List.of(new bian(15, v4));
        v4.list = List.of(new bian(6, v5));
        v6.list = List.of(new bian(9, v5));
        v5.list = List.of();

        List<Node> v7 = List.of(v1, v2, v3, v4, v5, v6);
        di(v7,v1);
        dfs(v1,new ArrayList<>());
        System.out.println();
        bfs(v1);
    }

    static void di(List<Node> nodeList,Node root){
        ArrayList<Node> list = new ArrayList<>(nodeList);
        root.distance = 0;

        while (!list.isEmpty()){
            Node node = list.stream().min(Comparator.comparing(s -> s.distance)).orElse(null);

            node.list.stream().filter(s -> list.contains(s.next)).forEach(
                    s -> {
                        s.next.distance = Integer.min(s.line + node.distance,s.next.distance);
                    }
            );

            list.remove(node);

        }
        for (Node node1 : nodeList) {
            System.out.println(node1.name + " " + node1.distance);
        }
    }

    static void dfs(Node root,List<Node> nodeList){
        if (nodeList.contains(root)){
            return;
        }
        nodeList.add(root);
        System.out.print(root.name + " ");
        for (bian bian : root.list) {
            dfs(bian.next,nodeList);
        }
    }

    static void bfs(Node root){
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node node = queue.pop();
            System.out.print(node.name + " ");
            node.list.stream().filter(s -> !queue.contains(s.next)).forEach(
                    s -> queue.add(s.next)
            );
        }
    }
}

class Node{

    String name;
    Node next;
    int distance = Integer.MAX_VALUE;
    List<bian> list;

    public Node(String name){
        this.name = name;
    }
    public Node(int distance, List<bian> list){
        this.distance = distance;
        this.list = list;
    }
}

class bian{
    int line;
    Node next;
    public bian(int line){
        this.line = line;
    }
    public bian(int line, Node next){
        this.line = line;
        this.next = next;
    }

}