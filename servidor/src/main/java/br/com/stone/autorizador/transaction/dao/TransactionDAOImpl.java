/*
* Criação : 11 de fev de 2018
*/
package br.com.stone.autorizador.transaction.dao;

import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import br.com.stone.autorizador.infra.dao.AbstractDAOImpl;
import br.com.stone.autorizador.transaction.entity.Transaction;

/**
 * Implementação do DAO da entidade {@link Transaction}
 * 
 * @author Fevereiro/2018: Saulo Santos
 *         <DD>
 */
public class TransactionDAOImpl extends AbstractDAOImpl<Long, Transaction> implements TransactionDAO
{

   private final String BUSCA_TRANSACOES_SQL = "SELECT TRN FROM Transaction TRN";
   private final String FILTRO_DATA_SQL = " WHERE TRN.referenceDate = :dataReferencia";

   public TransactionDAOImpl()
   {
      super(Transaction.class);

   }

   @SuppressWarnings("unchecked")
   @Override
   public List<Transaction> searchTransactions(Date referenceDate)
   {

      List<Transaction> transactions = null;
      String queryString = (referenceDate != null) ? BUSCA_TRANSACOES_SQL + FILTRO_DATA_SQL : BUSCA_TRANSACOES_SQL;

      Query query = getEntityManager().createQuery(queryString);

      if (referenceDate != null)
      {
         query.setParameter("dataReferencia", referenceDate);
      }

      transactions = query.getResultList();

      return transactions;
   }

}
