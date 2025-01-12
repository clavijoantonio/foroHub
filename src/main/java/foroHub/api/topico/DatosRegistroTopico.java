package foroHub.api.topico;

import java.time.LocalDateTime;


public record DatosRegistroTopico(
	
	    String titulo,
	    String mensaje,
	    String fechaCreacion,
	    String status,
	    String autor,
	    String respuestas
		
		) {

}
