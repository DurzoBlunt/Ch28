import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise1 {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.print("Enter a file name: ");
        @SuppressWarnings("resource")
        Scanner inputFileName = new Scanner(System.in);
        String fileName = inputFileName.nextLine();
        Scanner inputGraph = new Scanner(new File(fileName));
        int numberOfVertices = inputGraph.nextInt();
        inputGraph.nextLine();
        System.out.println("The number of vertices is " + numberOfVertices);
        ArrayList<Integer> vertices = new ArrayList<>();
        ArrayList<AbstractGraph.Edge> edges = new ArrayList<>();
        for (int i = 0; i < numberOfVertices; i++) {
            Scanner inputVertic = new Scanner(inputGraph.nextLine());
            int vertex = inputVertic.nextInt();
            vertices.add(vertex);
            while (inputVertic.hasNext()) {
                edges.add(new AbstractGraph.Edge(vertex, inputVertic.nextInt()));
            }
            inputVertic.close();
        }
        inputGraph.close();
        UnweightedGraph<Integer> graph = new UnweightedGraph<>(edges, vertices);
        graph.printEdges();

        if (graph.dfs(0).getNumberOfVerticesFound() == numberOfVertices) {
            System.out.print("The graph is connected");
        } else {
            System.out.print("The graph is not connected");
        }
    }
}