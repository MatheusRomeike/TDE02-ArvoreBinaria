public class Main {
    public static void main(String[] args) {

        No no = new No(50);

        no.inserir(30);
        no.inserir(70);
        no.inserir(20);
        no.inserir(40);
        no.inserir(60);
        no.inserir(80);


        /*
        int valorDesejado = 30;
        if (no.busca(valorDesejado)) {
            System.out.println("Valor " + valorDesejado + " encontrado.");
            no.imprimir(valorDesejado);
        } else
            System.out.println("Valor " + valorDesejado + " não encontrado.");
        */

        no.deletar(50);
        no.imprimir();

    }
}