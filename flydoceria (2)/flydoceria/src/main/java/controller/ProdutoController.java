package controller;

import jakarta.validation.Valid;
import model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.ProdutoService;

import java.util.*;

public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> listarProdutos() {
        return produtoService.listarTodosProdutos();
    }

    @GetMapping("/{id}")
    public Optional<Produto> buscarProduto(@PathVariable Integer id) {
        return produtoService.buscarProdutoPorId(id);
    }

    @PostMapping
    public Produto criarProduto(@RequestBody @Valid Produto produto) {
        return produtoService.salvarProduto(produto);
    }

    //Criar método de atualizar

    @DeleteMapping("/{id}")
    public void excluirProduto(@PathVariable Integer id) {
        produtoService.excluirProduto(id);
    }

}
