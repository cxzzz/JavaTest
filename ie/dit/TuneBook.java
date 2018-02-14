package ie.dit;

import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;

public class TuneBook {

  // arraylist for storing the tunes
  ArrayList<Tune> tunes = new ArrayList<Tune>();

  public TuneBook(String fileName) {

    // bufferread for reading from file
    BufferedReader inputStream = null;

    // load tunes from file
    try {
      inputStream = new BufferedReader(new FileReader(fileName));
      String l;
      // variable for counting the number of tunes
      int songCount = 1;

      // make a temp tune for storing the tune
      Tune temp = new Tune();

      while ((l = inputStream.readLine()) != null) {

        // when a new tune is found
        if (l.startsWith("X:")) {
          // give it a new address space
          temp = new Tune();
          temp.setx(songCount);

          // counter goes up by 1
          songCount++;
        }

        // when title is found
        if (l.startsWith("T:")) {
          if (temp.getTitle() == null) {
            // set the title of the tune
            temp.setTitle(l.substring(2));
            // when subtitle is found
          } else if (temp.getAlt() == "") {
            // set the subtitle of the tune
            temp.setAlt(l.substring(2));
          }
        }

        // when notation is found
        if (!(l.startsWith("H:")) && l.contains("|")) {
          // set the tune's notation
          temp.setNotation(l);
        }


        // add when a tune's notation is fully finished
        if (l.equals("") && temp.getTitle() != null) {
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

  // toString method of TuneBook, print all tunes in the arraylist
  public String toString() {
    StringBuffer sb = new StringBuffer();
    for (Tune t : tunes) {
      sb.append(t.getx() + ", " + t.getTitle() + ", " + t.getAlt() + "\n");
    }

    return sb.toString();
  }


  // method for finding a tune from the arraylist
  public Tune findTune(String title) {
    Tune temp = new Tune();

    for (Tune t : tunes) {
      // get the title of the tune
      String s = t.getTitle();
      // if matches parameter
      if (s.contains(title)) {
        temp = t;
        // break out since tune is found
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
          //
          // Tune s = tb.findTune("zzzaq");
          // s.play();
  }
}
