package controller;

import dao.MarcaDAO;
import model.Marca;

import java.util.Scanner;

public class MarcaController {
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao = 0;
        do {
            System.out.print("\n-------  Home -------");
            System.out.print(
                    """
                                
                            1. Ver marca
                            2. seleciona marca pelo id
                            3. Adicionar marca
                            4. Editar marca
                            Opção (Zero p/sair):\s""");
            opcao = input.nextInt();
            input.nextLine();
            switch (opcao) {
                case 1 -> listarMarcas();
                case 2 -> selectMarcaById();
                case 3 -> novaMarca();
                case 4 -> editaMarca();
                default -> {
                    if (opcao != 0) System.out.println("Opção inválida.");
                }
            }
        } while (opcao != 0);
        System.out.println("\n\n!!!!!!!! Fim da aplicação !!!!!!!!");
        input.close(); //libera o recurso
    }

    private static void listarMarcas() {
        System.out.println("\nLista de marcas cadastrados no banco de dados:\n" + MarcaDAO.listarMarcas());
    }

    private static void novaMarca() {
        Marca marca = new Marca();
        System.out.println("\n++++++ Cadastro de nova Marca ++++++");
        System.out.print("Digite o nome da Marca: ");
        Marca.setDescricao(input.nextLine());
        input.nextLine(); //limpa o input
        if (MarcaDAO.novaMarca(marca)) {
            System.out.println("\nMarca salva com sucesso.");
        } else {
            System.out.println("\nHouve um erro ao salvar a marca. Por favor, contate o administrador do sistema.");
        }
    }

    private static void editaMarca() {
        System.out.println("\n++++++ editar uma marca ++++++");
        Marca marca = null;
        int opcao = 0;
        do{
            System.out.print("\nDigite o código da marca (Zero p/sair): ");
            int marca_id = input.nextInt();
            input.nextLine();
            if(marca_id == 0) {
                opcao = 0;
            } else {
                marca = MarcaDAO.selectMarcaById(marca_id);
                if(marca == null){
                    System.out.println("Código inválido.");
                }else{
                    System.out.println("Marca: " + marca.getDescricao());
                    System.out.print("Alterar? (0-sim/1-não) ");
                    if(input.nextInt() == 0){
                        input.nextLine();
                        System.out.println("Digite o novo nome da marca: ");
                        marca.setDescricao(input.nextLine());
                    }
                    if(MarcaDAO.editaMarca(marca)){
                        System.out.println("marca ditada:" + marca);
                    }else{
                        System.out.println("Erro ao tentar editar a marca. Por favor, contate o adminstrador.");
                    }
                    opcao = 1;
                }

            }
        }while(opcao != 0);
    }

    private static void selectMarcaById() {
        System.out.print("\nDigite o código da marca: ");
        Marca marca= MarcaDAO.selectMarcaById(input.nextInt());
        input.nextLine();
        if(marca != null){
            System.out.println(marca);
        }else{
            System.out.println("Código não localizado.");
        }
    }
}