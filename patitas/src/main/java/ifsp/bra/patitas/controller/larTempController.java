package ifsp.bra.patitas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import ifsp.bra.patitas.model.larTemp;
import ifsp.bra.patitas.repository.larTempRepository;

@RestController
@RequestMapping("/api/4Patitas/larTemp")
public class larTempController {

    @Autowired
    larTempRepository larRepository;

    // GET: Lista de larTemp
    @GetMapping
    public List<larTemp> findAlllarTemp() {
        return StreamSupport.stream(larRepository
                .findAll()
                .spliterator(), false)
                .collect(Collectors.toList());
    }

    // GET: Recupera um larTemp específico por ID
    @GetMapping("/{id}")
    public larTemp findlarTempById(@PathVariable Long id) {
        return larRepository.findById(id).orElse(null);
    }

    // POST: Cria um novo larTemp
    @PostMapping
    public larTemp createlarTemp(@RequestBody larTemp larTemp) {
        return larRepository.save(larTemp);
    }

    // PUT: Atualiza um larTemp existente
    @PutMapping("/{id}")
    public larTemp updatelarTemp(@PathVariable Long id, @RequestBody larTemp novolarTemp) {
        return larRepository.findById(id)
                .map(larTempExistente -> {
                    larTempExistente.setNome(novolarTemp.getNome());
                    larTempExistente.setEmail(novolarTemp.getEmail());
                    larTempExistente.setTelefone(novolarTemp.getTelefone());
                    larTempExistente.setEndereco(novolarTemp.getEndereco());
                    larTempExistente.setDescription(novolarTemp.getDescription());
                    larTempExistente.setPeriodo(novolarTemp.getPeriodo());
                    larTempExistente.setCpf(novolarTemp.getCpf());
                    return larRepository.save(larTempExistente);
                })
                .orElse(null);
    }

    // DELETE: Deleta um larTemp
    @DeleteMapping("/{id}")
    public void deletelarTemp(@PathVariable Long id) {
        larRepository.deleteById(id);
    }
}
