# agenciaTrip-api
Api feita em Java para a atividade individual do curso Recode Pro

Para rodar a Api, certifique-se de que, no arquivo [application.properties](https://github.com/mathroque/agenciaTrip-api/blob/main/src/main/resources/application.properties), os dados de usuário e senha do banco de dados escolhido (MySql ou Postgres) estão preenchidos corretamente.

Em seguida, é possível alimentar as tabelas do banco de dados utilizando dois arquivos [.json](https://github.com/mathroque/agenciaTrip-api/jsonData), por meio de um api client como Postman. Basta usar o método post com todos os dados .json referente ao endpoint correto (ex.: método Post com os dados do arquivo destinos.json no endpoint http://localhost:8080/destino).
