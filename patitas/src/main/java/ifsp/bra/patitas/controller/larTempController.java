package ifsp.bra.patitas.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ifsp.bra.patitas.model.larTemp;
import ifsp.bra.patitas.repository.larTempRepository;

@RestController
@RequestMapping("/api/4Patitas/larTemp")
public class larTempController {
    
    
    @Autowired
    larTempRepository larRepository;

    private List<larTemp> listaLarTemp = new ArrayList<>();


    // GET: Lista de larTemp
    @GetMapping
    public List<larTemp> larTemp() {
        return listaLarTemp;
    }

    // GET: Recupera um larTemp específico por ID
    @GetMapping("/{id}")
    public larTemp findBylarTempId(@PathVariable int id) {
        return listaLarTemp.stream()
                .filter(larTemp -> larTemp.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // POST: Cria um novo larTemp
    @PostMapping
    public larTemp createlarTemp(@RequestBody larTemp larTemp) {
        listaLarTemp.add(larTemp);
        return larTemp;
    }

    // PUT: Atualiza um larTemp existente
    @PutMapping("/{id}")
    public larTemp updatelarTemp(@PathVariable int id, @RequestBody larTemp novolarTemp) {
        larTemp larTempExistente = listaLarTemp.stream()
                .filter(larTemp -> larTemp.getId() == id)
                .findFirst()
                .orElse(null);

        if (larTempExistente != null) {
            larTempExistente.setNome(novolarTemp.getNome());
            larTempExistente.setEmail(novolarTemp.getEmail());
            larTempExistente.setTelefone(novolarTemp.getTelefone());
            larTempExistente.setEndereco(novolarTemp.getEndereco());
            larTempExistente.setDesc(novolarTemp.getDesc());
            larTempExistente.setPeriodo(novolarTemp.getPeriodo());
            larTempExistente.setCpf(novolarTemp.getCpf());
        }//int id, String nome, String email, String telefone, String endereco, String desc, String periodo,
        return larTempExistente;
    }

    // DELETE: Deleta um larTemp
    @DeleteMapping("/{id}")
    public void deletelarTemp(@PathVariable int id) {
        listaLarTemp.removeIf(larTemp -> larTemp.getId() == id);
    }
}
