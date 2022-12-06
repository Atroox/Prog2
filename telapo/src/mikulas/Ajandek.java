package mikulas;

public class Ajandek implements Comparable<Ajandek>{
    protected String nev;
    protected double tomeg;
    protected int ar;

    public Ajandek(String nev, double tomeg, int ar) {
        this.nev = nev;
        this.tomeg = tomeg;
        this.ar = ar;
    }

    public int getAr() {
        return ar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != getClass()) return false;
        Ajandek ajandek = (Ajandek) o;
        return nev.equals(ajandek.nev) && Math.abs(tomeg - ajandek.tomeg) < 1;
    }

    @Override
    public String toString() {
        return nev+" ("+tomeg+" kg), "+ar+" Ft";
    }


    @Override
    public int compareTo(Ajandek o) {
        if(ar != o.ar) {
            return Integer.compare(ar, o.ar)*-1;
        }
        else {
            return nev.compareTo(o.nev);
        }

    }
}
