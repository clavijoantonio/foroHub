package foroHub.api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import foroHub.api.topico.DatosListaTopico;
import foroHub.api.topico.DatosRegistroTopico;
import foroHub.api.topico.ITopicoRepository;
import foroHub.api.topico.Topico;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/topico")
public class TopicoController {
   
	@Autowired
	private ITopicoRepository repository;
	
	    @PostMapping
	    @Transactional
	    public void registrar(@RequestBody @Valid DatosRegistroTopico datos) {

	        repository.save(new Topico(datos));
	    }
	    
	    @GetMapping
	    public List<DatosListaTopico> listarTopico() {
	        return repository.findAll().stream().map(DatosListaTopico::new).toList();
	    }
	    
	    
}
