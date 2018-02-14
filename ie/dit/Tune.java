package ie.dit;

public class Tune implements Player{

  // private fields of tune class
  private int x;
  private String title;
  private String altTitle = "";
  private String notation;

  Tune() {
  }


  // Accessors
  public int getx() {
    return x;
  }

  public void setx(int value) {
    x = value;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String s) {
    title = s;
  }

  public String getAlt() {
      return altTitle;
  }

  public void setAlt(String s) {
    altTitle = s;
  }

  public String getNotation() {
    return notation;
  }

  public void setNotation(String s) {
    notation += s;
  }

  public String toString() {
    String ret;

    ret = x + ", " + title;

    if (altTitle != null) {
      ret +=  ", " + altTitle;
    }

    return ret;
  }

  // play the notation of the tune
  public void play() {

    // some error checking on finding the tune
    if (title != "") {
      // if tune exist
      System.out.println("notation of played tune: "+ notation);
    } else {
      // if tune does not exist
      System.out.println("Tune not found");
    }
  }
}
