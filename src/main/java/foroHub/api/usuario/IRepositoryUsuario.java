package foroHub.api.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface IRepositoryUsuario extends JpaRepository<Usuario, Long> {
    UserDetails findByCorreo(String username);
}
