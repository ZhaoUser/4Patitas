package ifsp.bra.patitas.model;

import jakarta.persistence.Entity;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

@Entity
public class Adotante extends Usuario{
    private String cpf;
    public Adotante(){}

    public Adotante(Long id, String nome, String email, String telefone, String endereco, String description, String cpf) {
        super(id, nome, email, telefone, endereco, description);
        this.cpf = cpf;
    }

    @OneToMany(mappedBy = "adotante", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Adocao> listaAdocao= new ArrayList<>();

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
