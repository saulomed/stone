/*
* Criação : 28 de jan de 2018
*/
package br.com.stone.autorizador.infra.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Implementacao padrão para persistencia de entidades JPA
 * 
 * @author Junho/2013: Saulo Santos
 */
public abstract class AbstractDAOImpl<PRIMARY_KEY extends Serializable, ENTITY> implements DAO<PRIMARY_KEY, ENTITY>
{

   @PersistenceContext(unitName = "defaultPersistenceUnit")
   private EntityManager entityManager;

   private Class<ENTITY> entidadePadrao;

   public AbstractDAOImpl(Class<ENTITY> classe)
   {
      this.entidadePadrao = classe;
   }

   /**
    * (Ver Javadoc da super classe)
    * 
    * @see br.com.stone.autorizador.infra.dao.DAO#save(java.lang.Object)
    */
   @Override
   public void save(ENTITY entidade)
   {
      getEntityManager().persist(entidade);
   }

   /**
    * (Ver Javadoc da super classe)
    * 
    * @see br.com.stone.autorizador.infra.dao.DAO#update(java.lang.Object)
    */
   @Override
   public void update(ENTITY entidade)
   {
      getEntityManager().merge(entidade);
   }

   /**
    * (Ver Javadoc da super classe)
    * 
    * @see br.com.stone.autorizador.infra.dao.DAO#delete(java.lang.Object)
    */
   @Override
   public void delete(ENTITY entidade)
   {
      getEntityManager().remove(entidade);
   }

   /**
    * (Ver Javadoc da super classe)
    * 
    * @see br.com.stone.autorizador.infra.dao.DAO#findAll()
    */
   @Override
   public List<ENTITY> findAll()
   {
      Query query = getEntityManager().createQuery("SELECT e FROM " + entidadePadrao.getName() + " as e");

      @SuppressWarnings("unchecked")
      List<ENTITY> lista = Collections.checkedList(query.getResultList(), entidadePadrao.getClass());
      return lista == null ? new ArrayList<ENTITY>() : lista;
   }

   /**
    * (Ver Javadoc da super classe)
    * 
    * @see br.com.stone.autorizador.infra.dao.DAO#searchById(java.io.Serializable)
    */
   @Override
   public ENTITY searchById(PRIMARY_KEY primaryKey)
   {
      return (ENTITY) getEntityManager().find(entidadePadrao, primaryKey);
   }

   /**
    * (Ver Javadoc da super classe)
    * 
    * @see br.com.stone.autorizador.infra.dao.DAO#refresh(java.lang.Object)
    */
   @Override
   public void refresh(ENTITY entidade)
   {
      getEntityManager().refresh(entidade);
   }

   /**
    * (Ver Javadoc da super classe)
    * 
    * @see br.com.stone.autorizador.infra.dao.DAO#flush()
    */
   @Override
   public void flush()
   {
      getEntityManager().flush();
   }

   /**
    * (Ver Javadoc da super classe)
    * 
    * @see br.com.stone.autorizador.infra.dao.DAO#setEntityManager(javax.persistence.EntityManager)
    */
   @Override
   public void setEntityManager(EntityManager entityManager)
   {
      this.entityManager = entityManager;
   }

   /**
    * (Ver Javadoc da super classe)
    * 
    * @see br.com.stone.autorizador.infra.dao.DAO#getEntityManager()
    */
   @Override
   public EntityManager getEntityManager()
   {
      return this.entityManager;
   }

}
