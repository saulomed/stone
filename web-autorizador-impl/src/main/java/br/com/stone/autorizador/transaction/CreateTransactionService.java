/*
* Criação : 3 de mar de 2018
*/
package br.com.stone.autorizador.transaction;

import java.net.MalformedURLException;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import br.com.stone.autorizador.Comunicator;
import br.com.stone.autorizador.transaction.wsclient.IOException_Exception;
import br.com.stone.autorizador.transaction.wsclient.TransactionDTORequest;
import br.com.stone.autorizador.transaction.wsclient.TransactionResponse;
import br.com.stone.autorizador.transaction.wsclient.TransactionType;

/**
 * Service responsável pela tela de criação de transações
 * 
 * @author Março/2018: Saulo Santos
 *         <DD>
 */
@Stateless
@Local(CreateTransactionServiceLocal.class)
@Named(value = "CreateTransactionService")
public class CreateTransactionService implements CreateTransactionServiceLocal
{

   @Inject
   private Comunicator comunicator;

   private TransactionView transaction = new TransactionView();

   public void create() throws MalformedURLException, IOException_Exception
   {
      System.out.println(transaction.getCardNumber());
      TransactionResponse reponse = comunicator.getPort().transactionRequest(convertDTO(transaction));
   }

   private TransactionDTORequest convertDTO(TransactionView view)
   {
      TransactionDTORequest dto = new TransactionDTORequest();
      dto.setCardNumber(view.getCardNumber());
      dto.setMerchantId(view.getMerchantId());
      dto.setAmount(view.getAmount());
      dto.setPassword(view.getPassword());
      dto.setTransactionType(TransactionType.values()[view.getTransactionType()]);
      dto.setParcelNumber(view.getParcelNumber());

      return dto;

   }

   /**
    * Recupera o valor do atributo transaction
    * 
    * @return o transaction
    */
   public TransactionView getTransaction()
   {
      return transaction;
   }

   /**
    * Atribui o novo valor de transaction
    * 
    * @param transaction transaction que será atribuído
    */
   public void setTransaction(TransactionView transaction)
   {
      this.transaction = transaction;
   }

}
