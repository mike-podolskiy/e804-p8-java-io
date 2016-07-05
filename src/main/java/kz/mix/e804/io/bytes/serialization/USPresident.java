//CHECKSTYLE:OFF
package kz.mix.e804.io.bytes.serialization;

import java.io.Serializable;

public class USPresident implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String period;
    private transient String term;

    public USPresident(String name, String period, String term) {
        this.name = name;
        this.period = period;
        this.term = term;
    }

    @Override
    public String toString() {
        return "US President [name=" + name + ", preriod=" + period + ", term=" + term + "]";
    }
}
