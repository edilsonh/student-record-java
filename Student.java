public class Student {
  private String name;
  private String major;
  private int credits = 0;
  private int quality = 0;

  public Student(String n, String m){
      name = n;
      major = m;
  }

  public void courseCompleted(int c, int q) {
    credits += c;
    quality += q*c;
  }

  public String toString(){
    double gpa;
    if (credits == 0) {
      gpa = 4.0;
    } else {
      gpa = this.quality/this.credits;
    }
    return "Name: " + this.name +
      "\nMajor: " + this.major +
      "\nGPA: " + gpa;
  }
}
