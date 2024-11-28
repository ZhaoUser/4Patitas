package ifsp.bra.patitas.model;

import java.util.List;

import jakarta.persistence.Entity;

@Entity
public class larTemp extends Dono{
    
    //Atributos
    private String periodo;
    private String cpf;
    
    //Construtores
    public larTemp() {}

    public larTemp(Long id, String nome, String email, String telefone, String endereco, String description,
            List<Animal> listaAnimais, String periodo, String cpf) {
        super(id, nome, email, telefone, endereco, description, listaAnimais);
        this.periodo = periodo;
        this.cpf = cpf;
    }

    //Getters e Setters
    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
