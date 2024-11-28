package ifsp.bra.patitas.repository;
import ifsp.bra.patitas.model.Animal;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface animalRepository extends CrudRepository<Animal, Long>{
}
