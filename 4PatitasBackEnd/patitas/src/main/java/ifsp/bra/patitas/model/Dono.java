package ifsp.bra.patitas.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public abstract class Dono extends Usuario{

    //Cardinalidade Hibernate
    @OneToMany
    private List<Animal> listaAnimais = new ArrayList<>();

    //Construtores
    public Dono(){}

    public Dono(List<Animal> listaAnimais) {
        this.listaAnimais = listaAnimais;
    }

    public Dono(Long id, String nome, String email, String telefone, String endereco, String description,
            List<Animal> listaAnimais) {
        super(id, nome, email, telefone, endereco, description);
        this.listaAnimais = listaAnimais;
    }

    //Getters e Setters
    public List<Animal> getListaAnimais() {
        return listaAnimais;
    }

    public void setListaAnimais(List<Animal> listaAnimais) {
        this.listaAnimais = listaAnimais;
    };
    
}
