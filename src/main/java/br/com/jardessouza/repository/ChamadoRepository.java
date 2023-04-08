package br.com.jardessouza.repository;

import br.com.jardessouza.domain.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {
}
