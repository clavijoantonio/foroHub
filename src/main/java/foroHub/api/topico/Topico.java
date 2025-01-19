package foroHub.api.topico;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name = "topico")
@Entity(name = "Topico")
@Getter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String mensaje;
	private LocalDate fechaCreacion;
	private Boolean status;
	private String autor;
	private String respuestas;

	public Topico(DatosRegistroTopico datos) {
		this.titulo = datos.titulo();
		this.mensaje = datos.mensaje();
		this.fechaCreacion = LocalDate.parse(datos.fechaCreacion());
		this.status = true;
		this.autor = datos.autor();
		this.respuestas = datos.respuestas();

	}
public Topico (){

}

    public void actualizarTopico(DatosActualizarTopico datosActualizartopico) {
	  if (datosActualizartopico.mensaje()!=null) {
		  this.mensaje= datosActualizartopico.mensaje();
		}
		if (datosActualizartopico.autor()!=null) {
			this.titulo= datosActualizartopico.titulo();
		}

		if (datosActualizartopico.autor()!=null) {
			this.autor= datosActualizartopico.autor();
		}
		if (datosActualizartopico.fechaCreacion()!=null) {
		this.fechaCreacion= LocalDate.parse(datosActualizartopico.fechaCreacion());
	}
	}

    public void desativartopico() {
		this.status=false;
    }

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public Boolean getStatus() {
		return status;
	}

	public String getAutor() {
		return autor;
	}

	public String getRespuestas() {
		return respuestas;
	}
}
