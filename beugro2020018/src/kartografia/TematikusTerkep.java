package kartografia;

import java.util.List;

public class TematikusTerkep extends Terkep{
    protected String tema;

    public TematikusTerkep(String cim, int arany, List<String> nevjegyzek, String tema) {
        super(cim, arany, nevjegyzek);
        this.tema = tema;
    }

    @Override
    public String toString() {
        return super.toString()+", "+tema;
    }

    @Override
    public boolean nagybetusit() {
        boolean eredmeny = super.nagybetusit();
        if (tema.substring(0,1).toLowerCase().equals(tema.substring(0,1))) {
            eredmeny = true;
            tema = tema.substring(0,1).toUpperCase()+tema.substring(1);
            eredmeny = true;
        }
        return  eredmeny;
    }
}
