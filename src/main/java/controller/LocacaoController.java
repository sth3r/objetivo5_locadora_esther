package controller;

import dao.ClienteDAO;
import model.Cliente;

import java.util.Scanner;

public class LocacaoController {
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
                case 6 -> selectClientesBySituacao();
                default -> {
                    if (opcao != 0)
                        System.out.println("Opção inválida.");
                }
            }
        } while (opcao != 0);
    }
    private static void inserir() {
        Cliente cliente = new Cliente();
        System.out.println("\n++++++ Cadastro de novo Cliete ++++++");

        System.out.print("Digite o nome do Cliente: ");
        cliente.setNom_cliente(input.nextLine());

        System.out.print("\nDigite o CPF: ");
        cliente.setCpf_cliente(input.nextLong());

        System.out.print("\nDigite o enedreço: ");
        cliente.setEnd_cliente(input.nextLine());

        System.out.print("\nDigite o telefone: ");
        cliente.setTel_cliente(input.nextLine());

        System.out.print("\nDigite o e-mail: ");
        cliente.setEmail_cliente(input.nextLine());

        input.nextLine(); //limpa o input

        if(ClienteDAO.insertCliente(cliente)) {
            System.out.println("\nProduto salvo com sucesso.");
        }else {
            System.out.println("\nHouve um erro ao salvar o produto. Por favor, contate o administrador do sistema.");
        }
    }
}






















   /* create table Marcas(
        marca_id int(10) auto_increment primary key,
    descricao varchar(50) not null
        );

        create table Clientes(
        cli_id int(10) auto_increment not null primary key,
        cpf_cli long not null,
        nome_cli varchar(30) not null,
        end_cli varchar(30) not null,
        tel_cli varchar(30) not null,
        email_cli varchar(30) not null
        );

        create table Modelos(
        descricao varchar(50) not null,
        mod_id int(10) auto_increment not null primary key,
        marca_id int(10) not null,
        constraint fk_marca foreign key (marca_id)
        references Marcas(marca_id)
        );

        create table Automoveis(
        placa varchar(10) not null,
        cor varchar (10) not null,
        numero_portas int(2) not null,
        tipo_combustivel int(2) not null,
        quilometragem long not null,
        renavam long not null,
        chassi varchar(10) not null ,
        valor_locacao double not null,
        aut_id int(10) auto_increment not null primary key,
        mod_id int(10) not null,
        constraint fk_modelos foreign key (mod_id)
        references Modelos(mod_id)
        );

        create table Locacoes(
        pego timestamp not null ,
        devolucao datetime not null,
        quilometragem long not null,
        valor_caucao double not null,
        valor_locacao double not null,
        devolvido boolean not null,
        loc_id int(10) auto_increment not null primary key,
        aut_id int(10) not null,
        constraint fk_automoveis foreign key (aut_id)
        references Automoveis(aut_id),
        cli_id int(10) not null,
        constraint fk_clientes foreign key (cli_id)
        references Clientes(cli_id)
        );
*/