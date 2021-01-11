# Grafista de benchmarkings

Este esqueleto de projeto tem como objetivo facilitar a utilização de gráficos tipo plot em programação Java. Além disso, aproveito para explicar brevemente o papel de sistemas de construção de software e resolvedores de dependências externas.

## Maven

Este projeto utiliza o Maven como _build system_ e resolvedor de dependências. Por causa disso, a manipulação do projeto pode ser diferente, em sua IDE, da forma como normalmente utiliza projetos simples em branco.

No caso do IntelliJ, que até o momento é a IDE do professor, é necessário acionar o menu de ações Maven, e rodar a etapa de construção `package`.

## Dependências

Este projeto utiliza a biblioteca **JFreeChart**, para gerar e exibir gráficos interativos. Sem essa biblioteca, o projeto provavelmente não compila, e certamenta não roda. Se estiver tendo problemas, o erro provavelmente está na manipulação ou instalação do Maven.

## Colaboração

Caso algum aluno queira elaborar um passo-a-passo, com imagens e vídeos, sobre como rodar esse projeto utilizando o Maven, será muito bem vindo. O aluno ganhará pontos-extra na disciplina! Eu preciso de um passo-a-passo para cada caso:
 * Maven com IntelliJ.
 * Maven com VSCode.
 * Maven no terminal (Unix ou Windows).