package com.vertis.demo.domain.exception;

public class ProdutoNaoEncontradoException extends RuntimeException {

    private static final long serialVersionUID = 1L;
  
    public ProdutoNaoEncontradoException(String mensagem) {
      super(mensagem);
    }
    
    public ProdutoNaoEncontradoException(Long produtoId) {
      this(String.format("Não existe um cadastro de produto com código %d", 
      produtoId));
    }
}
