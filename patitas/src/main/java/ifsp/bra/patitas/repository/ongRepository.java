package ifsp.bra.patitas.repository;
import ifsp.bra.patitas.model.Ong;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface ongRepository extends CrudRepository<Ong, Long>{
}
