package ifsp.bra.patitas.model;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import ifsp.bra.patitas.repository.adotanteRepository;
import jakarta.persistence.Entity;

@Entity
public class Adotante extends Usuario{
    private String cpf;
    public Adotante(){

    }

    public Adotante(int id, String nome, String email, String telefone, String endereco, String desc, String cpf) {
        super(id, nome, email, telefone, endereco, desc);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    @Autowired
    adotanteRepository aRepository;

    Adotante adotante = new Adotante();

    public List<Adotante> getAllAdotante(){
        return (List<Adotante>) aRepository.findAll();
    }

    public Adotante getAdotanteById(int id){
        return aRepository.findById(id).orElse(null);
    }

    public void addAdotante(Adotante adotante){
        aRepository.save(adotante);
    }

    public void updateAdotante(int id, Adotante adotante){
        if (aRepository.existsById(id)==true) {
            aRepository.save(adotante);
        }
    }

    public void deleteAdotante(Adotante adotante){
        aRepository.delete(adotante);
    }
}
