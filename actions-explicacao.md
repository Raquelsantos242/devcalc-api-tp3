# GitHub Actions: Diferença entre Workflow e Action

O GitHub Actions é uma plataforma de automação integrada ao GitHub. Ele permite que desenvolvedores automatizem tarefas como build, testes, linting, deploy e muito mais. Uma confusão comum é que o nome da plataforma é "GitHub Actions", mas dentro dela existe um componente chamado simplesmente de **action**.

Um **workflow** é o arquivo `.yml` que define toda a automação. Ele é disparado por eventos (como um push ou execução manual) e contém os **jobs** a serem executados. Cada job é uma sequência de **steps**, que podem rodar comandos (`run:`) ou reutilizar blocos prontos com `uses:`, que são as **actions**.

Actions são unidades reutilizáveis que encapsulam uma tarefa. Elas podem ser feitas por você mesmo ou buscadas no GitHub Marketplace. Cada action tem um arquivo action.yml, que define quais parâmetros ela aceita (inputs), o que retorna (outputs) e como deve ser executada (runs). Por exemplo, no projeto foi usado:


name: Setup Java

  uses: actions/setup-java@v3

  with:

  distribution: 'temurin'

  java-version: '17'

Essa action é chamada dentro do workflow usando `uses:`, e os parâmetros são enviados com `with:`. O workflow completo fica salvo em `.github/workflows/ci.yml` e contém jobs como `build`, `test`, `package` e `deploy`, organizados com `needs:` para garantir ordem de execução. Assim, workflows coordenam **quando e o que** será executado, enquanto actions definem **como** cada tarefa específica é realizada.

**Referências**

DUKE, M. What’s the difference between a GitHub action and a workflow? Disponível em: <https://dev.to/github/whats-the-difference-between-a-github-action-and-a-workflow-2gba>. Acesso em: 6 jun. 2025.

‌