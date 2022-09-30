import java.util.Comparator;

public class NodeDistanceComparator implements Comparator<Node> {

    @Override
    public int compare(Node x, Node y) {
        if (x.getHarvesineDistance() < y.getHarvesineDistance()) {
            return -1;
        }
        if (x.getHarvesineDistance() > y.getHarvesineDistance()) {
            return 1;
        }
        return 0;
    }
}

