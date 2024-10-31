package ifsp.bra.patitas.model;

import jakarta.persistence.Entity;

@Entity
public class Ong extends Usuario{
    
    private String cnpj;
    private String pix;

    public Ong(){}

    public Ong(Long id, String nome, String email, String telefone, String endereco, String description, String cnpj,
            String pix) {
        super(id, nome, email, telefone, endereco, description);
        this.cnpj = cnpj;
        this.pix = pix;
    }
    
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
