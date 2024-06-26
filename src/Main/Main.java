package Main;

import Modelo.Financiamento;
import Modelo.Terreno;
import Modelo.Casa;
import Modelo.Apartamento;
import Util.DescontoMaiorDoQueJurosException;
import Util.InterfaceUser;


import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {  // Inicia o código.
        InterfaceUser interfaceUser = new InterfaceUser();
        ArquivoUtil.limparArquivo("ArquivoUtil.txt");

        List<Financiamento> financiamentos = new ArrayList<>(ArquivoUtil.lerFinanciamentos("ArquivoUtil.txt"));

        // Loop principal para continuar ou parar as simulações.
        boolean continuar = true;

        while (continuar) {
            int tipoImovel = interfaceUser.escolherTipoImovel(); // Seleciona o tipo de imóvel.
            int opcao = interfaceUser.escolherOpcao(); // Pergunta se deseja usar um financiamento pronto ou simular um novo.

            if (opcao == 1) {
                if (interfaceUser.confirmacaoFinanPronto()) {
                    try {
                        FinanciamentosProntos(financiamentos, tipoImovel);
                    } catch (DescontoMaiorDoQueJurosException e) {
                        System.out.println(e.getMessage());
                    }
                } else {
                    try {
                        simularNovosFinanciamentos(interfaceUser, financiamentos, tipoImovel);
                    } catch (DescontoMaiorDoQueJurosException e) {
                        System.out.println(e.getMessage());
                    }
                }
            } else {
                try {
                    simularNovosFinanciamentos(interfaceUser, financiamentos, tipoImovel);
                } catch (DescontoMaiorDoQueJurosException e) {
                    System.out.println(e.getMessage());
                }
            }

            imprimirFinanciamentosIndividuais(financiamentos);

            continuar = interfaceUser.perguntarContinuar();
        }

        imprimirSomaFinanciamentos(financiamentos);

        ArquivoUtil.salvarFinanciamentos(financiamentos);
    }

    // Método para adicionar financiamentos prontos à lista.
    private static void FinanciamentosProntos(List<Financiamento> financiamentos, int tipoImovel) throws DescontoMaiorDoQueJurosException {
        switch (tipoImovel) {
            case 1:
                financiamentos.add(new Casa(200000, 20, 5, 60.5, 100.2, 0.0));
                financiamentos.add(new Casa(350000, 25, 3, 102.5, 125, 0.0));
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
    private static void simularNovosFinanciamentos(InterfaceUser interfaceUser, List<Financiamento> financiamentos, int tipoImovel)
            throws DescontoMaiorDoQueJurosException {
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
    private static void simularFinanciamentoCasa(InterfaceUser interfaceUser, List<Financiamento> financiamentos) throws DescontoMaiorDoQueJurosException {
        double valor = interfaceUser.entradaValor();
        int prazoPagamento = interfaceUser.entradaPrazo();
        double taxaJuros = interfaceUser.entradaTaxas();
        double areaContruida = interfaceUser.entradaAreaContruida();
        double areaTerreno = interfaceUser.entradaAreaTerreno();
        double desconto = interfaceUser.entradaDoDesconto();

        Casa casa = new Casa(valor, prazoPagamento, taxaJuros, areaContruida, areaTerreno, desconto);
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
        System.out.println("\n\nDetalhes de cada financiamento\n");
        for (int i = 0; i < financiamentos.size(); i++) {
            Financiamento financiamento = financiamentos.get(i);
            if (financiamento != null) { // Verifica se o objeto financiamento não é nulo
                financiamento.setCalcularPagamentoMensal(); // Calcula o pagamento mensal.
                financiamento.setCalcularTotalPagamento(); // Calcula o total de pagamento.
                System.out.println("Financiamento " + (i + 1));
                switch (financiamento) {
                    case Casa casa -> {
                        System.out.println("Tipo: Casa");
                        System.out.println("Área Construída: " + casa.getAreaConstruida());
                        System.out.println("Área do Terreno: " + casa.getAreaTerreno());
                        System.out.println("Valor mensal da simulação: " + casa.setCalcularPagamentoMensal());
                        System.out.println("Valor total da simulação: " + casa.setCalcularPagamentoMensal());
                        System.out.println("Desconto aplicado: " + casa.getDesconto() + "% ao mês");
                    }
                    case Terreno terreno -> {
                        System.out.println("Tipo: Terreno");
                        System.out.println("Tipo de Zona: " + terreno.getTipoZona());
                        System.out.println("Valor mensal da simulação: " + terreno.setCalcularPagamentoMensal());
                        System.out.println("Valor total da simulação: " + terreno.setCalcularPagamentoMensal());
                    }
                    case Apartamento apartamento -> {
                        System.out.println("Tipo: Apartamento");
                        System.out.println("Vaga de Estacionamento: " + apartamento.getVagaEstacionamento());
                        System.out.println("Número do Andar: " + apartamento.getNumeroAndar());
                        System.out.println("Valor mensal da simulação: " + apartamento.setCalcularPagamentoMensal());
                        System.out.println("Valor total da simulação: " + apartamento.setCalcularPagamentoMensal());
                    }
                    default ->
                            System.out.println("Tipo de imóvel não reconhecido: " + financiamento.getClass().getSimpleName());
                }
                System.out.println(financiamento); // Imprime detalhes gerais do financiamento.
            }
        }
    }

    //Método para imprirmir a soma dos financiamentos.
    private static void imprimirSomaFinanciamentos(List<Financiamento> financiamentos) {
        double somaTotal = 0;
        System.out.println("\n\nValor de cada financiamento");
        for (int i = 0; i < financiamentos.size(); i++) {
            Financiamento financiamento = financiamentos.get(i);
            if (financiamento != null) { // Verifica se o financiamento não é nulo
                double valorFinanciamento = financiamento.setCalcularTotalPagamento();
                somaTotal += valorFinanciamento;
                System.out.println("Financiamento " + (i + 1) + ": " + valorFinanciamento);
            } else {
                System.out.println("Financiamento " + (i + 1) + " é nulo.");
            }
        }
        System.out.println("\nValor total do financiamento:  " + somaTotal);
    }
}
