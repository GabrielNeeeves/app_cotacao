package com.app_cotacao.app_cotacao.controller;

import com.app_cotacao.app_cotacao.model.Material_Empresa;
import com.app_cotacao.app_cotacao.model.fk_composta.MaterialEmpresaId;
import com.app_cotacao.app_cotacao.service.Material_EmpresaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/material-empresa")
public class Material_EmpresaController {

    @Autowired
    private Material_EmpresaService service;

    // Listar todos
    @GetMapping
    public List<Material_Empresa> getAll() {
        return service.getAll();
    }

    // Buscar por ID composto: espera 2 parâmetros no path
    @GetMapping("/empresa/{idEmpresa}/material/{idMaterial}")
    public ResponseEntity<Material_Empresa> getById(@PathVariable Long idEmpresa, @PathVariable Long idMaterial) {
        try {
            MaterialEmpresaId id = new MaterialEmpresaId(idEmpresa, idMaterial);
            Material_Empresa materialEmpresa = service.getById(id);
            return ResponseEntity.ok(materialEmpresa);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    // Criar ou atualizar
    @PostMapping
    public ResponseEntity<Material_Empresa> createOrUpdate(@RequestBody Material_Empresa materialEmpresa) {
        Material_Empresa salvo = service.saveOrUpdate(materialEmpresa);
        return ResponseEntity.ok(salvo);
    }

    // Deletar
    @DeleteMapping("/empresa/{idEmpresa}/material/{idMaterial}")
    public ResponseEntity<Void> delete(@PathVariable Long idEmpresa, @PathVariable Long idMaterial) {
        try {
            MaterialEmpresaId id = new MaterialEmpresaId(idEmpresa, idMaterial);
            service.delete(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
