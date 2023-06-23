//Don't change!
public class Lesson08_2{
    public static void main(String args[]){

        Student s1 = new Student();
        Student s2 = new Student(1260998); //Argument is id
        Student s3 = new Student(1260999, 3, "坂本龍馬"); // Argument is id, grade and name

        System.out.println("学籍番号:" + s1.id + " 学年:" + s1.grade + " 名前:" + s1.name);
        System.out.println("学籍番号:" + s2.id + " 学年:" + s2.grade + " 名前:" + s2.name);
        System.out.println("学籍番号:" + s3.id + " 学年:" + s3.grade + " 名前:" + s3.name);
       
    }
}
