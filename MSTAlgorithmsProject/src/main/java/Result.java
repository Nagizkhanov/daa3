import java.util.List;

public class Result {
    private List<Edge> mstEdges;
    private int totalCost;
    private int operationCount;
    private long executionTime;

    public Result(List<Edge> mstEdges, int totalCost, int operationCount, long executionTime) {
        this.mstEdges = mstEdges;
        this.totalCost = totalCost;
        this.operationCount = operationCount;
        this.executionTime = executionTime;
    }

    public List<Edge> getMstEdges() {
        return mstEdges;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public int getOperationCount() {
        return operationCount;
    }

    public long getExecutionTime() {
        return executionTime;
    }
}
