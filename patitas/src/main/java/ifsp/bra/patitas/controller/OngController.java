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
import ifsp.bra.patitas.model.Ong;
import ifsp.bra.patitas.repository.ongRepository;

@RestController
@RequestMapping("/api/4Patitas/ong")
public class OngController {
    
    @Autowired
    ongRepository ongRepository;

    private List<Ong> listaOng = new ArrayList<>();


    // GET: Lista de Ong
    @GetMapping
    public List<Ong> Ong() {
        return listaOng;
    }

    // GET: Recupera um Ong específico por ID
    @GetMapping("/{id}")
    public Ong findByOngId(@PathVariable int id) {
        return listaOng.stream()
                .filter(ong -> ong.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // POST: Cria um novo Ong
    @PostMapping
    public Ong createOng(@RequestBody Ong ong) {
        listaOng.add(ong);
        return ong;
    }

    // PUT: Atualiza um Ong existente
    @PutMapping("/{id}")
    public Ong updateOng(@PathVariable int id, @RequestBody Ong novoOng) {
        Ong OngExistente = listaOng.stream()
                .filter(ong -> ong.getId() == id)
                .findFirst()
                .orElse(null);

        if (OngExistente != null) {
            OngExistente.setNome(novoOng.getNome());
            OngExistente.setEmail(novoOng.getEmail());
            OngExistente.setTelefone(novoOng.getTelefone());
            OngExistente.setEndereco(novoOng.getEndereco());
            OngExistente.setDesc(novoOng.getDesc());            
            OngExistente.setCnpj(novoOng.getCnpj());
            OngExistente.setPix(novoOng.getPix());
        }
        return OngExistente;
    }

    // DELETE: Deleta um Ong
    @DeleteMapping("/{id}")
    public void deleteOng(@PathVariable int id) {
        listaOng.removeIf(ong -> ong.getId() == id);
    }
}
