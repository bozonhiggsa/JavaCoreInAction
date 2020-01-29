package net.core.tutorial.proficient._01_ConcurrencyAdvanced.exampleThreadLocal;

public class Context {

    private String userName;

    public Context(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Context{" +
                "userName='" + userName + '\'' +
                '}';
    }
}
