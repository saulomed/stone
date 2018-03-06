/*
* Criação : 28 de jan de 2018
*/
package br.com.stone.autorizador.card.ejb;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import br.com.stone.autorizador.card.builder.CardBuilder;
import br.com.stone.autorizador.card.dao.CardDAO;
import br.com.stone.autorizador.card.dto.CardDTO;
import br.com.stone.autorizador.card.entity.Card;
import br.com.stone.autorizador.infra.builder.AbstractBuilder;
import br.com.stone.autorizador.infra.dao.DAO;
import br.com.stone.autorizador.infra.ejb.EntityService;

/**
 * Implementação do Service EJB para manipulação da entidate {@link Card}
 * 
 * @author Janeiro/2018: Saulo Santos
 *         <DD>
 */
@Stateless
@Local(CardServiceLocal.class)
public class CardService extends EntityService<Card, String, CardDTO> implements CardServiceLocal
{

   @Inject
   private CardDAO dao;

   @Inject
   private CardBuilder builder;

   @Override
   protected DAO<String, Card> getDAO()
   {
      return dao;
   }

   @Override
   protected AbstractBuilder<CardDTO, Card> getBuilder()
   {
      return builder;
   }

}
