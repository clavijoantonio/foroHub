package foroHub.api.usuario;

public record DatosAutenticacionUsuario(
        String correo,
        String contrasena,
        String perfil
) {
}
