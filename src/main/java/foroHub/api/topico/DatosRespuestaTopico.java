package foroHub.api.topico;

public record DatosRespuestaTopico(
        String titulo,
        String mensaje,
        String fechaCreacion,
        Boolean status,
        String autor,
        String respuestas
) {

    public DatosRespuestaTopico(Topico topico){
        this(topico.getTitulo(), topico.getMensaje(), topico.getAutor(), topico.getStatus(),topico.getFechaCreacion().toString(), topico.getRespuestas());
    }

}
