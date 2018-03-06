/*
* Criação : 18 de fev de 2018
*/
package br.com.stone.autorizador.exception;


/**
 * Excecao para senah invalida
 * 
 * @author Fevereiro/2018: Saulo Santos
 *         <DD>
 */
public class PasswordInvalidException extends Exception
{

   /** @TODO Comentar atributo */
   private static final long serialVersionUID = -5565687539068810105L;

   public PasswordInvalidException(String message)
   {
      super(message);
   }

   public PasswordInvalidException()
   {
      super();
   }

}
