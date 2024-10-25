package ifsp.bra.patitas.model;
import jakarta.persistence.Entity;

@Entity
public class Animal {
    private int id_animal;
    private String nome;
    private int idade;
    private String raca;
    private String sexo;
    private String especie;
    private String porte;
    private String desc;
    private boolean disponivel;

    public Animal(){

    }

    public Animal(int id_animal, String nome, int idade, String raca, String sexo, String especie, String porte, String desc,
            boolean disponivel) {
        this.id_animal = id_animal;
        this.nome = nome;
        this.idade = idade;
        this.raca = raca;
        this.sexo = sexo;
        this.especie = especie;
        this.porte = porte;
        this.desc = desc;
        this.disponivel = disponivel;
    }


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


    public String getDesc() {
        return desc;
    }


    public void setDesc(String desc) {
        this.desc = desc;
    }


    public boolean isDisponivel() {
        return disponivel;
    }


    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public int getId_animal() {
        return id_animal;
    }

    public void setId_animal(int id_animal) {
        this.id_animal = id_animal;
    }

    
}
