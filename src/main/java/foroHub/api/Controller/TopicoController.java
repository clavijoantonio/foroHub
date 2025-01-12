package foroHub.api.Controller;

import java.net.URI;
import java.util.List;

import foroHub.api.topico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/topico")
public class TopicoController {
   
	@Autowired
	private ITopicoRepository repository;
	
	    @PostMapping
	    @Transactional
	    public ResponseEntity<DatosRespuestaTopico> registrar(@RequestBody @Valid DatosRegistroTopico datos, UriComponentsBuilder uriComponentsBuilder) {
			Topico topico =repository.save(new Topico(datos));
			DatosRespuestaTopico datosRespuestaTopico= new DatosRespuestaTopico(topico.getTitulo(),topico.getMensaje(),
			                     topico.getAutor(), topico.getStatus(),topico.getFechaCreacion().toString(), topico.getRespuestas());
			URI url = uriComponentsBuilder.path("/topico/{id}").buildAndExpand(topico.getId()).toUri();
           return ResponseEntity.created(url).body(datosRespuestaTopico);
	    }
	    
	    @GetMapping
	    public Page<DatosListaTopico> listarTopico(@PageableDefault(page=0, size=10, sort = {"fechaCreacion"}) Pageable paginacion) {
	        return repository.findAll(paginacion).map(DatosListaTopico::new);
	    }

		@GetMapping("/{id}")
		public ResponseEntity<DatosRespuestaTopico> obtenerTopico(@PathVariable Long id){
             Topico topico = repository.getReferenceById(id);
			 var datosTopico = new DatosRespuestaTopico(topico.getTitulo(),topico.getMensaje(),
					topico.getAutor(), topico.getStatus(),topico.getFechaCreacion().toString(), topico.getRespuestas());
			 return ResponseEntity.ok(datosTopico);
		}
	    
	    
}
