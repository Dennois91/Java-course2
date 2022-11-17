package assignment_12_TCP_Chat;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class MultiCaster {

    private List<PrintWriter> writerList = new ArrayList<PrintWriter>();

    public void addWriter(PrintWriter p) {
        writerList.add(p);
    }

    public List<PrintWriter> getWriters() {
        return writerList;
    }

    public void removeWriter(PrintWriter p) {
        writerList.remove(p);
    }

}
