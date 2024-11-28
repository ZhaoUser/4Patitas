package ifsp.bra.patitas.repository;
import ifsp.bra.patitas.model.larTemp;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface larTempRepository extends CrudRepository<larTemp, Long>{
}
