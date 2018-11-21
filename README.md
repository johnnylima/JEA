# Projeto Estações de Autoatendimento - PEA
## JJ ESTAÇÃO DE AUTOATENDIMENTO
Para driblar a crise, um cliente está querendo inovar no seu negócio de vendas de Livros, CD e DVD. Ele teve a ideia de
substituir os vendedores da concessionária por estações de autoatendimento. A ideia é que o cliente possa usá-lo para
consultar os automóveis existentes na loja, realizar suas compras e receber o pedido.

Diante disso, o projeto deve ser composto por um sistema de carrinho de compras automatizado e
inteligente, que permite o usuário listar todos os produtos cadastrados no sistema e escolher quais
serão adicionados ao carrinho e seus respectivos valores.

Ao escolher os produtos, o sistema deve permitir o usuário visualizar todos os itens do seu carrinho,
seus respectivos preços e o valor total da compra. Além disso, o sistema deve possibilitar a remoção
de um dos itens do carrinho.

Por fim, o sistema deve permitir que o cliente finalize a sua compra e um número de pedido é gerado, acompanhado do
prazo de entrega. Esta compra deve ser armazenada e o sistema deve retornar para o seu estado inicial, permitindo que
outro usuário também faça sua compra. Para evitar fraudes, o sistema deve permitir a compra de, no máximo, 10 itens de
cada produto. Este tratamento deve ser feito quando o cliente finalizar a compra.

##### Portanto, o sistema deve possuir as seguintes funcionalidades:
1. Cadastrar produto (`acesso restrito com senha: 123`)
2. Listar produtos
3. Adicionar produto ao carrinho com sua quantidade
4. Visualizar o carrinho
5. Excluir produto do carrinho
6. Finalizar a compra
7. Consultar pedido (usando o número gerado)
8. Listar compras realizadas (`acesso restrito com senha: 123`)
9. Controlar estoque (opcional) (`acesso restrito com senha: 123`)

Além disso, a coleção utilizada deve ser implementada pelo aluno. O Aluno deve criar uma nova classe concreta, que
represente uma coleção e que implemente uma das interfaces do Framework Collections.

Para a implementação do sistema, utilizar as seguintes regras (implementar a funcionalidade sem suas respectivas regras
implica na perda de 50% da sua pontuação):
- Utilizar Interfaces e Herança
- Utilizar coleções (nova coleção criada pelo aluno);
- Utilizar exceções nos seguintes casos:
  - Ao cadastrar um produto já existente;
  - Ao finalizar a compra e houver um produto acima do limite máximo permitido (10);
  - Efetuar a compra de um produto que não tem em estoque (opcional)

## Autores
- Johnny Lima
- Júlio Cesar