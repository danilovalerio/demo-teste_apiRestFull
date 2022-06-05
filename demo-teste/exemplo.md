#Projeto Backend
###Criar uma API RestFull para controle de produtos

####Modelo(model):
-[x] Produto: id, nome, quantidade, valor, observacao

####Repositorio de produto 
(no primeiro momento vai simular um banco de dados) 
CRUD Métodos:
-[x] obterTodos, obterPorId, adicionar, atualizar, deletar 

####Service de produto - pode conter regras de negócio ou não
-[x] obterTodos, obterPorId, adicionar, atualizar, deletar

####Controller de produto
-[x] obterTodos, obterPorId, adicionar, atualizar, deletar

####Conectar o crud ao banco de dados Postgresql
-[x] conectado e testado

####Criar um DTO para desacoplar a entidade produto
-[x] criar um DTO para trafegar od dados de produto

####Refatoração de Service e Controller
-[x] Utilizar os models de view - ProdutoResponse, ProdutoRequest e ProdutoDTO com Mappers

####Criar um Método que centralize o Uso do Mapper em Shared
-[ ] Diminuir o boilerplate dos Mappers utilizados em Controller e Service através de um médoto
que recebe os parametros para serem tratados e devolvidos