create table topico(

    id bigint not null auto_increment,
    titulo varchar(100) not null,
    mensaje varchar(400) not null,
    fecha_creacion datetime not null,
    status varchar(100) not null,
    autor varchar(100) not null,
    respuestas varchar(400),
   
    primary key(id)

);