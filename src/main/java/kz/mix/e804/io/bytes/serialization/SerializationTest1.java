package kz.mix.e804.io.bytes.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// Результат
// In Boo k = 5
// In BooBoo k = 5
// In Moo
// InvalidClassException
// При сериализации - все ок
// При десериализации: Moo - serializable - конструтор не вызывается,
// BooBoo - не serializable, следовательно будет попытка вызвать его конструктор без параметров - отсюда и ошибка
// Решения:
// 1) Объявить Boo serializable (BooBoo автоматически станет serializable)
// 2) Добавить в BooBoo конструктор без параметров, вызывающий родительский конструктор с параметром
// 3) Объявить BooBoo serializable, а в Boo добавить конструктор без параметров
class Boo {
    int boo = 10;

    public Boo(int k) {
        System.out.println("In Boo k = " + k);
        boo = k;
    }
}

class BooBoo extends Boo {
    public BooBoo(int k) {
        super(k);
        System.out.println("In BooBoo k = " + k);
    }
}

class Moo extends BooBoo implements Serializable {
    int moo = 10;

    public Moo() {
        super(5);
        System.out.println("In Moo");
    }
}

public class SerializationTest1 {
    public static void main(String[] args) throws Exception {
        Moo moo = new Moo();

        FileOutputStream fos = new FileOutputStream("C:\\Users\\Podolskiy.Mikhail\\Desktop\\FILES\\moo1.ser");
        ObjectOutputStream os = new ObjectOutputStream(fos);
        os.writeObject(moo);
        os.close();

        FileInputStream fis = new FileInputStream("C:\\Users\\Podolskiy.Mikhail\\Desktop\\FILES\\moo1.ser");
        ObjectInputStream is = new ObjectInputStream(fis);
        moo = (Moo) is.readObject();
        is.close();
    }
}
