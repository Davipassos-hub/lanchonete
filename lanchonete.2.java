public class Produto {
    int id;
    String descricao;
    double preco;

    public Produto(int id, String descricao, double preco) {
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Descrição: " + descricao + " | Preço: R$ " + preco;
    }
}


