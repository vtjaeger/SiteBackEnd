package br.com.cadeiras.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CadeiraDto(
        @NotBlank
        String nome,
        @NotNull
        BigDecimal valor,
        @NotNull
        String imagem
) {
}
