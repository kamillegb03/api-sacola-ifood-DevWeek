package me.dio.sacolaApi.repository;

import me.dio.sacolaApi.dto.ItemDto;
import me.dio.sacolaApi.models.ItemModel;
import me.dio.sacolaApi.models.SacolaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SacolaRepository extends JpaRepository<SacolaModel, Long> {

}
