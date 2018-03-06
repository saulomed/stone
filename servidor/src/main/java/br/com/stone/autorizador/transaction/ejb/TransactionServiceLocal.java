/*
* Criação : 11 de fev de 2018
*/
package br.com.stone.autorizador.transaction.ejb;

import java.util.Date;
import java.util.List;
import javax.ejb.Local;
import br.com.stone.autorizador.infra.ejb.EntityServiceLocal;
import br.com.stone.autorizador.transaction.dto.TransactionDTO;
import br.com.stone.autorizador.transaction.entity.Transaction;

/**
 * Entidade Local para o service da entidade {@link Transaction}
 * 
 * @author Fevereiro/2018: Saulo Santos
 *         <DD>
 */
@Local
public interface TransactionServiceLocal extends EntityServiceLocal<Transaction, Long, TransactionDTO>
{

   public List<Transaction> searchTransaction(Date referenceDate);

}
