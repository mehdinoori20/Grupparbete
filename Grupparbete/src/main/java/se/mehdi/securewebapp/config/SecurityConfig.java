/*
Info om SecurityConfig, Vi kan börja med annotationerna @Configuration och @EnableWebSecurity, @Configuration säger till springboot att här har vi en samlig med @Bean:s
Beans är ett sätt att markera metoder som returnerar objekt ett enkelt exempel i denna config kan vara PasswordEncoder den retunerar bara obejktet "BCryptPasswordEncoder"
och med hjälp av @Bean så kan vi använda denna metod på olika ställen i våran Springboot applikation. @EnableWebSecurity är lite som det låter, det ger oss ett extra lager
säkerhet

I securityFilterChain sätter vi vissa krav på olika endpoints för att komma åt admin måste användaren ha rollen admin t.ex. men på registrerings sidan kör vi .permitAll()
vilket som det låter tillåter vem som helst in på endpointen.
vi har även "redirects" om "loginformen" är successfull så skickas vi till "/" endpointen som i vårat fall är home pagen och om vi loggar ut skickas vi till "/logged-out"
endpointen

passwordEncoder är ett sätt för oss att hasha lösenord och att göra dom mer säkra.

 */

package se.mehdi.securewebapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorize -> authorize

                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/register", "/register/**").permitAll()
                        .anyRequest().authenticated()
                )

                .formLogin(form -> form
                       // .loginPage("/login")
                       // .permitAll()
                        .defaultSuccessUrl("/", true) // Redirect to home page after login
                )
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .permitAll()
                        .logoutSuccessUrl("/logged-out") // Redirect to logged-out page after logout
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/h2-console/", "/register", "/update/", "/delete/");
    }
}
