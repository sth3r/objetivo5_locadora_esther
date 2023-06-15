package controller;

import java.util.List;
import java.util.Scanner;

import model.Cliente;
import dao.ClienteDAO;
public class ClienteController {
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao = 0;
        do {
            System.out.print("\n\"-------  MENU cliente -------\"");
            System.out.print(
                    """
    
                        1. Inserir novo cliente
                        2. Atualizar um cliente
                        3. Listar todos os clientes
                        4. Buscar cliente pelo código
                        5. Buscar clientes pelo nome
                        6. Buscar clientes pela situação
                        Opção (Zero p/sair):\s""");
            opcao = input.nextInt();
            input.nextLine();
            switch (opcao) {
                case 1 -> inserir();
                case 2 -> atualizar();
                case 3 -> selectClientes();
                case 4 -> selectClientesById();
                case 5 -> selectClientesByNome();
//              case 6 -> selectClientesBySituacao();
                default -> {
                    if (opcao != 0)
                        System.out.println("Opção inválida.");
                }
            }
        } while (opcao != 0);
    }
    //opção 1
    private static void inserir() {
        Cliente cliente = new Cliente();
        System.out.println("\n++++++ Cadastro de novo Cliente ++++++");
        System.out.print("Digite o nome do cliente: ");
        cliente.setNom_cliente(input.nextLine());
        System.out.print("\nDigite o sobrenome do cliente: ");
        cliente.setCpf_cliente(input.nextLong());
        cliente.setEmail_cliente(input.nextLine());
        cliente.setEnd_cliente(input.nextLine());
        cliente.setTel_cliente(input.nextLine());
        cliente.setLocacoes(input.next());

        if(ClienteDAO.insertCliente(cliente)) {
            System.out.println("\nCliente salvo com sucesso.");
        }else {
            System.out.println("\nHouve um erro ao salvar o cliente. Por favor, contate o administrador do sistema.");
        }
    }

    //opção 2
    private static void atualizar() {
        System.out.println("\n++++++ Alterar um Cliente ++++++");
        Cliente cliente = null;
        int opcao = 0;
        do{
            System.out.print("\nDigite o código do cliente (Zero p/sair): ");
            long codigo = input.nextLong();
            input.nextLine();
            if(codigo == 0) {
                opcao = 0;
            } else {
                cliente = ClienteDAO.selectClienteById(codigo);
                if(cliente == null){
                    System.out.println("Código inválido.");
                }else{
                    System.out.println("Nome: " + cliente.getNom_cliente());
                    System.out.print("Alterar? (0-sim/1-não) ");
                    if(input.nextInt() == 0){
                        input.nextLine();
                        System.out.println("Digite o novo nome do cliente: ");
                        cliente.setNom_cliente(input.nextLine());
                    }
                    System.out.println("CPF: " + cliente.getCpf_cliente());
                    System.out.print("Alterar? (0-sim/1-não) ");
                    if(input.nextInt() == 0){
                        input.nextLine();
                        System.out.print("Digite o novo CPF do cliente: ");
                        cliente.setCpf_cliente(input.nextLong());
                    }
                    System.out.println("Endereço: " + cliente.getEnd_cliente());
                    System.out.print("Alterar? (0-sim/1-não) ");
                    if(input.nextInt() == 0){
                        input.nextLine();
                        System.out.print("Digite o novo endereço do cliente: ");
                        cliente.setEnd_cliente(input.nextLine());
                    }
                    System.out.println("Telefone: " + cliente.getTel_cliente());
                    System.out.print("Alterar? (0-sim/1-não) ");
                    if(input.nextInt() == 0){
                        input.nextLine();
                        System.out.print("Digite o novo telefone do cliente: ");
                        cliente.setTel_cliente(input.nextLine());
                    }
                    System.out.println("Email: " + cliente.getEmail_cliente());
                    System.out.print("Alterar? (0-sim/1-não) ");
                    if(input.nextInt() == 0){
                        input.nextLine();
                        System.out.print("Digite o novo e-mail do cliente: ");
                        cliente.setEmail_cliente(input.nextLine());
                    }
                    /*TEM QUE VER ISSO
                    cliente.setSituacao(true);
                    if(ClienteDAO.updateCliente(cliente)){
                        System.out.println("cliente salvo:" + cliente);
                    }else{
                        System.out.println("Erro ao tentar salvar o cliente. Por favor, contate o adminstrador.");
                    }*/
                    opcao = 1;
                }

            }
        }while(opcao != 0);
    }

    //opção 3
    private static void selectClientes() {
        System.out.println("\nLista de clientes cadastrados no banco de dados:\n" + ClienteDAO.selectClientes());
    }

    //opção 4
    private static void selectClientesById() {
        System.out.print("\nDigite o código do cliente: ");
        Cliente cliente = ClienteDAO.selectClienteById(input.nextLong());
        input.nextLine();
        if(cliente != null){
            System.out.println(cliente);
        }else{
            System.out.println("Código não localizado.");
        }
    }

    //opção 5
    private static void selectClientesByNome() {
        System.out.print("Digite o nome do cliente: ");
        String nome = input.next();
        System.out.println("Chave de pesquisa: " + nome);
        List<Cliente> clientes = ClienteDAO.selectClientesByName(nome);
        if(clientes.isEmpty()){
            System.out.println("Não há registros correspondentes para: " + nome);
        }else{
            System.out.println(clientes);
        }
    }

    //opção 6
/*    private static void selectClientesBySituacao() {
        System.out.print("Escolha uma das situações (0-inativo/1-ativo): ");
        int situacao = input.nextInt();
        input.nextLine();
        List<Cliente> clientes;
        switch (situacao) {
            case 0 -> {
                clientes = ClienteDAO.selectClientesBySituacao(false);
                System.out.println("Clientes na situação INATIVO:\n " + clientes);
            }
            case 1 -> {
                clientes = ClienteDAO.selectClientesBySituacao(true);
                System.out.println("Clientes na situação ATIVO:\n " + clientes);
            }
        }
    }*/

}//fim classe
//}
