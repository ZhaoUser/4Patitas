package ifsp.bra.patitas.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Animal {

    //Atributos
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int idade;
    private String raca;
    private String sexo;
    private String especie;
    private String porte;
    private String description;
    private boolean disponivel;

    //Construtores
    public Animal(){}

    public Animal(Long id, String nome, int idade, String raca, String sexo, String especie, String porte,
            String description, boolean disponivel, List<Adocao> listaAdocao, Dono donoAnimal) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.raca = raca;
        this.sexo = sexo;
        this.especie = especie;
        this.porte = porte;
        this.description = description;
        this.disponivel = disponivel;
        this.listaAdocao = listaAdocao;
        DonoAnimal = donoAnimal;
    }

    //Cardinalidade no Hibernate
    @OneToMany(mappedBy = "animal", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Adocao> listaAdocao= new ArrayList<>();

    @ManyToOne @JoinColumn
    (name = "Owner")
    private Dono DonoAnimal;

    //Getters e Setters
    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public int getIdade() {
        return idade;
    }


    public void setIdade(int idade) {
        this.idade = idade;
    }


    public String getRaca() {
        return raca;
    }


    public void setRaca(String raca) {
        this.raca = raca;
    }


    public String getSexo() {
        return sexo;
    }


    public void setSexo(String sexo) {
        this.sexo = sexo;
    }


    public String getEspecie() {
        return especie;
    }


    public void setEspecie(String especie) {
        this.especie = especie;
    }


    public String getPorte() {
        return porte;
    }


    public void setPorte(String porte) {
        this.porte = porte;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public boolean isDisponivel() {
        return disponivel;
    }


    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Adocao> getListaAdocao() {
        return listaAdocao;
    }

    public void setListaAdocao(List<Adocao> listaAdocao) {
        this.listaAdocao = listaAdocao;
    }

    public Dono getDonoAnimal() {
        return DonoAnimal;
    }

    public void setDonoAnimal(Dono donoAnimal) {
        DonoAnimal = donoAnimal;
    }

}
