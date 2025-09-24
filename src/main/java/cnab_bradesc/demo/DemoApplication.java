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
        SpringApplication app = new SpringApplication(DemoApplication.class);
        app.setHeadless(false); // permite Swing
        app.run(args);
    }

    @Bean
    CommandLineRunner run(GeraCnabPagamentoBusiness geraCnabPagamentoBusiness) {
        return args -> {
            javax.swing.SwingUtilities.invokeLater(() -> {
                JFrame frame = new JFrame("CNAB day pharma");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JButton btnGerar = new JButton("Gerar Arquivo CNAB");
                btnGerar.addActionListener(e -> {
                    try {
                        geraCnabPagamentoBusiness.GerarCnabPagamento();
                        JOptionPane.showMessageDialog(frame, "Arquivo gerado com sucesso!");
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frame, "Erro: selecione um arquivo");
                    }
                });

                frame.getContentPane().add(btnGerar);
                frame.setSize(300, 100);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            });
        };
    }
}
