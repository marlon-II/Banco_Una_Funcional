/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.UnaBanco.BancoUnaFuncional.data;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Marlon
 */
public interface HistoricoRepository extends JpaRepository<HistoricoEntity, Integer> {
    
    List<HistoricoEntity> findByClienteIdCliente(Integer idCliente);
}
