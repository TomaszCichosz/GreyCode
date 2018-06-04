import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {  //http://pl.spoj.com/problems/PP0505D/
    public static void main(String[] args) throws IOException {
        int t, n;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        List<String> grayCodeArray = new ArrayList<>(Arrays.asList("0", "1"));

        t = Integer.parseInt(reader.readLine());
        for (int testNumber = 1; testNumber <= t; testNumber++) {
            n = Integer.parseInt(reader.readLine());
            grayCodeArray = grayCodeArrayCreator(n, grayCodeArray);
            printArray(grayCodeArray, writer);
            writer.println();
            grayCodeArray.clear();
            grayCodeArray.add("0");
            grayCodeArray.add("1");
        }
        writer.close();
    }

    private static List<String> grayCodeArrayCreator(int lengthOfBinaryString, List<String> grayCodeArray) {
        while (lengthOfBinaryString > 1) {
            grayCodeArray = arrayExtender(grayCodeArray);
            grayCodeArray = arrayFiller(grayCodeArray);
            return grayCodeArrayCreator(--lengthOfBinaryString, grayCodeArray);
        }
        return grayCodeArray;
    }

    private static List<String> arrayExtender(List<String> grayCodeArray) {
        int size = grayCodeArray.size();
        for (int i = 0; i < size; i++) {
            grayCodeArray.add(size + i, grayCodeArray.get(size - (i + 1)));
        }
        return grayCodeArray;
    }

    private static List<String> arrayFiller(List<String> grayCodeArray) {
        int size = grayCodeArray.size();
        for (int j = 0; j < size; j++) {
            if (j < size / 2) {
                grayCodeArray.set(j, "0".concat(grayCodeArray.get(j)));
            } else {
                grayCodeArray.set(j, "1".concat(grayCodeArray.get(j)));
            }
        }
        return grayCodeArray;
    }

    private static void printArray(List<String> grayCodeArray, PrintWriter writer) {
        for (String temp : grayCodeArray) {
            writer.println(temp);
        }
    }
}
