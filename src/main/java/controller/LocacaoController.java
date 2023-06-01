package controller;

public class LocacaoController {

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