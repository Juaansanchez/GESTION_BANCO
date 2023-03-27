package es.taw.gestionbanco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class GestionBancoApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionBancoApplication.class, args);
    }

}
