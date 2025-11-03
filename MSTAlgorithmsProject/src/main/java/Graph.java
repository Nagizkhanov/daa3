import org.json.JSONArray;
import org.json.JSONObject;
import java.util.*;

public class Graph {
    private List<String> nodes;
    private List<Edge> edges;

    public Graph(JSONObject graphData) {
        this.nodes = new ArrayList<>();
        this.edges = new ArrayList<>();


        JSONArray nodesData = graphData.getJSONArray("nodes");
        for (int i = 0; i < nodesData.length(); i++) {
            this.nodes.add(nodesData.getString(i));
        }


        JSONArray edgesData = graphData.getJSONArray("edges");
        for (int i = 0; i < edgesData.length(); i++) {
            JSONObject edgeData = edgesData.getJSONObject(i);
            this.edges.add(new Edge(edgeData.getString("from"), edgeData.getString("to"), edgeData.getInt("weight")));
        }
    }

    public List<String> getNodes() {
        return nodes;
    }

    public List<Edge> getEdges() {
        return edges;
    }
}
