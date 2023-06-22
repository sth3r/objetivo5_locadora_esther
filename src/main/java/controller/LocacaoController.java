package controller;

import dao.ClienteDAO;
import dao.LocacaoDAO;
import model.Automovel;
import model.Cliente;
import model.Locacao;

import java.time.LocalDateTime;
import java.util.Scanner;

import static dao.LocacaoDAO.selectLocacao;

public class LocacaoController {
    private static final Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int opcao = 0;
        do {
            System.out.print("\n\"-------  MENU cliente -------\"");
            System.out.print(
                    """
    
                        1. Locar um automovel
                        3. Listar todas as locacoes
                        4. Buscar locacao pelo código
                        Opção (Zero p/sair):\s""");
            opcao = input.nextInt();
            input.nextLine();
            switch (opcao) {
                case 1 -> locar();
                case 3 -> selectLocacoes();
                case 4 -> selectLocacaoById();
                default -> {
                    if (opcao != 0)
                        System.out.println("Opção inválida.");
                }
            }
        } while (opcao != 0);
    }
    private static void locar() {
        Locacao locacao = new Locacao();
        System.out.println("\n++++++ Locar um automovel ++++++");

        System.out.print("id do Cliente: ");
        locacao.setCliente(input.nextInt());

        System.out.print("Tempo de locação: ");
        locacao.setDiasLocados(input.nextInt());

        System.out.print("quilometragem: ");
        locacao.setQuilometragem(input.nextLong());

        System.out.print("valor custação: ");
        locacao.setValor_custacao(input.nextLong());

        System.out.print("valor locação: ");
        locacao.setValor_locacao(input.nextLong());

        System.out.print("devolvido?: ");
        locacao.setDevolvido(input.nextBoolean());

        System.out.print("automovel: ");
        locacao.setAutomovel(input.next);

        System.out.print("quilometragem: ");
        locacao.setQuilometragem(input.nextLong());


        input.nextLine(); //limpa o input

        if(LocacaoDAO.locar(locacao)) {
            System.out.println("\nLocação salvo com sucesso.");
        }else {
            System.out.println("\nHouve um erro ao locar o carro. Por favor, contate o administrador do sistema.");
        }
    }

    private static void selectLocacoes(){
        System.out.println("\nLista de locacoes feitas no banco de dados:\n" + LocacaoDAO.selectLocacao());
    }

    private static void selectLocacaoById() {
        System.out.print("\nDigite o código da locação: ");
        Locacao locacao = LocacaoDAO.selectLocacaoById(input.nextInt());
        input.nextLine();
        if(locacao != null){
            System.out.println(locacao);
        }else{
            System.out.println("Código não localizado.");
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