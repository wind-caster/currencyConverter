import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("\nHello World! Welcome to the currency converter... \n" +
                "This project was created by Carlos Ramos as an exercise part of the Oracle Next Education program.");
        Menu.printAvailableCurrencies();
        Scanner sc = new Scanner(System.in);
        UserRequest userRequest = new UserRequest(Menu.promptUserBaseCurrency(sc),
                Menu.promptUserConvertTo(sc),
                Menu.promptUserAmount(sc));
        sc.close();
        Requester requester = new Requester(userRequest.userBaseCurrency(), userRequest.userConvertTo());
        Converter converter = new Converter(userRequest.userBaseCurrency(), userRequest.userConvertTo(), userRequest.userAmount());
        converter.convert(requester.makeRequest());
    }//main
}//Main