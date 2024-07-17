package com.renato.santander.avaliacao.service;

import com.renato.santander.avaliacao.entity.Funcionario;
import com.renato.santander.avaliacao.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Funcionario> listarFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public Funcionario buscarFuncionarioPorId(Long id) {
        Optional<Funcionario> optionalFuncionario = funcionarioRepository.findById(id);
        return optionalFuncionario.orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));
    }

    public Funcionario criarFuncionario(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public Funcionario atualizarFuncionario(Long id, Funcionario funcionarioAtualizado) {
        Funcionario funcionario = buscarFuncionarioPorId(id);
        funcionario.setNome(funcionarioAtualizado.getNome());
        funcionario.setCargo(funcionarioAtualizado.getCargo());
        funcionario.setSalario(funcionarioAtualizado.getSalario());
        funcionario.setTelefone(funcionarioAtualizado.getTelefone());
        funcionario.setEndereco(funcionarioAtualizado.getEndereco());

        return funcionarioRepository.save(funcionario);
    }

    public void deletarFuncionario(Long id) {
        Funcionario funcionario = buscarFuncionarioPorId(id);
        funcionarioRepository.delete(funcionario);
    }


}

