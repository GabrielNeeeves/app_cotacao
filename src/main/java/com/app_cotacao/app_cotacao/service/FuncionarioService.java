package com.app_cotacao.app_cotacao.service;

import com.app_cotacao.app_cotacao.model.Empresa;
import com.app_cotacao.app_cotacao.model.Escola;
import com.app_cotacao.app_cotacao.model.Funcionario;
import com.app_cotacao.app_cotacao.model.Usuario;
import com.app_cotacao.app_cotacao.repository.EmpresaRepository;
import com.app_cotacao.app_cotacao.repository.EscolaRepository;
import com.app_cotacao.app_cotacao.repository.FuncionarioRepository;
import com.app_cotacao.app_cotacao.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private EscolaRepository escolaRepository;

    // Criar Funcionario
    public Funcionario createFuncionario(Long usuarioId, Long empresaId, Long escolaId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com id: " + usuarioId));

        Empresa empresa = empresaRepository.findById(empresaId)
                .orElseThrow(() -> new EntityNotFoundException("Empresa não encontrada com id: " + empresaId));

        Escola escola = null;
        if (escolaId != null) {
            escola = escolaRepository.findById(escolaId)
                    .orElseThrow(() -> new EntityNotFoundException("Escola não encontrada com id: " + escolaId));
        }

        Funcionario funcionario = new Funcionario(usuario, empresa, escola);
        return funcionarioRepository.save(funcionario);
    }

    // Buscar por id
    public Funcionario getFuncionarioById(Long id) {
        return funcionarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado com id: " + id));
    }

    // Atualizar Funcionario
    public Funcionario updateFuncionario(Long id, Long usuarioId, Long empresaId, Long escolaId) {
        Funcionario funcionarioExistente = funcionarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado com id: " + id));

        if (usuarioId != null) {
            Usuario usuario = usuarioRepository.findById(usuarioId)
                    .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com id: " + usuarioId));
            funcionarioExistente.setUsuario(usuario);
        }

        if (empresaId != null) {
            Empresa empresa = empresaRepository.findById(empresaId)
                    .orElseThrow(() -> new EntityNotFoundException("Empresa não encontrada com id: " + empresaId));
            funcionarioExistente.setEmpresa(empresa);
        }

        if (escolaId != null) {
            Escola escola = escolaRepository.findById(escolaId)
                    .orElseThrow(() -> new EntityNotFoundException("Escola não encontrada com id: " + escolaId));
            funcionarioExistente.setEscola(escola);
        } else {
            funcionarioExistente.setEscola(null);
        }

        return funcionarioRepository.save(funcionarioExistente);
    }

    // Deletar Funcionario
    public Funcionario deleteFuncionario(Long id) {
        Funcionario funcionarioExistente = funcionarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado com id: " + id));

        funcionarioRepository.delete(funcionarioExistente);
        return funcionarioExistente;
    }
}