import java.util.Map;

public class Converter {
    private String baseCurrency;
    private String userConvertTo;
    private double userAmount;

    public Converter(String baseCurrency, String userConvertTo, double userAmount){
        this.baseCurrency = baseCurrency;
        this.userConvertTo = userConvertTo;
        this.userAmount = userAmount;
    }//constructor

    public void convert(ConversionRates cr){
        double rate = cr.conversionRates().get(this.userConvertTo);
        System.out.printf("%.2f (%s) converted to (%s) is: %.2f", this.userAmount,this.baseCurrency,this.userConvertTo ,this.userAmount * rate);
    }//convert
}
