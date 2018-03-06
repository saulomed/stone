package br.com.stone.autorizador.infra.ejb;

import java.io.Serializable;
import java.util.List;
import br.com.stone.autorizador.infra.builder.AbstractBuilder;
import br.com.stone.autorizador.infra.dao.DAO;
import br.com.stone.autorizador.infra.dto.DTO;
import br.com.stone.autorizador.infra.entity.IEntity;

public abstract class EntityService<ENTITY extends IEntity, PRIMARY_KEY extends Serializable, D extends DTO> implements
   EntityServiceLocal<ENTITY, PRIMARY_KEY, D>
{

   protected abstract DAO<PRIMARY_KEY, ENTITY> getDAO();

   protected abstract AbstractBuilder<D, ENTITY> getBuilder();

   /**
    * Realiza a persistencia no banco de uma entidade a partir do seu DTO
    * 
    * @param dto da entidade a ser persistida
    * @return dto da entidade pesistirda
    */
   public D save(D dto)
   {
      D result = null;

      ENTITY entity = getBuilder().createEntity(dto);
      getDAO().save(entity);

      result = getBuilder().createDTO(entity);
      return result;
   }

   /**
    * Atualiza entidade persistida a partir do seu DTO
    * 
    * @param dto da entidade a ser atualizada
    * @return dto da entidade atualizada
    */
   public D update(D dto)
   {
      D result = null;

      ENTITY entity = getBuilder().createEntity(dto);
      getDAO().update(entity);

      result = getBuilder().createDTO(entity);
      return result;

   }

   /**
    * Remove entidade persistida a partir do seu DTO
    * 
    * @param dto da entidade a ser removida
    * @return dto da entidade removida
    */
   @SuppressWarnings("unchecked")
   public D delete(D dto)
   {
      D result = null;
      
      ENTITY entity = getBuilder().createEntity(dto);
      
      entity = getDAO().searchById((PRIMARY_KEY) entity.getKey());
      
      getDAO().delete(entity);

      return result;
   }

   /**
    * Busca todas as entidades persistidas
    * 
    * @return lista de entidades carregadas do banco
    */
   public List<ENTITY> findAll()
   {
      List<ENTITY> list = null;

      list = getDAO().findAll();

      return list;

   }

   @SuppressWarnings("unchecked")
   public ENTITY searchById(Serializable primaryKey)
   {
      ENTITY entity = getDAO().searchById((PRIMARY_KEY) primaryKey);
      return entity;
   }

}
