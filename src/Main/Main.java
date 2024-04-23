package Main;

import Modelo.Financiamento;
import Modelo.Terreno;
import Modelo.Casa;
import Modelo.Apartamento;
import Util.InterfaceUser;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {  // Inicia o código.
        InterfaceUser interfaceUser = new InterfaceUser();
        List<Financiamento> financiamentos = new ArrayList<>();

        // Loop principal para continuar ou parar as simulações.
        boolean continuar = true;

        while (continuar) {
            int tipoImovel = interfaceUser.escolherTipoImovel(); // Seleciona o tipo de imóvel.
            int opcao = interfaceUser.escolherOpcao(); // Pergunta se deseja usar um financiamento pronto ou simular um novo.

            if (opcao == 1) {
                if (interfaceUser.confirmacaoFinanPronto()) { // Se escolher usar um financiamento pronto.
                    FinanciamentosProntos(financiamentos, tipoImovel); // Carrega financiamentos prontos.
                } else {
                    simularNovosFinanciamentos(interfaceUser, financiamentos, tipoImovel); // Simula novos financiamentos.
                }
            } else {
                simularNovosFinanciamentos(interfaceUser, financiamentos, tipoImovel); // Simula novos financiamentos.
            }

            imprimirFinanciamentosIndividuais(financiamentos); // Imprime os financiamentos individuais após cada simulação.

            continuar = interfaceUser.perguntarContinuar(); // Pergunta se deseja continuar ou parar.
        }

        // Ao final do loop while, imprimimos a soma total dos financiamentos.
        imprimirSomaFinanciamentos(financiamentos);
    }

    // Método para adicionar financiamentos prontos à lista.
    private static void FinanciamentosProntos(List<Financiamento> financiamentos, int tipoImovel) {
        switch (tipoImovel) {
            case 1:
                financiamentos.add(new Casa(200000, 20, 5, 60.5, 100.2));
                financiamentos.add(new Casa(350000, 25, 3, 102.5, 125));
                break;
            case 2:
                financiamentos.add(new Terreno(120000, 3, 8, "Zona Rural"));
                financiamentos.add(new Terreno(180000, 10, 12, "Zona Urbana"));
                break;
            case 3:
                financiamentos.add(new Apartamento(280000, 18, 3.3, 55, 4));
                financiamentos.add(new Apartamento(185000, 20, 5.5, 33, 3));
                break;
        }
    }

    // Método para simular novos financiamentos.
    private static void simularNovosFinanciamentos(InterfaceUser interfaceUser, List<Financiamento> financiamentos, int tipoImovel) {
        switch (tipoImovel) {
            case 1:
                simularFinanciamentoCasa(interfaceUser, financiamentos);
                break;
            case 2:
                simularFinanciamentoTerreno(interfaceUser, financiamentos);
                break;
            case 3:
                simularFinanciamentoApartamento(interfaceUser, financiamentos);
                break;
        }
    }

    // Métodos para simular financiamentos de cada tipo de imóvel.
    private static void simularFinanciamentoCasa(InterfaceUser interfaceUser, List<Financiamento> financiamentos) {
        double valor = interfaceUser.entradaValor();
        int prazoPagamento = interfaceUser.entradaPrazo();
        double taxaJuros = interfaceUser.entradaTaxas();
        double areaContruida = interfaceUser.entradaAreaContruida();
        double areaTerreno = interfaceUser.entradaAreaTerreno();

        Casa casa = new Casa(valor, prazoPagamento, taxaJuros, areaContruida, areaTerreno);
        financiamentos.add(casa);
    }

    private static void simularFinanciamentoTerreno(InterfaceUser interfaceUser, List<Financiamento> financiamentos) {
        double valor = interfaceUser.entradaValor();
        int prazoPagamento = interfaceUser.entradaPrazo();
        double taxaJuros = interfaceUser.entradaTaxas();
        String tipoZona = interfaceUser.entradaZonaTerreno();

        Terreno terreno = new Terreno(valor, prazoPagamento, taxaJuros, tipoZona);
        financiamentos.add(terreno);
    }

    private static void simularFinanciamentoApartamento(InterfaceUser interfaceUser, List<Financiamento> financiamentos) {
        double valor = interfaceUser.entradaValor();
        int prazoPagamento = interfaceUser.entradaPrazo();
        double taxaJuros = interfaceUser.entradaTaxas();
        int vagaEstacionamento = interfaceUser.entradaVagaEstacionamento();
        int numeroAndar = interfaceUser.entradaNumeroAndar();

        Apartamento apartamento = new Apartamento(valor, prazoPagamento, taxaJuros, vagaEstacionamento, numeroAndar);
        financiamentos.add(apartamento);
    }

    // Métodos para imprimir os financiamentos individuais e a soma total.
    private static void imprimirFinanciamentosIndividuais(List<Financiamento> financiamentos) {
        System.out.println("Detalhes de cada financiamento\n\n");
        for (int i = 0; i < financiamentos.size(); i++) {
            Financiamento financiamento = financiamentos.get(i);
            financiamento.setCalcularPagamentoMensal(); // Calcula o pagamento mensal.
            financiamento.setCalcularTotalPagamento(); // Calcula o total de pagamento.
            System.out.println("Financiamento " + (i + 1));
            switch (financiamento) {
                case Casa casa -> {
                    System.out.println("Tipo: Casa");
                    System.out.println("Área Construída: " + casa.getAreaConstruida());
                    System.out.println("Área do Terreno: " + casa.getAreaTerreno());
                    System.out.println("Valor mensal da simulação: " + financiamento.setCalcularPagamentoMensal());
                    System.out.println("Valor total da simulação: " + financiamento.setCalcularTotalPagamento());
                }
                case Terreno terreno -> {
                    System.out.println("Tipo: Terreno");
                    System.out.println("Tipo de Zona: " + terreno.getTipoZona());
                    System.out.println("Valor mensal da simulação: " + financiamento.setCalcularPagamentoMensal());
                    System.out.println("Valor total da simulação: " + financiamento.setCalcularTotalPagamento());
                }
                case Apartamento apartamento -> {
                    System.out.println("Tipo: Apartamento");
                    System.out.println("Vaga de Estacionamento: " + apartamento.getVagaEstacionamento());
                    System.out.println("Número do Andar: " + apartamento.getNumeroAndar());
                    System.out.println("Valor mensal da simulação: " + financiamento.setCalcularPagamentoMensal());
                    System.out.println("Valor total da simulação: " + financiamento.setCalcularTotalPagamento());
                }
                default -> {
                }
            }
            System.out.println(financiamento); // Imprime detalhes gerais do financiamento.
        }
    }

    //Método para imprirmir a soma dos financiamentos.
    private static void imprimirSomaFinanciamentos(List<Financiamento> financiamentos) {
        double somaTotal = 0;
        System.out.println("\n\nValor de cada financiamento");
        for (int i = 0; i < financiamentos.size(); i++) {
            Financiamento financiamento = financiamentos.get(i);
            double valorFinanciamento = financiamento.setCalcularTotalPagamento();
            somaTotal += valorFinanciamento;
            System.out.println("Financiamento " + (i + 1) + ": " + valorFinanciamento);
        }
        System.out.println("\nValor total do financiamento:  " + somaTotal);
    }
}