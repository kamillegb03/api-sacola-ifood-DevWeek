package me.dio.sacolaApi.repository;

import me.dio.sacolaApi.models.RestauranteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestauranteRepository extends JpaRepository<RestauranteModel, Long> {
}
