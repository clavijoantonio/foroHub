package foroHub.api.topico;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String mensaje;
	private LocalDate fechaCreacion;
	private String status;
	private String autor;
	private String respuestas;

	public Topico(DatosRegistroTopico datos) {
		this.titulo = datos.titulo();
		this.mensaje = datos.mensaje();
		this.fechaCreacion = LocalDate.parse(datos.fechaCreacion());
		this.status = datos.status();
		this.autor = datos.autor();
		this.respuestas = datos.respuestas();

	}
	public Topico(){

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

	public String getStatus() {
		return status;
	}

	public String getAutor() {
		return autor;
	}

	public String getRespuestas() {
		return respuestas;
	}
}
