public class Lesson08_3 {
    public static void main(String[] args) {

        Student student = new Student();
        // Add here**************************************
        // student.subject = new Subject("情報学群実験第１", 1);
        System.out.println(student.name + "は" + student.subject.quarter
                + "Qに" + student.subject.subjectName + "の授業を受けている");
    }
}
