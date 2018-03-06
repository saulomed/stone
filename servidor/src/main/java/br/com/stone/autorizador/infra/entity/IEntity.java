/*
* Criação : 28 de jan de 2018
*/
package br.com.stone.autorizador.infra.entity;

import java.io.Serializable;

/**
 * Interface padrão para entidades do sistema
 * 
 * @author Janeiro/2018: Saulo Santos
 *         <DD>
 */
public interface IEntity extends Serializable
{

   public Serializable getKey();

}
