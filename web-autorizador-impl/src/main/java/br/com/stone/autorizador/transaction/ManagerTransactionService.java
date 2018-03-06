/*
* Criação : 4 de mar de 2018
*/
package br.com.stone.autorizador.transaction;

import java.net.MalformedURLException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import br.com.stone.autorizador.Comunicator;
import br.com.stone.autorizador.transaction.wsclient.ConsultaTransacoesResposta;
import br.com.stone.autorizador.transaction.wsclient.ConsultaTransacoesSolicitacao;
import br.com.stone.autorizador.transaction.wsclient.TransacationViewDTO;

/**
 * Service responsável pela tela de gerenciamento de transações
 * 
 * @author Março/2018: Saulo Santos
 *         <DD>
 */
@Stateless
@Local(ManagerTransactionServiceLocal.class)
@Named(value = "ManagerTransactionService")
public class ManagerTransactionService implements ManagerTransactionServiceLocal
{

   @Inject
   private Comunicator comunicator;
   private List<TransacationViewDTO> transactions;

   @PostConstruct
   public void init() throws MalformedURLException
   {
      setTransactions(findAll());
   }

   public List<TransacationViewDTO> findAll() throws MalformedURLException
   {
      ConsultaTransacoesSolicitacao param = new ConsultaTransacoesSolicitacao(); 
      ConsultaTransacoesResposta response = comunicator.getPort().consultaTransacoes(param);
      return response.getTransactions();
   }

   /**
    * Recupera o valor do atributo transactions
    * 
    * @return o transactions
    * @throws MalformedURLException
    */
   public List<TransacationViewDTO> getTransactions() throws MalformedURLException
   {
      setTransactions(findAll());
      return transactions;
   }

   /**
   * Atribui o novo valor de transactions
   * @param transactions transactions que será atribuído
   */
   public void setTransactions(List<TransacationViewDTO> transactions)
   {
      this.transactions = transactions;
   }

}
