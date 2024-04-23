package Util;

import java.util.Scanner;

public class InterfaceUser {
    private final Scanner scanner;

    // Construtor da classe que inicializa o Scanner.
    public InterfaceUser() {
        this.scanner = new Scanner(System.in);
    }

    // Método para escolher entre usar um financiamento pronto ou simular um financiamento.
    public int escolherOpcao() {
        System.out.println("\nEscolha uma opção!");
        System.out.println("1 - Usar um financiamento pronto");
        System.out.println("2 - Simular seu financiamento");

        int opcao;
        do {
            System.out.print("\nOpção: ");
            opcao = scanner.nextInt();
        } while (opcao != 1 && opcao != 2);

        return opcao;
    }

    // Método para escolher o tipo de imóvel a ser financiado.
    public int escolherTipoImovel() {
        System.out.println("\nEscolha uma opção:");
        System.out.println("1 - Simular financiamento de Casa");
        System.out.println("2 - Simular financiamento de Terreno");
        System.out.println("3 - Simular financiamento de Apartamento");

        int tipoImovel;
        do {
            System.out.print("\nOpção: ");
            tipoImovel = scanner.nextInt();
        } while (tipoImovel < 1 || tipoImovel > 3);

        return tipoImovel;
    }

    // Método para confirmar se o usuário deseja usar os financiamentos prontos.
    public boolean confirmacaoFinanPronto() {
        char resposta;
        do {
            System.out.print("\nTem certeza que deseja avançar com os financiamentos já prontos? (S/N): ");
            resposta = scanner.next().charAt(0);
            resposta = Character.toUpperCase(resposta);
        } while (resposta != 'S' && resposta != 'N');

        return resposta == 'S';
    }

    // Método para inserir o valor do imóvel.
    public double entradaValor() {
        System.out.print("\nPor favor insira o valor do imóvel: ");
        double valor = scanner.nextDouble();

        while (valor <= 0) {
            System.out.println("\nO valor é inválido, por favor insira um valor positivo!");
            System.out.print("Insira o valor do imóvel novamente: ");
            valor = scanner.nextDouble();
        }
        System.out.println("O valor do imóvel é: " + valor + " R$");
        return valor;
    }

    // Método para inserir o prazo de pagamento.
    public int entradaPrazo() {
        System.out.print("\nPor favor insira o prazo de pagamento (em anos): ");
        int prazoPagamento = scanner.nextInt();

        while (prazoPagamento <= 0) {
            System.out.println("\nO prazo é inválido, por favor insira um valor positivo!");
            System.out.print("Prazo em anos: ");
            prazoPagamento = scanner.nextInt();
        }
        System.out.println("O prazo é de: " + prazoPagamento + " anos");
        return prazoPagamento;
    }

    // Método para inserir a taxa de juros.
    public double entradaTaxas() {
        System.out.print("\nPor favor insira a taxa de juros (anual): ");
        double taxaJurosAnual = scanner.nextDouble();

        while (taxaJurosAnual <= 0) {
            System.out.println("\nA taxa inserida não é válida, por favor insira um valor positivo!");
            System.out.print("A taxa sem o sinal de '%': ");
            taxaJurosAnual = scanner.nextDouble();
        }
        System.out.println("A taxa de juros anual é: " + taxaJurosAnual + "%");
        return taxaJurosAnual;
    }

    // Método para inserir o número de vagas de estacionamento.
    public int entradaVagaEstacionamento() {
        System.out.print("\nPor favor insira o número correspondente a vaga do apartamento desejado: ");
        int vagaEstacionamento = scanner.nextInt();

        while (vagaEstacionamento <= 0) {
            System.out.println("\nA vaga inserida não existe no condomínio, por favor insira novamente!");
            System.out.print("As vagas começam a partir da (1), insira uma válida!: ");
            vagaEstacionamento = scanner.nextInt();
        }

        System.out.println("A sua vaga é a: " + vagaEstacionamento);
        return vagaEstacionamento;
    }

    // Método para inserir o número do andar.
    public int entradaNumeroAndar() {
        System.out.print("\nPor favor insira o número correspondente ao andar do apartamento desejado: ");
        int numeroAndar = scanner.nextInt();

        while (numeroAndar <= 0) {
            System.out.println("O andar inserido não existe no prédio, por favor insira novamente: ");
            numeroAndar = scanner.nextInt();
        }

        System.out.println("A sua vaga é a: " + numeroAndar);
        return numeroAndar;
    }

    // Método para escolher a zona do terreno.
    public String entradaZonaTerreno() {
        String zona;
        scanner.nextLine(); // Consumir a nova linha pendente do buffer
        do {
            System.out.println("\nEscolha a zona (zona rural / zona urbana): ");
            zona = scanner.nextLine().trim().toLowerCase();
            if (!zona.equals("zona rural") && !zona.equals("zona urbana")) {
                System.out.println("Por favor, insira uma zona válida (zona rural / zona urbana).");
            }
        } while (!zona.equals("zona rural") && !zona.equals("zona urbana"));

        return zona;
    }

    // Método para inserir a área construída da casa.
    public double entradaAreaContruida() {
        System.out.print("\nPor favor insira o tamanho da casa em metros: ");
        double areaConstruida = scanner.nextDouble();

        while (areaConstruida <= 0) {
            System.out.println("A área informada não é válida, tente novamente!");
            System.out.print("A área em metros: ");
            areaConstruida = scanner.nextDouble();
        }
        System.out.println("A área da casa é de " + areaConstruida + " metros quadrados");
        return areaConstruida;
    }

    // Método para inserir a área do terreno.
    public double entradaAreaTerreno() {
        System.out.print("\nPor favor insira o tamanho do terreno em metros: ");
        double areaTerreno = scanner.nextDouble();

        while (areaTerreno <= 0) {
            System.out.println("A área do terreno é inválida, tente novamente!");
            System.out.print("A área do terreno em metros: ");
            areaTerreno = scanner.nextDouble();
        }
        System.out.println("A área do terreno é de " + areaTerreno + " metros quadrados\n");
        return areaTerreno;
    }

    // Método para perguntar se o usuário deseja continuar.
    public boolean perguntarContinuar() {
        System.out.print("\nDeseja fazer mais simulações de financiamento? (s/n): ");
        String resposta = scanner.next();

        while (!resposta.equalsIgnoreCase("s") && !resposta.equalsIgnoreCase("n")) {
            System.out.println("Por favor, responda com 's' para sim ou 'n' para não.");
            resposta = scanner.next();
        }

        return resposta.equalsIgnoreCase("s");
    }
}