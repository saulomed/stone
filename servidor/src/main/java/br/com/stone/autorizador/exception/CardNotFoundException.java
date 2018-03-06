/*
* Criação : 18 de fev de 2018
*/

package br.com.stone.autorizador.exception;

/**
 * Excecao para cartao nao encontrado
 * 
 * @author Fevereiro/2018: Saulo Santos
 *         <DD>
 */
public class CardNotFoundException extends Exception
{

   /** @TODO Comentar atributo */
   private static final long serialVersionUID = -7404457367630088358L;

   public CardNotFoundException()
   {
      super();
   }

   public CardNotFoundException(String message)
   {
      super(message);
   }

}
