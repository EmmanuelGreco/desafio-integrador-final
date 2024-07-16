package com.educacionit.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ordenes")
public class Orden {

	@Schema(description = "ID de la orden", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Schema(description = "Fecha de la orden utilizando CURRENT_DATE", requiredMode = Schema.RequiredMode.REQUIRED)
	@Column(name = "fecha_creacion", nullable = false)
	private LocalDate fechaCreacion = LocalDate.now();

	@Schema(description = "ID de socio", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
	@ManyToOne
	@JoinColumn(name = "socio_id", nullable = false)
	private User socio;

	@Schema(description = "ID de estado_orden", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
	@ManyToOne
	@JoinColumn(name = "estado_orden_id", nullable = false)
	private Estado estadoOrden;

	@Schema(description = "ID del cupón", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
	@ManyToOne
	@JoinColumn(name = "cupon_id")
	private Cupon cupon;

	@Schema(description = "ID de la película", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
	@ManyToOne
	@JoinColumn(name = "pelicula_id")
	private Pelicula pelicula;

	@Schema(description = "Monto total de la orden", requiredMode = Schema.RequiredMode.REQUIRED, example = "6399.99")
	@Column(name = "monto_total", nullable = false, length = 25, precision = 10, scale=2)
	private BigDecimal montoTotal;
}
