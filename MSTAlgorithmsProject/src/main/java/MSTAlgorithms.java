import org.json.JSONObject;
import org.json.JSONArray;
import java.io.IOException;
import java.util.*;

public class MSTAlgorithms {
    public static void main(String[] args) throws IOException {

        String[] inputFiles = {
                "src/main/resources/input_example_1.json",
                "src/main/resources/input_example_2.json",
                "src/main/resources/input_example_3.json",
                "src/main/resources/input_example_4.json",
                "src/main/resources/input_example_5.json",
                "src/main/resources/input_example_6.json"
        };

        for (int i = 0; i < inputFiles.length; i++) {
            String inputFilePath = inputFiles[i];

            String outputFilePath = "src/main/resources/output_result_" + (i + 1) + ".json";


            Graph graph = InputOutputHelper.readGraphFromFile(inputFilePath);


            Result primResult = PrimAlgorithm.run(graph);
            Result kruskalResult = KruskalAlgorithm.run(graph);


            JSONObject result = new JSONObject();
            result.put("graph_id", i + 1);
            result.put("input_stats", new JSONObject()
                    .put("vertices", graph.getNodes().size())
                    .put("edges", graph.getEdges().size()));

            result.put("prim", new JSONObject()
                    .put("mst_edges", convertToJSONArray(primResult.getMstEdges()))
                    .put("total_cost", primResult.getTotalCost())
                    .put("operations_count", primResult.getOperationCount())
                    .put("execution_time_ms", primResult.getExecutionTime()));

            result.put("kruskal", new JSONObject()
                    .put("mst_edges", convertToJSONArray(kruskalResult.getMstEdges()))
                    .put("total_cost", kruskalResult.getTotalCost())
                    .put("operations_count", kruskalResult.getOperationCount())
                    .put("execution_time_ms", kruskalResult.getExecutionTime()));


            InputOutputHelper.writeResultsToFile(result, outputFilePath);

            System.out.println("Results for input " + (i + 1) + " saved to " + outputFilePath);
        }
    }

    
    private static JSONArray convertToJSONArray(List<Edge> mstEdges) {
        JSONArray mstEdgesArray = new JSONArray();
        for (Edge edge : mstEdges) {
            JSONObject edgeJson = new JSONObject();
            edgeJson.put("from", edge.getFrom());
            edgeJson.put("to", edge.getTo());
            edgeJson.put("weight", edge.getWeight());
            mstEdgesArray.put(edgeJson);
        }
        return mstEdgesArray;
    }
}
