package assignment_8_extends_7;

public class Protokoll {
    Database db = new Database();
    final protected int INITIAL = 0;
    final protected int INLOOP = 1;

    protected int state = INITIAL;

    public Object getOutput(String name) {


        if (state == INITIAL) {
            state = INLOOP;
            return new Intro();

        } else if (state == INLOOP) {
            Person answer = db.search(name.trim());
            if (answer == null) {
                return new Response(false);
            }
            return new Response(true, answer);
        }
        return "";
    }
}
