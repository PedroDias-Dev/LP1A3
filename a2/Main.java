package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double saldo = 30.00;
        List<Produto> lista = new ArrayList<Produto>();

        Produto produto1 = new Produto(1, "Suco", 4.80);
        Produto produto2 = new Produto(2, "Arroz", 5.80);
        Produto produto3 = new Produto(3, "Feijão", 8.80);
        Produto produto4 = new Produto(4, "Carne", 10.80);
        Produto produto5 = new Produto(5, "Miojo", 2.80);
        Produto produto6 = new Produto(6, "Shampoo", 20.80);

        lista.add(produto1);
        lista.add(produto2);
        lista.add(produto3);
        lista.add(produto4);
        lista.add(produto5);
        lista.add(produto6);

        while (true){
            try {
                System.out.println("para comprar produto, digite o id do produto:");
                System.out.println("para ver os produtos disponiveis, digite lista:");

                String answer = scan.next();

                if(new String(answer).equals("lista")){
                    if(!listProducts(lista)){
                        System.out.println("Nenhum produto disponível!");
                    };
                } else {
                    int id = Integer.parseInt(answer);
                    saldo = sell(id, saldo, lista);
                    System.out.println("Saldo atual: " + saldo);
                }
            } catch (Exception err){
                System.out.println("Opção inválida, tente novamente!");
            }
        }

    }

    public static double sell(int productId, double saldo, List<Produto> products){
        try {
            Produto productExists = searchProduct(productId, products);
            if (productExists == null) {
                System.out.println("Produto não existe na lista");
                throw new Exception();
            }

            if (productExists.preco > saldo) {
                System.out.println("Saldo insuficiente para compra");
                throw new Exception();
            }

            products.remove(productExists);
            saldo = saldo - productExists.preco;
            System.out.println("Produto vendido!");
        } catch (Exception err){
            System.out.println("Tente novamente!");
        }

        return saldo;
    }

    public static boolean listProducts(List<Produto> products){
        if(products.size() == 0){
            return false;
        }

        for (Produto p : products)
        {
            System.out.println("ID: " + p.id);
            System.out.println("NOME: " + p.nome);
            System.out.println("PRECO: " + p.preco);
            System.out.println("\n");
        }

        return true;
    }

    public static Produto searchProduct(int productId, List<Produto> products){
        for (Produto p : products)
        {
            if (p.id == productId)
                return p;
        }
        return null;
    }
}