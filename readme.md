# Conversor de moedas
_Este é um conversor de moedas que utiliza a API ... link da api ... _
Sua forma de interação é o console por se tratar de um challenge referente ao projeto Oracle one (info sobre o oracle one) na alura info da alura blablabla_
## Como rodar:
- Informações de como rodar a aplicação  

## Desenvolvimento
1. Primeira saída:
    ~~~shell
    Seja bem vindo:
    Para começar escolha qual a sua moeda de origem: 
        - 1-> Moeda 1
        - 2-> Moeda 2
        - 3-> Moeda 3
        - 4-> Moeda 4
        - 5-> Moeda 5
        - 6-> Moeda 6
    ~~~
    - Aqui é onde o usuário vai escolher a moeda de base que ele está utilizando para a conversão.  
    Vou utilizar uma função que funciona assim:
      1. `public String seletorDeMoeda(boolean origemOuSaida){} ` => A função recebe argumento tipo boolean para escolher se será a moeda de oriegem ou a moeda de destino e retorna uma String para concatenação na uri;
      2. Esta função vai ser utilizada para escolher a moeda de origem e a moeda do resultado final;

2. Segunda saída:
    ~~~shell
       Escolha qual a sua moeda de destino:
        - 1-> Moeda 1
        - 2-> Moeda 2
        - 3-> Moeda 3
        - 4-> Moeda 4
        - 5-> Moeda 5
        - 6-> Moeda 6
    ~~~
    - Utiliza a mesma função da 1

3. Terceira saída
    ~~~shell
    Qual o valor que deseja converter? 
    ~~~
    - Uma função que não tem parâmetros e que pede ao usuário o valor;
        - Importante lembrar de chegar os erros que podem acontecer na conversão e tratar os mesmos.
    - Após converter corretamente e verificar erros retorna uma string com todos os dados da uri para a requuisição

4. Quarta saída:
    ~~~shell
   $$ 1233.00 equivalem a $$ 123131.00
   ~~~
   - Entre o 3 e o 4 é onde será iniciado o HttpClient, será feita a requisição com a string que foi formada;
     - Fazer a requisição, se atentar a erros que podem vir a ocorrer e tratar os mesmos;

