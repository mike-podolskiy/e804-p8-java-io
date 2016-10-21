package kz.mix.e804.io.bytes.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// Результат Loaded[bob, 10, null, 0]
class Student implements Serializable {
    // если поменять версию при десериализации вылетит InvalidClassException
    public static final long serialVersionUID = 2;

    public String name;
    public String grade;
    public String id = "s111";
    public int age = 15;

    //J-
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grade='" + grade + '\'' +
                ", id='" + id + '\'' +
                ", age=" + age +
                '}';
    }
    //J+
}

public class SerialVersionTest1 {
    public static void main(String[] args) throws Exception {
        Student s = new Student();

        // сначала выполняем этот кусок кода
        // Student - пока два поля - name, grade
        // сериализуем класс с заданными значениями
        //-----------------------------
        // s.name = "bob";
        // s.grade = "10";

        // FileOutputStream fos = new FileOutputStream("C:\\Users\\Podolskiy.Mikhail\\Desktop\\FILES\\moo1.ser");
        // ObjectOutputStream oos = new ObjectOutputStream(fos);
        // oos.writeObject(s);
        // oos.close();
        //-----------------------------

        // Потом выполняем данный кусок кода
        // Сначала добавляем в класс Student два дополнительных поля - id и age
        //-----------------------------
        FileInputStream fis = new FileInputStream("C:\\\\Users\\\\Podolskiy.Mikhail\\\\Desktop\\\\FILES\\\\moo1.ser");
        ObjectInputStream is = new ObjectInputStream(fis);

        s = ((Student) is.readObject());
        is.close();
        //-----------------------------

        System.out.println("Loaded " + s);
    }
}
