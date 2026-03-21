# 📚 QUALIS Periódicos
<img width="370" height="170" alt="image" src="https://github.com/user-attachments/assets/0431414f-8095-42f5-aa86-ce6cf21a0f7f" />


Sistema web fullstack com **API REST** para consulta da classificação QUALIS de periódicos acadêmicos da CAPES.

---

## ⚙️ Setup

### Pré-requisitos
- Java 17+
- Maven (ou use o `mvnw` incluso no projeto)

### Rodando a aplicação

**Linux/Mac:**
```bash
git clone https://github.com/cindy197/qualis-api.git
cd qualis-api
./mvnw spring-boot:run
```

**Windows:**
```bash
git clone https://github.com/cindy197/qualis-api.git
cd qualis-api
mvnw.cmd spring-boot:run
```

> 💡 **Na primeira vez que abrir o projeto na IDE**, ela irá sugerir a instalação das dependências do Maven — clique em **Accept** ou **Import** para carregar todas as bibliotecas automaticamente.

Acesse `http://localhost:8080` no navegador.

Na primeira execução, os 171.111 registros do CSV são carregados automaticamente. Nas execuções seguintes, o banco já estará populado e a importação é ignorada.

---

## 🛠️ Tecnologias

| Camada | Tecnologias |
|--------|-------------|
| Backend | Java 25, Spring Boot 3.5.11, Spring Data JPA, H2 Database, Lombok |
| Frontend | HTML5, CSS3, JavaScript (Vanilla) |

---

## 📡 Endpoints

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/api/areas` | Lista todas as áreas de avaliação |
| GET | `/api/area?area=` | Busca periódicos por área |
| GET | `/api/estrato?estrato=` | Busca periódicos por estrato |
| GET | `/api/issn/{issn}` | Busca periódico por ISSN |
| GET | `/api/titulo?titulo=` | Busca periódicos por título |
| GET | `/api/filtro?area=&estrato=` | Filtra por área e estrato combinados |
| GET | `/api/distribuicao?area=` | Distribuição por estrato de uma área |

---

## 🔍 Como foi testado a API

Com a aplicação rodando foram testado das seguintes formas através do `http://localhost:8080`:

**1. Pelo navegador** — foi testado o GET diretamente:
```
http://localhost:8080/api/areas
http://localhost:8080/api/issn/2328-0662
http://localhost:8080/api/area?area=ODONTOLOGIA
```

**2. Pelo Postman** — teste de todos os endpoints:


  <img width="612" height="678" alt="image" src="https://github.com/user-attachments/assets/3e7731b9-f44d-4bbe-ba85-84dfc80456eb" />

---

## 🧠 Decisões técnicas

**H2 em modo arquivo em vez de memória**
O H2 em memória reiniciava o banco a cada restart, forçando a reimportação de 171.111 registros. O modo arquivo persiste os dados entre execuções. O projeto está preparado para migração para PostgreSQL — basta atualizar o `application.properties`.

**`@PostConstruct` para importação do CSV**
Garante que a importação ocorre após o Spring inicializar todos os beans e o banco estar pronto. A verificação `repository.count() > 0` evita duplicação de dados em restarts.

**`List` em vez de `Optional` no `findByIssn`**
O CSV possui ISSNs duplicados — o mesmo ISSN aparece em áreas diferentes. O `Optional` lança exceção ao encontrar mais de um resultado, então a solução foi usar `List` e retornar o primeiro com `.get(0)`.

**`@RestControllerAdvice` para tratamento de erros**
Centraliza o tratamento de exceções em uma única classe, retornando sempre um JSON padronizado com `status`, `message` e `error`. O controller fica limpo, sem blocos try/catch espalhados.

**Frontend em `resources/static/`**
O frontend foi colocado dentro do Spring Boot em vez de uma pasta separada, permitindo que a aplicação inteira seja servida por um único servidor na porta 8080 — sem problemas de CORS e sem precisar abrir o `index.html` manualmente.

---

## 🔮 O que faria diferente com mais tempo

- **Migrar para PostgreSQL** — o H2 é adequado para desenvolvimento, mas um banco robusto seria ideal para produção
- **Adicionar paginação no backend** — hoje a paginação é feita no frontend, o que significa que todos os dados são trafegados de uma vez. Com `Pageable` do Spring, apenas os dados necessários seriam retornados
- **Testes automatizados** — implementar testes unitários com JUnit e Mockito para o service e testes de integração para os endpoints
- **Containerizar com Docker** — facilitar o setup com um `docker-compose.yml` que sobe banco e aplicação juntos
- **Documentação com Swagger** — a dependência já está no `pom.xml`, faltou apenas configurar as anotações nos endpoints

---

*Desenvolvido por Cindy de Almeida Souza Pessoa — 2026*
