package me.dio.sacolaApi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Builder
@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NoArgsConstructor
public class RestauranteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ProdutoModel> produtos;

    @Embedded
    private EnderecoModel endereco;

}
