/*
Info om UserRepository, Ett Repository i spring är vanligtvis till för att "prata" med databasen lite som ett api(??)
Våran UserRepository tar hand om AppUser klassen. Vi anväder oss av ett interface som extendar JpaRepository detta ger oss tillgång till olika funktionen som till exempel
Delete.

Parametern <AppUser, Long> säger att AppUser är våran entety och Long är vår "entetys" primary key (notera att Id:et i AppUser classen är en long)

findByUsername låter oss hitta en AppUser med hjälp av användarnamnet. Optional används då det inte är säkert att användaren vi söker efter finns eller inte.

 */

package se.mehdi.securewebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.mehdi.securewebapp.entity.AppUser;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByUsername(String username);
}
