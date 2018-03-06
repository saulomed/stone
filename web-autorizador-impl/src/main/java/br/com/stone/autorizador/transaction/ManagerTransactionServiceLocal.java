/*
* Criação : 4 de mar de 2018
*/
package br.com.stone.autorizador.transaction;

import java.net.MalformedURLException;
import java.util.List;
import javax.ejb.Local;
import br.com.stone.autorizador.transaction.wsclient.TransacationViewDTO;

/**
 * Interface Local para a servico de gerenciamento de transações
 * 
 * @author Março/2018: Saulo Santos
 *         <DD>
 */
@Local
public interface ManagerTransactionServiceLocal
{

   List<TransacationViewDTO> findAll() throws MalformedURLException;

   List<TransacationViewDTO> getTransactions() throws MalformedURLException;

   void setTransactions(List<TransacationViewDTO> transactions);

}
