package ifsp.bra.patitas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import ifsp.bra.patitas.model.Ong;
import ifsp.bra.patitas.repository.ongRepository;

@RestController
@RequestMapping("/api/4Patitas/ong")
public class OngController {

    @Autowired
    ongRepository ongRepository;

    // GET: Lista de Ong
    @GetMapping
    public List<Ong> findAllOngs() {
        return StreamSupport.stream(ongRepository
                .findAll()
                .spliterator(), false)
                .collect(Collectors.toList());
    }

    // GET: Recupera um Ong específico por ID
    @GetMapping("/{id}")
    public Ong findOngById(@PathVariable Long id) {
        return ongRepository.findById(id).orElse(null);
    }

    // POST: Cria um novo Ong
    @PostMapping
    public Ong createOng(@RequestBody Ong ong) {
        return ongRepository.save(ong);
    }

    // PUT: Atualiza um Ong existente
    @PutMapping("/{id}")
    public Ong updateOng(@PathVariable Long id, @RequestBody Ong novoOng) {
        return ongRepository.findById(id)
                .map(ongExistente -> {
                    ongExistente.setNome(novoOng.getNome());
                    ongExistente.setEmail(novoOng.getEmail());
                    ongExistente.setTelefone(novoOng.getTelefone());
                    ongExistente.setEndereco(novoOng.getEndereco());
                    ongExistente.setDescription(novoOng.getDescription());
                    ongExistente.setCnpj(novoOng.getCnpj());
                    ongExistente.setPix(novoOng.getPix());
                    return ongRepository.save(ongExistente);
                })
                .orElse(null);
    }

    // DELETE: Deleta um Ong
    @DeleteMapping("/{id}")
    public void deleteOng(@PathVariable Long id) {
        ongRepository.deleteById(id);
    }
}
