package Modelo;

public class Casa extends Financiamento {
    // Atributos para armazenar a área construída e a área do terreno da casa.
    protected double areaConstruida;
    protected double areaTerreno;

    public double getAreaConstruida() {
        return areaConstruida;
    }

    public double getAreaTerreno() {
        return areaTerreno;
    }

    // Construtor da classe Casa.
    public Casa(double valor, int prazoPagamento, double taxaJurosAnual, double areaConstruida, double areaTerreno) {
        // Chamada ao construtor da superclasse Financiamento
        super(valor, prazoPagamento, taxaJurosAnual);
        this.areaConstruida = areaConstruida;
        this.areaTerreno = areaTerreno;
    }

    // Método para calcular o pagamento mensal, com um acréscimo de R$80.
    @Override
    public double setCalcularPagamentoMensal() {
        return super.setCalcularPagamentoMensal() + 80;
    }
}
