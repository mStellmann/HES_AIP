package komponentenFassaden;

import interfaces.IAuftrag;
import interfaces.IRechnung;
import interfaces.IZahlungseingang;
import komponentenInterfaces.extern.IBuchhaltungsverwaltungExtern;
import komponentenInterfaces.intern.IAuftragsverwaltungIntern;
import komponentenInterfaces.intern.IBankAdapter;
import komponentenInterfaces.intern.IBuchhaltungsverwaltungIntern;
import komponentenInterfaces.intern.IPersitenz;
import komponentenLogik.BuchhaltungLogik;
import komponentenRepositories.BuchhaltungsverwaltungRepository;
import typClasses.AuftragTyp;
import typClasses.RechnungTyp;

import java.util.Date;

public class BuchhaltungverwaltungFassade implements IBuchhaltungsverwaltungIntern, IBuchhaltungsverwaltungExtern {

    private BuchhaltungsverwaltungRepository repository;
    private BuchhaltungLogik logik;

    public BuchhaltungverwaltungFassade(IBankAdapter bankAdapter, IAuftragsverwaltungIntern auftragsverwaltungIntern, IPersitenz persitenz) {
        this.repository = new BuchhaltungsverwaltungRepository(persitenz);
        this.logik = new BuchhaltungLogik(bankAdapter, auftragsverwaltungIntern, repository);
    }

    @Override
    public IRechnung erstelleRechnung(Date rechnungsDatum, IAuftrag auftrag) {
        IRechnung rechnung = repository.erstelleRechnung(rechnungsDatum);
        rechnung.setAuftrag(auftrag);
        repository.updateRechnung(rechnung);
        return rechnung;
    }

    @Override
    public RechnungTyp erstelleRechnung(Date rechnungsDatum) {
        return new RechnungTyp(repository.erstelleRechnung(rechnungsDatum));
    }

    @Override
    public RechnungTyp addAuftragZuRechnung(int rechnungsNr, int auftragsNr) {
        return new RechnungTyp(logik.addAuftragZuRechnung(rechnungsNr, auftragsNr));
    }

    @Override
    public IZahlungseingang erstelleZahlungseingang(Date eingangsdatum, float betrag) {
        return repository.erstelleZahlungseingang(eingangsdatum, betrag);
    }

    @Override
    public void markiereRechnungAlsBezahlt(int rechnungsNummer) {
        repository.getRechnung(rechnungsNummer).setIstBezahlt(true);
    }

    @Override
    public IRechnung getRechnung(int rechnungsNummer) {
        return repository.getRechnung(rechnungsNummer);
    }

    @Override
    public IZahlungseingang getZahlungseingang(int rechnungsNummer) {
        return repository.getZahlungseingang(rechnungsNummer);
    }

    @Override
    public void getZahlungseingaengeVonAdapter() {
        logik.getZahlungseingaengeVonAdapter();
    }
}
