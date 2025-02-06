📌 API de Gerenciamento de Tarefas

Uma API simples e eficiente para gerenciar tarefas, permitindo a criação, atualização, listagem e remoção de tarefas de forma intuitiva.

🚀 Funcionalidades

✅ Listar todas as tarefas
✅ Adicionar novas tarefas (inicialmente com status pendente)
✅ Atualizar o status de uma tarefa para concluída
✅ Editar uma tarefa (nome e descrição)
✅ Excluir tarefas pelo ID

🛠️ Tecnologias Utilizadas

Java + Spring Boot 🟢

Spring JPA (para interação com o banco de dados)

Flyway (controle de migrações)

Spring Boot DevTools (atualização automática no desenvolvimento)

PostgreSQL (banco de dados relacional)

📦 Instalação e Execução

Clone este repositório:

git clone https://github.com/Cleitonviana/ToDoList

Acesse o diretório do projeto:

cd ToDoList

Configure o banco de dados PostgreSQL e ajuste o application.properties:

spring.datasource.url=jdbc:postgresql://localhost:5432/seu_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

Execute o projeto:

mvn spring-boot:run

📝 Endpoints Principais

GET /tarefas → Retorna todas as tarefas

POST /tarefas → Adiciona uma nova tarefa (status padrão: pendente)

PUT /tarefas/{id} → Atualiza nome ou descrição de uma tarefa

PATCH /tarefas/{id}/status → Altera o status para concluído

DELETE /tarefas/{id} → Remove uma tarefa pelo ID

📌 Considerações

Este projeto foi desenvolvido com foco na simplicidade e na eficiência, garantindo um CRUD funcional para gestão de tarefas. Qualquer sugestão de melhoria é bem-vinda! 😊

📧 Contato: cleiton_inacio@outlook.com | LinkedIn: www.linkedin.com/in/cleitoninacio
