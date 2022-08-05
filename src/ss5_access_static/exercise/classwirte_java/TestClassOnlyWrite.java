package ss5_access_static.exercise.classwirte_java;

public class TestClassOnlyWrite {
    public static void main(String[] args) {
        ClassOnlyWrite student = new ClassOnlyWrite();
        student.setName("Son");
        student.setClasString("C0622G1");

        System.out.println("My name is: " + student.getName());
        System.out.println("My class is: " + student.getClasString());
    }
}

 /*   Nếu thay accessmodifier là default hoặc protected thì chương trình chạy bình thường
         Nếu là private thì chương trình báo lỗi
     */
