package se.mehdi.securewebapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GrupparbeteApplicationTests {


    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoads() {
        // Testa att applikationskontexten läses in
    }

    @Test
    public void testHomePage() {
        String url = "http://localhost:" + "/";
        String body = this.restTemplate.getForObject(url, String.class);
        assertThat(body).contains("Welcome"); // Replace with your expected homepage content
    }

    // Lägg till fler testmetoder efter behov för att täcka din applikations funktionalitet
}
