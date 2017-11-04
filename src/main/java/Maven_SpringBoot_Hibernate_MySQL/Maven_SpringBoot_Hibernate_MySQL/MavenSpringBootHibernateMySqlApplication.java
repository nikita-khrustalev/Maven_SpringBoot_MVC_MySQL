package Maven_SpringBoot_Hibernate_MySQL.Maven_SpringBoot_Hibernate_MySQL;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "Maven_SpringBoot_Hibernate_MySQL.Maven_SpringBoot_Hibernate_MySQL")

public class MavenSpringBootHibernateMySqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(MavenSpringBootHibernateMySqlApplication.class, args);
    }
}
