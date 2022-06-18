package com.tenis.apirest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST tenis")
@CrossOrigin(origins="*")
class TenisController {
	@Autowired
    private final TenisRepository repository;

    TenisController(TenisRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/Tenis")
    @ApiOperation(value="Retorna uma lista de tenis")
    List<Tenis> all() {
        return repository.findAll();
    }

    
    @PostMapping("/Tenis")
    @ApiOperation(value="Adiciona um novo tenis")
    Tenis newTenis(@RequestBody Tenis newTenis) {
        return repository.save(newTenis);
    }



    @GetMapping("/Tenis/{id}")
    @ApiOperation(value="Retorna um tenis por seu id")
    Tenis one(@PathVariable Long id) {

        return repository.findById(id)
        		.orElseThrow(() -> new TenisNotFoundException(id));
    }

    @PutMapping("/Tenis/{id}")
    @ApiOperation(value="Altera os dados do tenis")
    Tenis replaceTenis(@RequestBody Tenis newTenis, @PathVariable Long id) {

        return repository.findById(id)
                .map(Tenis -> {
                    Tenis.setNome(newTenis.getNome());
                    Tenis.setMarca(newTenis.getMarca());
                    Tenis.setTamanho(newTenis.getTamanho());
                    return repository.save(Tenis);
                })
                .orElseGet(() -> {
                    newTenis.setId(id);
                    return repository.save(newTenis);
                });
    }

    @DeleteMapping("/Tenis/{id}")
    void deleteTenis(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
