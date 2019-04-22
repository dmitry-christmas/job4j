package ru.job4j.departmentssort;
/**
 * Класс организации.
 * @author Dmitry Rozhdestvenskiy (dmr1433@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Org {
    private String kod;
    public Org(String kod) {
        this.kod = kod;
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }
    public int compareTo(Org o) {
        return this.kod.compareTo(o.kod);
    }
}
