import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

class Student implements Serializable {
    String name, grade;
    int marks;
    Student(String name, String grade, int marks) {
        this.name = name;
        this.grade = grade;
        this. marks = marks;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Grade: " + grade + ", Marks: " + marks;
    }
}

class Students extends Thread {
    ArrayList<Student> s;

    Students(ArrayList<Student> s) {
        this.s = s;
    }

    @Override
    public void run() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("studentsdetails.bin", true));
            for(Student i:s) {
                oos.writeObject(i);
//                System.out.println(i);
            }
            System.out.println("Students details added succesfully!");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}

class Summary extends Thread {
    ArrayList<Student> students;
    Summary() {
        try {
            students = new ArrayList<>();
            ObjectInputStream bis = new ObjectInputStream(new FileInputStream("studentsdetails.bin"));
            do {
                Student s = (Student)bis.readObject();
                students.add(s);
//                System.out.println(s);
            } while (true);
        } catch(EOFException e) {
            System.out.println("Data fetched successfully!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void run() {
        try {
            BufferedOutputStream bis = new BufferedOutputStream(new FileOutputStream("summary.txt"));
            String topperName = "";
            double avgMarks;

            int sum = 0, mxmMarks = 0;
            for(Student i: students) {
                sum += i.marks;
                if(i.marks > mxmMarks) {
                    mxmMarks = i.marks;
                    topperName = i.name;
                }
            }
            avgMarks = (sum * 1.0)/ students.size();

            String summary = "Topper name: " + topperName + "\nTopper Marks: " + mxmMarks + "\nAverage Marks: " + avgMarks;
            byte[] b = summary.getBytes();
            bis.write(b);
            bis.close();
            System.out.println("Summary added successfully!");
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

public class StudentDetails {
    public static void main(String[] args) throws InterruptedException {

        Student s1 = new Student("harsit", "A+", 500);
        Student s2 = new Student("harsh", "A", 480);
        Student s3 = new Student("hart", "B+", 450);
        Student s4 = new Student("hsit", "B", 400);

        ArrayList<Student> students = new ArrayList<>(Arrays.asList(s1, s2, s3, s4));

        Students ss = new Students(students);
        ss.start();
        ss.join();

        Summary sm = new Summary();
        sm.start();
        sm.join();


    }
}
