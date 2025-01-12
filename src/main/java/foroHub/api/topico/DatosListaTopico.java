package foroHub.api.topico;

import java.time.LocalDate;
import java.time.LocalTime;

public record DatosListaTopico(
		String titulo,
	    String mensaje,
	    String fechaCreacion
	   ) {
	
	
public DatosListaTopico(Topico topico) {
	this(topico.getTitulo(),topico.getMensaje(),topico.getFechaCreacion().toString());
}
	


	
}
