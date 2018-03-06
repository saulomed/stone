/*
* Criação : 11 de fev de 2018
*/
package br.com.stone.autorizador.transaction.ejb;

import java.util.Date;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import br.com.stone.autorizador.infra.builder.AbstractBuilder;
import br.com.stone.autorizador.infra.dao.DAO;
import br.com.stone.autorizador.infra.ejb.EntityService;
import br.com.stone.autorizador.transaction.builder.TransactionBuilder;
import br.com.stone.autorizador.transaction.dao.TransactionDAO;
import br.com.stone.autorizador.transaction.dto.TransactionDTO;
import br.com.stone.autorizador.transaction.entity.Transaction;

/**
 * Implementação do Service EJB para manipulação da entidate {@link Transaction}
 * 
 * @author Fevereiro/2018: Saulo Santos
 *         <DD>
 */
@Stateless
@Local(TransactionServiceLocal.class)
public class TransactionService extends EntityService<Transaction, Long, TransactionDTO> implements TransactionServiceLocal
{

   @Inject
   private TransactionDAO dao;

   @Inject
   private TransactionBuilder builder;

   @Override
   protected DAO<Long, Transaction> getDAO()
   {
      return dao;
   }

   @Override
   protected AbstractBuilder<TransactionDTO, Transaction> getBuilder()
   {
      return builder;
   }

   @Override
   public List<Transaction> searchTransaction(Date referenceDate)
   {
      return dao.searchTransactions(referenceDate);
   }

}
