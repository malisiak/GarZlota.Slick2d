import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by Martyna on 05.01.2016.
 */
public class SaveReadFile {

    // SimpleDateFormat object; set format
    public static SimpleDateFormat simpleDateHere = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss ");

    public static void Save() throws IOException {

        StringBuilder tekstDoPliku = new StringBuilder();
        tekstDoPliku.append("Data: " + simpleDateHere.format(new Date()));

        tekstDoPliku.append(" Punkty za poziom 1: " + Summary.scoreLevel1);

        tekstDoPliku.append(" Punkty za poziom 2: " + SummaryAfterLevel2.scoreLevel2);

        tekstDoPliku.append(" Suma punktow: " + GameStatus.gameScore());

        File file = new File("Gar zlota - wynki.txt");

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

        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader("Gar zlota - wynki.txt"));
            StreamTokenizer st = new StreamTokenizer(in);
            st.eolIsSignificant(false);
            // remove comment handling
            st.slashSlashComments(false);
            st.slashStarComments(false);

            while (st.nextToken() != StreamTokenizer.TT_EOF) {
                if (st.ttype == StreamTokenizer.TT_NUMBER) {
                    // the default is to treat numbers differently than words
                    // also the numbers are doubles
                    System.out.println((int) st.nval);
                } else {
                    System.out.println(st.sval);
                }
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ex) {
                }
            }
        }

        System.out.println("Zapisano");
    }

    public static void read()  {

      /*  BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader("Gar zlota - wynki.txt"));
            StreamTokenizer st = new StreamTokenizer(in);
            st.eolIsSignificant(false);
            // remove comment handling
            st.slashSlashComments(false);
            st.slashStarComments(false);

            while (st.nextToken() != StreamTokenizer.TT_EOF) {
                if (st.ttype == StreamTokenizer.TT_NUMBER) {
                    // the default is to treat numbers differently than words
                    // also the numbers are doubles
                    System.out.println((int) st.nval);
                } else {
                    System.out.println(st.sval);
                }
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ex) {
                }
            }
        }*/

    }
}


