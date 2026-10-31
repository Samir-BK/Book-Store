
package fi.haagahelia.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;

import fi.haagahelia.bookstore.domain.User;
import fi.haagahelia.bookstore.domain.UserRepository;

@Configuration
@Profile("prod")
public class ProductionAdminInitializer {

    @Bean
    public CommandLineRunner createProductionAdmin(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            @Value("${ADMIN_USERNAME:}") String username,
            @Value("${ADMIN_PASSWORD:}") String password,
            @Value("${ADMIN_EMAIL:}") String email) {

        return args -> {
            if (username.isBlank() || password.isBlank() || email.isBlank()) {
                return;
            }

            if (userRepository.findByUsername(username) == null) {
                User admin = new User(
                        username,
                        passwordEncoder.encode(password),
                        email,
                        "ADMIN"
                );

                userRepository.save(admin);
                System.out.println("Production administrator created.");
            }
        };
    }
}
