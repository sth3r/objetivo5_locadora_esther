package controller;

public class LocacaoController {
    create table Marcas(
            marca_id int(10) auto_increment not null primary key,
);

    create table Modelos(
            mod_id int(10) auto_increment not null primary key,

    marca_id int(10) not null,
    constraint fk_marca foreign key (marca_id)
    references Marcas(marca_id)
    );

    create table Automoveis(
            aut_id int(10) auto_increment not null primary key,

    mod_id int(10) not null,
    constraint fk_modelos foreign key (mod_id)
    references Modelos(mod_id)
    );

    create table Clientes(
            cli_id int(10) auto_increment not null primary key,
);

    create table Locacoes(
            loc_id int(10) auto_increment not null primary key,

    aut_id int(10) not null,
    constraint fk_automoveis foreign key (aut_id)
    references Automoveis(aut_id),

    cli_id int(10) not null,
    constraint fk_clientes foreign key (cli_id)
    references Clientes(cli_id)
);
}
