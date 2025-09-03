package com.vans.backend.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuarios_seq_gen")
    @SequenceGenerator(name = "usuarios_seq_gen", sequenceName = "usuarios_seq", allocationSize = 1)
    @Column(name = "usuario_id")
    private Integer usuario_id;
    private Integer rol_id;
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
    @Size(min = 5, max = 100, message = "La contraseña debe tener entre 5 y 100 caracteres")
    private String contraseña;
    @NotBlank(message = "El nombre de usuario no puede estar vacío")
    @Size(min = 2, max = 20, message = "El nombre de usuario debe tener entre 2 y 20 caracteres")
    private String username;
    @NotBlank(message = "El correo electrónico no puede estar vacío")
    @Email(message = "El correo electrónico debe ser válido")
    private String email;
    private Integer edad;


    public Usuario(){}

    public Integer getUsuario_id() {
        return usuario_id;
    }

    public Integer getRol_id() {
        return rol_id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSexo() { 
        return sexo; 
    }

    public void setSexo(String sexo) {
        this.sexo = sexo; }

    public String getEmail(){
        return email;
    }

    public String getContraseña(){
        return contraseña;
    }


    public String getUsername() {
        return username;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getApellido() {
        return apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setUsuario_id(Integer usuario_id) {
        this.usuario_id = usuario_id;
    }

    public void setRol_id(Integer rol_id) {
        this.rol_id = rol_id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setContraseña(String contraseña){
        this.contraseña = contraseña;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
}
