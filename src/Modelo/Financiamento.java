package Modelo;

// Classe abstrata que representa um financiamento genérico.
public abstract class Financiamento {
    // Atributos protegidos para armazenar o valor, prazo de pagamento e taxa de juros anual.
    protected final double valor;
    protected final int prazoPagamento;
    protected final double taxaJurosAnual;

    // Construtor da classe Financiamento.
    public Financiamento(double valor, int prazoPagamento, double taxaJurosAnual) {
        this.valor = valor;
        this.prazoPagamento = prazoPagamento;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    // Métodos de acesso aos atributos da classe.
    public double getValor() {
        return valor;
    }

    public int getPrazoPagamento() {
        return prazoPagamento;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    // Método abstrato para calcular o pagamento mensal do financiamento.
    public double setCalcularPagamentoMensal() {
        return (this.valor / (this.prazoPagamento * 12)) * (1 + (taxaJurosAnual / 100 / 12));
    }

    // Método para calcular o total de pagamentos ao longo do prazo do financiamento.
    public double setCalcularTotalPagamento() {
        return setCalcularPagamentoMensal() * prazoPagamento * 12;
    }

    // Método toString para representar o financiamento como uma string formatada.
    @Override
    public String toString() {
        return "Financiamento | " +
                "Valor: " + getValor() +
                "| Prazo de pagamento: " + getPrazoPagamento() + " anos" +
                "| Taxa juros anual: " + getTaxaJurosAnual() + "%\n\n";
    }
}