package com.educacionit.entity;

import java.util.Objects;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Schema(description = "Modelo de Películas")
@Table(name="peliculas")
public class Pelicula {
	
	@Schema(description = "Código de la película", requiredMode = Schema.RequiredMode.REQUIRED,
			example = "01")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
    private Integer id;
    
    @Schema(description = "Título de la película", requiredMode = Schema.RequiredMode.REQUIRED,
    		example = "Oppenheimer")
    @Column(name="Titulo", nullable=false, length=50)
    private String titulo;
    
    @Schema(description = "Director de la película", requiredMode = Schema.RequiredMode.NOT_REQUIRED,
    		example = "Christopher Nolan")
    @Column(name="Director", nullable=true, length=50)
    private String director;
    
    @Schema(description = "Sitio oficial de la película", requiredMode = Schema.RequiredMode.NOT_REQUIRED,
    		example = "https://www.uphe.com/movies/oppenheimer")
    @Column(name="URL", nullable=true, length=100)
    private String url;
    
    @Schema(description = "Imagen de portada de la película", requiredMode = Schema.RequiredMode.NOT_REQUIRED,
    		example = "https://dx35vtwkllhj9.cloudfront.net/universalstudios/oppenheimer-watch/images/regions/us/onesheet.jpg")
    @Column(name="Portada", nullable=true, length=100)
    private String portada;
    
    @Schema(description = "Precio de la película", requiredMode = Schema.RequiredMode.NOT_REQUIRED,
    		example = "6399.99")
    @Column(name="Precio", nullable=true, length=25)
    private Float precio;
    
    public Pelicula() {
    }
    
    public Pelicula(String titulo) {
    	super();
    	this.titulo = titulo;
    }

    @ManyToOne
    @JoinColumn(name = "genero_id")
    private Genero genero;
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pelicula pelicula = (Pelicula) o;
        return Objects.equals(id, pelicula.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
