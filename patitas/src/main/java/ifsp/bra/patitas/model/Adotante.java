package ifsp.bra.patitas.model;

import jakarta.persistence.Entity;

@Entity
public class Adotante extends Usuario{
    private String cpf;
    public Adotante(){

    }

    public Adotante(Long id, String nome, String email, String telefone, String endereco, String desc, String cpf) {
        super(id, nome, email, telefone, endereco, desc);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
