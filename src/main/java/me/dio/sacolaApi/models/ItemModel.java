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
public class ItemModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private ProdutoModel produto;

    private int quantidade;

    @ManyToOne
    @JsonIgnore
    private SacolaModel sacola;
}
