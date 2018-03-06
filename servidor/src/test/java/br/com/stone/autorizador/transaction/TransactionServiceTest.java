/*
* Criação : 11 de fev de 2018
*/

package br.com.stone.autorizador.transaction;

import java.math.BigDecimal;
import java.text.ParseException;
import javax.naming.NamingException;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import br.com.stone.autorizador.card.dto.CardDTO;
import br.com.stone.autorizador.card.ejb.CardServiceLocal;
import br.com.stone.autorizador.infra.AbstractTest;
import br.com.stone.autorizador.merchant.dto.MerchantDTO;
import br.com.stone.autorizador.merchant.ejb.MerchantServiceLocal;
import br.com.stone.autorizador.transaction.dto.TransactionDTO;
import br.com.stone.autorizador.transaction.ejb.TransactionServiceLocal;
import br.com.stone.autorizador.transaction.entity.Transaction;
import br.com.stone.autorizador.transaction.enums.TransactionType;

/**
 * Classe de teste para validação de serviço da entidade {@link Transaction}
 * 
 * @author Fevereiro/2018: Saulo Santos
 *         <DD>
 */
public class TransactionServiceTest extends AbstractTest
{

   private TransactionServiceLocal transactionService;

   private CardServiceLocal cardService;

   private MerchantServiceLocal merchantService;

   private CardDTO card;
   private MerchantDTO merchant;

   @Before
   public void setup() throws NamingException, ParseException
   {
      getCardService();
      getTransactionService();
      getMerchantService();
      card = createCardDefault();
      getCardService().save(card);
      merchant = createMechantDefault();
      merchant = getMerchantService().save(merchant);

   }

   private MerchantServiceLocal getMerchantService() throws NamingException
   {
      if (merchantService == null)
      {
         merchantService = (MerchantServiceLocal) getContext().lookup("MerchantServiceLocal");
      }

      return merchantService;
   }

   /**
    * Teste de inserção de transação
    * 
    * @throws ParseException
    * @throws NamingException
    */
   @Test
   public void testInsertRemoveTransaction() throws ParseException, NamingException
   {
      System.out.println("-----------TESTE 1-----------------");

      TransactionDTO trans =
         criaTransacaoPadrao(card, BigDecimal.TEN, TransactionType.DEBIT, NumberUtils.INTEGER_ZERO, merchant);

      trans = getTransactionService().save(trans);

      Transaction tBase = getTransactionService().searchById(trans.getKey());
      Assert.assertNotNull(trans);
      Assert.assertEquals(tBase.getAmount().compareTo(BigDecimal.TEN), NumberUtils.INTEGER_ZERO.intValue());
      Assert.assertEquals(tBase.getCard().getNumber(), card.getNumber());
      getTransactionService().delete(trans);
      System.out.println("-----------FIM-----------------");

   }


   protected TransactionDTO criaTransacaoPadrao(CardDTO card, BigDecimal amount, TransactionType type, Integer parcel, MerchantDTO merch)
   {
      TransactionDTO dto = new TransactionDTO();
      dto.setAmount(amount);
      dto.setCard(card);
      dto.setType(type);
      dto.setNumber(parcel);
      dto.setMerchant(merch);

      return dto;
   }

   /**
    * Recupera o valor do atributo transactionService
    * 
    * @return o transactionService
    * @throws NamingException
    */
   public TransactionServiceLocal getTransactionService() throws NamingException
   {
      if (transactionService == null)
      {
         transactionService = (TransactionServiceLocal) getContext().lookup("TransactionServiceLocal");
      }

      return transactionService;
   }

   public CardServiceLocal getCardService() throws NamingException
   {
      if (cardService == null)
      {
         cardService = (CardServiceLocal) getContext().lookup("CardServiceLocal");
      }

      return cardService;
   }

}
