package net.core.tutorial.proficient._04_JSON;

public class Model1 {

    private int number;
    private double floatNumber;
    private boolean flag;
    private String message;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getFloatNumber() {
        return floatNumber;
    }

    public void setFloatNumber(double floatNumber) {
        this.floatNumber = floatNumber;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Model1{" +
                "number=" + number +
                ", floatNumber=" + floatNumber +
                ", flag=" + flag +
                ", message='" + message + '\'' +
                '}';
    }
}
