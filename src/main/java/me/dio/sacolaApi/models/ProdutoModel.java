package me.dio.sacolaApi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@Getter
@Setter
@Builder
@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NoArgsConstructor
public class ProdutoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private double valorUnitario;

    @Builder.Default
    private Boolean disponivel = true;

    @ManyToOne
    @JsonIgnore
    private RestauranteModel restaurante;
}
