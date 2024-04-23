package Modelo;

public class Terreno extends Financiamento {
    // Atributo para armazenar o tipo de zona do terreno.
    public String tipoZona;

    public String getTipoZona() {
        return tipoZona;
    }

    // Construtor da classe Terreno.
    public Terreno(double valor, int prazoPagamento, double taxaJurosAnual, String tipoZona) {
        // Chamada ao construtor da superclasse Financiamento
        super(valor, prazoPagamento, taxaJurosAnual);
        this.tipoZona = tipoZona;
    }

    // Método para calcular o total de pagamento, com uma taxa adicional de 1.02%.
    @Override
    public double setCalcularTotalPagamento() {
        return (super.setCalcularTotalPagamento() * 102) / 100;
    }
}
