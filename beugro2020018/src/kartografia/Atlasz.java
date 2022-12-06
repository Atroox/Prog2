package kartografia;

import terkepkiado.TerkepTar;

import java.util.*;

public class Atlasz implements TerkepTar {
    private String atlaszCim;
    private List<Terkep> terKepek = new ArrayList<>();

    public Atlasz(String atlaszCim, List<Terkep> terKepek) {
        this.atlaszCim = atlaszCim;
        this.terKepek.addAll(terKepek);
    }

    @Override
    public String toString() {
        String result = atlaszCim+"\n\n";
        for(Terkep terkep : terKepek) {
            result += terkep+"\n";
        }
        return result;
    }

    @Override
    public void hozzaad(Terkep[] terkepek) {
        for (Terkep terkep : terkepek) {
            terKepek.add(terkep);
        }
    }

    @Override
    public List<Terkep> terkepek(boolean csakTematikus, int nevekSzama) {
        List<Terkep> visszateres = new ArrayList<>();
        for (Terkep terkep : terKepek) {
            if (terkep.nevjegyzek.size() >= nevekSzama && csakTematikus) {
                visszateres.add(terkep);
            }
            else if (terkep.nevjegyzek.size() >= nevekSzama){
                visszateres.add(terkep);
            }
        }
        Collections.sort(visszateres);
        return visszateres;
    }

    @Override
    public Collection<String> teljesNevjegyzek(String cim) {
        Set<String> visszateres = new HashSet<>();
        for (Terkep terkep : terKepek) {
            if (terkep.cim.equals(cim))  {
                visszateres.add(terkep.toString());
            }
        }
        return visszateres;
    }

    public int terkepSzam(String tema) {
        int count = 0;
        for (Terkep terkep : terKepek) {
            if(terkep instanceof TematikusTerkep) {
                TematikusTerkep temTerkep = (TematikusTerkep) terkep;
                if (temTerkep.tema.equals(tema)) {
                    count++;
                }
            }
        }
        return count;
    }
}
