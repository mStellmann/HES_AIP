package komponentenLogik;

import interfaces.IAuftrag;
import interfaces.IRechnung;
import interfaces.IZahlungseingang;
import komponentenInterfaces.intern.IAuftragsverwaltungIntern;
import komponentenInterfaces.intern.IBankAdapter;
import komponentenRepositories.BuchhaltungsverwaltungRepository;
import org.javatuples.Pair;
import typClasses.AuftragTyp;
import typClasses.RechnungTyp;

import java.util.Date;

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
                    Pair<IZahlungseingang, Integer> zahlungseingangIntegerPair = bankAdapter.getNaechstenZahlungseingang();
                    IZahlungseingang zahlungseingang = zahlungseingangIntegerPair.getValue0();
                    IRechnung rechnung = repository.getRechnung(zahlungseingangIntegerPair.getValue1());

                    if (rechnung.getAuftrag().getAngebot().getGesamtPreis() == zahlungseingang.getBetrag()) {
                        rechnung.setIstBezahlt(true);
                        repository.updateRechnung(rechnung);
                        zahlungseingang = repository.erstelleZahlungseingang(zahlungseingang.getEingangsdatum(), zahlungseingang.getBetrag());
                        zahlungseingang.setRechnung(rechnung);
                        repository.updateZahlungseingang(zahlungseingang);
                    } else {
                        System.out.println("[INFO] Buchhaltung - Betrag nicht gedeckt - Rechnungsnummer: " + rechnung.getRechnungsNummer());
                    }
                }
            }
        }.start();
    }

    public IRechnung addAuftragZuRechnung(int rechnungsNr, int auftragsNr) {
        IRechnung rechnung = repository.getRechnung(rechnungsNr);
        IAuftrag auftrag = auftragsverwaltungIntern.getAuftrag(auftragsNr);
        rechnung.setAuftrag(auftrag);
        repository.updateRechnung(rechnung);
        return rechnung;
    }
}
