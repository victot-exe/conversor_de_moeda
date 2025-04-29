package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RequisitorDeDados {

    private final List<String> moedasSuportadas;

    public RequisitorDeDados (){
        moedasSuportadas = new ArrayList<String>();
        moedasSuportadas.add("Moeda1");
        moedasSuportadas.add("Moeda2");
        moedasSuportadas.add("Moeda3");
        moedasSuportadas.add("Moeda4");
        moedasSuportadas.add("Moeda5");
        moedasSuportadas.add("Moeda6");
        moedasSuportadas.add("Ou mais para cancelar");
    }

    public String seletorDeMoedaDeOrigem(){

        System.out.println("Seja bem vindo:\n" +
                "    Para começar escolha qual a sua moeda de origem:");
        exibirMoedas();

        Scanner sc = new Scanner(System.in);//TODO alguma coisa aqui está quebrando verificar o que é
        int moedaSelecionada = Integer.parseInt(sc.next());//TODO Verificar se é um numero e coisas do tipo fazer um método externo para verificar tambem no outro método
        sc.next();

        if(moedaSelecionada >= 6) {
            sc.close();
            throw new RuntimeException("Você saiu da aplicação." + "\nAté mais :)");//TODO Criar exceção personalizada
        }
        sc.close();
        return moedasSuportadas.get(moedaSelecionada);
    }



    public String seletorDeMoedaFinal(){

        System.out.println("Escolha qual a sua moeda de conversão:");
        exibirMoedas();

        Scanner sc = new Scanner(System.in);
        int moedaSelecionada = Integer.parseInt(sc.next());//TODO Da pra fazer um método externo que verifica já se é uma letra ou não e pede um caractere válido

        if(moedaSelecionada > 5) {
            while (moedaSelecionada > 5) {
                System.out.print("Insira uma opção válida: ");
                moedaSelecionada = Integer.parseInt(sc.next());

            }
        }

        if(moedaSelecionada == 5){
            sc.close();
            throw new RuntimeException("Você cancelou a operação" + "\nAté mais :)");
        }

        return moedasSuportadas.get(moedaSelecionada);
    }

    private void exibirMoedas() {
        for(int i = 0; i < moedasSuportadas.size(); i++){
            System.out.println(i + ": " + moedasSuportadas.get(i));
        }

        System.out.print("Selecione o numero correspondente a moeda: ");
    }

}
