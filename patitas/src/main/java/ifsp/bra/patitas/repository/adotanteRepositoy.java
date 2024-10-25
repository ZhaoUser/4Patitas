package ifsp.bra.patitas.repository;
import ifsp.bra.patitas.model.Adotante;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface adotanteRepositoy extends JpaRepository<Adotante, Integer>{
    
}
