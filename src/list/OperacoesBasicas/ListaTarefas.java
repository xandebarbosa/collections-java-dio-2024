package list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefas {
    private List<Tarefa> tarefaList;

    public ListaTarefas() {
        this.tarefaList = new ArrayList<>(); //Criando um arrayList vazio
    }

    public void adicionarTarefa(String descricao) {
        tarefaList.add(new Tarefa(descricao)); //adicionando uma nova tarefa
    }

    public void removerTarefa(String descricao) {
        //List representa todas as tarefas para remoção
        List<Tarefa> tarefasParaRemover = new ArrayList<>();
        for(Tarefa tarefa : tarefaList) { //pegando cada tarefa de dentro de tarefaList
            //Se a descrição da tarefa for igual a descrição passada como parametro no metodo
            //Pego tarefasParaRemover e vou adicionar, vai percorrer toda a lista
            if(tarefa.getDescricao().equalsIgnoreCase(descricao)) {
                tarefasParaRemover.add(tarefa);
            }
        }
        //pegando a lista original "tarefaList" chamando removeAll chamando tarefasParaRemover, remove também elementos repetidos
        tarefaList.removeAll(tarefasParaRemover);
    }

    public int obterNumeroTotalTarefas() {
        return tarefaList.size();
    }

    public void obterDescricoesTarefas() {

        System.out.println(tarefaList);
    }

    public static void main(String[] args) {

        ListaTarefas listaTarefa = new ListaTarefas();
        System.out.println("O número de elementos na lista é: " + listaTarefa.obterNumeroTotalTarefas());

        listaTarefa.adicionarTarefa("Tarefa 1");
        listaTarefa.adicionarTarefa("Tarefa 1");
        listaTarefa.adicionarTarefa("Tarefa 2");
        System.out.println("O número de elementos na lista é: " + listaTarefa.obterNumeroTotalTarefas());

        listaTarefa.removerTarefa("Tarefa 1");
        System.out.println("O número de elementos na lista é: " + listaTarefa.obterNumeroTotalTarefas());

        listaTarefa.obterDescricoesTarefas();
    }
}
