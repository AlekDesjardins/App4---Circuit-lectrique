package electronique;

public class Resistance extends Composant {

    private double resistance;

    public Resistance(double resistance) {
        setResistance(resistance);
    }

    public void setResistance(double resistance) {
        this.resistance = resistance;
    }

    public double getResistance() {
        return resistance;
    }

    @Override
    public double calculerResistance() {
        return this.resistance;
    }
}
