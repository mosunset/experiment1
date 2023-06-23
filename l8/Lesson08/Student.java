//Use Lesson08_1, Lesson08_2, Lesson08_3

public class Student {

    int id;
    int grade;
    String name;

    // Lesson08_1 add here
    public Student() {
        this.id = 1260997;
        this.grade = 2;
        this.name = "高知太郎";
    }

    // Lesson08_2 add here
    public Student(int id) {
        this.id = id;
        this.grade = 2;
        this.name = "山田花子";
    }

    public Student(int id, int grade, String name) {
        this.id = id;
        this.grade = grade;
        this.name = name;
    }

    // Lesson08_3 add here
    Subject subject;;// = new Subject("",1);

}

