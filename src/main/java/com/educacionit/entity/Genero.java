package com.educacionit.entity;

import java.util.List;
import java.util.Objects;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Schema(description = "Modelo de Generos")
@Table(name="generos")
public class Genero {
	
	@Schema(description = "Código del género", requiredMode = Schema.RequiredMode.REQUIRED,
			example = "01")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    
	@Schema(description = "Nombre del género", requiredMode = Schema.RequiredMode.REQUIRED,
    		example = "Suspenso")
    @Column(name="nombre", nullable=false, length=50)
    private String nombre;
    
    public Genero() {
    }
    
    public Genero(String nombre) {
    	super();
    	this.nombre = nombre;
    }
        
    @OneToMany(mappedBy = "genero")
    private List<Pelicula> peliculas;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genero genero = (Genero) o;
        return Objects.equals(id, genero.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
