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
                    if (rechnung == null) continue;

                    if (rechnung.getAuftrag().getAngebot().getGesamtPreis() <= zahlungseingang.getBetrag()) {
                        rechnung.setIstBezahlt(true);
                        repository.updateRechnung(rechnung);
                        zahlungseingang = repository.erstelleZahlungseingang(zahlungseingang.getEingangsdatum(), zahlungseingang.getBetrag());
                        zahlungseingang.setRechnung(rechnung);
                        repository.updateZahlungseingang(zahlungseingang);
                        System.out.println("[INFO] Buchhaltung - Betrag bezahlt von Rechung: " + rechnung.getRechnungsNummer());
                    } else {
                        System.out.println("[ERROR] Buchhaltung - Betrag nicht gedeckt - Rechnungsnummer: " + rechnung.getRechnungsNummer());
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
