/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unitec.geoloca;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
/**
 *
 * @author SE
 */

@RestController
@RequestMapping("/api")
public class ControladorUsuario {
    
    
        @Autowired
        RepoUsuario repoUsuario;
        
        
    @GetMapping("/usuario")
    public  List <Usuario> obtenerUsuario(){
       
        
      
        
       return repoUsuario.findAll();
    
    }
    
    //Metodo POST para guardar un usuario
    @PostMapping("/usuario")
    public Estatus guardarUsuario(@RequestBody String json) throws Exception{
        
        //Mapeando el objeto llegando
        ObjectMapper maper = new ObjectMapper();
        Usuario u= maper.readValue(json,Usuario.class);
        repoUsuario.save(u);
        
        //Generamos el estatus
        Estatus e = new Estatus();
        e.setMensaje("Usuario ya se guardo");
        e.setSucess(true);
        return e;
    }
}
