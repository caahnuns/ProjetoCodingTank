import java.util.InputMismatchException;

public class Temperatura {

    public double temperaturaInicial;
    public char unidadeDeMedidaInicial;
    public char unidadeDeMedidaConvertida;

    public Temperatura(double temperaturaInicial, char unidadeDeMedidaInicial, char unidadeDeMedidaConvertida) {
        this.temperaturaInicial = temperaturaInicial;
        this.unidadeDeMedidaInicial = unidadeDeMedidaInicial;
        this.unidadeDeMedidaConvertida = unidadeDeMedidaConvertida;
    }

    private double converterCelsiusParaFahrenheit(double celsius) {
        return (celsius * (9.0/5.0)) + 32;
    }

    private double converterCelsiusParaKelvin(double celsius) {
        return (celsius + 273.15);
    }

    private double converterFahrenheitParaCelsius(double fahrenheit) {
        return ((fahrenheit * (9.0/5.0)) + 32.0);
    }

    private double converterFahrenheitParaKelvin(double fahrenheit) {
        return (((fahrenheit - 32.0) * (5.0/9.0))  + 273.15);
    }

    private double converterKelvinParaFahrenheit(double kelvin) {
        return (((9.0/5.0) * (kelvin - 273.15)) + 32.0);
    }

    private double converterKelvinParaCelsius(double kelvin) {
        return (kelvin - 273.15);
    }

    public double converterTemperatura(Temperatura temperatura) throws InputMismatchException {

        if(temperatura.unidadeDeMedidaInicial == temperatura.unidadeDeMedidaConvertida) {
            return temperatura.temperaturaInicial;
        }

        switch (temperatura.unidadeDeMedidaInicial) {
            case 'C':
                if (temperatura.unidadeDeMedidaConvertida == 'F') {
                    return converterCelsiusParaFahrenheit(temperatura.temperaturaInicial);
                } else if (temperatura.unidadeDeMedidaConvertida == 'K') {
                    return converterCelsiusParaKelvin(temperatura.temperaturaInicial);
                }
            case 'F':
                if (temperatura.unidadeDeMedidaConvertida == 'C') {
                    return converterFahrenheitParaCelsius(temperatura.temperaturaInicial);
                } else if (temperatura.unidadeDeMedidaConvertida == 'K') {
                    return converterFahrenheitParaKelvin(temperatura.temperaturaInicial);
                }
            case 'K':
                if (temperatura.unidadeDeMedidaConvertida == 'C') {
                    return converterKelvinParaCelsius(temperatura.temperaturaInicial);
                } else if (temperatura.unidadeDeMedidaConvertida == 'F') {
                    return converterKelvinParaFahrenheit(temperatura.temperaturaInicial);
                }
            default:
                throw new InputMismatchException("Unidade de medida informada incompatível");
        }
    }
}
