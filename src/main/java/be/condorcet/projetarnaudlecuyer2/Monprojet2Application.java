package be.condorcet.projetarnaudlecuyer2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Monprojet2Application implements CommandLineRunner {
/*
    @Autowired
    private FormateurServiceImpl formateurServiceImpl;
    @Autowired
    private SessionCoursServiceImpl sessionCoursServiceImpl;
    */

    public static void main(String[] args) {

        SpringApplication.run(Monprojet2Application.class, args);
    }



    @Override
    public void run(String... args) throws Exception {

    }

}