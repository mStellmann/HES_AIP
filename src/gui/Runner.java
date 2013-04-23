package gui;

import adapter.BankAdapter;
import adapter.PersistenzAdapter;
import adapter.TransaktionsAdapter;
import adapter.TransportdienstleisterAdapter;
import komponentenFassaden.*;
import komponentenInterfaces.intern.IPersitenz;
import komponentenInterfaces.intern.ITransaktionsAdapter;

/**
 *
 */
public class Runner {
    public static void main(String[] args) {
        // adapter
        IPersitenz persitenz = new PersistenzAdapter();
        ITransaktionsAdapter transaktionsAdapter = new TransaktionsAdapter();
        BankAdapter bankAdapter = new BankAdapter();
        TransportdienstleisterAdapter transportdienstleisterAdapter = new TransportdienstleisterAdapter();

        // Fassaden
        LieferantenverwaltungFassade lieferantenverwaltung = new LieferantenverwaltungFassade(persitenz);
        ProduktverwaltungFassade produktverwaltung = new ProduktverwaltungFassade(persitenz);
        KundenverwaltungFassade kundenverwaltung = new KundenverwaltungFassade(persitenz);

        AngebotsverwaltungFassade angebotsverwaltung = new AngebotsverwaltungFassade(produktverwaltung, kundenverwaltung, persitenz);
        EinkaufsverwaltungFassade einkaufsverwaltung = new EinkaufsverwaltungFassade(persitenz, produktverwaltung, lieferantenverwaltung);
        LagerverwaltungFassade lagerverwaltung = new LagerverwaltungFassade(produktverwaltung, einkaufsverwaltung, persitenz);
        AuftragsverwaltungFassade auftragsverwaltung = new AuftragsverwaltungFassade(angebotsverwaltung, lagerverwaltung, transportdienstleisterAdapter, persitenz);
        BuchhaltungverwaltungFassade buchhaltungverwaltung = new BuchhaltungverwaltungFassade(bankAdapter, auftragsverwaltung, persitenz);

        // --- SIMULATING SOME STUFF ---
        //             TODO
        // -----------------------------
    }

}



