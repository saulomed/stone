/*
* Criação : 3 de mar de 2018
*/
package br.com.stone.autorizador.transaction;

import java.net.MalformedURLException;
import javax.ejb.Local;
import br.com.stone.autorizador.transaction.wsclient.IOException_Exception;

/**
 * Interface Local para a servico de criação de transação
 * 
 * @author Março/2018: Saulo Santos
 *         <DD>
 */
@Local
public interface CreateTransactionServiceLocal
{

   TransactionView getTransaction();

   void setTransaction(TransactionView transaction);

   void create() throws MalformedURLException, IOException_Exception;

}
