package komponentenLogik;

import interfaces.IZahlungseingang;
import komponentenInterfaces.intern.IAuftragsverwaltungIntern;
import komponentenInterfaces.intern.IBankAdapter;
import komponentenRepositories.BuchhaltungsverwaltungRepository;
import org.javatuples.Pair;

/**
 * Created with IntelliJ IDEA.
 * User: aaz527
 * Date: 19.04.13
 * Time: 13:18
 * To change this template use File | Settings | File Templates.
 */
public class BuchhaltungLogik {
    private IBankAdapter bankAdapter;
    private IAuftragsverwaltungIntern auftragsverwaltungIntern;
    private BuchhaltungsverwaltungRepository repository;

    public BuchhaltungLogik(IBankAdapter bankAdapter, IAuftragsverwaltungIntern auftragsverwaltungIntern, BuchhaltungsverwaltungRepository repo) {
        this.repository = repo;
        this.auftragsverwaltungIntern = auftragsverwaltungIntern;
        this.bankAdapter = bankAdapter;
    }

    public void getZahlungseingaengeVonAdapter() {
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    Pair<IZahlungseingang, Integer> zahlungseingang = bankAdapter.getNaechstenZahlungseingang();

                    repository.erstelleZahlungseingang(zahlungseingang.getEingangsdatum(), zahlungseingang.getBetrag());

                }
            }
        }.start();
    }
}
