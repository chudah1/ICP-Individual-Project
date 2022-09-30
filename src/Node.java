import java.io.*;
import java.util.ArrayList;
import java.util.Collections;


public class Node {
    private String state;
    private String airlineCode;
    private Node parent;
    int nStops;
    private double HarvesineDistance;

    public Node(String state, String airlineCode, int nStops, Node parent, double HarvesineDistance) {
        this.state = state;
        this.parent = parent;
        this.airlineCode = airlineCode;
        this.nStops = nStops;
        this.HarvesineDistance = HarvesineDistance;

    }

    public Node(String state) {
        this.state = state;
        this.parent = null;
        this.airlineCode = "";
        this.nStops = 0;
        this.HarvesineDistance = 0;

    }


    public String getState() {
        return state;
    }

    public String getAirlineCode() {
        return airlineCode;
    }

    public Node getParent() {
        return parent;
    }

    @Override
    // This function is used to check if the current node is equal to the node passed as a parameter.
    public boolean equals(Object obj) {
        if (obj == this) return true;

        if (!(obj instanceof Node)) return false;

        Node node = (Node) obj;

        return this.state.equals(node.state);

    }

    /**
     * This function is used to print the solution path to a file
     */
    public void solutionPath() {
        ArrayList<String> solution = new ArrayList<>();
        String path = "";
        Node curr = this;
        while (curr.parent != null) {
            path = curr.getAirlineCode() + " from " + curr.getParent().getState() + " to " + curr.getState() + " " + curr.nStops + " stops";
            solution.add(path);
            curr = curr.parent;
        }
        Collections.reverse(solution);

        try {
            FileWriter myWriter = new FileWriter("accra-london_output.txt");
            PrintWriter printWriter = new PrintWriter(myWriter);
            // Used to count the number of stops in the solution path.
            int noStops = 0;
            for (String solutionpath : solution) {
                printWriter.println(solutionpath);
                noStops += Integer.parseInt(solutionpath.split(" ")[5]);
            }
            printWriter.println("Total flights: " + "" + solution.size());
            printWriter.println("Total additional stops: " + "" + noStops);
            printWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public double getHarvesineDistance() {
        return HarvesineDistance;
    }
}
