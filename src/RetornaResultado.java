import java.text.DecimalFormat;

public record RetornaResultado(double conversion_result) {
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        String formattedValue = df.format(conversion_result);

        return formattedValue;
    }
}
