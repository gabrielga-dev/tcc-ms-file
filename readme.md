![campus-formiga.jpg](doc/images/campus-formiga.jpg)

Olá! Este é o microsserviço "ms-file", ele compõe o TCC: "APLICAÇÃO DE UMA ARQUITETURA DE MICROSSERVIÇOS EM UM
SISTEMA WEB PARA CONECTAR PRODUTORES DE EVENTOS E PRESTADORES DE SERVIÇOS".

**Atenção:** É importante a leitura de como executar o "ms-mailer" antes de qualquer outro microsserviço. Caso você 
ainda não tenha lido, acesse o repositório por <a href="https://github.com/gabrielga-dev/tcc-ms-mailer">aqui</a>.

Sua principal função é gerenciar todos os arquivos enviados pelos usuários do projeto, além de enviá-los para o seu 
local de armazenamento, um servidor FTP ou um s3.

Para executar o microsserviço, basta rodar o seguinte comando:
```
mvn spring-boot:run
```
ou simplesmente importando o projeto em sua IDE de preferência e executando através dela.

Além disso, é preciso criar uma cópia do arquivo
[application.properties.example](src/main/resources/application.properties.example), removendo o final ".example". Ao fazer isso você poderá escolher a tecnologia
de armazenamento através do valor `file.technology`, caso você deseje utilizar um servidor FTP, utilize o valor `ftp`,
mas case você possua um servidor s3 na AWS, pode utilizar o valor `s3`.

- Caso você opte pelo s3, você deverá preencher os placeholders "<ACCESS-KEY>", "<SECRET-KEY>", "<REGION>" e
  "<BUCKET-NAME>" com a access key da AWS, a secret key da AWS, a region do s3 e o nome do bucket da s3, respectivamente.

- Caso você utilize o FTP, ele já estará configurado e funcionando normalmente!