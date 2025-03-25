📅 Agenda Digital Muralis Backend 💻
📖 Sobre o projeto
Este projeto é uma API desenvolvida para gerenciar uma agenda digital. Trata-se de um teste prático para a Muralis, utilizando Java e Spring Boot no backend.

🚀 Tecnologias Utilizadas
O projeto foi desenvolvido utilizando as seguintes tecnologias:

Java 21 (Oracle OpenJDK)

Spring Boot 3.2.4

MySQL




📍 API Endpoints
A API segue um CRUD básico para gerenciamento de clientes e seus contatos.

🧑 Cliente
Método	Rota	Descrição
GET	/cliente	Retorna todos os registros de clientes
GET	/cliente/buscar?nome=	Retorna o registro do cliente pelo nome informado
GET	/cliente/buscar?cpf=	Retorna o registro do cliente pelo CPF informado
POST	/cliente	Registra um novo cliente
PUT	/cliente/{id}	Atualiza os dados do cliente respectivo do ID informado
DELETE	/cliente/{id}	Deleta os dados do cliente respectivo do ID informado
🔹 Exemplo de POST /cliente
json
Copiar
Editar
{
    "nome": "exemplo",
    "cpf": "xxxxxxxxxxx",
    "dt_nascimento": "yyyy-MM-dd",
    "cep": "xxxxxxxx",
    "numeroResidencia": "xx"
}
🔹 Exemplo de PUT /cliente/{id}
json
Copiar
Editar
{
    "nome": "exemplo",
    "cpf": "xxxxxxxxxxx",
    "dt_nascimento": "yyyy-MM-dd",
    "cep": "xxxxxxxx",
    "numeroResidencia": "xx"
}
📞 Contato
Método	Rota	Descrição
GET	/contato/{id}	Retorna todos os contatos vinculados ao ID informado
POST	/contato	Registra um novo contato
PUT	/contato/{id}	Atualiza os dados do contato respectivo do ID informado
DELETE	/contato/{id}	Deleta os dados do contato respectivo do ID informado
🔹 Exemplo de POST /contato
json
Copiar
Editar
{
    "id_cliente": "x",
    "tipo": "email",
    "valor": "exemplo@gmail.com",
    "observacao": "..."
}
🔹 Exemplo de PUT /contato/{id}
json
Copiar
Editar
{
    "id_cliente": "x",
    "tipo": "email",
    "valor": "exemplo@gmail.com",
    "observacao": "..."
}
🛠 Dependências
O projeto utiliza as seguintes dependências:

Spring Data JPA → Utilizado para persistência no banco de dados.

Spring Boot DevTools → Ferramentas que auxiliam no desenvolvimento.

Spring Web → Dependência para desenvolvimento web.

Flyway Migrations → Gerenciamento de versões do banco de dados.

Lombok → Reduz código boilerplate.

📂 Estrutura do Projeto
O projeto segue a arquitetura MVC, respeitando a separação de camadas.

📌 Modelagem do Banco de Dados
A modelagem foi baseada em uma estrutura normalizada, seguindo boas práticas. O endereço do cliente foi separado em uma entidade específica para garantir maior flexibilidade e evitar redundância de dados.

📌 Diagrama Entidade-Relacionamento (DER):
![image](https://github.com/user-attachments/assets/1fc2e778-74e3-43d8-ab1e-fbd3bf79f6df)

🚀 Instruções de Uso
Para executar o projeto localmente, siga os passos abaixo:

📌 Requisitos:
XAMPP ou outro servidor MySQL para iniciar o banco de dados.

IDE Java (IntelliJ, Eclipse, VS Code) configurada com a versão correta da JDK.

Ferramenta para gerenciar o banco (MySQL Workbench, DBeaver, etc.).

Postman ou Insomnia para testar as requisições HTTP.

Configuração do Banco → user=root e password= (sem senha por padrão).

▶️ Executando a aplicação:
Inicie o servidor MySQL.

Clone o repositório:

bash
Copiar
Editar
git clone https://github.com/JoaoFelipeSantana/Agenda_Digital_Muralis_Backend.git
Acesse o diretório do projeto:

bash
Copiar
Editar
cd Agenda_Digital_Muralis_Backend
Configure o banco de dados com as migrations do Flyway.

Execute o projeto na sua IDE.

Utilize o Postman/Insomnia para testar os endpoints.

📝 Licença
Este projeto está disponível sob a licença MIT.
📄 MIT License
