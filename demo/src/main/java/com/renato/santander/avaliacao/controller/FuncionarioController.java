package com.renato.santander.avaliacao.controller;

import com.renato.santander.avaliacao.entity.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.renato.santander.avaliacao.service.FuncionarioService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public List<Funcionario> listarFuncionarios() {
        return funcionarioService.listarFuncionarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> buscarFuncionarioPorId(@PathVariable Long id) {
        Funcionario funcionario = funcionarioService.buscarFuncionarioPorId(id);
        return ResponseEntity.ok().body(funcionario);
    }

    @PostMapping
    public ResponseEntity<Funcionario> criarFuncionario(@Valid @RequestBody Funcionario funcionario) {
        Funcionario novoFuncionario = funcionarioService.criarFuncionario(funcionario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoFuncionario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> atualizarFuncionario(@PathVariable Long id, @Valid @RequestBody Funcionario funcionarioAtualizado) {
        Funcionario funcionario = funcionarioService.atualizarFuncionario(id, funcionarioAtualizado);
        return ResponseEntity.ok().body(funcionario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFuncionario(@PathVariable Long id) {
        funcionarioService.deletarFuncionario(id);
        return ResponseEntity.noContent().build();
    }
}
