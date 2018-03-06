/*
* Criação : 28 de jan de 2018
*/
package br.com.stone.autorizador.card.dao;

import br.com.stone.autorizador.card.entity.Card;
import br.com.stone.autorizador.infra.dao.AbstractDAOImpl;

/**
 * Implementação do DAO da entidade {@link Card}
 * 
 * @author janeiro/2018: Saulo Santos
 *         <DD>
 */
public class CardDAOImpl extends AbstractDAOImpl<String, Card> implements CardDAO
{

   public CardDAOImpl()
   {
      super(Card.class);

   }

}
