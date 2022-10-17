package me.dio.sacolaApi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import me.dio.sacolaApi.enumeration.FormaPagamento;

import javax.persistence.*;
import java.util.List;


@AllArgsConstructor
@Builder
@Data
@Getter
@Setter
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NoArgsConstructor
public class SacolaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JsonIgnore
    private ClienteModel cliente;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ItemModel> itens;

    private Double valorTotal;

    @Enumerated
    private FormaPagamento FormaPagamento;
    private boolean fechada;

}
