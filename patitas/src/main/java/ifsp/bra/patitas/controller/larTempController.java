package ifsp.bra.patitas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import ifsp.bra.patitas.model.LarTemp;
import ifsp.bra.patitas.repository.LarTempRepository;

@RestController
@RequestMapping("/api/4Patitas/larTemp")
public class LarTempController {

    @Autowired
    LarTempRepository larRepository;

    // GET: Lista de larTemp
    @GetMapping
    public List<LarTemp> findAllLarTemp() {
        return StreamSupport.stream(larRepository
                .findAll()
                .spliterator(), false)
                .collect(Collectors.toList());
    }

    // GET: Recupera um larTemp específico por ID
    @GetMapping("/{id}")
    public LarTemp findLarTempById(@PathVariable int id) {
        return larRepository.findById(id).orElse(null);
    }

    // POST: Cria um novo larTemp
    @PostMapping
    public LarTemp createLarTemp(@RequestBody LarTemp larTemp) {
        return larRepository.save(larTemp);
    }

    // PUT: Atualiza um larTemp existente
    @PutMapping("/{id}")
    public LarTemp updateLarTemp(@PathVariable int id, @RequestBody LarTemp novoLarTemp) {
        return larRepository.findById(id)
                .map(larTempExistente -> {
                    larTempExistente.setNome(novoLarTemp.getNome());
                    larTempExistente.setEmail(novoLarTemp.getEmail());
                    larTempExistente.setTelefone(novoLarTemp.getTelefone());
                    larTempExistente.setEndereco(novoLarTemp.getEndereco());
                    larTempExistente.setDesc(novoLarTemp.getDesc());
                    larTempExistente.setPeriodo(novoLarTemp.getPeriodo());
                    larTempExistente.setCpf(novoLarTemp.getCpf());
                    return larRepository.save(larTempExistente);
                })
                .orElse(null);
    }

    // DELETE: Deleta um larTemp
    @DeleteMapping("/{id}")
    public void deleteLarTemp(@PathVariable int id) {
        larRepository.deleteById(id);
    }
}
