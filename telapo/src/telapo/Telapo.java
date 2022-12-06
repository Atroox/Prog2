package telapo;

import mikulas.Ajandek;
import mikulas.AjandekCsomag;
import mikulas.GyerekJatek;
import mikulas.Puttony;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Telapo {
    public static void main(String[] args) {
        if(args.length < 1) {
            System.out.println("Nem adta meg a file nevét!");
            return;
        }
        List<Ajandek> ajandekok = new ArrayList<>();
        File fajl = new File(args[0]);
        try {
            Scanner bemenet = new Scanner(fajl);
            while (bemenet.hasNextLine()) {
                Scanner sorOlvaso = new Scanner(bemenet.nextLine());
                sorOlvaso.useDelimiter(";");
                String nev = sorOlvaso.next();
                double tomeg = sorOlvaso.nextDouble();
                int ar = sorOlvaso.nextInt();
                if (sorOlvaso.hasNextInt()) {
                    ajandekok.add(new GyerekJatek(nev, tomeg, ar, sorOlvaso.nextInt()));
                } else {
                    ajandekok.add(new Ajandek(nev, tomeg, ar));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("nincs ilyen fajl");
        }
        Collections.sort(ajandekok);
        System.out.println(ajandekok);


        String nev = "a világ összes gyereke";
        if(args.length > 2) {
            nev = args[1];
        }
        Ajandek[] ajandeks = (Ajandek[]) ajandekok.toArray();
        Puttony puttony = new Puttony(nev, ajandeks);
        int maxAr = 0;
        for(GyerekJatek jatek : puttony.gyerekjatekok()) {
            if(jatek.getAr() > maxAr) {
                maxAr = jatek.getAr();
            }
            else {
                System.out.println("Nincs gyerekjatek a puttonyban!");
            }
        }
        Scanner bemenet = new Scanner(System.in);
        int korhatar = bemenet.nextInt();
        System.out.println(puttony.nagyobbKorhatar(korhatar));

        AjandekCsomag[] tomb = new AjandekCsomag[2];

    }
    public Double[] iedikElem(AjandekCsomag[] csomagok) {
        int osszErtek = 0;
        int count = 0;
        double atlagErtek =osszErtek / count;
        Double[] ajandekokAra = new Double[csomagok.length];
        for(AjandekCsomag csomag : csomagok) {
            if(csomag instanceof Ajandek) {
                Ajandek ajandek = (Ajandek) csomag;
                osszErtek += ajandek.getAr();
                count++;
            }
        }
        return ajandekokAra;
    }



}
