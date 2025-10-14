package miscellaneous;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReadingLargeFile {

    public static void main(String[] args) throws IOException {
         java8();
         usingBuffredReader();
         usingParallelStream();
         usingBuffredReaderAndStream();
         extremlyLargeFile();
    }


    /*
    Files.lines(Path) returns a lazy Stream of lines.
    It does not load the entire file into memory — it reads line-by-line as needed.
    The file is automatically closed at the end of the try-with-resources block.
    Perfect for huge files (GBs).
    */
    static void java8(){
        Path path = Paths.get("largefile.txt");

        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(line -> {
                // process each line
                System.out.println(line);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void usingBuffredReader(){
        try (BufferedReader br = new BufferedReader(new FileReader("largefile.txt"))) {
            br.lines().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void usingBuffredReaderAndStream() throws IOException {
        try (BufferedReader br = Files.newBufferedReader(Paths.get("largefile.txt"))) {
            br.lines()
                    .filter(line -> !line.isBlank())
                    .forEach(System.out::println);
        }
    }

    //Use .parallel() only for CPU-bound tasks (not I/O-bound), or you may hurt performance.
    static void usingParallelStream() throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get("largefile.txt"))) {
            lines.parallel()
                    .filter(line -> line.contains("ERROR"))
                    .forEach(System.out::println);
        }

    }

    //The manual readLine() loop is still one of the most memory-efficient methods possible.
    //You can tune the buffer size (e.g., 16 KB, 64 KB) depending on the workload.
    static void extremlyLargeFile(){
        try (BufferedReader br = new BufferedReader(new FileReader("hugefile.txt"), 16 * 1024)) {
            String line;
            while ((line = br.readLine()) != null) {
                // process
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
