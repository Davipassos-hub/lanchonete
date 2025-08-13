import javax.swing.*;
import java.awt.*;

public class ExemploImagem {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Exemplo de Imagem");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        ImageIcon icon1 = new ImageIcon("minhaImagem.jpg");

        ImageIcon icon2 = new ImageIcon(ExemploImagem.class.getResource("minhaImagem.jpg"));

        JLabel label = new JLabel(icon1);

        frame.getContentPane().add(label, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}