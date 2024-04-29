package Modelo;

import Util.DescontoMaiorDoQueJurosException;

public class Casa extends Financiamento {
    // Atributos para armazenar a área construída e a área do terreno da casa.
    protected double areaConstruida;
    protected double areaTerreno;
    protected double desconto;

    public double getAreaConstruida() { // getter para a área Construida
        return areaConstruida;
    }

    public double getAreaTerreno() { // getter para a área de terreno
        return areaTerreno;
    }

    public double getDesconto() { // getter para o desconto
        return desconto;
    }

    // Construtor da classe Casa.
    public Casa(double valor, int prazoPagamento, double taxaJurosAnual, double areaConstruida, double areaTerreno, double desconto) throws DescontoMaiorDoQueJurosException {
        // Chamada ao construtor da superclasse Financiamento
        super(valor, prazoPagamento, taxaJurosAnual);

        // Verifica se o desconto é maior que o juro mensal
        if (desconto > super.setCalcularPagamentoMensal()) {
            throw new DescontoMaiorDoQueJurosException();
        }

        this.areaConstruida = areaConstruida;
        this.areaTerreno = areaTerreno;
        this.desconto = desconto;
    }

    public double setCalcularPagamentoMensal() {
        return super.setCalcularPagamentoMensal() - desconto;
    }
}
