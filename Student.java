public class Student {
  private String name;
  private String major;
  private double credits = 0.0;
  private double quality = 0.0;

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
      "\nGPA: " + String.format("%.2f", gpa);
  }
}
