/*
* Criação : 18 de fev de 2018
*/

package br.com.stone.autorizador.webservice.ejb;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.apache.commons.lang3.time.DateUtils;
import br.com.stone.autorizador.card.builder.CardBuilder;
import br.com.stone.autorizador.card.ejb.CardServiceLocal;
import br.com.stone.autorizador.card.entity.Card;
import br.com.stone.autorizador.comunicator.ComunicatorBankCardBrandServiceLocal;
import br.com.stone.autorizador.exception.CardNotFoundException;
import br.com.stone.autorizador.exception.PasswordInvalidException;
import br.com.stone.autorizador.exception.PasswordLengthException;
import br.com.stone.autorizador.exception.TransactionInvalidAmountException;
import br.com.stone.autorizador.merchant.builder.MerchantBuilder;
import br.com.stone.autorizador.merchant.ejb.MerchantServiceLocal;
import br.com.stone.autorizador.transaction.dto.TransactionDTO;
import br.com.stone.autorizador.transaction.ejb.TransactionServiceLocal;
import br.com.stone.autorizador.webservice.dto.TransactionDTORequest;
import br.com.stone.autorizador.webservice.dto.TransactionResponse;
import br.com.stone.autorizador.webservice.enums.ResponseCode;

/**
 * EJB responsavel pela autorizacao de uma trasacao
 * 
 * @author Fevereiro/2018: Saulo Santos
 *         <DD>
 */
@Stateless
public class AutorizerTransactionService implements AutorizerTransactionServiceLocal
{

   private static final int MAX_LENGTH_PASS = 6;

   private static final int MIN_LENGTH_PASS = 4;

   private static BigDecimal MIN_VALUE_TRANSACTION = new BigDecimal("0.10");

   @EJB
   private CardServiceLocal cardService;

   @EJB
   private TransactionServiceLocal transactionService;

   @EJB
   private ComunicatorBankCardBrandServiceLocal comunicatorService;

   @EJB
   private MerchantServiceLocal merchantService;

   @Inject
   private CardBuilder cardBuilder;

   @Inject
   private MerchantBuilder merchantBuilder;

   private Card card;

   public TransactionResponse execute(TransactionDTORequest request) throws IOException
   {
      TransactionResponse response = null;

      try
      {
         validate(request);
         response = validateBankCardBrand(request);
         transactionService.save(convertRequestToDTO(request));
      }
      catch (TransactionInvalidAmountException e)
      {
         response = createResponse(request, ResponseCode.VALOR_INVALIDO);
      }
      catch (CardNotFoundException e)
      {
         response = createResponse(request, ResponseCode.CARTAO_INVALIDO);
      }
      catch (PasswordLengthException e)
      {
         response = createResponse(request, ResponseCode.TAMANHO_SENHA);
      }
      catch (PasswordInvalidException e)
      {
         response = createResponse(request, ResponseCode.SENHA_INVALIDA);
      }

      return response;

   }

   private TransactionDTO convertRequestToDTO(TransactionDTORequest request)
   {
      TransactionDTO dto = new TransactionDTO();
      dto.setAmount(request.getAmount());
      dto.setType(request.getTransactionType());
      dto.setCard(cardBuilder.createDTO(cardService.searchById(request.getCardNumber())));
      dto.setNumber(request.getParcelNumber());
      dto.setMerchant(merchantBuilder.createDTO(merchantService.searchById(request.getMerchantId())));
      dto.setReferenceDate(DateUtils.truncate(new Date(), Calendar.DATE));
      return dto;

   }

   /**
    * Metodo para realizar a comuncacao com o banco ou bandeira do cartao para validar a transacao
    * 
    * @param request
    * @return
    * @throws IOException
    */
   protected TransactionResponse validateBankCardBrand(TransactionDTORequest request) throws IOException
   {
      return comunicatorService.validate(request);
   }

   /**
    * Valida os dados da trasacao
    * 
    * @param request
    * @throws CardNotFoundException
    * @throws TransactionInvalidAmountException
    * @throws PasswordInvalidException
    * @throws PasswordLengthException
    */
   protected void validate(TransactionDTORequest request)
      throws CardNotFoundException, TransactionInvalidAmountException, PasswordLengthException, PasswordInvalidException
   {
      validateValue(request.getAmount());
      validateCard(request.getCardNumber());
      validatePassword(request.getPassword());

   }

   /**
    * Valida senha caso necessario
    * 
    * @param string
    * @throws PasswordLengthException
    * @throws PasswordInvalidException
    */
   protected void validatePassword(String pass) throws PasswordLengthException, PasswordInvalidException
   {
      // verifica que o cartao tem senha
      if (card.getHasPassword())
      {
         if (isBlank(pass) || (pass.length() <= MIN_LENGTH_PASS && pass.length() >= MAX_LENGTH_PASS))
         {
            String message = "INVALID PASS LENGTH";
            PasswordLengthException ex = new PasswordLengthException(message);
            Logger.getLogger(AutorizerTransactionService.class.getName()).log(Level.SEVERE, message, ex);
            throw ex;
         }
         else if (!card.validatePass(pass))
         {
            String message = "INVALID PASS";
            PasswordInvalidException ex = new PasswordInvalidException(message);
            Logger.getLogger(AutorizerTransactionService.class.getName()).log(Level.SEVERE, message, ex);
            throw ex;
         }
      }
   }

   /**
    * Verificar se a string não está vazia
    * 
    * @param pass
    * @return
    */
   protected boolean isBlank(String pass)
   {
      boolean result = false;

      if (pass == null || pass.trim().length() <= 0)
      {
         result = true;
      }

      return result;
   }

   /**
    * Valida valor minino da transacao
    * 
    * @param amount
    * @throws TransactionInvalidAmountException
    */
   protected void validateValue(BigDecimal amount) throws TransactionInvalidAmountException
   {
      if (MIN_VALUE_TRANSACTION.compareTo(amount) > 1)
      {
         String message = "TRANSACTION VALUE: " + amount + " MIN_VALUE:" + MIN_VALUE_TRANSACTION;
         TransactionInvalidAmountException ex = new TransactionInvalidAmountException(message);
         Logger.getLogger(AutorizerTransactionService.class.getName()).log(Level.SEVERE, message, ex);
         throw ex;
      }
   }

   /**
    * Cria resposta com o codido de resposta passado por parametro
    * 
    * @param request
    * @param valorInvalido
    */
   protected TransactionResponse createResponse(TransactionDTORequest request, ResponseCode responseCode)
   {
      TransactionResponse response = new TransactionResponse();
      response.setCardNumber(request.getCardNumber());
      response.setMerchantId(request.getMerchantId());
      response.setAmount(request.getAmount());
      response.setPassword(request.getPassword());
      response.setTransactionType(request.getTransactionType());
      response.setParcelNumber(request.getParcelNumber());
      response.setReponseCode(responseCode.ordinal());
      return response;
   }

   private void validateCard(String cardNumber) throws CardNotFoundException
   {

      card = cardService.searchById(cardNumber);

      if (card == null)
      {
         String message = "CARD NUMBER: " + cardNumber;
         CardNotFoundException ex = new CardNotFoundException(message);
         Logger.getLogger(AutorizerTransactionService.class.getName()).log(Level.SEVERE, message, ex);
         throw ex;
      }
   }

}
