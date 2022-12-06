package mikulas;

public class GyerekJatek extends Ajandek{
    private int korhatar;

    public GyerekJatek(String nev, double tomeg, int ar, int korhatar) {
        super(nev, tomeg, ar);
        this.korhatar = korhatar;
    }

    public int getKorhatar() {
        return korhatar;
    }

    @Override
    public String toString() {
        return super.toString()+", "+korhatar+" éves kortól";
    }
}
