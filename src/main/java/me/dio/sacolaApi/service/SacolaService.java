package me.dio.sacolaApi.service;

import lombok.RequiredArgsConstructor;
import me.dio.sacolaApi.dto.ItemDto;
import me.dio.sacolaApi.enumeration.FormaPagamento;
import me.dio.sacolaApi.models.ItemModel;
import me.dio.sacolaApi.models.SacolaModel;
import me.dio.sacolaApi.repository.ItemRepository;
import me.dio.sacolaApi.repository.ProdutoRepository;
import me.dio.sacolaApi.repository.SacolaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SacolaService {
    private final SacolaRepository sacolaRepository;
    private final ItemRepository itemRepository;

    private final ProdutoRepository produtoRepository;

    public ItemModel incluirItemSacola(ItemDto itemDto){
        System.out.println("AQUI");
        SacolaModel sacolaModel = verSacola(itemDto.getProdutoId());

        ItemModel toItemDTO = ItemModel.builder()
                .produto(produtoRepository.findById(itemDto.getProdutoId()).orElseThrow(() -> {throw new RuntimeException("Esse produto não existe");}))
                .quantidade(itemDto.getQuantidade())
                .sacola(sacolaModel)
                .build();

        if(sacolaModel.isFechada()){
            throw new RuntimeException("Essa sacola está fechada");
        }
        if(!itensMesmoRestaurante(sacolaModel)){
            throw new RuntimeException("Não é possivel adicionar produtos de restaurantes diferentes. Feche a sacola ou esvazie");
        }
        sacolaModel.getItens().add(toItemDTO);
        sacolaRepository.save(sacolaModel);
        return itemRepository.save(toItemDTO);
    }

    public SacolaModel verSacola(Long id){
        return sacolaRepository.findById(id).orElseThrow(
                () -> {
                    throw new RuntimeException("Essa sacola não existe");
                }
        );
    }

    public SacolaModel fecharSacola(Long id, int numeroFormaPagamento){
        SacolaModel sacolaModel = verSacola(id);
        if(sacolaModel.getItens().isEmpty()){
            throw new RuntimeException("Sacola Vazia! inclua itens antes de fechar a sacola");
        }
        FormaPagamento formaPagamento = numeroFormaPagamento == 0 ? FormaPagamento.DINHEIRO : FormaPagamento.MAQUINETA;
        sacolaModel.setFormaPagamento(formaPagamento);
        sacolaModel.setFechada(true);

        return sacolaRepository.save(sacolaModel);
    }

    public boolean itensMesmoRestaurante(SacolaModel sacolaModel){
        List<ItemModel> itensDaSacola = sacolaModel.getItens();

        if(!itensDaSacola.isEmpty()){
            return false;
        }
        return true;
    }
}
