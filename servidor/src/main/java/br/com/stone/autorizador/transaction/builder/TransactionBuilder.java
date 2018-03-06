/*
* Criação : 11 de fev de 2018
*/
package br.com.stone.autorizador.transaction.builder;

import javax.inject.Inject;
import br.com.stone.autorizador.card.builder.CardBuilder;
import br.com.stone.autorizador.infra.builder.AbstractBuilder;
import br.com.stone.autorizador.merchant.builder.MerchantBuilder;
import br.com.stone.autorizador.transaction.dto.TransactionDTO;
import br.com.stone.autorizador.transaction.entity.Transaction;

/**
 * Classe responsável pela criação de classes de transporte da entidade {@link Transaction}
 * 
 * @author Fevereiro/2018: Saulo Santos
 *         <DD>
 */
public class TransactionBuilder extends AbstractBuilder<TransactionDTO, Transaction>
{

   @Inject
   private MerchantBuilder merchantBuilder;

   @Inject
   private CardBuilder cardBuilder;

   @Override
   public void fillEntity(TransactionDTO dto, Transaction entity) throws RuntimeException
   {
      entity.setUsn(dto.getUsn());
      entity.setAmount(dto.getAmount());
      entity.setType(dto.getType());
      entity.setCard(cardBuilder.createEntity(dto.getCard()));
      entity.setNumber(dto.getNumber());
      entity.setMerchant(merchantBuilder.createEntity(dto.getMerchant()));
      entity.setReferenceDate(dto.getReferenceDate());
   }

   @SuppressWarnings("unchecked")
   @Override
   public TransactionDTO createDTO(Transaction entity)
   {
      TransactionDTO dto = new TransactionDTO();
      dto.setUsn(entity.getUsn());
      dto.setAmount(entity.getAmount());
      dto.setType(entity.getType());
      dto.setCard(cardBuilder.createDTO(entity.getCard()));
      dto.setNumber(entity.getNumber());
      dto.setMerchant(merchantBuilder.createDTO(entity.getMerchant()));
      dto.setReferenceDate(entity.getReferenceDate());

      return dto;
   }

}
