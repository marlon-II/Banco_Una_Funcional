/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.UnaBanco.BancoUnaFuncional.data.ClienteEntity;
import com.UnaBanco.BancoUnaFuncional.data.HistoricoEntity;
import com.UnaBanco.BancoUnaFuncional.data.LoginDTO;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.ClienteService;



/**
 *
 * @author Marlon
 */

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    
    @Autowired
    ClienteService clienteService;
    
    @PostMapping("/login")
    public ResponseEntity<ClienteEntity> login(@RequestBody LoginDTO LoginDTO){
    ClienteEntity cliente = clienteService.login(LoginDTO.getLogin(), LoginDTO.getSenha());
    return cliente != null ? ResponseEntity.ok(cliente) : ResponseEntity.status(401).build();
    }
    
    @PostMapping("/{id}/deposito")
    public ClienteEntity deposito(@PathVariable Integer id, @RequestBody Map<String, Float>body){
        return clienteService.depositar(id, body.get("valor"));
    }
    
    @PostMapping("/{id}/tranferencia")
    public ClienteEntity tranferencia(@PathVariable Integer id, @RequestBody Map<String, Float>body){
        return clienteService.tranferir(id, body.get("valor"));
    }
    
    @PostMapping("/{id}/historico")
    public List<HistoricoEntity> historico(@PathVariable Integer id){
        return clienteService.getHistorico(id);
    }
    
    
    
}
