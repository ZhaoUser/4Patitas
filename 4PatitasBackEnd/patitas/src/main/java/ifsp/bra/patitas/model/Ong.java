package ifsp.bra.patitas.model;

import java.util.List;

import jakarta.persistence.Entity;

@Entity
public class Ong extends Dono{
    
    //Atributos
    private String cnpj;
    private String pix;

    //Construtores
    public Ong() {}

    public Ong(Long id, String nome, String email, String telefone, String endereco, String description,
            List<Animal> listaAnimais, String cnpj, String pix) {
        super(id, nome, email, telefone, endereco, description, listaAnimais);
        this.cnpj = cnpj;
        this.pix = pix;
    }

    //Getters e Setters
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getPix() {
        return pix;
    }

    public void setPix(String pix) {
        this.pix = pix;
    }
    
}
