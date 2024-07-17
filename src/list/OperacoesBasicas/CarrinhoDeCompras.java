package list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Item> listaDeItens;

    public CarrinhoDeCompras() {
        this.listaDeItens = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade) {
        Item item = new Item(nome, preco, quantidade);
        this.listaDeItens.add(item);

    }

    public void removerItem(String nome) {
        List<Item> itemParaRemover = new ArrayList<>();
        if (!listaDeItens.isEmpty()) {
            for(Item item : listaDeItens) {
                if(item.getNome().equalsIgnoreCase(nome)) {
                    itemParaRemover.add(item);
                }
            }

            listaDeItens.removeAll(itemParaRemover);
        } else {
            System.out.println("A lista esta vazia");
        }
    }

    public double calcularValorTotal() {
        double valorTotal = 0d;
        if (!listaDeItens.isEmpty()) {
            for (Item item : listaDeItens) {
                double valorItem = item.getPreco() * item.getQuantidade();
                valorTotal += valorItem;
            }
            return valorTotal;
        } else {
            throw new RuntimeException("A lista esta vaiza!");
        }
    }

    public void exibirItens() {
        if (!listaDeItens.isEmpty()) {
            System.out.println(this.listaDeItens);
        } else {
            System.out.println("A lista esta vazia");
        }
    }

    @Override
    public String toString() {
        return "CarrinhoDeCompras{" +
                "listaDeItens=" + listaDeItens +
                '}';
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();

        System.out.println("*** Adicionando itens no carrinho de compras ***");
        carrinho.adicionarItem("Mouse Gamer Fortrek", 55d, 1);
        carrinho.adicionarItem("Mouse Generico sem marca", 25d, 5);
        carrinho.adicionarItem("PadMouse Gamer Fortrek", 30d, 3);
        carrinho.adicionarItem("Teclado Gamer Fortrek", 125d, 1);

        System.out.println(" *** Exibindo itens do carrinho ***");
        carrinho.exibirItens();

        System.out.println(" *** Removendo itens do carrinho");
        carrinho.removerItem("Mouse Generico sem marca");

        System.out.println(" *** Exibindo itens atualizados do carrinho ***");
        carrinho.exibirItens();

        System.out.println(" *** Calculando o valor total da compra ***");
        System.out.println("O valor total da compra é: " + carrinho.calcularValorTotal());

    }
}
