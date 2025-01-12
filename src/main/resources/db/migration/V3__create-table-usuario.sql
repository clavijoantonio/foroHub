create table usuario(

    id bigint not null auto_increment,
    nombre varchar(100) not null,
    correoElectronico varchar(100) not null,
    contraseña varchar(100) not null,
    perfiles varchar(100) not null,
    
    primary key(id)

);