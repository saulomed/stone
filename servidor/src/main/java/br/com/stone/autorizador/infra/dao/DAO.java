/*
* Criação : 28 de jan de 2018
*/
package br.com.stone.autorizador.infra.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;

/**
 * Inteface padrão para persistencia de entidades JPA
 * 
 * @author Junho/2013: Saulo Santos
 */
public interface DAO<PRIMARY_KEY extends Serializable, ENTITY>
{

   /**
    * Realiza persistencia da entidade na base de dados
    * 
    * @param entidade
    */
   public void save(ENTITY entity);

   /**
    * Atualiza entidade no banco de dados
    * 
    * @param entidade
    */
   public void update(ENTITY entity);

   /**
    * Remove entidade do banco de dados
    * 
    * @param entidade
    */
   public void delete(ENTITY entity);

   /**
    * Busca todas as entidades peristidas
    * 
    * @return
    */
   public List<ENTITY> findAll();

   /**
    * Busca entidade pela chave primária
    * 
    * @param chavePrimaria
    * @return
    */
   public ENTITY searchById(PRIMARY_KEY primaryKey);

   public void refresh(ENTITY entity);

   public void flush();

   public void setEntityManager(EntityManager entityManager);

   public EntityManager getEntityManager();

}
