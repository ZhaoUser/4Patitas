package ifsp.bra.patitas.repository;
import ifsp.bra.patitas.model.Adotante;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface adotanteRepository extends CrudRepository<Adotante, Integer>{
}
