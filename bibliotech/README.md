# BiblioTech
​
Sistema de emprestimo de livros para a biblioteca do campus.
​
## 1. O projeto
​
(O cliente do BiblioTech é a biblioteca do campus. O sistema serve para facilitar o empréstimo e a devolução de livros.
Ele ajuda a biblioteca a controlar quais livros estão disponíveis, quais estão emprestados e quem pegou cada livro. O sistema será usado pelos funcionários da biblioteca e pelos alunos do campus, deixando o processo mais rápido e organizado.)

## 3. Requisitos
​
### Requisitos funcionais
​
| # | Requisito funcional | Veio da |
|---|---|---|
| RF01 | O sistema deve permitir que a bibliotecaria cadastre um livro no acervo. | HU04 |
| RF02 | O sistema deve permitir que a bibliotecaria cadastre um leitor. | regra de acesso: so quem tem cadastro leva livro |
| RF03 | O sistema deve permitir que o leitor consulte a disponibilidade de um livro. | HU01 |
| RF04 | O sistema deve permitir que a bibliotecaria registre a devolucao de um livro. | HU02 |
| RF05 | O sistema deve permitir que a bibliotecaria registre o emprestimo de um livro. | HU03 |
| RF06 | (O sistema deve permitir que a bibliotecaria consulte os livros que estão emprestados.) |(necessidade da biblioteca) |
|RF06  | O sistema deve permitir que o leitor reserve um livro.	|HU06|
​
### Requisitos nao funcionais
​
| # | Requisito nao funcional |
|---|---|
| RNF01 | A consulta de disponibilidade deve responder em menos de 3 segundos. |
| RNF02 | Somente usuarios identificados como bibliotecarios podem alterar o acervo. |

## 4. Diagramas (feitos em APS)
​
### Casos de uso
​
![Diagrama de casos de uso do BiblioTech](/bibliotech/docs/casos-de-uso.svg)
​
### Classes
​
![Diagrama de classes do BiblioTech](/bibliotech/docs/classes.svg)