package kartografia;

import java.util.List;
import java.util.Objects;

public class Terkep implements Comparable<Terkep>{
    protected String cim;
    protected int arany;
    protected List<String> nevjegyzek;

    public List<String> getNevjegyzek() {
        return nevjegyzek;
    }

    public Terkep(String cim, int arany, List<String> nevjegyzek){
        if (arany < 0) {
            throw new IllegalArgumentException("Hibás méretarány");
        }
        this.cim = cim;
        this.arany = arany;
        this.nevjegyzek = nevjegyzek;
    }
    public boolean nagybetusit(){
        boolean eredmeny = false;
        for (int i = 0; i< nevjegyzek.size(); i++) {
            if(nevjegyzek.get(i).substring(0,1).toLowerCase().equals(nevjegyzek.get(i).substring(0,1))) {
                eredmeny = true;
                nevjegyzek.set(i, nevjegyzek.get(i).substring(0, 1).toUpperCase()+nevjegyzek.get(i).substring(1));
            }
        }
        return eredmeny;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Terkep terkep = (Terkep) o;
        return Objects.equals(cim, terkep.cim) && arany == terkep.arany;
    }

    @Override
    public String toString() {
        return String.format("%S, 1:%d %s", cim, arany,String.join(", ", nevjegyzek));
    }


    @Override
    public int compareTo(Terkep o) {
        if(!cim.equals(o.cim)) {
            return cim.compareTo(o.cim);
        }
        else if (arany != o.arany) {
            return Integer.compare(arany, o.arany);
        }
        else {
            return Integer.compare(nevjegyzek.size(), o.nevjegyzek.size());
        }
    }
}
