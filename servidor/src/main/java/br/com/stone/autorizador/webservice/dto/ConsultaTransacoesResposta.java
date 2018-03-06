/*
* Criação : 14 de fev de 2018
*/
package br.com.stone.autorizador.webservice.dto;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * Objeto de resposta para a consulta de transações
 * 
 * @author Fevereiro/2018: Saulo Santos
 *         <DD>
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsultaTransacoesResposta", propOrder = {
   "transactions"
})
public class ConsultaTransacoesResposta implements Serializable
{

   private static final long serialVersionUID = -4908016563399968174L;


   private List<TransacationViewDTO> transactions;


   /**
   * Recupera o valor do atributo transactions
   * @return o transactions
   */
   public List<TransacationViewDTO> getTransactions()
   {
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
