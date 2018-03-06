/*
* Criação : 18 de fev de 2018
*/
package br.com.stone.autorizador.transaction;

import java.io.IOException;
import java.math.BigDecimal;
import javax.naming.NamingException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import br.com.stone.autorizador.card.dto.CardDTO;
import br.com.stone.autorizador.card.ejb.CardServiceLocal;
import br.com.stone.autorizador.comunicator.ComunicatorBankCardBrandServiceLocal;
import br.com.stone.autorizador.infra.AbstractTest;
import br.com.stone.autorizador.merchant.dto.MerchantDTO;
import br.com.stone.autorizador.merchant.ejb.MerchantServiceLocal;
import br.com.stone.autorizador.transaction.enums.TransactionType;
import br.com.stone.autorizador.webservice.AutorizadorServiceRemote;
import br.com.stone.autorizador.webservice.dto.TransactionDTORequest;
import br.com.stone.autorizador.webservice.dto.TransactionResponse;
import br.com.stone.autorizador.webservice.enums.ResponseCode;
import junit.framework.Assert;


/**
 * Teste para validacao de requisicao de transacao
 * 
 * @author Fevereiro/2018: Saulo Santos
 *         <DD>
 */
public class TransactionRequestTest extends AbstractTest
{

   private CardServiceLocal cardService;

   private MerchantServiceLocal merchantService;

   private AutorizadorServiceRemote autorizadorService;

   @Mock
   private ComunicatorBankCardBrandServiceLocal comunicatorService;

   private CardDTO card;
   private CardDTO cardSaldoInsuficiente;
   private CardDTO cardTransacaoNegada;
   private MerchantDTO merchant;

   @Before
   public void setUp() throws Exception
   {

      getCardService();
      getMerchantService();
      card = createCardDefault();
      getCardService().save(card);
      cardSaldoInsuficiente = createCardNoBalance();
      getCardService().save(cardSaldoInsuficiente);
      cardTransacaoNegada = createCardTransactionFault();
      getCardService().save(cardTransacaoNegada);
      merchant = createMechantDefault();
      merchant = getMerchantService().save(merchant);
   }

   protected TransactionResponse createDefaultResponse()
   {
      TransactionResponse response = new TransactionResponse();
      response.setCardNumber(card.getNumber());
      response.setMerchantId(merchant.getId());
      response.setAmount(BigDecimal.TEN);
      response.setPassword("123987");
      response.setTransactionType(TransactionType.DEBIT);
      response.setParcelNumber(1);
      response.setReponseCode(ResponseCode.APROVADO.ordinal());

      return response;
   }

   protected TransactionResponse createfaultResponse()
   {
      TransactionResponse response = new TransactionResponse();
      response.setCardNumber(card.getNumber());
      response.setMerchantId(merchant.getId());
      response.setAmount(BigDecimal.TEN);
      response.setPassword("123987");
      response.setTransactionType(TransactionType.DEBIT);
      response.setParcelNumber(1);
      response.setReponseCode(ResponseCode.TRANSACAO_NEGADA.ordinal());

      return response;
   }

   @Test
   public void successTest() throws NamingException, IOException
   {
      TransactionDTORequest request = createDefaultRequest();
      TransactionResponse response = getAutorizadorService().transactionRequest(request);

      Assert.assertNotNull(response);
      Assert.assertEquals(response.getReponseCode(), ResponseCode.APROVADO.ordinal());


   }

   @Test
   public void faultTest() throws NamingException, IOException
   {
      TransactionDTORequest request = createFaultRequest();
      TransactionResponse response = getAutorizadorService().transactionRequest(request);

      Assert.assertNotNull(response);
      Assert.assertEquals(response.getReponseCode(), ResponseCode.TRANSACAO_NEGADA.ordinal());

   }

   @Test
   public void noBalanceTest() throws NamingException, IOException
   {
      TransactionDTORequest request = createNoBalanceRequest();
      TransactionResponse response = getAutorizadorService().transactionRequest(request);

      Assert.assertNotNull(response);
      Assert.assertEquals(response.getReponseCode(), ResponseCode.SALDO_INSIFICIENTE.ordinal());

   }

   /**
    * Cria uma requisicao padrao
    * 
    * @return
    */
   protected TransactionDTORequest createDefaultRequest()
   {
      TransactionDTORequest request = new TransactionDTORequest();
      request.setCardNumber(card.getNumber());
      request.setMerchantId(merchant.getId());
      request.setAmount(BigDecimal.TEN);
      request.setPassword("123987");
      request.setTransactionType(TransactionType.DEBIT);
      request.setParcelNumber(1);
      
      return request;
   }

   /**
    * Cria uma requisicao transacao negada
    * 
    * @return
    */
   protected TransactionDTORequest createFaultRequest()
   {
      TransactionDTORequest request = new TransactionDTORequest();
      request.setCardNumber(cardTransacaoNegada.getNumber());
      request.setMerchantId(merchant.getId());
      request.setAmount(BigDecimal.TEN);
      request.setPassword("123987");
      request.setTransactionType(TransactionType.DEBIT);
      request.setParcelNumber(1);

      return request;
   }

   /**
    * Cria uma requisicao transacao negada por saldo insuficiente
    * 
    * @return
    */
   protected TransactionDTORequest createNoBalanceRequest()
   {
      TransactionDTORequest request = new TransactionDTORequest();
      request.setCardNumber(cardSaldoInsuficiente.getNumber());
      request.setMerchantId(merchant.getId());
      request.setAmount(BigDecimal.TEN);
      request.setPassword("123987");
      request.setTransactionType(TransactionType.DEBIT);
      request.setParcelNumber(1);

      return request;
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

}
