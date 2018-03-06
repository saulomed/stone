/*
 * Criação : 28/01/2018
 */

package br.com.stone.autorizador.infra.builder;

import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import br.com.stone.autorizador.infra.dto.DTO;
import br.com.stone.autorizador.infra.entity.IEntity;
import lombok.AccessLevel;
import lombok.Getter;

/**
 * Classe abstrata para a criação de builder de entidades
 * 
 * @author Janeiro/2018: Saulo Santos
 *         <DD>
 */
public abstract class AbstractBuilder<D extends DTO, E extends IEntity>
{

   @Getter(AccessLevel.PROTECTED)
   private Class<? extends E> classeEntidadeConcreta;

   @PersistenceUnit(unitName = "defaultPersistenceUnit")
   private EntityManagerFactory emf;

   protected AbstractBuilder()
   {
   }

   @SuppressWarnings("unchecked")
   @PostConstruct
   private void init()
   {
      this.classeEntidadeConcreta = (Class<E>) concreteClass(getClass());
   }

   /**
    * (Ver Javadoc da super classe)
    * 
    * @see la.foton.netbanking.builder.Builder#createEntity()
    */
   @SuppressWarnings("unchecked")
   public <T extends E> T createEntity()
   {
      if (classeEntidadeConcreta != null)
      {
         try
         {
            return (T) classeEntidadeConcreta.newInstance();
         }
         catch (InstantiationException | IllegalAccessException e)
         {
            return null;
         }
      }
      return null;
   }

   /**
    * Método para criar uma lista de entidades a partir de uma lista de DTOs.
    * 
    * @param dtos Lista de DTOs.
    * @return Lista de entidades.
    * @throws BusinessException
    */
   public final List<E> createEntities(List<? extends D> listaDTOs) throws RuntimeException
   {
      List<E> entidades = new ArrayList<E>();
      for (D dto : listaDTOs)
      {
         entidades.add(createEntity(dto));
      }
      return entidades;
   }

   /**
    * Método para criar uma lista de DTOs a partir de uma lista de Entidades.
    * 
    * @param listaEntidades Lista de Entidades.
    * @return Lista de DTOs.
    */
   public final List<D> createDTOs(List<? extends E> listaEntidades)
   {
      List<D> dtos = new ArrayList<D>();
      for (E entidade : listaEntidades)
      {
         dtos.add(createDTO(entidade));
      }
      return dtos;
   }

   /**
    * (Ver Javadoc da super classe)
    * 
    * @throws BusinessException
    * @see la.foton.netbanking.builder.Builder#createEntity(D)
    */
   @SuppressWarnings("unchecked")
   public <T extends E> T createEntity(D dto) throws RuntimeException
   {
      if (classeEntidadeConcreta != null)
      {
         T entidade = (T) createProtectedEntity(dto);
         if (entidade != null)
         {
            fillEntity(dto, entidade);
            return entidade;
         }
      }

      return null;
   }

   /**
    * Cria a entidade com base no {@link DTO}
    * 
    * @param dto
    * @return
    * @throws BusinessException
    */
   protected <T extends E> T createProtectedEntity(D dto) throws RuntimeException
   {
      return createEntity();
   }

   @SuppressWarnings("unchecked")
   protected <DTO_ extends DTO, ENTITY extends IEntity, CONCRETE extends IEntity, BUILDER extends AbstractBuilder<DTO_, ENTITY>> Class<CONCRETE> concreteClass(
      Class<BUILDER> builderClass)
   {
      Class<CONCRETE> concreteClass = null;

      Class<BUILDER> genericBuilder = builderClass;
      while (genericBuilder.getGenericSuperclass() != null &&
         !(genericBuilder.getGenericSuperclass() instanceof ParameterizedType))
      {
         genericBuilder = (Class<BUILDER>) genericBuilder.getSuperclass();
      }

      Type[] genIfaces = ((ParameterizedType) genericBuilder.getGenericSuperclass()).getActualTypeArguments();
      if (genIfaces.length == 2)
      {
         Class<IEntity> entityClass = (Class<IEntity>) genIfaces[1];
         Metamodel metamodel = emf.getMetamodel();
         Set<EntityType<?>> allEntities = metamodel.getEntities();

         for (EntityType<?> e : allEntities)
         {
            Class<?> candidate = e.getJavaType();
            if (entityClass.isAssignableFrom(candidate) && !Modifier.isAbstract(candidate.getModifiers()))
            {
               concreteClass = (Class<CONCRETE>) candidate;
            }
         }
      }

      return concreteClass;
   }

   /**
    * Cria {@link Entidade} a partir do {@link DTO}
    * 
    * @throws BusinessException
    */
   public abstract void fillEntity(D dto, E entity) throws RuntimeException;

   /** Cria {@link DTO} a partir do {@link Entidade} */
   public abstract <T extends D> T createDTO(E entity);
}
