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
@RequestMapping("/Adocao")
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

    // Create a new adoption request
    @PostMapping
    public ResponseEntity<Adocao> createAdocao(@RequestBody AdocaoDTO dto) {
        Animal animal = animalRepository.findById(dto.getAnimalId())
                .orElseThrow(() -> new ResourceNotFoundException("Animal not found with ID " + dto.getAnimalId()));
        
        FosterUser fosterUser = adotanteRepository.findById(dto.getFosterUserId())
                .orElseThrow(() -> new ResourceNotFoundException("FosterUser not found with ID " + dto.getFosterUserId()));
        
        Adocao Adocao = new Adocao();
        Adocao.setAnimal(animal);
        Adocao.setFosterUser(fosterUser);
        Adocao.setStatus("Pending");
        Adocao.setRequestDate(LocalDate.now());

        Adocao savedRequest = adocaoRepository.save(Adocao);
        return ResponseEntity.ok(savedRequest);
    }

    // Retrieve adoption requests by foster user ID
    @GetMapping("/fosterUser/{fosterUserId}")
    public List<Adocao> getRequestsByFosterUser(@PathVariable Long fosterUserId) {
        return adocaoRepository.findByAdontanteId(fosterUserId);
    }

    // Retrieve adoption requests by animal ID
    @GetMapping("/animal/{animalId}")
    public List<Adocao> getRequestsByAnimal(@PathVariable Long animalId) {
        return adocaoRepository.findByAnimalId(animalId);
    }

    // Additional methods to update or delete requests if needed
}