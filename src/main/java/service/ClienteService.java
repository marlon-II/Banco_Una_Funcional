/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import com.UnaBanco.BancoUnaFuncional.data.ClienteEntity;
import com.UnaBanco.BancoUnaFuncional.data.ClienteRepository;
import com.UnaBanco.BancoUnaFuncional.data.HistoricoEntity;
import com.UnaBanco.BancoUnaFuncional.data.HistoricoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Marlon
 */

@Service

public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepo;

    @Autowired
    private HistoricoRepository historicoRepo;
    
    public ClienteEntity login(String login, String senha){
        return clienteRepo.findByLoginAndSenha(login, senha).orElse(null);
    }
    
    public ClienteEntity depositar(Integer id, Float valor){
        ClienteEntity cliente = clienteRepo.findById(id).orElse(null);
        cliente.setValor(cliente.getValor() + valor);
        clienteRepo.save(cliente);
        
       historicoRepo.save(new HistoricoEntity(null, cliente, "Depósito", cliente.getValor()));
       
       return cliente;
    }
    
    public ClienteEntity tranferir(Integer id, Float valor){
        ClienteEntity cliente = clienteRepo.findById(id).orElse(null);
        cliente.setValor(cliente.getValor() - valor);
        clienteRepo.save(cliente);
        
        historicoRepo.save(new HistoricoEntity(null, cliente, "Transferencia", cliente.getValor()));
        
        return cliente;
    }
    
    public List<HistoricoEntity> getHistorico (Integer id_cliente){
        return historicoRepo.findByClienteIdCliente(id_cliente);
    }
}
