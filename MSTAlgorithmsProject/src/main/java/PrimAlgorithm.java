import java.util.*;

public class PrimAlgorithm {
    public static Result run(Graph graph) {
        long startTime = System.nanoTime();

        Set<String> visited = new HashSet<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(Edge::getWeight));
        List<Edge> mstEdges = new ArrayList<>();
        int totalCost = 0;
        int operationCount = 0;

        visited.add(graph.getNodes().get(0));
        for (Edge edge : graph.getEdges()) {
            if (edge.getFrom().equals(graph.getNodes().get(0))) {
                pq.add(edge);
            }
        }

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            operationCount++;
            if (visited.contains(edge.getTo())) continue;

            visited.add(edge.getTo());
            mstEdges.add(edge);
            totalCost += edge.getWeight();

            for (Edge e : graph.getEdges()) {
                if (e.getFrom().equals(edge.getTo()) && !visited.contains(e.getTo())) {
                    pq.add(e);
                }
            }
        }

        long endTime = System.nanoTime();
        long executionTime = (endTime - startTime) / 1000000;

        return new Result(mstEdges, totalCost, operationCount, executionTime);
    }
}
