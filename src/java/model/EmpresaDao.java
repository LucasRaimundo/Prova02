/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author LucasRaimundo
 */
public class EmpresaDao {
    private EntityManager manager;
    private void conectar(){
        manager = Persistence.createEntityManagerFactory("Prova23-11PU").createEntityManager();
    }
    
    public int salvarFuncionario(Funcionario funcionario){
        conectar();
        try{
            manager.getTransaction().begin();
            manager.persist(funcionario); // insere no banco
            manager.getTransaction().commit();
            return 1;
        } catch (Exception erro){
            return 0;
        }
    }
    
    public List<Funcionario> listarFuncionarios(){
        conectar();
        return manager.createNamedQuery("Funcionario.findAll", Funcionario.class).getResultList();
    }
}
