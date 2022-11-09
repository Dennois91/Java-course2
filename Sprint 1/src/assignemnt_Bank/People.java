package assignemnt_Bank;

abstract class People{
    private String name;
    private String iD;

    public People(String name, String personalID) {
        this.name = name;
        this.iD = personalID;
    }

    public People() {
    }

    public String getName(){
        return this.name;
    }
    public String getiD(){
        return this.iD;
    }
}
