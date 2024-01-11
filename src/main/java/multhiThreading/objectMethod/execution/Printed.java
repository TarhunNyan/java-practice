package multhiThreading.objectMethod.execution;

public class Printed {

    static private int count;
    final private int number;
    final private Design design;

    public Printed(Design design) {
        Printed.count += 1;
        this.number = Printed.count;
        this.design = design;
    }

    public int getNumber() {
        return number;
    }

    public Design getDesign() {
        return design;
    }
}
