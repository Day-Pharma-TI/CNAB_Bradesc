package cnab_bradesc.demo;

import cnab_bradesc.demo.Business.GeraCnabPagamentoBusiness;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
       SpringApplication.run(DemoApplication.class, args);
    }
}
