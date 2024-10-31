package ifsp.bra.patitas.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ifsp.bra.patitas.model.Adocao;
import ifsp.bra.patitas.model.Adotante;
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
    public ResponseEntity<Adocao> createAdocao(@RequestBody Map<String, Long> requestIds) {
        Long animal_id = requestIds.get("animal_id");
        Long adotante_id = requestIds.get("adotante_id");
    
        Animal animal = animalRepository.findById(animal_id)
                .orElseThrow();
        
        Adotante adotante = adotanteRepository.findById(adotante_id)
                .orElseThrow();
    
        Adocao adocao = new Adocao();
        adocao.setAnimal(animal);
        adocao.setAdotante(adotante);
        adocao.setStatus("Pending");
        adocao.setRequestDate(LocalDate.now());

        Adocao pedidoAdocao = adocaoRepository.save(adocao);
        return ResponseEntity.ok(pedidoAdocao);
    }
    
    @GetMapping("/adotante/{adotante_id}")
    public List<Adocao> getRequestsByAdotante(@PathVariable Long adotante_id) {
        return adocaoRepository.findByAdotanteId(adotante_id);
    }

    @GetMapping("/animal/{animal_id}")
    public List<Adocao> getRequestsByAnimal(@PathVariable Long animal_id) {
        return adocaoRepository.findByAnimalId(animal_id);
    }

    @PutMapping("/{id}")
    public Adocao updateAdocao(@PathVariable Long id, @RequestBody Adocao novoAdocao) {
        return adocaoRepository.findById(id)
                .map(adocaoExistente -> {
                    adocaoExistente.setAnimal(novoAdocao.getAnimal());
                    adocaoExistente.setAdotante(novoAdocao.getAdotante());
                    adocaoExistente.setStatus(novoAdocao.getStatus());
                    adocaoExistente.setRequestDate(novoAdocao.getRequestDate());
                    return adocaoRepository.save(adocaoExistente);
                })
                .orElse(null); 
    }
    

    @DeleteMapping("/{id}")
    public void deleteAdocao(@PathVariable Long id) {
        adocaoRepository.deleteById(id);
    }
}
