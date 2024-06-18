/*
Info om GrupparbeteApplication, detta är start punkten av vår applikation vår "run"del av appen så vi kan starta upp allt
 */

package se.mehdi.securewebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class  GrupparbeteApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrupparbeteApplication.class, args);
	}

}
