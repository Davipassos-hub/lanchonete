import java.util.ArrayList;
import java.util.Scanner;

public class CadastroProduto {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Produto> produtos = new ArrayList<>();

    public static void main(String[] args) {
        int opcao;
        do {
            menu();
            opcao = lerInt("Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    editarProduto();
                    break;
                case 3:
                    excluirProduto();
                    break;
                case 4:
                    listarProdutos();
                    break;
                case 5:
                    venderProduto();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);
    }

    private static void menu() {
        System.out.println("\n--- MENU ---");
        System.out.println("1 - Cadastrar produto");
        System.out.println("2 - Editar produto");
        System.out.println("3 - Excluir produto");
        System.out.println("4 - Listar produtos");
        System.out.println("5 - Vender produto");
        System.out.println("0 - Sair");
    }

    static void cadastrarProduto() {
        int id = lerInt("Qual o código do produto: ");
        System.out.print("Qual a descrição: ");
        String descricao = sc.nextLine();
        double preco = lerDouble("Qual o preço: ");

        Produto p = new Produto(id, descricao, preco);
        produtos.add(p);

        System.out.println("Produto cadastrado com sucesso!");
    }

    static void editarProduto() {
        int id = lerInt("Digite o ID do produto para editar: ");
        for (Produto p : produtos) {
            if (p.id == id) {
                System.out.print("Nova descrição: ");
                p.descricao = sc.nextLine();
                p.preco = lerDouble("Novo preço: ");
                System.out.println("Produto atualizado!");
                return;
            }
        }
        System.out.println("Produto não encontrado!");
    }

    static void excluirProduto() {
        int id = lerInt("Digite o ID do produto para excluir: ");
        if (produtos.removeIf(p -> p.id == id)) {
            System.out.println("Produto excluído!");
        } else {
            System.out.println("Produto não encontrado!");
        }
    }

    static void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado!");
        } else {
            for (Produto p : produtos) {
                System.out.println(p);
            }
        }
    }

    static void venderProduto() {
        int id = lerInt("Digite o ID do produto para vender: ");
        if (produtos.removeIf(p -> p.id == id)) {
            System.out.println("Produto vendido!");
        } else {
            System.out.println("Produto não encontrado!");
        }
    }

    // Métodos auxiliares para leitura segura
    static int lerInt(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido! Digite um número inteiro.");
            }
        }
    }

    static double lerDouble(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido! Digite um número decimal.");
            }
        }
    }
}
