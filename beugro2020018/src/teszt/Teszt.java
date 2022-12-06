package teszt;

import kartografia.Atlasz;
import kartografia.TematikusTerkep;
import kartografia.Terkep;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Teszt {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Nem adta meg a megnyitandó file nevét");
            return;
        }
        List<Terkep> terKepek = new ArrayList<>();
        File fajl = new File(args[0]);
        try {
            Scanner bemenet = new Scanner(fajl);
            while (bemenet.hasNextLine()) {
                Scanner sorOlvaso = new Scanner(bemenet.nextLine());
                sorOlvaso.useDelimiter(";");
                String cim = bemenet.next();
                int arany = bemenet.nextInt();
                List<String> nevjegyzek = Collections.singletonList(bemenet.next());
                if (sorOlvaso.hasNext()) {
                    terKepek.add(new TematikusTerkep(cim, arany, nevjegyzek, bemenet.next()));
                } else {
                    terKepek.add(new Terkep(cim, arany, nevjegyzek));
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        String atlaszCim = "Földrajzi világatlasz";
        if (args.length > 1) {
            atlaszCim = args[1];
        }
        Atlasz atlaszka = new Atlasz(atlaszCim, terKepek);
        Scanner input = new Scanner(System.in);
        int darabszam = input.nextInt();
        for (Terkep terkepp : terKepek) {
            if (terkepp instanceof TematikusTerkep) {
                TematikusTerkep temTerkep = (TematikusTerkep) terkepp;
                if (temTerkep.getNevjegyzek().size() >= darabszam) {
                    System.out.println(temTerkep);

                }
            }

        }
        System.out.println(atlaszka.terkepSzam(input.next()));

    }
}
