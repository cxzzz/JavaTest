import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;

public class TuneBook {

  ArrayList<Tune> tunes = new ArrayList<Tune>();

  public TuneBook(String str) {

    BufferedReader inputStream = null;

    // load tunes from file
    try {
      inputStream = new BufferedReader(new FileReader("hnj0.abc"));
      String l;
      int counter = 0;
      while (l = inputStream.readLine()) != null) {
        if (l.startsWith("X:")) {
          Tune temp = new Tune();
          temp.setx(l.subString(2));
        }

        if (l.startsWith("T:")) {
          if (counter == 0) {
            // set the title of the tune
            temp.setTitle(l.subString(2));
            counter++;
          } else if (counter == 1) {
            temp.setAlt(l.subString(2));
          } else {
            continue;
          }
        }

        if (l.startsWith)
      }
    }
  }


}
