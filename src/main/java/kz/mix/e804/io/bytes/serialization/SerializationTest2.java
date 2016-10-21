package kz.mix.e804.io.bytes.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// Результат
// booby dooby tooby booby 10 20 30
// При создании объекта Tooby поочередно будут вызваны конструкторы предков: booby dooby tooby
// классы Dooby и Tooby - serializable - их конструкторы при десериализации вызываться не будут
// класс Booby - не serializable - соответственно:
// 1) значение i = 100 при сериализации будет утеряно
// 2) будет вызван конструктор Booby без параметров и i будет присвоено значение 10
class Booby {
    int i;

    public Booby() {
        i = 10;
        System.out.println("Booby");
    }
}

class Dooby extends Booby implements Serializable {
    int j;

    public Dooby() {
        j = 20;
        System.out.println("Dooby");
    }
}

class Tooby extends Dooby {
    int k;

    public Tooby() {
        k = 30;
        System.out.println("Tooby");
    }
}

public class SerializationTest2 {
    public static void main(String[] args) throws Exception {
        Tooby t = new Tooby();

        t.i = 100;

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Podolskiy.Mikhail\\Desktop\\FILES\\moo1.ser"));
        oos.writeObject(t);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\Podolskiy.Mikhail\\Desktop\\FILES\\moo1.ser"));
        Tooby t2 = ((Tooby) ois.readObject());
        ois.close();

        System.out.println(t2.i + " " + t2.j + " " + t2.k);

    }
}
