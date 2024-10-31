package ifsp.bra.patitas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import ifsp.bra.patitas.model.Adotante;
import ifsp.bra.patitas.repository.adotanteRepository;

@RestController
@RequestMapping("/api/4Patitas/adotante")
public class AdotanteController {

    @Autowired
    adotanteRepository adRepository;

    // GET: Lista de Adotante
    @GetMapping
    public List<Adotante> findAllAdotantes() {
        return StreamSupport.stream(adRepository
                .findAll()
                .spliterator(), false)
                .collect(Collectors.toList());
    }

    // GET: Recupera um Adotante específico por ID
    @GetMapping("/{id}")
    public Adotante findAdotanteById(@PathVariable Long id) {
        return adRepository.findById(id).orElse(null);
    }

    // POST: Cria um novo Adotante
    @PostMapping
    public Adotante createAdotante(@RequestBody Adotante adotante) {
        return adRepository.save(adotante);
    }

    // PUT: Atualiza um Adotante existente
    @PutMapping("/{id}")
    public Adotante updateAdotante(@PathVariable Long id, @RequestBody Adotante novoAdotante) {
        return adRepository.findById(id)
                .map(adotanteExistente -> {
                    adotanteExistente.setNome(novoAdotante.getNome());
                    adotanteExistente.setEmail(novoAdotante.getEmail());
                    adotanteExistente.setTelefone(novoAdotante.getTelefone());
                    adotanteExistente.setEndereco(novoAdotante.getEndereco());
                    adotanteExistente.setDescription(novoAdotante.getDescription());
                    adotanteExistente.setCpf(novoAdotante.getCpf());
                    return adRepository.save(adotanteExistente);
                })
                .orElse(null);
    }

    // DELETE: Deleta um Adotante
    @DeleteMapping("/{id}")
    public void deleteAdotante(@PathVariable Long id) {
        adRepository.deleteById(id);
    }
}
