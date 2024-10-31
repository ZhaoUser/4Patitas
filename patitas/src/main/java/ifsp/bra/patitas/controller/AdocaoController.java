package ifsp.bra.patitas.controller;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ifsp.bra.patitas.model.Adocao;
import ifsp.bra.patitas.model.Animal;
import ifsp.bra.patitas.repository.adocaoRepository;
import ifsp.bra.patitas.repository.adotanteRepository;
import ifsp.bra.patitas.repository.animalRepository;

@RestController
@RequestMapping("/adocao")
public class AdocaoController {

    private final adocaoRepository adocaoRepository;
    private final animalRepository animalRepository;
    private final adotanteRepository adotanteRepository;

    @Autowired
    public AdocaoController(adocaoRepository adocaoRepository,
                                     animalRepository animalRepository,
                                     adotanteRepository adotanteRepository) {
        this.adocaoRepository = adocaoRepository;
        this.animalRepository = animalRepository;
        this.adotanteRepository = adotanteRepository;
    }

    @PostMapping
    public ResponseEntity<AdoptionRequest> createAdoptionRequest(@RequestBody Map<String, Long> requestIds) {
        Long id_animal = requestIds.get("id_animal");
        Long id_adotante = requestIds.get("id_adotante");
    
        Animal animal = animalRepository.findById(id_animal)
                .orElseThrow(() -> new ResourceNotFoundException("Animal not found with ID " + id_animal));
        
        FosterUser fosterUser = fosterUserRepository.findById(id_adotante)
                .orElseThrow(() -> new ResourceNotFoundException("FosterUser not found with ID " + id_adotante));
    
        // Directly create and set up the AdoptionRequest entity
        AdoptionRequest adoptionRequest = new AdoptionRequest();
        adoptionRequest.setAnimal(animal);
        adoptionRequest.setFosterUser(fosterUser);
        adoptionRequest.setStatus("Pending");
        adoptionRequest.setRequestDate(LocalDate.now());
    
        // Save and return the new adoption request
        AdoptionRequest savedRequest = adoptionRequestRepository.save(adoptionRequest);
        return ResponseEntity.ok(savedRequest);
    }
    
    // Retrieve adoption requests by foster user ID
    @GetMapping("/adotante/{id_adotante}")
    public List<Adocao> getRequestsByAdotante(@PathVariable Long id_adotante) {
        return adocaoRepository.findByAdontanteId(id_adotante);
    }

    // Retrieve adoption requests by animal ID
    @GetMapping("/animal/{id_animal}")
    public List<Adocao> getRequestsByAnimal(@PathVariable Long id_animal) {
        return adocaoRepository.findByid_animal(id_animal);
    }

    // Additional methods to update or delete requests if needed
}