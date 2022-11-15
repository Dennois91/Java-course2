package assignment_15;

public class Main {
    private void Run() {
        Que que = new Que<>();
        que.put(5);
        que.put(5);
        que.put(5);
        System.out.println(que.summarize());
    }

    public static void main(String[] args) {
        new Main().Run();
    }
}
