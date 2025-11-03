import java.util.*;

public class KruskalAlgorithm {
    public static Result run(Graph graph) {
        long startTime = System.nanoTime();

        List<Edge> edgeList = new ArrayList<>(graph.getEdges());
        edgeList.sort(Comparator.comparingInt(Edge::getWeight));

        UnionFind unionFind = new UnionFind(graph.getNodes());
        List<Edge> mstEdges = new ArrayList<>();
        int totalCost = 0;
        int operationCount = 0;

        for (Edge edge : edgeList) {
            operationCount++;
            if (unionFind.find(edge.getFrom()) != unionFind.find(edge.getTo())) {
                mstEdges.add(edge);
                totalCost += edge.getWeight();
                unionFind.union(edge.getFrom(), edge.getTo());
            }
        }

        long endTime = System.nanoTime();
        long executionTime = (endTime - startTime) / 1000000;

        return new Result(mstEdges, totalCost, operationCount, executionTime);
    }
}
