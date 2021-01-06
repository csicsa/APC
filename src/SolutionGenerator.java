import java.util.*;

public class SolutionGenerator {

    public List<Integer> generateSolution(List<Integer> machines, int n, List<Integer> result, int startIndex) {
        if (n == 0) {
            return result;
        }
        for (int i = startIndex; i >= 0 && i < machines.size(); i--) {
            if (machines.get(i) <= n) {
                int remaining = n - machines.get(i);
                result.add(machines.get(i));
                machines.remove(i);
                return generateSolution(machines, remaining, result, startIndex - 1);
            }
        }
        return Collections.EMPTY_LIST;
    }
}
