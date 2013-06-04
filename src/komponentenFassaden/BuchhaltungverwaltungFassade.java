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

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: abe263
 * Date: 19.04.13
 * Time: 13:10
 * To change this template use File | Settings | File Templates.
 */
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
