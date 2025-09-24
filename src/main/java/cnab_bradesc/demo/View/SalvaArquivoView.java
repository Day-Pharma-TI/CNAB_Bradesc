package cnab_bradesc.demo.View;

import javax.swing.*;
import  java.io.File;

public class SalvaArquivoView {

    public static File escolherLocalSalvar() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Salvar arquivo CNAB");

        fileChooser.setSelectedFile(new File("arquivo_cnab_daypharma.txt"));

        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        }

        return null;
    }
}
