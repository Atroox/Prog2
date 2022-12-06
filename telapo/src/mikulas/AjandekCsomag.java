package mikulas;

public interface AjandekCsomag
{
    // visszaadja az ajándékok összértékét
    int osszErtek();
    // visszaadja a t-nél nehezebb ajándékok számát
    int nehezekSzama(double t);
    // visszaadja a gyerekjátékokat a természetes rendezettségük sorrendjében úgy,
    // hogy az egyenlő gyerekjátékok közül csak egy szerepel a kollekcióban
    java.util.Collection<GyerekJatek> gyerekjatekok();
}
