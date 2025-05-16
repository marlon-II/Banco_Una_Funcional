/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.UnaBanco.BancoUnaFuncional.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Marlon
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class HistoricoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_historico;
    
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private ClienteEntity cliente;
    
    private String operacao;
    private Float saldo;
    
  
}
