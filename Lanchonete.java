import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Lanchonete {
    public static void main(String[] args) {
        
        Map<Integer, String> nomes = new HashMap<>();
        Map<Integer, Double> precos = new HashMap<>();

        nomes.put(1, "Cachorro Quente");
        precos.put(1, 4.00);

        nomes.put(2, "X-Salada");
        precos.put(2, 4.50);

        nomes.put(3, "X-Bacon");
        precos.put(3, 5.00);

        nomes.put(4, "Torrada Simples");
        precos.put(4, 2.00);

        nomes.put(5, "Refrigerante");
        precos.put(5, 1.50);

        while (true) {
            
            String menu = "----- CARDÁPIO -----\n";
            for (int cod : nomes.keySet()) {
                menu += cod + " - " + nomes.get(cod) + " (R$ " + String.format("%.2f", precos.get(cod)) + ")\n";
            }
            menu += "\nDigite o código do produto (0 para sair):";

            int codigo = Integer.parseInt(JOptionPane.showInputDialog(menu));

            if (codigo == 0) {
                JOptionPane.showMessageDialog(null, "Obrigado pela preferência!");
                break;
            }

            if (!precos.containsKey(codigo)) {
                JOptionPane.showMessageDialog(null, "Código inválido!");
                continue;
            }

            int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade:"));

            double total = precos.get(codigo) * quantidade;

            // Criar janela com imagem e total
            JFrame frame = new JFrame("Pedido");
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setSize(400, 400);

            JPanel panel = new JPanel(new BorderLayout());

            JLabel labelTexto = new JLabel(
                    "<html><center>Produto: " + nomes.get(codigo) +
                    "<br>Quantidade: " + quantidade +
                    "<br>Total: R$ " + String.format("%.2f", total) + "</center></html>",
                    SwingConstants.CENTER
            );
            labelTexto.setFont(new Font("Arial", Font.BOLD, 18));

            // Carregar imagem
            ImageIcon icon = new ImageIcon("\"C:\\Users\\Davi\\Downloads\\hamburguer pnc 2,0.jpg\"");
            Image img = icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            JLabel labelImagem = new JLabel(new ImageIcon(img));
            labelImagem.setHorizontalAlignment(SwingConstants.CENTER);

            panel.add(labelTexto, BorderLayout.NORTH);
            panel.add(labelImagem, BorderLayout.CENTER);

            frame.add(panel);
            frame.setVisible(true);
        }
    }
}
