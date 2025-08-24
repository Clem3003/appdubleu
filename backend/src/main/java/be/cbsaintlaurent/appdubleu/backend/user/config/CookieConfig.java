package be.cbsaintlaurent.appdubleu.backend.user.config;

import org.springframework.boot.web.servlet.server.CookieSameSiteSupplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CookieConfig {
    @Bean
    public CookieSameSiteSupplier applicationCookieSameSiteSupplier() {
        // Ajoute SameSite=None et Secure sur JSESSIONID
        return CookieSameSiteSupplier.ofNone().whenHasName("JSESSIONID");
    }
}
