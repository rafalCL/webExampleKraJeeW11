package pl.coderslab.web.examples;

public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() { // -> property "name"
        return name;
    }

    public void setName(String name) { // -> property "name"
        this.name = name;
    }

    public String getPoliteName() {
        return "Dla Ciebie Pan " + this.name;
    }
}
