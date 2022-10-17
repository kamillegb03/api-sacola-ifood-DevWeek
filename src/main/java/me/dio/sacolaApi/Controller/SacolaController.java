package me.dio.sacolaApi.Controller;

import lombok.RequiredArgsConstructor;
import me.dio.sacolaApi.dto.ItemDto;
import me.dio.sacolaApi.models.ItemModel;
import me.dio.sacolaApi.models.SacolaModel;
import me.dio.sacolaApi.service.SacolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/ifood-devweek/sacolas")
public class SacolaController {

    private final SacolaService sacolaService;

    @PostMapping("/incluir")
    public ItemModel incluirItemSacola(@RequestBody ItemDto itemDto){
        return sacolaService.incluirItemSacola(itemDto);
    }

    @GetMapping("/{id}")
    public SacolaModel verSacola(@PathVariable("id") Long id){
        return sacolaService.verSacola(id);
    }

    @PutMapping("/fecharSacola/{id}")
    public SacolaModel fecharSacola(@PathVariable("id") Long id, @RequestParam("formaPagamento") int formaPagamento){
        return sacolaService.fecharSacola(id, formaPagamento);
    }
}
