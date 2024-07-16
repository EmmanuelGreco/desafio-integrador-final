package com.educacionit.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Schema(description = "Modelo de Géneros")
@Table(name = "generos")
public class Genero {

	@Schema(description = "ID del género", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Schema(description = "Nombre del género", requiredMode = Schema.RequiredMode.REQUIRED, example = "Suspenso")
	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;

	@ManyToMany(mappedBy = "generos")
    @JsonIgnore
    private Set<Pelicula> peliculas = new HashSet<>();

	public Genero(String nombre) {
		super();
		this.nombre = nombre;
	}
}
