import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public abstract class Menu {
    private static final String[] supportedCurrencies = {"MXN", "USD", "ARS", "COP", "BRL"}; //Can be updated to use any currency
    private static String baseCurrency;

    public static void printAvailableCurrencies(){
        List<String> sp = Arrays.asList(supportedCurrencies);
        System.out.println("+--------------------------------------------------------+");
        System.out.println("Available currencies: ");
        for(String item: sp){
            int index = sp.indexOf(item) + 1;
            System.out.print(index + "." + item + " | ");
        }//for item in array
        System.out.println("\n+--------------------------------------------------------+");
    }//printMenu

    public static String promptUserBaseCurrency(Scanner scanner){
        System.out.println("Choose a base currency (1-" + supportedCurrencies.length + "): ");
        Menu.baseCurrency = supportedCurrencies[scanner.nextInt()-1];
        return Menu.baseCurrency;
    }//promptUserBaseCurrency

    public static String promptUserConvertTo(Scanner scanner){
        System.out.println("Choose a currency to convert to: ");
        return supportedCurrencies[scanner.nextInt()-1];
    }//promptUserConvertTo

    public static double promptUserAmount(Scanner scanner){
        System.out.println("Type the amount of money (" + Menu.baseCurrency +") you want to convert : ");
        return scanner.nextDouble();
    }

}//Menu
