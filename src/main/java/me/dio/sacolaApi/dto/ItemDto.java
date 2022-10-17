package me.dio.sacolaApi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.dio.sacolaApi.models.ItemModel;
import me.dio.sacolaApi.models.ProdutoModel;
import me.dio.sacolaApi.models.SacolaModel;
import me.dio.sacolaApi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {
    private Long produtoId;
    private int quantidade;
    private Long sacolaId;

}
