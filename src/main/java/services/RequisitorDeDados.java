package services;

import exception.EncerramentoException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class RequisitorDeDados {

    private final List<String> moedas;
    private String moedaOrigem;

    private final Scanner sc;

    public RequisitorDeDados (){
        moedas = new ArrayList<>();
        moedas.add("USD");
        moedas.add("EUR");
        moedas.add("JPY");
        moedas.add("CNY");
        moedas.add("GBP");
        moedas.add("CHF");
        moedas.add("BRL");

        moedaOrigem = "";
        sc = new Scanner(System.in);
    }

    public String seletorDeMoeda(){
        //Mensagem
        exibirMoedas();//Exibe moedas
// fazer modo para verificar o numero escolhido
        int moeda = 0;//inicia a moeda


        while (true){
            try{
                moeda = sc.nextInt();//pega o next int

            }catch(InputMismatchException e){//caso passe algo diferente de um numero volta para o começo
                System.out.println("Insira um número entre 1 e 7 ou <0 para cancelar a operação");
                sc.nextLine();//consome o caractere invalido, caso não consuma o codigo fica preso nessa parte
                continue;
            }

            if(moeda < 0){//caso a escolha seja sair
                throw new EncerramentoException("Você escolheu encerrar :( ByeBye!");

            } else if (moedaOrigem.equals(moedas.get(moeda -1))) {
                System.out.println("Você escolheu a mesma moeda de origem e a mesma moeda de destino, por favor selecione outra para o destino ou cancele");
                continue;//mesmo sendo desnecessário colocar aqui eu quero deixar claro que é pra pular e não fazer nada
            } else if (moeda < 8) {
                moedaOrigem = moedas.get(moeda -1);
                break;
            }else{
                System.out.println("Voce escolheu um número fora da lista, escolha outro ou cancele a operação.");
            }
        }
        return moedaOrigem;
    }

    private void exibirMoedas() {
        for(int i = 0; i < moedas.size(); i++){
            if(moedas.get(i).equals(moedaOrigem))
                continue;
            System.out.println((i +1) + ": " + moedas.get(i));
        }


        System.out.print("Selecione o numero correspondente a moeda ou coloque um numero menor do que zero: ");
    }

}
