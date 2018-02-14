package ie.dit;

public class Tune implements Player{

  // private fields of tune class
  private int x;
  private String title = "";
  private String altTitle = "";
  private String notation = "";


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
    return x + ", " + title + ", " + altTitle;
  }

  public void play() {
    System.out.println("notation of searched tune: "+ notation);
  }
}
