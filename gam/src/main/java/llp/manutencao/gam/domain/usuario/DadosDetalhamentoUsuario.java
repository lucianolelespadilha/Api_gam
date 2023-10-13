/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package llp.manutencao.gam.domain.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 *
 * @author llpad
 */
public record DadosDetalhamentoUsuario(@NotNull
        Long id,
        String nome,
        Departamento departamento,
        TipoUsuario tipo) {

    public DadosDetalhamentoUsuario(Usuario usuario) {

        this(
                usuario.getId(),
                usuario.getNome(),
                usuario.getDepartamento(),
                usuario.getTipo());
    }

}
