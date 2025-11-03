import org.json.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class InputOutputHelper {
    public static Graph readGraphFromFile(String filePath) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        JSONObject json = new JSONObject(content);
        return new Graph(json.getJSONArray("graphs").getJSONObject(0));
    }

    public static void writeResultsToFile(JSONObject result, String filePath) throws IOException {
        try (FileWriter file = new FileWriter(filePath)) {
            file.write(result.toString(4));
        }
    }
}
