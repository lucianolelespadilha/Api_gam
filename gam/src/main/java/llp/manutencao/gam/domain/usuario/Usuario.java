/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package llp.manutencao.gam.domain.usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.Table;

/**
 *
 * @author llpad
 */
@Table(name = "usuarios")
@Entity(name = "Usuarios")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private long id;
    
    private String nome;
    
    private Departamento departamento;
    
    private TipoUsuario tipo;
    
    public Usuario(DadosCadastroUsuarios dados){
        
        this.nome = dados.nome();
        this.departamento = dados.departamento();
        this.tipo =  dados.tipo();
        
        
    }
}

