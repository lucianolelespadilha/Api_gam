/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package llp.manutencao.gam.controller;

import llp.manutencao.gam.domain.usuario.DadosCadastroUsuarios;
import jakarta.validation.Valid;
import llp.manutencao.gam.domain.usuario.DadosDetalhamentoUsuario;
import llp.manutencao.gam.domain.usuario.TipoUsuario;
import llp.manutencao.gam.domain.usuario.Usuario;
import llp.manutencao.gam.domain.usuario.UsuarioRepository;
import org.springframework.data.repository.Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author llpad
 */
@RestController
@RequestMapping("users")
public class UserController {
    private UsuarioRepository repository;
    
    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroUsuarios dados, UriComponentsBuilder uriBuilder){
        
        var usuario = new Usuario(dados);
        
        repository.save(usuario);
        
        
        var uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        
        return ResponseEntity.created(uri).body(new DadosDetalhamentoUsuario(usuario));
    }
    
}
