JOÃO LUCAS CRUZ – SANTANDER CODERS

PROJETO REALIZADO COMO TRABALHO FINAL DOS MÓDULOS DE MICRO SERVIÇOS E CLOUD E OBSERVABILITY;

O projeto conta com 3 micro serviços:

- MarketPlace

- Cliente-MarketPlace

- Produto-MarketPlace

Get-Startup

Repositórios:

- MarketPlace: https://github.com/jaotuta/projetofinal-marketplace

- Cliente-MarketPlace: https://github.com/jaotuta/clientes-marketplace

- Produto-MarketPlace: https://github.com/jaotuta/produto-marketplace

O projeto conta também com um repositório do serviço Eureka: https://github.com/jaotuta/eureka

Dentro do repositório do serviço de MarketPlace, encontra-se o arquivo Docker-compose, o mesmo levanta todos os bancos de dados necessários nos 3 micros serviços (MongoDb e Postgres).

MarketPlace

O serviço de market-place conta com 3 end-points:

(GET) http://localhost:8089/venda/carrinho -> retorna carrinhos criados.

(POST) http://localhost:8089/venda/add-carrinho -> Adiciona um produto ao carrinho. No body da requisição é necessário passar um JSON conforme exemplo abaixo:

{

“idproduto”: “idProduto tipo UUID”

“idcarrinho”: “idCarrinho tipo String”,

}

Para a primeira inserção será criado um carrinho, neste caso não é necessário a passagem do Id do mesmo.

(POST) http://localhost:8089/vendas/finalizar -> Este end-point é para a finalização da venda, ele retorna um JSON com as informações, dos produtos adicionados ao carrinho, os dados do cliente, método de pagamento e se o pagamento foi aprovado;

No body da requisição é necessário passar um JSON conforme exemplo abaixo:

{

“idcliente”: “idcliente tipo UUID”,

“idcarrinho”: “idCarrinho tipo String”,

“método-pagamento”: “CARTAOCREDITO(ENUM)”,

}

O serviço conta ainda com um sistema de Observability, com a implementação do Prometheus. O mesmo pode ser acessado através do link:

Cliente-MarketPlace

Este serviço tem por objetivo gerenciar os clientes, o mesmo foi criado de forma assíncrona, utilizando o WEBFLUX para as requisições ele conta com os seguintes end-points:

(GET) http://localhost:8091/clientes/ -> retorna clientes criados.

(POST) http://localhost:8091/ clientes / -> Adiciona um Cliente. No body da requisição é necessário passar um JSON conforme exemplo abaixo:

{

“nome”: “João Lucas”,

“email”: “exemplo@email.com.br”,

“telefone”:”99999-9999”

}

(GET) http://localhost:8091/clientes/{id} -> retorna cliente pelo Id.

Produto-MarketPlace

Este serviço tem por objetivo gerenciar os Produtos, para as requisições ele conta com os seguintes end-points:

(GET) http://localhost:8090/produtos/ -> retorna produtos criados.

(POST) http://localhost:8090/produtos / -> Adiciona um produto. No body da requisição é necessário passar um JSON conforme exemplo abaixo:

{

“nome”: “Geladeira Frost Free 397L”,

“fabricante”: “Consul”,

“valor”:”2799,90”

}

(GET) http://localhost:8090/ produtos /{id} -> retorna produto pelo Id.