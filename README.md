PetPlace – Sistema de Gestão para Pet Shop
Trabalho Final – Disciplina de Banco de Dados – Universidade Católica de Brasília (UCB)

Este repositório apresenta o desenvolvimento do PetPlace, sistema criado como Trabalho Final da disciplina de Banco de Dados da Universidade Católica de Brasília (UCB).
O projeto tem como objetivo aplicar conceitos de modelagem, implementação de banco relacional, integração com banco NoSQL e desenvolvimento de um sistema funcional para gestão de pet shop.

Descrição do Projeto

O PetPlace é um sistema de gestão que permite administrar:

Cadastro de clientes

Controle de produtos e estoque

Serviços (banho, tosa etc.)

Registro de vendas com baixa automática de estoque

Agendamentos de serviços

Autenticação com controle de acesso

Armazenamento no MongoDB para dados dinâmicos, logs e sessões

O sistema combina MySQL (banco relacional) e MongoDB Atlas (banco NoSQL), aplicando triggers, views, procedures, functions e índices para otimizar desempenho e garantir integridade.

Tecnologias Utilizadas
Frontend

HTML5

CSS3

JavaScript (ES6+)

Backend

Java (estrutura MVC, sem Spring Boot)

JDBC para MySQL

Driver oficial do MongoDB para Java

Banco de Dados

MySQL – armazenamento estruturado, transacional e com integridade referencial

MongoDB Atlas – armazenamento de dados dinâmicos, não estruturados e de alta mutabilidade

Funcionalidades Principais

Cadastro, edição e listagem de clientes

Cadastro, edição e controle de produtos

Registro de vendas com cálculo de total

Redução automática do estoque via Trigger

Agendamento de serviços

Views para relatórios e consultas

Controle de usuários e permissões (Administrador e Vendedor)

Armazenamento NoSQL para logs, sessões e dados voláteis

Modelagem do Banco de Dados

A modelagem contempla:

DER completo no MySQL

Entidades principais: CLIENTE, PRODUTO, SERVICO, COMPRA, COMPRA_has_PRODUTO, AGENDAMENTO, USUARIOS e grupos_usuarios

Coleções do MongoDB para logs, sessões e registros dinâmicos

Como Executar

Execute o script SQL disponível no repositório para criar o banco petshop no MySQL.

Configure as credenciais do MySQL e do MongoDB no código Java.

Abra o projeto na IDE de sua preferência (NetBeans ou IntelliJ).

Execute a classe principal para iniciar o sistema.

Autores

Guilherme Cunha Braga

Gustavo Nascimento Ferreira

Igor Amaral Ferreira

João Antônio de Souza Assunção

Guilherme Santana Marques Guedes

Objetivo Acadêmico

Este trabalho demonstra:

Aplicação prática de conceitos de um SGBD relacional

Uso combinado de tecnologias SQL e NoSQL

Implementação de rotinas internas como triggers, procedures, functions e views

Desenvolvimento de um sistema completo com base em modelagem formal e requisitos reais
