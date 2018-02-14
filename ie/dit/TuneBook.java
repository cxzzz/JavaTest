package ie.dit;

import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;

public class TuneBook {

  ArrayList<Tune> tunes = new ArrayList<Tune>();

  public TuneBook(String fileName) {

    BufferedReader inputStream = null;

    // load tunes from file
    try {
      inputStream = new BufferedReader(new FileReader(fileName));
      String l;
      int songCount = 1;
      Tune temp = new Tune();
      while ((l = inputStream.readLine()) != null) {
        if (l.startsWith("X:")) {
          temp = new Tune();
          temp.setx(songCount);
          songCount++;
        }

        if (l.startsWith("T:")) {
          if (temp.getTitle() == "") {
            // set the title of the tune
            temp.setTitle(l.substring(2));
          } else if (temp.getAlt() == ""){
            if (l.substring(2) != "") {
              temp.setAlt(l.substring(2));
            }
          }
        }

        if (!(l.startsWith("H:")) && l.contains("|")) {
          temp.setNotation(l);
        }

        if (l.equals("")) {
          tunes.add(temp);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (inputStream != null) {
        try {
          inputStream.close();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
  } // end of constructor

  public String toString() {
    StringBuffer sb = new StringBuffer();
    for (Tune t : tunes) {
      sb.append(t.getx() + ", " + t.getTitle() + ", " + t.getAlt() + ", " + t.getNotation() + "\n");
    }

    return sb.toString();
  }

  public Tune findTune(String title) {
    Tune temp = new Tune();

    for (Tune t : tunes) {
      String s = t.getTitle();
      if (s.contains(title)) {
        temp = t;
        break;
      }
    }

    return temp;
  }

  public static void main(String[] args)
  {
          TuneBook tb = new TuneBook("hnj0.abc");
          System.out.println(tb);

          Tune t = tb.findTune("Scotsman over the Border");
          t.play();
  }
}
