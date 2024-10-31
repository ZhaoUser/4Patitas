package ifsp.bra.patitas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import ifsp.bra.patitas.model.Animal;
import ifsp.bra.patitas.repository.AnimalRepository;

@RestController
@RequestMapping("/api/4Patitas/animal")
public class AnimalController {

    @Autowired
    AnimalRepository anRepository;

    // GET: Lista de animal
    @GetMapping
    public List<Animal> findAllAnimals() {
        return StreamSupport.stream(anRepository
                .findAll()
                .spliterator(), false)
                .collect(Collectors.toList());
    }

    // GET: Recupera um animal específico por ID
    @GetMapping("/{id_animal}")
    public Animal findAnimalById(@PathVariable int id_animal) {
        return anRepository.findById(id_animal).orElse(null);
    }

    // POST: Cria um novo animal
    @PostMapping
    public Animal createAnimal(@RequestBody Animal animal) {
        return anRepository.save(animal);
    }

    // PUT: Atualiza um Animal existente
    @PutMapping("/{id_animal}")
    public Animal updateAnimal(@PathVariable int id_animal, @RequestBody Animal novoAnimal) {
        return anRepository.findById(id_animal)
                .map(animalExistente -> {
                    animalExistente.setNome(novoAnimal.getNome());
                    animalExistente.setIdade(novoAnimal.getIdade());
                    animalExistente.setRaca(novoAnimal.getRaca());
                    animalExistente.setSexo(novoAnimal.getSexo());
                    animalExistente.setEspecie(novoAnimal.getEspecie());
                    animalExistente.setPorte(novoAnimal.getPorte());
                    animalExistente.setDesc(novoAnimal.getDesc());
                    animalExistente.setDisponivel(novoAnimal.isDisponivel());
                    return anRepository.save(animalExistente);
                })
                .orElse(null);
    }

    // DELETE: Deleta um Animal
    @DeleteMapping("/{id_animal}")
    public void deleteAnimal(@PathVariable int id_animal) {
        anRepository.deleteById(id_animal);
    }
}
