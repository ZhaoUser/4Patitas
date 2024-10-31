package ifsp.bra.patitas.model;
import jakarta.persistence.Entity;

@Entity
public class larTemp extends Usuario{
    
    private String periodo;
    private String cpf;
    
    public larTemp(){

    }

    public larTemp(Long id, String nome, String email, String telefone, String endereco, String desc, String periodo,
            String cpf) {
        super(id, nome, email, telefone, endereco, desc);
        this.periodo = periodo;
        this.cpf = cpf;
    }

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
