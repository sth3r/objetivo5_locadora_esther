package controller;

import controller.AutomovelController;
import controller.ClienteController;
import controller.LocacaoController;
import controller.MarcaController;

import java.util.Scanner;

public class HomeController {

    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int opcao = 0;
        do {
            System.out.print("\n-------  Home -------");
            System.out.print(
                    """
    
                        1. Locar
                        2. Manter Clientes
                        3. Manter Automoevel
                        4. Manter Marca
                        5. Manter Modelo
                        Opção (Zero p/sair):\s""");
            opcao = input.nextInt();
            input.nextLine();
            switch (opcao) {
                case 1 -> LocacaoController.main(null);
                case 2 -> ClienteController.main(null);
                case 3 -> AutomovelController.main(null);
                case 4 -> MarcaController.main(null);
                case 5 -> MarcaController.main(null);
                default -> {
                    if (opcao != 0) System.out.println("Opção inválida.");
                }
            }
        } while(opcao != 0) ;
        System.out.println("\n\n!!!!!!!! Fim da aplicação !!!!!!!!");
        input.close(); //libera o recurso
    }

}//fim classe