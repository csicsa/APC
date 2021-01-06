import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        FileIO fileIO = new FileIO();
        List<String> unparsedInput = fileIO.readInput();

        int nrOfMachines = Integer.parseInt(unparsedInput.get(0));
        List<Integer> machineThroughput = Arrays.stream(unparsedInput.get(1).split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int desiredAmount = Integer.parseInt(unparsedInput.get(2));


        machineThroughput.sort(Comparator.naturalOrder());
        SolutionGenerator solutionGenerator = new SolutionGenerator();

        int bestResult = Integer.MAX_VALUE;

        List<List<Integer>> results = new ArrayList<>();
        for (int i = nrOfMachines - 1; i > 0; i--) {
            List<Integer> possibleResult = solutionGenerator.generateSolution(new ArrayList<>(machineThroughput), desiredAmount, new ArrayList<>(), i);
            int sum = possibleResult.stream().mapToInt(Integer::intValue).sum();

            if (sum >= desiredAmount && sum <= bestResult) {
                if (sum < bestResult) {
                    bestResult = sum;
                    results = new ArrayList<>();
                }
                results.add(solutionGenerator.generateSolution(new ArrayList<>(machineThroughput), desiredAmount, new ArrayList<>(), i));
            }

        }

        System.out.print("Nr of solutions: ");
        System.out.println(results.size());
        System.out.println(results);
        System.out.print("Waste: ");
        System.out.println(bestResult - desiredAmount);

    }
}
