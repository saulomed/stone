/*
* Criação : 18 de fev de 2018
*/
package br.com.stone.autorizador.transaction;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.text.ParseException;
import java.util.Date;
import javax.naming.NamingException;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Before;
import org.junit.Test;
import br.com.stone.autorizador.card.dto.CardDTO;
import br.com.stone.autorizador.card.ejb.CardServiceLocal;
import br.com.stone.autorizador.infra.AbstractWsTest;
import br.com.stone.autorizador.merchant.dto.MerchantDTO;
import br.com.stone.autorizador.merchant.ejb.MerchantServiceLocal;
import br.com.stone.autorizador.transaction.dto.TransactionDTO;
import br.com.stone.autorizador.transaction.ejb.TransactionServiceLocal;
import br.com.stone.autorizador.transaction.enums.TransactionType;
import br.com.stone.autorizador.webservice.AutorizadorServiceRemote;
import br.com.stone.autorizador.webservice.dto.ConsultaTransacoesResposta;
import br.com.stone.autorizador.webservice.dto.ConsultaTransacoesSolicitacao;
import junit.framework.Assert;

/**
 * Classe de teste para consulta de transações
 * 
 * @author Fevereiro/2018: Saulo Santos
 *         <DD>
 */
public class TransactionSearchTest extends AbstractWsTest
{

   private TransactionServiceLocal transactionService;

   private CardServiceLocal cardService;

   private MerchantServiceLocal merchantService;

   private AutorizadorServiceRemote autorizadorService;
   private CardDTO card;
   private MerchantDTO merchant;

   @Before
   public void setUp() throws NamingException, ParseException
   {

      getCardService();
      getTransactionService();
      getMerchantService();
      card = createCardDefault();
      getCardService().save(card);
      merchant = createMechantDefault();
      merchant = getMerchantService().save(merchant);
      TransactionDTO trans =
         criaTransacaoPadrao(card, BigDecimal.TEN, TransactionType.DEBIT, NumberUtils.INTEGER_ZERO, merchant);

      trans = getTransactionService().save(trans);

      trans =
         criaTransacaoPadrao(card, BigDecimal.ONE, TransactionType.CREDIT, NumberUtils.INTEGER_ZERO, merchant);
      trans = getTransactionService().save(trans);
   }

   protected TransactionDTO criaTransacaoPadrao(CardDTO card, BigDecimal amount, TransactionType type, Integer parcel, MerchantDTO merch)
   {
      TransactionDTO dto = new TransactionDTO();
      dto.setAmount(amount);
      dto.setCard(card);
      dto.setType(type);
      dto.setNumber(parcel);
      dto.setMerchant(merch);
      dto.setReferenceDate(new Date());

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

   private MerchantServiceLocal getMerchantService() throws NamingException
   {
      if (merchantService == null)
      {
         merchantService = (MerchantServiceLocal) getContext().lookup("MerchantServiceLocal");
      }

      return merchantService;
   }

   private AutorizadorServiceRemote getAutorizadorService() throws NamingException
   {
      if (autorizadorService == null)
      {
         autorizadorService = (AutorizadorServiceRemote) getContext().lookup("AutorizadorServiceRemote");
      }
      return autorizadorService;
   }

   @Test
   public void searchTransactionsTest() throws MalformedURLException, NamingException
   {
      ConsultaTransacoesSolicitacao solicitacao = new ConsultaTransacoesSolicitacao();
      ConsultaTransacoesResposta resposta = getAutorizadorService().consultaTransacoes(solicitacao);

      Assert.assertNotNull(resposta);
      Assert.assertNotNull(resposta.getTransactions());
   }

}
