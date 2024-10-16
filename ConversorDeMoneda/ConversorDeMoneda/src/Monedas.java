public record Monedas(
        String base_code,
        String target_code,
        double conversion_rate
) {

    public double getTasaDeConversion(){
        return conversion_rate;
    }

    public double tasaDeConversion(){
        return conversion_rate;
    }
}
