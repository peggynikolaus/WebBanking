package de.telekom.sea7.implementation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // teilt Spring mit, dass diese Schnittstelle die Verbindung zwischen der Anwendung und der Datenbank ist
// die Parameter in <> geben an, dass diese Schnittstelle für die Verwaltung ZahlungEntity verantwortlich ist und vom Typ Long ist
public interface ZahlungRepository extends JpaRepository<ZahlungEntity, Long> {
	
	

}
