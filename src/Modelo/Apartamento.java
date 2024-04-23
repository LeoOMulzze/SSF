package Modelo;

import java.lang.Math;

public class Apartamento extends Financiamento {
    // Atributos para armazenar o número da vaga de estacionamento e o número do andar do apartamento.
    protected final int vagaEstacionamento;
    protected int numeroAndar;

    // Getters para detalhes especificos do apartamento.
    public int getVagaEstacionamento() {
        return vagaEstacionamento;
    }

    public int getNumeroAndar() {
        return numeroAndar;
    }

    // Construtor da classe Apartamento.
    public Apartamento(double valor, int prazoPagamento, double taxaJurosAnual, int vagaEstacionamento, int numeroAndar) {
        // Chamada ao construtor da superclasse Financiamento
        super(valor, prazoPagamento, taxaJurosAnual);
        this.vagaEstacionamento = vagaEstacionamento;
        this.numeroAndar = numeroAndar;
    }

    // Método para calcular o pagamento mensal.
    @Override
    public double setCalcularPagamentoMensal() {
        // Cálculo do pagamento mensal utilizando a fórmula de amortização de empréstimo.
        double taxaDeJurosMensal = this.taxaJurosAnual / 100 / 12;
        int totalParcelas = this.prazoPagamento * 12;
        double numerador = this.valor * taxaDeJurosMensal * Math.pow(1 + taxaDeJurosMensal, totalParcelas);
        double denominador = Math.pow(1 + taxaDeJurosMensal, totalParcelas) - 1;
        return numerador / denominador;
    }
}

