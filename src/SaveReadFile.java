import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Martyna on 05.01.2016.
 */
public class SaveReadFile {

    // SimpleDateFormat object; set format
    public static SimpleDateFormat simpleDateHere = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss ");

    public static void Save() throws IOException{

        StringBuilder tekstDoPliku = new StringBuilder();
        tekstDoPliku.append("Data: " + simpleDateHere.format(new Date()));

        tekstDoPliku.append(" Punkty za poziom 1: " + Summary.scoreLevel1);

        tekstDoPliku.append(" Punkty za poziom 2: " + SummaryAfterLevel2.scoreLevel2);

        tekstDoPliku.append(" Suma punktow: " + GameStatus.gameScore());



        File file = new File("Gar zlota - wyniki.txt");

        // create new file if doesn't exists
        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(tekstDoPliku.toString());
        tekstDoPliku.toString();
        bw.newLine();
        bw.close();

        System.out.println("Zapisano");
    }
    }

