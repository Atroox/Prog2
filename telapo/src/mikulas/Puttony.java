package mikulas;

import java.util.*;

public class Puttony implements AjandekCsomag{
    private String cimzett;
    private Ajandek[] ajandekok;

    public Puttony(String cimzett, Ajandek[] ajandekok) {
        this.cimzett = cimzett;
        this.ajandekok = ajandekok;
    }

    @Override
    public int osszErtek() {
        int osszErtek = 0;
        for(Ajandek ajandek : ajandekok) {
            osszErtek += ajandek.ar;
        }
        return osszErtek;
    }

    @Override
    public int nehezekSzama(double t) {
        int count = 0;
        for(Ajandek ajandek : ajandekok) {
            if(ajandek.tomeg > t) {
                count++;
            }
        }
        return count;
    }

    @Override
    public Collection<GyerekJatek> gyerekjatekok() {
        Set<GyerekJatek> visszateres = new HashSet<>();
        for(Ajandek ajandek : ajandekok) {
            if (ajandek instanceof GyerekJatek) {
                GyerekJatek gyerekJatek = (GyerekJatek) ajandek;
                visszateres.add(gyerekJatek);
            }
        }
        List<GyerekJatek> lista = new ArrayList<>(visszateres);
        Collections.sort(lista);
        return lista;
    }

    @Override
    public String toString() {
        String result = cimzett+"\n\n";
        for(Ajandek ajandek : ajandekok) {
            result += ajandek.nev+"\n";
        }
        return result;
    }

    public List<GyerekJatek> nagyobbKorhatar(int minKor) throws IllegalArgumentException {
        if(minKor < 1) {
            throw new IllegalArgumentException("Negatív életkor!");
        }
        List<GyerekJatek> visszateres = new ArrayList<>();
        for(Ajandek ajandek : ajandekok) {
            if(ajandek instanceof GyerekJatek) {
                GyerekJatek gyerekJatek = (GyerekJatek) ajandek;
                if (gyerekJatek.getKorhatar() > minKor) {
                    visszateres.add(gyerekJatek);
                }
            }
        }
        return visszateres;
    }
}
