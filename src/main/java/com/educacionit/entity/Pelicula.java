package com.educacionit.entity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
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
@Schema(description = "Modelo de Películas")
@Table(name = "peliculas")
public class Pelicula {

	@Schema(description = "ID de la película", requiredMode = Schema.RequiredMode.REQUIRED, example = "01")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Schema(description = "Título de la película", requiredMode = Schema.RequiredMode.REQUIRED, example = "Oppenheimer")
	@Column(name = "titulo", nullable = false, length = 50)
	private String titulo;

	@Schema(description = "Director de la película", requiredMode = Schema.RequiredMode.NOT_REQUIRED, example = "Christopher Nolan")
	@Column(name = "director", nullable = true, length = 50)
	private String director;

	@Schema(description = "Sitio oficial de la película", requiredMode = Schema.RequiredMode.NOT_REQUIRED, 
			example = "https://www.uphe.com/movies/oppenheimer")
	@Column(name = "url", nullable = true, length = 100)
	private String url;

	@Schema(description = "Imagen de portada de la película", requiredMode = Schema.RequiredMode.NOT_REQUIRED, 
			example = "https://dx35vtwkllhj9.cloudfront.net/universalstudios/oppenheimer-watch/images/regions/us/onesheet.jpg")
	@Column(name = "portada", nullable = true, length = 255)
	private String portada;

	@Schema(description = "Precio de la película", requiredMode = Schema.RequiredMode.NOT_REQUIRED, example = "63999.99")
	@Column(name = "precio", nullable = true, precision = 10, scale=2)
	private BigDecimal precio;

	@Schema(description = "Tabla de relación películas-géneros")
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "peliculas_generos", joinColumns = @JoinColumn(name = "pelicula_id"), inverseJoinColumns = @JoinColumn(name = "genero_id"))
	private Set<Genero> generos = new HashSet<>();

	public void addRole(Genero genero) {
		this.generos.add(genero);
	}

	public Pelicula(String titulo, String director, String url, String portada, BigDecimal precio) {
		this.titulo = titulo;
        this.director = director;
        this.url = url;
        this.portada = portada;
        this.precio = precio;
	}

	public Pelicula(String titulo) {
		super();
		this.titulo = titulo;
	}
}
