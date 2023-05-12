/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package net.codejava.repositories;

import net.codejava.entity.CalculadoraPrecio;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ansan
 */
public interface CotizacionRepository extends JpaRepository<CalculadoraPrecio, Long>{
    
}
