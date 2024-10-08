# Latitude e Longitude de Cidades!

Este projeto oferece um serviço para buscar a latitude e longitude de uma cidade específica.

## Rotas
- `POST /user` - Registra um novo usuário.
  - Exemplo de body:
    ```json
    {
      "username": "Miguel"
    }
    ```

- `GET /procurarlatlon?cidade={nome}` - Busca latitude e longitude de uma cidade.
  - Exemplo:
    ```json
    {
      "latitude": "-23.55052",
      "longitude": "-46.633309"
    }
    ```

- `GET /sobre` - Retorna informações do projeto.
  - Exemplo de resposta:
    ```json
    {
      "estudante": "Miguel Rossi Fermo",
      "projeto": "Latitude e Longitude de Cidades!"
    }
    ```

O serviço será acessível na porta 8080.