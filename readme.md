# Conversor de moedas

## Explicando quem propos
Olá! Este é um desafio proposto pela [Alura](https://www.alura.com.br/), na trilha do [OracleOne](https://www.oracle.com/br/education/oracle-next-education/), como forma de treinar o consumo de apis externas em Java.  

## Explicando um pouco sobre o projeto
O projeto proposto foi um conversor de moedas que utilize a uma api externa, a que sugeriram foi [ExangeRate-API](https://app.exchangerate-api.com/dashboard)  

Para facilitar a importação de bibliotecas utilizei o gradle portanto é necessário te-lo em sua máquina quando for rodar o projeto.  
A única biblioteca externa que utilizo é a [Gson 2.13.1](https://mvnrepository.com/artifact/com.google.code.gson/gson/2.13.1)

Para interação com o programa utilizo o console, onde fiz menus básicos utilizando laços while que se repetem até que a opção de cancelar seja selecionada.  
Para captar as chamadas de saída do programa aproveitei do tratamento de exceções para criar uma personalizada que pode ser facilmente captada e usada para sair do laço e encerrar a aplicação.

- Tentei organizar o projeto simulando o uso de um framework, para por em prática também as boas práticas de programação

### Explicando as classes
#### RequisitorDeDados -> é a classe responsável pelo serviços que requisitam os dados.

##### Variáveis
- `moedas` -> uma lista que eu mesmo inicio no programa contendo 7 moedas que que acordo com o que pesquisei são as mais utilizadas hoje no mercado internacional referente ao Brasil:  

| Moeda | Local            |
|-------|------------------|
| USD   | Dólar americano  |
| EUR   | Euro             |
| JPY   | Iene Japonês     |
| CNY   | Yuan Chines      |
| GBP   | Libra Esterlina  |
| CHF   | Franco Suiço     |
| BRL   |  Real Brasileiro |
    - Caso deseje é só adicionar uma sigla válida na lista para adicionar mais moedas compatíveis na aplicação.  
- `moedaOrigem` -> é uma string que coloquei para que ela salve qual foi a moeda de origem, para evitar que o programa não tente converter a mesma moeda de entrada e de saída.
- `sc` -> é uma instância global de Scanner, para não ocorrerem erros fora do método, mantendo sempre o mesmo sc para toda a aplicação.

##### Métodos
- Construtor -> responsável por iniciar a classe, iniciando a lista com os valores padrão e definindo a moedaOrigem como uma string vazia.
- `exibirMoedas` -> método que percorre a lista com um for e exibe o número referente a cada moeda, nele utilizo a moeda de origem para evitar a repetição da moeda que já está selecionada como origem.
- `reset` -> método que ao final de uma conversão reseta o valor de moedaOrigem, para que a próxima repetição ocorra sem quaisquer conflitos com a antiga.
- `solicitarValor` -> método usado para inserir um valor double para que seja realizado o cambio de uma moeda para a outra, ele trata o erro de caso não digite numero ou coloque . no lugar da , para que a aplicação não se encerre a menos que o valor seja < 0;
- `seletorDeMoedas` -> este método é o que usamos para selecionar uma moeda da lista através do terminal, ele tem um retorno com a sigla da moeda utilizada, o mesmo retorno é adicionado a uri da requisição e é utilzado para pegar o valor de cambio do Map que ficam armazenados os valores;

#### RequestToApi
##### Métodos
- `requestToApi` -> é o método que recebe a uri, ele é responsável por realizar o request e retornar o mesmo em forma de string, para que seja feita a conversão para um objeto que podemos utilizar.
- `converteStringParaMoedaBase` -> ele é quem vai receber a request já convertida em forma de string, usar a lib Gson para fazer a serialização para o formato que desejamos `MoedaBase`;
- `getMoedaBase` -> este sendo o método que é público da classe, recebe a uri, chama o `requestToApi` e manda o retorno do mesmo para o `converteStringParaMoedaBase`, assim obtendo o retorno no formato desejado.

#### MoedaBase
##### Variáveis
- `conversionRates` -> é um Map com chave que corresponde a moeda e o valor um Double que corresponde ao valor. Optei por utilizar o Map pois ele já tem os métodos que eu precisaria implementar, e também por ser uma abordagem que não utilizei antes, acabei achando interessante, versátil, já que se eu quiser adicionar mais moedas a lista de moedas que posso fazer cãmbio não precisarei modificar essa parte.
- 
##### Métodos
- utilizei um método get para retornar Map com os valores que foram definidor.

#### EncerramentoException
- É uma exceção personalizada que fiz para controlar melhor o fluxo de sáida da aplicação.

#### Menu
- Nesta classe é que está o coração da aplicação, nela eu escolho quando chamar e trato as exceções que geram a saída da aplicação, ela é responsável pelo loop principal que vai se repetir até que o usuário escolha sair. Ao final de cada repetição coloquei o app para dormir por 5 segundos para que de para visualizar o resultado antes do loop começar novamente.

#### Main
- utilizei essa apenas para colocar o `public static void main(String[] args){}` e iniciar o menu _simulando um start de um framework_.

### Aviso importante
- Para rodar de preferência para rodar no [InteliJ](https://www.jetbrains.com/idea/download/?section=windows) _baixe a versão community, ela é free_ ele já faz todo o processo do gradle, baixa as libs e tem uma compatibilidade melhor com o terminal que é o recurso que utlizamos para interagir no app.
- Deixei disponível a minha chave de API para a utilização do ExangeRate-API, caso deseje você pode solicitar a sua através do [site deles](https://app.exchangerate-api.com/dashboard) e substituir no código.

## Agradecimentos
Agradeço a Alura e a Oracle pela oportunidade de acessar os cursos, e aos professores que os fizeram.

