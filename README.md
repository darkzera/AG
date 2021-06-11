
INSTITUTO FEDERAL DO ESPÍRITO SANTO - IFES

CAMPUS SANTA TERESA

TECNOLOGIA EM ANÁLISE E DESENVOLVIMENTO DE SISTEMAS

TÓPICOS ESPECIAIS II

Lucas Augusto Cruz Lopes

20171TADST0430

Santa Teresa - ES, Junho de 2021





**RESUMO**

**3**

**4**

**INTRODUÇÃO**

**METODOLOGIA**

**RESULTADOS E DISCUSSÃO**

**CONCLUSÃO**

**5**

**7**

**8**

**TABELAS E FIGURAS**

**REFERÊNCIAS**

**9**

**13**





**RESUMO**

Algoritmos Genéticos são algoritmos inspirados na teoria darwinista da

evolução natural. Onde os indivíduos mais aptos sobrevivem mais e passam suas

características aos descendentes, assegurando que os atributos vantajosos sejam

disseminados em uma população. Estes algoritmos podem ser aplicados a diversas

necessidades que necessitam de soluções tecnológicas do mundo atual, tais como

encontrar a logística e roteamento de veículos, sequenciamento de genomas,

marcação e perfuração de circuitos integrados, auxiliar no rotação de telescópio

entre outros.

***Palavras-chave:***

*caixeiro viajante, algoritmos genéticos, mutação por troca, seleção por roleta,*

*cruzamento pmx*





**INTRODUÇÃO**

A técnica de algoritmos genéticos de otimização mimetiza os princípios da

seleção natural e busca pela melhor solução possível para um problema definido,

pela evolução na população de soluções candidatas.

O problema do caixeiro viajante, que será abordado neste trabalho, é um dos

clássicos entre os problemas de otimização combinatória. Seu objetivo principal é:

Se dado um número finito de cidades (n), entregar o melhor trajeto (n-1) possível ao

viajante sem que o mesmo visite uma cidade duas vezes e ao fim do caminho,

retorne a cidade inicial. Classificado como um problema *NP-Completo*, o PCV

(Problema do Caixeiro Viajante), uma vez que o número de rotas possíveis cresce

exponencialmente em função do número de cidades. Tornando impraticável o uso de

algoritmos tradicionais para a busca de uma boa solução (caminho). Portanto,

utilizaremos estratégias de AG ao problema indicado.

Pela sua complexidade computacional, não há solução precisa para o

problema do Caixeiro Viajante. Porém, pela sua relevância histórica e aplicabilidade

diversa, há várias abordagens sendo estudadas e desenvolvidas na atualidade.





**METODOLOGIA**

A primeira fase do trabalho consiste em analisarmos o problema para

estabelecer a estrutura de classes (Figura 1.1) e atributos para apresentação

confortável. A representação de uma solução pro PCV é chamada de Caminho ou

Rota (na nomenclatura clássica Cromossomo), possuidor de genes, estes ganham o

signo de Cidades. O desempenho de cada solução é dado pela avaliação da

distância percorrida entre a sequência de cidades definidas. (Tabela 1.1).

A seleção é realizada a Seleção proporcional (Método da Roleta) consiste em

um esquema de seleção natural que seleciona os sobreviventes para a fase de

reprodução conforme os valores de fitness extraídos da função de aptidão durante a

fase de avaliação.

A Mutação é realizada através de um método chamado de Swap Mutation,

que consiste na troca de 2 cidades do mesmo indivíduo.

Seguidamente o cruzamento, o qual foi escolhido como base para este algoritmo foi

o Partially Matched Crossover (PMX), tendo como objetivo gerar dois filhos,

recombinando características de dois pais. A modificação realizada no algoritmo

PMX foi a alteração de seu funcionamento de forma que ao realizar o corte para a

transposição dos elementos limitando-se a 80% de todo tamanho o vetor de

elementos.

Inicialmente serão selecionados os genes do primeiro pai e criando uma sub lista a

qual é inserida nas mesmas posições do vetor de elementos do primeiro filho.

Seguidamente é selecionado os mesmo intervalo de índices do vetor de elementos

do segundo pai, a fim de percorrer todos os índices de elementos verificando se

cada elemento se está apto a entrar nas posições de mesmo índice no vetor de

elementos do individuo filho, para isto é verificado a sub lista herdada anteriormente

do primeiro pai, caso não esteja presente este será adicionado na mesma posição

do vetor de elementos no filho, se estiver presente será verificado a sublista do

segundo pai buscando o primeiro valor que não esteja presente na sub lista do

primeiro pai, conforme descrito nas Figuras 2.1 e 2.2, na seção Tabelas e Figuras.





Critério de parada definido foi a realização de execução de forma exaustiva de (n)

ciclos com tempo de execução previamente definidos, conforme descrito na Tabela

2.1.





**RESULTADOS E DISCUSSÃO**

Este estudo considera a necessidade do viajante sair da cidade inicial, percorrer

todas as outras cidades (n-1) e retornar a cidade de origem. O propósito é encontrar

o caminho com a menor rota possível. Para isso foram utilizados os parâmetros

citados na tabela 2.





**CONCLUSÃO**

Com os resultados obtidos e apresentados na tabela 3, é possível perceber que a

estratégia utilizada não apresenta eficácia quando operada num largo espaço de

tempo, já que os melhores caminhos são selecionados antes dos seis minutos de

execução.





**TABELAS E FIGURAS**

**Tabela 1.1 -** Relação entre nomenclaturas da abordagem clássica pro PCV

Solução

Caminho

Cidade

Gene

Aptidão

Fitness (distância

percorrida)

População

**Tabela 2 -** Parâmetros de execução do algoritmo

Parâmetro

Valor

Tamanho da população

Quantidade de Cidades

Quantidade de Execuções

Tempo de Cada Execução

Taxa de mutação

200

35

10

600 secs (10 min)

2%

Limite de Sangria

80% do array

**Tabela 3 -** Tempo de Execução - Melhor Fitness

Ordem execucao Melhor encontrado no tempo( sec)

Melhor indivíduo (Fitness)

4179.484519391407

4311.81953965736

1

2

227

59

3

479

4066.4869179125685

4358.796402268067

4215.996046311673

4070.505215763173

4142.208922161478

4008.1968452455326

3860.918914389334

4121.909836353164

4133,6323159453700

4

39

5

423

6

153

7

30

8

21

9

60

35

10

Média dos Fitness:





**Figura 1.1** - Diagrama de classe simples

**Figura 2.1** - Cruzamento PMX Modificado - Parte 1. Pais





**Figura 2.2** - Cruzamento PMX Modificado - Parte 2. Filhos





**REFERÊNCIAS**

Heinen, M. R. (2005). Análise e implementação de algoritmos para o roteamento de

veículos.

MALAQUIAS, N. G. (2006). Uso dos algoritmos genéticos para a otimização de rotas

de distribuição.

https://repositorio.ufu.br/bitstream/123456789/14632/1/NGLMalaquiasDISPRT.pdf

PACHECO, M.A (2013) Algoritmos genéticos: princípios e aplicações.

https://repositorio.ufu.br/bitstream/123456789/14632/1/NGLMalaquiasDISPRT.pdf

WEI. J.D (2008).

https://www.researchgate.net/publication/221787155\_Approaches\_to\_the\_Travelling

\_Salesman\_Problem\_Using\_Evolutionary\_Computing\_Algorithms

RAMOS. J. M. (2001). Implementação e Análise do Problema do Caixeiro Viajante

usando uma nova abordagem através dos Algoritmos Genético e Simulated

Annealing https://repositorio.ufsc.br/xmlui/handle/123456789/79640
