package pilhaDinamicaSorteio;
import java.util.Stack;

class Pilha {
    private String nome;
    private Stack<Integer> pilha;

    public Pilha(String nome) {
        this.nome = nome;
        this.pilha = new Stack<>();
    }

    public String getNome() {
        return nome;
    }

    public void empilhar(int valor) {
        pilha.push(valor);
    }

    public int desempilhar() {
        if (pilha.isEmpty()) {
            throw new RuntimeException("A pilha " + nome + " está vazia.");
        }
        return pilha.pop();
    }

    public boolean estaVazia() {
        return pilha.isEmpty();
    }

    public void imprimirPilha() {
        System.out.println("Pilha " + nome + ": " + pilha);
    }
}