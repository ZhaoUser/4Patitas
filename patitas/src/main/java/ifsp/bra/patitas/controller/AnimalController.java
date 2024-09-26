package ifsp.bra.patitas.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ifsp.bra.patitas.model.Animal;

@RestController
@RequestMapping("/api/4Patitas/animal/")
public class AnimalController {
    private List<Animal> listaAnimal = new ArrayList<>();


    // GET: Lista de animal
    @GetMapping
    public List<Animal> listarAnimal() {
        return listaAnimal;
    }

    // GET: Recupera um animal específico por ID
    @GetMapping("/{id_animal}")
    public Animal getAnimalById(@PathVariable int id_animal) {
        return listaAnimal.stream()
                .filter(animal -> animal.getId_animal() == id_animal)
                .findFirst()
                .orElse(null);
    }

    // POST: Cria um novo animal
    @PostMapping
    public Animal createAnimal(@RequestBody Animal animal) {
        listaAnimal.add(animal);
        return animal;
    }

    // PUT: Atualiza um Animal existente
    @PutMapping("/{id_animal}")
    public Animal updateAnimal(@PathVariable int id_animal, @RequestBody Animal novoAnimal) {
        Animal animalExistente = listaAnimal.stream()
                .filter(Animal -> Animal.getId_animal() == id_animal)
                .findFirst()
                .orElse(null);

        if (animalExistente != null) {
            animalExistente.setNome(novoAnimal.getNome());
            animalExistente.setIdade(novoAnimal.getIdade());
            animalExistente.setRaca(novoAnimal.getRaca());
            animalExistente.setSexo(novoAnimal.getSexo());
            animalExistente.setPorte(novoAnimal.getPorte());
            animalExistente.setDesc(novoAnimal.getDesc());
            animalExistente.setDisponivel(novoAnimal.isDisponivel());
        }
        return animalExistente;
    }

    // DELETE: Deleta um Animal
    @DeleteMapping("/{id_Animal}")
    public void deleteAnimal(@PathVariable int id_animal) {
        listaAnimal.removeIf(Animal -> Animal.getId_animal() == id_animal);
    }
}
