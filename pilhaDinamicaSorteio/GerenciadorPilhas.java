package pilhaDinamicaSorteio;
import java.util.Random;
public class GerenciadorPilhas {
    private Pilha pilha1;
    private Pilha pilha2;
    private Pilha pilha3;
    private Random random;
    public GerenciadorPilhas() {
        this.pilha1 = new Pilha("1");
        this.pilha2 = new Pilha("2");
        this.pilha3 = new Pilha("3");
        this.random = new Random();
    }
    public Pilha getPilha1() {
        return pilha1;
    }
    public void setPilha1(Pilha pilha1) {
        this.pilha1 = pilha1;
    }
    public Pilha getPilha2() {
        return pilha2;
    }
    public void setPilha2(Pilha pilha2) {
        this.pilha2 = pilha2;
    }
    public Pilha getPilha3() {
        return pilha3;
    }
    public void setPilha3(Pilha pilha3) {
        this.pilha3 = pilha3;
    }
    public Random getRandom() {
        return random;
    }
    public void setRandom(Random random) {
        this.random = random;
    }
    public void executar() {
        try {
            fase1();
            imprimirPilhas();
            fase2();
            imprimirPilhas();
            verificarEncerramento();
        } catch (RuntimeException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
    private void fase1() {
        for (int i = 0; i < 100; i++) {
            int numero = random.nextInt(9) + 1;
            if (numero >= 1 && numero <= 3) {
                pilha1.empilhar(numero);
            } else if (numero >= 4 && numero <= 6) {
                pilha2.empilhar(numero);
            } else {
                pilha3.empilhar(numero);
            }
        }
        System.out.println("Fase 1: Números sorteados e armazenados nas pilhas:");
    }
    private void moverEntrePilhas(Pilha origem1, Pilha origem2, Pilha destino) {
        boolean origem1TemElementos = !origem1.estaVazia();
        boolean origem2TemElementos = !origem2.estaVazia();
    
        if (origem1TemElementos && origem2TemElementos) {
            int num1 = origem1.desempilhar();
            int num2 = origem2.desempilhar();
            destino.empilhar(num1);
            destino.empilhar(num2);
            System.out.println("Empilhando os números " + num1 + " e " + num2 + " na pilha " + destino.getNome());
        } else if (origem1TemElementos) {
            int num1 = origem1.desempilhar();
            destino.empilhar(num1);
            System.out.println("Empilhando o número " + num1 + " na pilha " + destino.getNome());
        } else if (origem2TemElementos) {
            int num2 = origem2.desempilhar();
            destino.empilhar(num2);
            System.out.println("Empilhando o número " + num2 + " na pilha " + destino.getNome());
        }
    }
    private void fase2() {
        for (int i = 0; i < 100; i++) {
            if (pilha1.estaVazia() || pilha2.estaVazia() || pilha3.estaVazia()) {
                break;
            }
    
            int pilhaEscolhida = random.nextInt(3) + 1;
            switch (pilhaEscolhida) {
                case 1:
                    moverEntrePilhas(pilha2, pilha3, pilha1);
                    break;
                case 2:
                    moverEntrePilhas(pilha1, pilha3, pilha2);
                    break;
                case 3:
                    moverEntrePilhas(pilha1, pilha2, pilha3);
                    break;
            }
        }
    
        System.out.println("Fase 2: Estado final das pilhas:");
    }
    private void imprimirPilhas() {
        pilha1.imprimirPilha();
        pilha2.imprimirPilha();
        pilha3.imprimirPilha();
    }
    private void verificarEncerramento() {
        if (pilha1.estaVazia()) {
            System.out.println("O programa foi encerrado porque a pilha 1 está vazia.");
        } else if (pilha2.estaVazia()) {
            System.out.println("O programa foi encerrado porque a pilha 2 está vazia.");
        } else if (pilha3.estaVazia()) {
            System.out.println("O programa foi encerrado porque a pilha 3 está vazia.");
        } else {
            System.out.println("O programa foi encerrado porque o total de números sorteados foi atingido.");
        }
    }
}

