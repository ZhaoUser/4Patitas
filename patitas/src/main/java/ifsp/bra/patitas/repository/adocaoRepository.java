package ifsp.bra.patitas.repository;

import ifsp.bra.patitas.model.Adocao;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface adocaoRepository extends CrudRepository<Adocao, Long>{

    List<Adocao> findByAdotanteId(Long adotanteId);

    List<Adocao> findByAnimalId(Long animal_id);
}
