package br.com.cadeiras.service;

import br.com.cadeiras.models.CadeiraModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CadeiraRepository extends JpaRepository<CadeiraModel, UUID> {

}
