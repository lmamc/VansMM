package com.vans.backend.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuarios_seq_gen")
    @SequenceGenerator(name = "usuarios_seq_gen", sequenceName = "usuarios_seq", allocationSize = 1)
    @Column(name = "usuario_id")
    private Integer usuario_id;

    @ManyToOne
    @JoinColumn(name = "rol_id")
    private Roles rol;

    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    private String nombre;

    private String sexo;

    @NotBlank(message = "El teléfono no puede estar vacío")
    @Pattern(regexp = "^(\\+56\\s?)?9\\d{8}$", message = "El formato del teléfono móvil no es válido. Ejemplo: +56912345678 o 912345678")
    private String telefono;

    @NotBlank(message = "El apellido no puede estar vacío")
    @Size(min = 2, max = 50, message = "El apellido debe tener entre 2 y 50 caracteres")
    private String apellido;

    @NotBlank(message = "La contraseña no puede estar vacía")
    @Size(min = 5, max = 1000, message = "La contraseña debe tener entre 5 y 100 caracteres")
    @Column(name = "CONTRASENA") 
    private String contrasena;

    @NotBlank(message = "El nombre de usuario no puede estar vacío")
    @Size(min = 2, max = 20, message = "El nombre de usuario debe tener entre 2 y 20 caracteres")
    private String username;

    @NotBlank(message = "El correo electrónico no puede estar vacío")
    @Email(message = "El correo electrónico debe ser válido")
    private String email;

    private Integer edad;

    @OneToMany(mappedBy = "usuario")
    @JsonManagedReference("usuario-reservas")
    private List<Reserva> reservas;

    public Usuario(){}

    // Getters y Setters
    public Integer getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Integer usuario_id) {
        this.usuario_id = usuario_id;
    }

    public Roles getRol() {
        return rol;
    }

    public void setRol(Roles rol) {
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() { 
        return sexo; 
    }

    public void setSexo(String sexo) {
        this.sexo = sexo; 
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getContrasena(){
        return contrasena;
    }

    public void setContrasena(String contrasena){
        this.contrasena = contrasena;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }
}