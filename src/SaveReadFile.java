import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * there are a methods responsible for saving and reading files
 */
public class SaveReadFile {

    // SimpleDateFormat object; set format
    public static SimpleDateFormat simpleDateHere = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
    public static boolean readFile = false;
    public static int bestLevel1 = 0;
    public static int bestLevel2 = 0;
    public static int bestTotal = 0;

    /**
     * save files
     *
     * @throws IOException
     */
    public static void Save() throws IOException {

        StringBuilder tekstDoPliku = new StringBuilder();
        SummaryAfterLevel2.scoreLevel2 = GameStatus.levelScore();
        tekstDoPliku.append(simpleDateHere.format(new Date()));
        tekstDoPliku.append(";" + Summary.scoreLevel1);
        tekstDoPliku.append(";" + SummaryAfterLevel2.scoreLevel2);
        tekstDoPliku.append(";" + GameStatus.gameScore());
        File file = new File("GarZlota-wyniki.txt");

        // create new file if doesn't exists
        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(tekstDoPliku.toString());
        bw.newLine();
        bw.close();
    }

    /**
     * read files
     *
     * @throws IOException
     */
    public static void read() throws IOException {
        if (!SaveReadFile.readFile) {
            String path = "GarZlota-wyniki.txt";
            Charset charset = Charset.forName("UTF-8");
            List<String> lines = Files.readAllLines(Paths.get(path), charset);
            for (String line : lines) {

                String[] parts = line.split(";");
                if (Integer.parseInt(parts[1]) > bestLevel1) {
                    bestLevel1 = Integer.parseInt(parts[1]);
                }
                if (Integer.parseInt(parts[2]) > bestLevel2) {
                    bestLevel2 = Integer.parseInt(parts[2]);
                }
                if (Integer.parseInt(parts[3]) > bestTotal) {
                    bestTotal = Integer.parseInt(parts[3]);
                }
            }
            SaveReadFile.readFile = true;
        }
    }
}



