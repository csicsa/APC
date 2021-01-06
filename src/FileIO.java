import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileIO {

    public List<String> readInput(){
        Scanner scanner = null;
        List<String> res = new ArrayList<>();
        try {
            scanner = new Scanner(new File("input.in"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNextLine()) {
           res.add(scanner.nextLine());

        }
        return res;
    }
}
