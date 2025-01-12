create table respuestas(

    id bigint not null auto_increment,
    mensaje varchar(400) not null,
    topico varchar(400) not null,
    fecha_creacion datetime not null,
    autor varchar(100) not null,
    solucion varchar(400),
   
    primary key(id)

);