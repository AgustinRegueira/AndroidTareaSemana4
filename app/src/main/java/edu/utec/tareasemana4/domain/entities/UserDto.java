package edu.utec.tareasemana4.domain.entities;

import com.google.gson.annotations.SerializedName;

import edu.utec.tareasemana4.room.entities.User;

public class UserDto {
    @SerializedName("id")
    private int id;
    @SerializedName("nombre")
    private String nombre;
    @SerializedName("apellido")
    private String apellido;
    @SerializedName("tipoUsuario")
    private String tipoUsuario;
    @SerializedName("fechaRegistro")
    private String fechaRegistro;

    public UserDto(int id, String nombre, String apellido, String tipoUsuario, String fechaRegistro) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoUsuario = tipoUsuario;
        this.fechaRegistro = fechaRegistro;
    }

    public UserDto() {

    }

    public User buildUser() {
        return new User(this.getId(), this.getNombre(), this.getApellido(), this.getTipoUsuario(), this.getFechaRegistro());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
