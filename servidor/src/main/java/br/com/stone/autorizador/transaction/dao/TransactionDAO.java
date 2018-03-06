/*
* Criação : 11 de fev de 2018
*/
package br.com.stone.autorizador.transaction.dao;

import java.util.Date;
import java.util.List;
import br.com.stone.autorizador.infra.dao.DAO;
import br.com.stone.autorizador.transaction.entity.Transaction;

/**
 * Interface dao para a entidade {@link Transaction}
 * 
 * @author Fevereiro/2018: Saulo Santos
 *         <DD>
 */
public interface TransactionDAO extends DAO<Long, Transaction>
{

   public List<Transaction> searchTransactions(Date referenceDate);

}
