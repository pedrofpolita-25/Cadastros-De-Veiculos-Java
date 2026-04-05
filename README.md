* CadVeículos

 Sistema de cadastro de veículos desenvolvido em Java como atividade prática de programação.



* Sobre o Projeto

 **CadVeículos** é um sistema de gerenciamento de veículos via terminal, desenvolvido em Java. O programa permite cadastrar, listar, buscar, editar e remover veículos de forma simples e interativa, utilizando um menu com `switch/do-while`.



* Funcionalidades

| Opção | Funcionalidade |
| 1 | Cadastrar veículo (com validação de duplicatas) |
| 2 | Listar todos os veículos em ordem alfabética |
| 3 | Buscar veículo por nome |
| 4 | Editar nome de um veículo existente |
| 5 | Remover veículo por número |
| 6 | Remover veículo por nome |
| 0 | Sair do sistema |


* Tecnologias Utilizadas

- **Java** (versão 21+)
- `ArrayList` e `List` para armazenamento dos dados
- Estruturas básicas: `for`, `if`, `switch`, `do-while`


* Estrutura do Projeto

CadVeiculos/
├── CadVeiculos.java   # arquivo principal com o menu e todas as funcionalidades
└── Input.java         # classe auxiliar para leitura de dados do teclado



* Como Executar

**1. Clone ou baixe os arquivos do projeto**

**2. Compile os arquivos:**
```bash
javac Input.java CadVeiculos.java
```

**3. Execute o programa:**
```bash
java CadVeiculos
```

---

* Detalhes de Implementação

- **Validação de duplicatas:** o sistema impede o cadastro de veículos com nomes iguais, ignorando diferenças entre maiúsculas e minúsculas.
- **Ordenação alfabética:** implementada manualmente com Bubble Sort usando `for` e variável auxiliar — sem uso de `Collections.sort()` ou similares.
- **Busca e comparação case-insensitive:** feitas com `.toLowerCase().equals()`.
- **Lista vazia:** todas as operações verificam se há veículos cadastrados antes de prosseguir.


* Autores: Pedro Henrique Fernandes Polita - RA 1138911
           Gabriel Nunes dos Santos - RA  

Desenvolvido como atividade prática da disciplina de Programação.
