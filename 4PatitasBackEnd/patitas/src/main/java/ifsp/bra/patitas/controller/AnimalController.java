package ifsp.bra.patitas.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ifsp.bra.patitas.model.Animal;
import ifsp.bra.patitas.repository.animalRepository;

@RestController
@RequestMapping("/api/4Patitas/animal")
public class AnimalController {

    @Autowired
    animalRepository anRepository;

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
    public Animal findAnimalById(@PathVariable Long id_animal) {
        return anRepository.findById(id_animal).orElse(null);
    }

    // POST: Cria um novo animal
    @PostMapping
    public Animal createAnimal(@RequestBody Animal animal) {
        return anRepository.save(animal);
    }

    // PUT: Atualiza um Animal existente
    @PutMapping("/{id_animal}")
    public Animal updateAnimal(@PathVariable Long id_animal, @RequestBody Animal novoAnimal) {
        return anRepository.findById(id_animal)
                .map(animalExistente -> {
                    animalExistente.setNome(novoAnimal.getNome());
                    animalExistente.setIdade(novoAnimal.getIdade());
                    animalExistente.setRaca(novoAnimal.getRaca());
                    animalExistente.setSexo(novoAnimal.getSexo());
                    animalExistente.setEspecie(novoAnimal.getEspecie());
                    animalExistente.setPorte(novoAnimal.getPorte());
                    animalExistente.setDescription(novoAnimal.getDescription());
                    animalExistente.setDisponivel(novoAnimal.isDisponivel());
                    animalExistente.setDonoAnimal(novoAnimal.getDonoAnimal());
                    return anRepository.save(animalExistente);
                })
                .orElse(null);
    }

    // DELETE: Deleta um Animal
    @DeleteMapping("/{id_animal}")
    public void deleteAnimal(@PathVariable Long id_animal) {
        anRepository.deleteById(id_animal);
    }
}
