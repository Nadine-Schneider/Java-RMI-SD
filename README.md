# Java-RMI-SD

Dupla: Nadine Schneider e Fabiane Kuhn

Exercício 2 da disciplina de Sistemas Distribuídos - Unisinos 2021/2

# Proposta
Implementação em RMI de uma conta corrente e realização de testes de escala, com e sem o modificador Synchronized nos métodos.

# Implementação
O código tinha como objetivo realizar a implementação em RMI de uma conta corrente e realização de testes de escala, com e sem o modificador Synchronized nos métodos.
Para isso foram criadas 4 classes java, sendo elas:
* Client
* Server
* ServerMain
* TransactionAccount

A TransactionAccount é uma interface, implementada pelo Server, que está rodando com Synchronized.

Durante os testes enfrentamos problemas para rodar o servidor, obtendo o erro: _java.rmi.ConnectException: Connection refused to host: 192.168.1.16._ Portanto, devido a falta de tempo para a finalização do exercício, não foi possível corrigir o problema e rodar os testes de comparação do modificador Synchronized.


