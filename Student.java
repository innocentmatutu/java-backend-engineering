public class Student {
    String name;
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Innocent";
        Student s2 = s1;
        s2.name = "Innocent M";
        System.out.println("Student Name: " + s1.name);
    }
}