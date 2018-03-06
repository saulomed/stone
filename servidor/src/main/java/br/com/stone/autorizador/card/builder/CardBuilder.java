/*
* Criação : 28 de jan de 2018
*/
package br.com.stone.autorizador.card.builder;

import br.com.stone.autorizador.card.dto.CardDTO;
import br.com.stone.autorizador.card.entity.Card;
import br.com.stone.autorizador.infra.builder.AbstractBuilder;

/**
 * Classe responsável pela criação de classes de transporte da entidade {@link Card}
 * 
 * @author Janeiro/2018: Saulo Santos
 *         <DD>
 */
public class CardBuilder extends AbstractBuilder<CardDTO, Card>
{

   @Override
   public void fillEntity(CardDTO dto, Card entity) throws RuntimeException
   {
      entity.setHolderName(dto.getHolderName());
      entity.setNumber(dto.getNumber());
      entity.setExpirationDate(dto.getExpirationDate());
      entity.setCardBrand(dto.getCardBrand());
      entity.setPassword(dto.getPassword());
      entity.setType(dto.getType());
      entity.setHasPassword(dto.getHasPassword());
   }

   @SuppressWarnings("unchecked")
   @Override
   public CardDTO createDTO(Card entity)
   {
      CardDTO dto = new CardDTO();
      dto.setHolderName(entity.getHolderName());
      dto.setNumber(entity.getNumber());
      dto.setExpirationDate(entity.getExpirationDate());
      dto.setCardBrand(entity.getCardBrand());
      dto.setPassword(entity.getPassword());
      dto.setType(entity.getType());
      dto.setHasPassword(entity.getHasPassword());

      return dto;
   }

}
