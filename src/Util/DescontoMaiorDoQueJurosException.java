package Util;

public class DescontoMaiorDoQueJurosException extends Exception { // Classe que trata de exeções.
    public DescontoMaiorDoQueJurosException() { // Construtor da exeção.
        System.out.println("\nEssa simulação não deve ser considerada. Desconto maior que o juro mensal!\n");
    }
}
