/*
* Criação : 28 de jan de 2018
*/
package br.com.stone.autorizador.infra.ejb;

import java.io.Serializable;
import java.util.List;
import br.com.stone.autorizador.infra.entity.IEntity;

/**
 * Interface padrão local para os services do sistema
 * 
 * @author Janeiro/2018: Saulo Santos
 *         <DD>
 */
public interface EntityServiceLocal<ENTITY extends IEntity, PRIMARY_KEY extends Serializable, DTO extends Serializable>
{

   DTO save(DTO dto);

   DTO update(DTO dto);

   DTO delete(DTO dto);

   List<ENTITY> findAll();

   ENTITY searchById(Serializable primaryKey);

}
