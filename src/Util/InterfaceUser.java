package Util;

import java.util.InputMismatchException;
import java.util.Scanner;



public class InterfaceUser {
    private final Scanner scanner;

    public InterfaceUser() { // Construtor da classe que inicializa o Scanner.
        this.scanner = new Scanner(System.in);
    }

    public int escolherOpcao() { // Método para escolher entre usar um financiamento pronto ou simular um financiamento.
        System.out.println("\nEscolha uma opção!");
        System.out.println("1 - Usar um financiamento pronto");
        System.out.println("2 - Simular seu financiamento");

        int opcao = 0;
        boolean entradaValida = false;
        do {
            System.out.print("\nOpção: ");
            try {
                opcao = scanner.nextInt();
                if (opcao != 1 && opcao != 2) {
                    System.out.println("Opção invalida! Por favor insira 1 ou 2.");
                } else {
                    entradaValida = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada Invalida! Por favor insira um número!(1 ou 2)");
                scanner.next();
            }
        } while (!entradaValida);

        return opcao;
    }

    public int escolherTipoImovel() { // Método para escolher o tipo de imóvel a ser financiado.
        System.out.println("\nEscolha uma opção:");
        System.out.println("1 - Simular financiamento de Casa");
        System.out.println("2 - Simular financiamento de Terreno");
        System.out.println("3 - Simular financiamento de Apartamento");

        int tipoImovel = 0;
        boolean entradaValida = false;
        do {
            System.out.print("\nOpção: ");
            try {
                tipoImovel = scanner.nextInt();
                if (tipoImovel < 1 || tipoImovel > 3) {
                    System.out.println("Entrada invalida! Por favor insira 1, 2 ou 3!");
                } else {
                    entradaValida = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada Invalida! Por favor insira um numero!(1, 2 ou 3)");
                scanner.next();
            }
        } while (!entradaValida);
        return tipoImovel;
    }

    public boolean confirmacaoFinanPronto() { // Método para confirmar se o usuário deseja usar os financiamentos prontos.
        char resposta = ' ';
        boolean entradaValida = false;
        do {
            System.out.print("\nTem certeza que deseja avançar com os financiamentos já prontos? (S/N): ");
            try {
                resposta = scanner.next().toUpperCase().charAt(0);
                if (resposta != 'S' && resposta != 'N') {
                    System.out.println("Entrada inválida! Por favor, responda com 'S' ou 'N'.");
                } else {
                    entradaValida = true;
                }
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Por favor, responda com 'S' ou 'N'.");
                scanner.nextLine();
            }
        } while (!entradaValida);

        return resposta == 'S';
    }

    public double entradaValor() { // Método para inserir o valor do imóvel.
        double valor = 0.0;
        boolean entradaValida = false;
        do {
            try {
                System.out.print("\nPor favor insira o valor do imóvel: ");
                valor = scanner.nextDouble();
                if (valor <= 0) {
                    System.out.println("\nO valor é inválido, por favor insira um valor positivo!");
                } else {
                    entradaValida = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Por favor, insira um valor numérico.");
                scanner.next();
            }
        } while (!entradaValida);

        System.out.println("O valor do imóvel é: " + valor + " R$");
        return valor;
    }

    public int entradaPrazo() { // Método para inserir o prazo de pagamento.
        int prazoPagamento = 0;
        boolean entradaValida = false;
        do {
            try {
                System.out.print("\nPor favor insira o prazo de pagamento (em anos): ");
                prazoPagamento = scanner.nextInt();
                if (prazoPagamento <= 0) {
                    System.out.println("\nO prazo é inválido, por favor insira um valor positivo!");
                } else {
                    entradaValida = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Por favor, insira um valor numérico inteiro.");
                scanner.next();
            }
        } while (!entradaValida);

        System.out.println("O prazo é de: " + prazoPagamento + " anos");
        return prazoPagamento;
    }

    public double entradaTaxas() { // Método para inserir a taxa de juros.
        double taxaJurosAnual = 0.0;
        boolean entradaValida = false;
        do {
            try {
                System.out.print("\nPor favor insira a taxa de juros (anual): ");
                taxaJurosAnual = scanner.nextDouble();
                if (taxaJurosAnual <= 0) {
                    System.out.println("\nA taxa inserida não é válida, por favor insira um valor positivo!");
                } else {
                    entradaValida = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Por favor, insira um valor numérico.");
                scanner.next();
            }
        } while (!entradaValida);

        System.out.println("A taxa de juros anual é: " + taxaJurosAnual + "%");
        return taxaJurosAnual;
    }

    public double entradaDoDesconto() { // Método para a entrada do desconto.
        double desconto = 0.0;
        boolean entradaValida = false;
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                System.out.println("\nCaso você tenha recebido algum desconto, insira-o aqui: ");
                desconto = scanner.nextDouble();

                if (desconto < 0) {
                    System.out.println("O valor informado não é válido, precisa ser positivo.");
                } else {
                    entradaValida = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida, por favor insira apenas números.");
                scanner.next();
            }
        } while (!entradaValida);
        System.out.println("Desconto aplicado no valor de: " + desconto);
        return desconto;
    }

    public int entradaVagaEstacionamento() { // Método para inserir o número de vagas de estacionamento.
        int vagaEstacionamento = 0;
        boolean entradaValida = false;
        do {
            try {
                System.out.print("\nPor favor insira o número correspondente a vaga do apartamento desejado: ");
                vagaEstacionamento = scanner.nextInt();
                if (vagaEstacionamento <= 0) {
                    System.out.println("\nA vaga inserida não existe no condomínio, por favor insira novamente!");
                } else {
                    entradaValida = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Por favor, insira um número inteiro.");
                scanner.next();
            }
        } while (!entradaValida);

        System.out.println("A sua vaga é a: " + vagaEstacionamento);
        return vagaEstacionamento;
    }

    public int entradaNumeroAndar() { // Método para inserir o número do andar.
        int numeroAndar = 0;
        boolean entradaValida = false;
        do {
            try {
                System.out.print("\nPor favor insira o número correspondente ao andar do apartamento desejado: ");
                numeroAndar = scanner.nextInt();
                if (numeroAndar <= 0) {
                    System.out.println("\nO andar inserido não existe no prédio, por favor insira novamente: ");
                } else {
                    entradaValida = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Por favor, insira um número inteiro.");
                scanner.next();
            }
        } while (!entradaValida);

        System.out.println("O andar escolhido é o: " + numeroAndar);
        return numeroAndar;
    }

    public String entradaZonaTerreno() { // Método para escolher a zona do terreno.
        String zona = "";
        boolean entradaValida = false;
        do {
            try {
                scanner.nextLine();
                System.out.println("\nEscolha a zona (zona rural / zona urbana): ");
                zona = scanner.nextLine().trim().toLowerCase();
                if (!zona.equals("zona rural") && !zona.equals("zona urbana")) {
                    System.out.println("Por favor, insira uma zona válida (zona rural / zona urbana).");
                } else {
                    entradaValida = true;
                }
            } catch (Exception e) {
                System.out.println("Erro de entrada! Por favor, tente novamente.");
                scanner.nextLine();
            }
        } while (!entradaValida);

        return zona;
    }

    public double entradaAreaContruida() { // Método para inserir a área construída da casa.
        double areaConstruida = 0.0;
        boolean entradaValida = false;
        do {
            try {
                System.out.print("\nPor favor insira o tamanho da casa em metros: ");
                areaConstruida = scanner.nextDouble();
                if (areaConstruida <= 0) {
                    System.out.println("A área informada não é válida, tente novamente!");
                } else {
                    entradaValida = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Por favor, insira um valor numérico.");
                scanner.next();
            }
        } while (!entradaValida);

        System.out.println("A área da casa é de " + areaConstruida + " metros quadrados");
        return areaConstruida;
    }

    public double entradaAreaTerreno() { // Método para inserir a área do terreno.
        double areaTerreno = 0.0;
        boolean entradaValida = false;
        do {
            try {
                System.out.print("\nPor favor insira o tamanho do terreno em metros: ");
                areaTerreno = scanner.nextDouble();
                if (areaTerreno <= 0) {
                    System.out.println("A área do terreno é inválida, tente novamente!");
                } else {
                    entradaValida = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Por favor, insira um valor numérico.");
                scanner.next();
            }
        } while (!entradaValida);

        System.out.println("A área do terreno é de " + areaTerreno + " metros quadrados\n");
        return areaTerreno;
    }

    public boolean perguntarContinuar() { // Método para perguntar se o usuário deseja continuar.
        String resposta = "";
        boolean entradaValida = false;
        do {
            try {
                System.out.print("\nDeseja fazer mais simulações de financiamento? (s/n): ");
                resposta = scanner.next();
                if (!resposta.equalsIgnoreCase("s") && !resposta.equalsIgnoreCase("n")) {
                    System.out.println("Por favor, responda com 's' para sim ou 'n' para não.");
                } else {
                    entradaValida = true;
                }
            } catch (Exception e) {
                System.out.println("Erro de entrada! Por favor, tente novamente.");
                scanner.nextLine();
            }
        } while (!entradaValida);

        return resposta.equalsIgnoreCase("s");
    }
}
