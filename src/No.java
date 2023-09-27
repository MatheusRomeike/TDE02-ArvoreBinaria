public class No {
    private int valor;
    private No esquerda;
    private No direita;

    public No(int valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
    }

    public int getValor() {
        return this.valor;
    }

    public No getEsquerda() {
        return this.esquerda;
    }

    public No getDireita() {
        return this.direita;
    }

    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }

    public void setDireita(No direita) {
        this.direita = direita;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void inserir(int valor) {
        if (valor < getValor()) {
            if (this.esquerda == null) {
                this.esquerda = new No(valor);
            } else {
                this.esquerda.inserir(valor);
            }
        } else if (valor > getValor()) {
            if (this.direita == null) {
                this.direita = new No(valor);
            } else {
                this.direita.inserir(valor);
            }
        }
    }

    public void imprimir() {
        imprimir("", true, Integer.MIN_VALUE);
    }

    public void imprimir(int valorDesejado) {
        imprimir("", true, valorDesejado);
    }

    private void imprimir(String prefixo, boolean esquerdo, int valorDesejado) {
        String direcao;
        if (this.direita != null) {
            direcao = esquerdo ? "│   " : "    ";
            this.direita.imprimir(prefixo + direcao, false, valorDesejado);
        }
        String valorColorido = this.valor == valorDesejado ? "\u001B[32m" + this.valor + "\u001B[0m" : String.valueOf(this.valor);
        System.out.println(prefixo + (esquerdo ? "└── " : "┌── ") + valorColorido);
        if (this.esquerda != null) {
            direcao = esquerdo ? "    " : "│   ";
            this.esquerda.imprimir(prefixo + direcao, true, valorDesejado);
        }
    }


    public boolean busca(int valor) {
        if (valor > getValor()) {
            if (this.direita == null) {
                return false;
            } else {
                return this.direita.busca(valor);
            }
        } else if (valor < getValor()) {
            if (this.esquerda == null) {
                return false;
            } else {
                return this.esquerda.busca(valor);
            }
        } else {
            return true;
        }
    }

    public No deletar(int valor) {
        if (valor > getValor()) {
            if (this.direita != null) {
                this.direita = this.direita.deletar(valor);
            }
        } else if (valor < getValor()) {
            if (this.esquerda != null) {
                this.esquerda = this.esquerda.deletar(valor);
            }
        } else {
            if (this.esquerda == null) {
                return this.direita;
            } else if (this.direita == null) {
                return this.esquerda;
            } else {
                No sucessor = obterSucessor();
                this.setValor(sucessor.getValor());
                this.direita = this.direita.deletar(sucessor.getValor());
            }
        }
        System.out.println("Valor " + valor + " deletado.");
        return this;
    }


    private No obterSucessor() {
        No sucessor = this.direita;
        while (sucessor.getEsquerda() != null)
            sucessor = sucessor.getEsquerda();
        return sucessor;
    }

}
