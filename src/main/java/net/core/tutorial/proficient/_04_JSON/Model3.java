package net.core.tutorial.proficient._04_JSON;

public class Model3 {

    private Model1 model1;
    private Model2 model2;

    public Model1 getModel1() {
        return model1;
    }

    public void setModel1(Model1 model1) {
        this.model1 = model1;
    }

    public Model2 getModel2() {
        return model2;
    }

    public void setModel2(Model2 model2) {
        this.model2 = model2;
    }

    @Override
    public String toString() {
        return "Model3{" +
                "model1=" + model1 +
                ", model2=" + model2 +
                '}';
    }
}
