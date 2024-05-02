package Main;

import Modelo.Financiamento;
import Modelo.Apartamento;
import Modelo.Casa;
import Modelo.Terreno;
import Util.DescontoMaiorDoQueJurosException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArquivoUtil {

    private static final Logger logger = Logger.getLogger(ArquivoUtil.class.getName());

    public static void salvarFinanciamentos(List<Financiamento> financiamentos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("ArquivoUtil.txt"))) {
            for (Financiamento financiamento : financiamentos) {
                String infoAdicionais = obterInformacoesAdicionais(financiamento);
                writer.write(financiamento.toString() + "," + infoAdicionais);
                writer.newLine();
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Erro ao salvar financiamentos: " + e.getMessage(), e);
        }
    }

    private static String obterInformacoesAdicionais(Financiamento financiamento) {
        return switch (financiamento) {
            case Casa casa ->
                    String.format("%f,%f,%f", casa.getAreaConstruida(), casa.getAreaTerreno(), casa.getDesconto());
            case Apartamento apartamento ->
                    String.format("%d,%d", apartamento.getVagaEstacionamento(), apartamento.getNumeroAndar());
            case Terreno terreno -> terreno.getTipoZona();
            case null, default -> "";
        };
    }

    public static List<Financiamento> lerFinanciamentos(String nomeArquivo) {
        List<Financiamento> financiamentos = new ArrayList<>();
        File arquivo = new File(nomeArquivo);

        if (!arquivo.exists()) {
            System.out.println("O arquivo especificado não foi encontrado.");
            return financiamentos;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while (null != (linha = reader.readLine())) {
                String[] dados = linha.split(",");
                financiamentos.add(criarFinanciamento(dados));
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Erro ao ler financiamentos: " + e.getMessage(), e);
        }
        return financiamentos;
    }

    private static Financiamento criarFinanciamento(String[] dados) {
        String tipoImovel = dados[0];
        double valorImovel;
        int prazoFinanciamento;
        double taxaJuros;

        switch (tipoImovel) {
            case "Casa":
                valorImovel = Double.parseDouble(dados[1]);
                prazoFinanciamento = Integer.parseInt(dados[2]);
                taxaJuros = Double.parseDouble(dados[3]);
                double areaConstruida = Double.parseDouble(dados[4]);
                double areaTerreno = Double.parseDouble(dados[5]);
                double desconto = Double.parseDouble(dados[6]);
                try {
                    return new Casa(valorImovel, prazoFinanciamento, taxaJuros, areaConstruida, areaTerreno, desconto);
                } catch (DescontoMaiorDoQueJurosException e) {
                    logger.log(Level.SEVERE, "Erro ao criar financiamento de Casa: " + e.getMessage(), e);
                    throw new RuntimeException(e);
                }

            case "Apartamento":
                valorImovel = Double.parseDouble(dados[1]);
                prazoFinanciamento = Integer.parseInt(dados[2]);
                taxaJuros = Double.parseDouble(dados[3]);
                int vagaEstacionamento = Integer.parseInt(dados[4]);
                int numeroAndar = Integer.parseInt(dados[5]);
                return new Apartamento(valorImovel, prazoFinanciamento, taxaJuros, vagaEstacionamento, numeroAndar);

            case "Terreno":
                valorImovel = Double.parseDouble(dados[1]);
                prazoFinanciamento = Integer.parseInt(dados[2]);
                taxaJuros = Double.parseDouble(dados[3]);
                String tipoZona = dados[4];
                return new Terreno(valorImovel, prazoFinanciamento, taxaJuros, tipoZona);

            default:
                throw new IllegalArgumentException("Tipo de imóvel não reconhecido: " + tipoImovel);
        }
    }

    public static void limparArquivo(String nomeArquivo) {
        File arquivo = new File(nomeArquivo);
        if (arquivo.exists()) {
            if (arquivo.delete()) {
                System.out.println("Arquivo " + nomeArquivo + " excluído com sucesso.");
            } else {
                System.out.println("Falha ao excluir o arquivo " + nomeArquivo + ".");
            }
        }
    }
}

