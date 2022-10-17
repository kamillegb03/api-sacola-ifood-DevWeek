package me.dio.sacolaApi.models;

import lombok.*;

import javax.persistence.Embeddable;

@AllArgsConstructor
@Getter
@Setter
@Builder
@Data
@Embeddable
@NoArgsConstructor
public class EnderecoModel{

    private String cep;

    private String complemento;
}
