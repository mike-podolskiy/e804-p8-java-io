//CHECKSTYLE:OFF
package kz.mix.e804.io.buffered;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Read {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Podolskiy.Mikhail\\Desktop\\FILES\\test.txt"));

        br.skip(8); // skip 8 bytes
        System.out.println(br.readLine());
        br.mark(3); // MARK
        System.out.println(br.readLine());
        br.reset(); // RESET
        System.out.println(br.readLine());
    }
}
