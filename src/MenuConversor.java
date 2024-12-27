import java.io.IOException;
import java.util.Scanner;

public abstract class MenuConversor {

    public static void iniciarConversoes() throws IOException, InterruptedException {

        ConversorDeMoeadas converter = new ConversorDeMoeadas();


        int saida = 0;

        while (saida != 7){

            Scanner input = new Scanner(System.in);

            String menu = """
                    ___________________________________________________________
                    
                    Seja bem-vindo ap Conversor De moeda =]
                    
                    1 - Dólar =>> Peso Argentino
                    2 - Peso Argentino =>> Dólar
                    3 - Dólar =>> Real Brasileiro
                    4 - Real Brasileiro =>> Dolar
                    5 - Dólar =>> Peso Colombiano
                    6 - Peso Colombiano =>> Dólar
                    7 - sair
                    
                    ___________________________________________________________
                    """;
            System.out.println(menu);



            try {

                int opcaoMenu = input.nextInt();

                if((opcaoMenu > 7) || (opcaoMenu < 1)) {

                    System.out.println("Digite um valor entre 1 e 7, numero digitado invalido!");

                }
                    if (opcaoMenu == 7) {

                        saida = opcaoMenu;

                    } else if (opcaoMenu == 1) {

                        converter.setValor("1");
                        converter.setMoedaConvertida("Peso Argentino");

                        System.out.println("Dolar : " + converter.getValor());

                        converter.converterMoeda("USD", "ARS");

                    } else if (opcaoMenu == 2) {

                        converter.setValor("1000");
                        converter.setMoedaConvertida("Dolar");

                        System.out.println("Peso Argentino: " + converter.getValor());
                        converter.converterMoeda("ARS", "USD");

                    } else if (opcaoMenu == 3) {

                        converter.setValor("1");
                        converter.setMoedaConvertida("Real Brasileiro");

                        System.out.println("Dolar: " + converter.getValor());
                        converter.converterMoeda("USD", "BRL");

                    } else if (opcaoMenu == 4) {

                        converter.setValor("1");
                        converter.setMoedaConvertida("Dolar");

                        System.out.println("Real brasileiro: " + converter.getValor());
                        converter.converterMoeda("BRL", "USD");

                    } else if (opcaoMenu == 5) {

                        converter.setValor("1");
                        converter.setMoedaConvertida("Peso Colombiano");

                        System.out.println("Dolar: " + converter.getValor());
                        converter.converterMoeda("USD", "COP");

                    } else if (opcaoMenu == 6) {

                        converter.setValor("1000");
                        converter.setMoedaConvertida("Dolar");

                        System.out.println("Peso Colombiano: " + converter.getValor());
                        converter.converterMoeda("COP", "USD");

                    }


            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
