package ifsp.bra.patitas.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

@Entity
public class Adotante extends Usuario{

    //Atributos
    private String cpf;

    //Construtores
    public Adotante(){}

    public Adotante(Long id, String nome, String email, String telefone, String endereco, String description,
            String cpf, List<Adocao> listaAdocao) {
        super(id, nome, email, telefone, endereco, description);
        this.cpf = cpf;
        this.listaAdocao = listaAdocao;
    }

    //Cardinalidade
    @OneToMany(mappedBy = "adotante", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Adocao> listaAdocao= new ArrayList<>();

    //Getters e Setters
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Adocao> getListaAdocao() {
        return listaAdocao;
    }

    public void setListaAdocao(List<Adocao> listaAdocao) {
        this.listaAdocao = listaAdocao;
    }
    
}
