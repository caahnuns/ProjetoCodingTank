import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n..:: Boas vindas ao Conversor de Temperaturas CT#928 ::..\n");

        System.out.println("Informe a unidade de medida de origem das temperaturas:");
        apresentaOpcoesDeTemperatura();

        char unidadeDeMedidaOriginal = scanner.next().charAt(0);

        apresentaQuebraDeLinha();

        System.out.println("Agora, informe a unidade de medida para a qual deseja converter as temperaturas:");
        apresentaOpcoesDeTemperatura();

        char unidadeDeMedidaConvertida = scanner.next().charAt(0);

        apresentaQuebraDeLinha();

        System.out.println("Informe a quantidade de temperaturas que deseja converter: ");

        int quantidadeTemperaturas = scanner.nextInt();
        double[] temperaturasParaConversao = new double[quantidadeTemperaturas];

        apresentaQuebraDeLinha();

        for (int contador = 0; contador < temperaturasParaConversao.length; contador++) {
            System.out.println("Informe a " + (contador + 1) + "ª temperatura a ser convertida: ");
            temperaturasParaConversao[contador] = scanner.nextDouble();
            System.out.println("---");
        }

        apresentaQuebraDeLinha();

        double somatorioTemperaturasParaConversao = 0;
        double somatorioTemperaturasConvertidas = 0;

        try {
            for (int contador = 0; contador < temperaturasParaConversao.length; contador++) {
                Temperatura temperaturaParaConversao = new Temperatura(temperaturasParaConversao[contador], unidadeDeMedidaOriginal, unidadeDeMedidaConvertida);

                double temperaturaConvertida = temperaturaParaConversao.converterTemperatura(temperaturaParaConversao);

                System.out.printf("[" + (contador+1) + "] %.2fº" + unidadeDeMedidaOriginal + " corresponde à %.2fº" + unidadeDeMedidaConvertida + "\n", temperaturaParaConversao.temperaturaInicial, temperaturaConvertida);

                somatorioTemperaturasParaConversao += temperaturaParaConversao.temperaturaInicial;
                somatorioTemperaturasConvertidas += temperaturaConvertida;
            }

            apresentaQuebraDeLinha();

            double mediaTemperaturasParaConversao = somatorioTemperaturasParaConversao / temperaturasParaConversao.length;
            double mediaTemperaturasConvertidas = somatorioTemperaturasConvertidas / temperaturasParaConversao.length;

            System.out.printf("A média das temperaturas para conversão é igual à %.2fº" + unidadeDeMedidaOriginal + "\n", mediaTemperaturasParaConversao);
            System.out.printf("Já a média das temperaturas convertidas é igual à %.2fº" + unidadeDeMedidaConvertida + "\n", mediaTemperaturasConvertidas);

        } catch (InputMismatchException erroInput) {
            System.out.println("!!! Operação inválida !!!" + erroInput.getMessage());
            return;
        }

        apresentaQuebraDeLinha();

        System.out.println("..:: Obrigada por utilizar o Conversor de Temperaturas CT#928 ::..");
        System.out.println("..:: Nos vemos no Curso de Formação ;) ::..");

    }

    private static void apresentaOpcoesDeTemperatura() {
        System.out.println(" - C para Celsius - ");
        System.out.println(" - F para Farenheit - ");
        System.out.println(" - K para Kelvin - ");
    }

    private static void apresentaQuebraDeLinha() {
        System.out.println("\n..:::..\n");
    }

}