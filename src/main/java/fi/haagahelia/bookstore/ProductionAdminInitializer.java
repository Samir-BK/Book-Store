
package fi.haagahelia.bookstore;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
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
            @Value("${ADMIN_EMAIL:}") String email,
            @Value("${ADMIN_RESET_PASSWORD:false}") boolean resetPassword) {

        return args -> {
            if (username.isBlank() || password.isBlank()) {
                return;
            }

            User admin = userRepository.findByUsername(username);

            if (admin == null) {
                if (email.isBlank()) {
                    return;
                }

                userRepository.save(new User(
                        username,
                        passwordEncoder.encode(password),
                        email,
                        "ADMIN"
                ));

                System.out.println("Production administrator created.");
            } else if (resetPassword) {
                if (!"ADMIN".equals(admin.getRole())) {
                    throw new IllegalStateException(
                            "Password reset refused: account is not an administrator.");
                }

                admin.setPassword(passwordEncoder.encode(password));
                userRepository.save(admin);

                System.out.println("Production administrator password reset completed.");
            }
        };
    }
}
