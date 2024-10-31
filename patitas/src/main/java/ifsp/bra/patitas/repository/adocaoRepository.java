package ifsp.bra.patitas.repository;
import ifsp.bra.patitas.model.Adocao;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface adocaoRepository extends CrudRepository<Adocao, Long>{
}
