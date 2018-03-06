/*
* Criação : 14 de fev de 2018
*/

package br.com.stone.autorizador.webservice.ejb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import br.com.stone.autorizador.transaction.ejb.TransactionServiceLocal;
import br.com.stone.autorizador.transaction.entity.Transaction;
import br.com.stone.autorizador.webservice.ConvertUtil;
import br.com.stone.autorizador.webservice.dto.ConsultaTransacoesResposta;
import br.com.stone.autorizador.webservice.dto.ConsultaTransacoesSolicitacao;
import br.com.stone.autorizador.webservice.dto.TransacationViewDTO;

/**
 * EJB resposavel por realizar a consulta de transacoes
 * 
 * @author Fevereiro/2018: Saulo Santos
 *         <DD>
 */
@Stateless
@Local(ConsultaTransacoesServiceLocal.class)
public class ConsultaTransacoesService implements ConsultaTransacoesServiceLocal
{

   @EJB
   private TransactionServiceLocal transactionService;

   public ConsultaTransacoesResposta execute(ConsultaTransacoesSolicitacao consulta)
   {

      Date refereceDate =
         (consulta.getReferenceDate() != null) ? ConvertUtil.convertGregorianCalendarToDate(consulta.getReferenceDate()) : null;
      List<Transaction> transactionList = transactionService.searchTransaction(refereceDate);

      return convertResponse(transactionList);

   }

   public ConsultaTransacoesResposta convertResponse(List<Transaction> transactions)
   {

      ConsultaTransacoesResposta response = new ConsultaTransacoesResposta();

      if (transactions != null && !transactions.isEmpty())
      {
         List<TransacationViewDTO> transactionViews = new ArrayList<>();
         TransacationViewDTO view = null;

         for (Transaction transaction : transactions)
         {
            view = new TransacationViewDTO();
            view.setUsn(transaction.getUsn());
            view.setType(transaction.getType());
            view.setCard(transaction.getCard().getNumber());
            view.setHolderNameCard(transaction.getCard().getHolderName());
            view.setNumber(transaction.getNumber());
            view.setMerchant(transaction.getMerchant().getName());
            view.setReferenceDate(ConvertUtil.convertToXMLGregorianCalendar(transaction.getReferenceDate()));
            view.setAmount(transaction.getAmount());
            transactionViews.add(view);
         }
         response.setTransactions(transactionViews);

      }

      return response;

   }
}
