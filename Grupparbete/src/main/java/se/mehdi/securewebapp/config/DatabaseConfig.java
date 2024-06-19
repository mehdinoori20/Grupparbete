package se.mehdi.securewebapp.config;
//@configuration kan säga att klassen innehåller en eller flera metoder som definerar bean-konteksten. vilket betyder att spring använder denna klass för att generera och hantera beans.
//@autoward injicera beroenden, som i vårt fall userrespository i databaseconfigklassen.
//1-@postconstruct skriver ett meddelande till till konsolen för att indikera att databaseconfig har initialiserats med userrepository.detta klass kan vara
//2-detta kan vara mkt bra användbart för felsökning eller för att utföra vissa initialiseringsåtgärder vid applikationens start.
// syftet i applikationen: säkertställa att userrepository är tillgängligt och injicerat vid upptart.
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import se.mehdi.securewebapp.repository.UserRepository;


@Configuration
public class DatabaseConfig {

    private final UserRepository userRepository;

    @Autowired
    public DatabaseConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void init() {
        System.out.println("DatabaseConfig initialized with UserRepository: " + userRepository);
    }
}
