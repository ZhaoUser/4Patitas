package ifsp.bra.patitas.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ifsp.bra.patitas.model.Adotante;

@RestController
@RequestMapping("/api/4Patitas/adotante")
public class AdotanteController {
    
    private List<Adotante> listaAdotante = new ArrayList<>();


    // GET: Lista de Adotante
    @GetMapping
    public List<Adotante> Adotante() {
        return listaAdotante;
    }

    // GET: Recupera um Adotante específico por ID
    @GetMapping("/{id}")
    public Adotante getAdotanteById(@PathVariable int id) {
        return listaAdotante.stream()
                .filter(adotante -> adotante.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // POST: Cria um novo Adotante
    @PostMapping
    public Adotante createAdotante(@RequestBody Adotante adotante) {
        listaAdotante.add(adotante);
        return adotante;
    }

    // PUT: Atualiza um Adotante existente
    @PutMapping("/{id}")
    public Adotante updateAdotante(@PathVariable int id, @RequestBody Adotante novoAdotante) {
        Adotante AdotanteExistente = listaAdotante.stream()
                .filter(adotante -> adotante.getId() == id)
                .findFirst()
                .orElse(null);

        if (AdotanteExistente != null) {
            AdotanteExistente.setNome(novoAdotante.getNome());
            AdotanteExistente.setNome(novoAdotante.getNome());
            AdotanteExistente.setEmail(novoAdotante.getEmail());
            AdotanteExistente.setTelefone(novoAdotante.getTelefone());
            AdotanteExistente.setEndereco(novoAdotante.getEndereco());
            AdotanteExistente.setDesc(novoAdotante.getDesc());
            AdotanteExistente.setCpf(novoAdotante.getCpf());
        }//int id, String nome, String email, String telefone, String endereco, String desc, String cpf
        return AdotanteExistente;
    }

    // DELETE: Deleta um Adotante
    @DeleteMapping("/{id}")
    public void deleteAdotante(@PathVariable int id) {
        listaAdotante.removeIf(adotante -> adotante.getId() == id);
    }
}
