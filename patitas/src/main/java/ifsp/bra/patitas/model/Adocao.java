package ifsp.bra.patitas.model;

import java.time.LocalDate;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Adocao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;

    @ManyToOne
    @JoinColumn(name = "adotante_id")
    private Adotante adotante;

    private String status;
    private LocalDate requestDate;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Animal getAnimal() {
        return animal;
    }
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
    public Adotante getAdotante() {
        return adotante;
    }
    public void setAdotante(Adotante adotante) {
        this.adotante = adotante;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public LocalDate getRequestDate() {
        return requestDate;
    }
    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }
    
    public Adocao(Long id, Animal animal, Adotante adotante, String status, LocalDate requestDate) {
        this.id = id;
        this.animal = animal;
        this.adotante = adotante;
        this.status = status;
        this.requestDate = requestDate;
    }
    public Adocao() {}
    
}
