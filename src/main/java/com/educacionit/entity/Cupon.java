package com.educacionit.entity;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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
@Table(name = "cupones")
public class Cupon {

	@Schema(description = "ID del cupón", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Schema(description = "Nombre del cupón", requiredMode = Schema.RequiredMode.REQUIRED, example = "DESC10")
	@Column(nullable = false, length = 50, unique = true)
	private String name;

	@Schema(description = "Valor del cupón", requiredMode = Schema.RequiredMode.REQUIRED, example = "10.0")
	@Column(nullable = false, precision = 10, scale=2)
	@NotNull
	@Min(value = 0, message = "El descuento debe ser mayor o igual a 0 (cero)!")
	private BigDecimal descuento;
}
