package komponentenLogik;

import interfaces.IAngebot;
import interfaces.IProdukt;
import komponentenInterfaces.intern.IKundenverwaltungIntern;
import komponentenInterfaces.intern.IProduktverwaltungIntern;
import komponentenRepositories.AngebotsverwaltungRepository;
import typClasses.ProduktTyp;

/**
 * Created with IntelliJ IDEA.
 * User: aaz527
 * Date: 19.04.13
 * Time: 13:23
 * To change this template use File | Settings | File Templates.
 */
public class AngebotsverwaltungLogik {
    IProduktverwaltungIntern produktverwaltungIntern;
    IKundenverwaltungIntern kundenverwaltungIntern;
    AngebotsverwaltungRepository repository;

    public AngebotsverwaltungLogik(IProduktverwaltungIntern produktverwaltungIntern, IKundenverwaltungIntern kundenverwaltungIntern, AngebotsverwaltungRepository repository) {
        this.kundenverwaltungIntern = kundenverwaltungIntern;
        this.produktverwaltungIntern = produktverwaltungIntern;
        this.repository = repository;
    }

//    public void addProduktMengeZuAngebot(IAngebot angebot, ProduktTyp produkt, int menge) {
//        IProdukt produktVar = produktverwaltungIntern.getProdukt(produkt)
//        repository.getAngebot(angebot.getAngebotsNummer()).addProduktMenge();
//    }


}
