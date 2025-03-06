/* -*-mode:java; c-basic-offset:2; indent-tabs-mode:nil -*- */
/*
Copyright (c) 2002-2018 ymnk, JCraft,Inc. All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:

  1. Redistributions of source code must retain the above copyright notice,
     this list of conditions and the following disclaimer.

  2. Redistributions in binary form must reproduce the above copyright 
     notice, this list of conditions and the following disclaimer in 
     the documentation and/or other materials provided with the distribution.

  3. The names of the authors may not be used to endorse or promote products
     derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED WARRANTIES,
INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL JCRAFT,
INC. OR ANY CONTRIBUTORS TO THIS SOFTWARE BE LIABLE FOR ANY DIRECT, INDIRECT,
INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA,
OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

package com.jcraft.jsch.interfaces;

public interface DiffieHellman {

  /**
   * Inicializa os parâmetros e o estado interno para o processo de troca de chaves.
   */
  void initialize() throws Exception;

  /**
   * Define o número primo (modulus) utilizado no algoritmo Diffie-Hellman.
   *
   * @param primeModulus o valor do número primo em formato de byte array.
   */
  void setPrimeModulus(byte[] primeModulus);

  /**
   * Define o gerador (base) utilizado no algoritmo Diffie-Hellman.
   *
   * @param generator o valor do gerador em formato de byte array.
   */
  void setGenerator(byte[] generator);

  /**
   * Calcula e retorna o valor público gerado, a partir dos parâmetros internos.
   *
   * @return o valor público em formato de byte array.
   */
  byte[] computePublicValue() throws Exception;

  /**
   * Define o valor público recebido da outra parte para a troca de chaves.
   *
   * @param peerPublicValue o valor público da outra parte em formato de byte array.
   */
  void setPeerPublicValue(byte[] peerPublicValue);

  /**
   * Calcula e retorna o segredo compartilhado (chave comum) a partir dos valores públicos.
   *
   * @return o segredo compartilhado em formato de byte array.
   */
  byte[] computeSharedSecret() throws Exception;

  /**
   * Valida se os valores públicos gerados e recebidos estão dentro do intervalo seguro [1, primeModulus - 1],
   * conforme definido na RFC4253, seção 8.
   */
  void validatePublicValues() throws Exception;
}
