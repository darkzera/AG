# INSTITUTO FEDERAL DO ESPÍRITO SANTO - IFES

- RESUMO
- INTRODUÇÃO
- METODOLOGIA
- RESULTADOS E DISCUSSÃO
- CONCLUSÃO
- TABELAS E FIGURAS
- REFERÊNCIAS


## RESUMO

Algoritmos Genéticos são algoritmos inspirados na teoria darwinista da
evolução natural.Ondeosindivíduosmaisaptossobrevivem maisepassamsuas
características aos descendentes, assegurandoqueosatributosvantajosossejam
disseminadosemumapopulação.Estesalgoritmospodemseraplicadosadiversas
necessidadesquenecessitamdesoluçõestecnológicasdomundoatual,taiscomo
encontrar a logística e roteamento de veículos, sequenciamento de genomas,
marcação e perfuração de circuitos integrados, auxiliar no rotaçãode telescópio
entre outros.

**_Palavras-chave:_**

_caixeiroviajante,algoritmosgenéticos,mutaçãoportroca,seleçãoporroleta,
cruzamento pmx_


## INTRODUÇÃO

A técnicade algoritmos genéticos de otimização mimetiza osprincípiosda
seleção naturale buscapelamelhorsolução possívelparaumproblemadefinido,
pela evolução na população de soluções candidatas.
Oproblemadocaixeiroviajante,queseráabordadonestetrabalho,éumdos
clássicosentreosproblemasdeotimizaçãocombinatória.Seu objetivoprincipalé:
Sedadoumnúmerofinitodecidades(n),entregaromelhortrajeto(n-1)possívelao
viajante sem que o mesmo visite uma cidade duasvezes eao fim do caminho,
retorne a cidade inicial. Classificado como um problema _NP-Completo_ , o PCV
(ProblemadoCaixeiroViajante), umavezqueonúmeroderotaspossíveiscresce
exponencialmenteemfunçãodonúmerodecidades.Tornandoimpraticávelousode
algoritmos tradicionais para a busca de uma boa solução (caminho). Portanto,
utilizaremos estratégias de AG ao problema indicado.
Pela sua complexidade computacional, não há solução precisa para o
problemadoCaixeiroViajante.Porém,pelasuarelevânciahistóricaeaplicabilidade
diversa, há várias abordagens sendo estudadas e desenvolvidasna atualidade.


## METODOLOGIA

A primeira fase do trabalho consiste em analisarmos o problema para
estabelecer a estrutura de classes (Figura 1.1) e atributos para apresentação
confortável.Arepresentaçãodeuma soluçãoproPCVéchamadadeCaminhoou
Rota(nanomenclaturaclássicaCromossomo),possuidordegenes,estesganhamo
signo de Cidades. O desempenho de cada solução é dado pela avaliação da
distância percorrida entre a sequência de cidadesdefinidas. (Tabela 1.1).
AseleçãoérealizadaaSeleçãoproporcional(MétododaRoleta)consisteem
um esquema de seleção natural que selecionaossobreviventes paraa fasede
reproduçãoconformeosvaloresdefitnessextraídosdafunçãodeaptidãodurantea
fase de avaliação.
A Mutaçãoérealizada atravésdeummétodochamadodeSwapMutation,
que consiste na troca de 2 cidades do mesmo indivíduo.
Seguidamenteocruzamento,oqualfoiescolhidocomobaseparaestealgoritmofoi
o Partially Matched Crossover (PMX), tendo como objetivo gerar dois filhos,
recombinando características de dois pais. A modificação realizadano algoritmo
PMXfoiaalteraçãodeseufuncionamentodeformaqueaorealizarocorteparaa
transposição dos elementos limitando-se a 80% de todo tamanho o vetor de
elementos.
Inicialmenteserãoselecionadososgenesdoprimeiropaiecriandoumasublistaa
qual é inserida nas mesmas posições do vetor de elementos do primeiro filho.
Seguidamenteéselecionadoosmesmointervalodeíndicesdovetordeelementos
do segundo pai, afimde percorrer todos osíndicesde elementosverificandose
cada elemento seestáapto aentrar nas posições de mesmo índicenovetorde
elementosdoindividuofilho,paraistoéverificadoasublistaherdadaanteriormente
doprimeiropai, casonãoestejapresenteesteseráadicionadonamesmaposição
do vetor de elementos no filho, seestiver presenteserá verificado a sublistado
segundo pai buscando o primeiro valor que nãoesteja presentena sub lista do
primeiro pai, conforme descrito nas Figuras 2.1 e2.2, na seção Tabelas e Figuras.


Critériodeparadadefinidofoiarealizaçãode execuçãodeformaexaustivade(n)
cicloscomtempo deexecuçãopreviamentedefinidos,conformedescritonaTabela
2.1.


## RESULTADOS E DISCUSSÃO

Este estudo considera anecessidade do viajante sair da cidade inicial,percorrer
todasasoutrascidades(n-1)eretornaracidadedeorigem.Opropósitoéencontrar
o caminho com amenor rotapossível. Para isso foramutilizados osparâmetros
citados na tabela 2.


## CONCLUSÃO

Comosresultadosobtidoseapresentadosnatabela3,épossívelperceberquea
estratégiautilizada não apresentaeficácia quandooperada num largoespaçode
tempo,jáqueosmelhorescaminhossãoselecionadosantesdos seisminutosde
execução.


## TABELAS E FIGURAS

**Tabela 1.1 -** Relação entre nomenclaturas da abordagemclássica pro PCV

```
Solução Caminho
Gene Cidade
Aptidão Fitness (distânciapercorrida)
População
```
**Tabela 2 -** Parâmetros de execução do algoritmo

```
Parâmetro Valor
Tamanho da população 200
Quantidade de Cidades 35
Quantidade de Execuções 10
Tempo de Cada Execução 600 secs (10 min)
Taxa de mutação 2%
Limite de Sangria 80% do array
```
**Tabela 3 -** Tempo de Execução - Melhor Fitness

```
Ordem execucao Melhor encontrado no tempo( sec) Melhor indivíduo (Fitness)
1 227 4179.
2 59 4311.
3 479 4066.
4 39 4358.
5 423 4215.
6 153 4070.
7 30 4142.
8 21 4008.
9 60 3860.
10 35 4121.
Média dos Fitness: 4133,
```

**Figura 1.1** - Diagrama de classe simples

**Figura 2.1** - Cruzamento PMX Modificado - Parte 1.Pais


**Figura 2.2** - Cruzamento PMX Modificado - Parte 2.Filhos


## REFERÊNCIAS

Heinen,M.R.(2005).Análiseeimplementaçãodealgoritmosparaoroteamentode
veículos.

MALAQUIAS,N.G.(2006).Usodosalgoritmosgenéticosparaaotimizaçãoderotas
de distribuição.
https://repositorio.ufu.br/bitstream/123456789/14632/1/NGLMalaquiasDISPRT.pdf

PACHECO, M.A (2013) Algoritmos genéticos: princípiose aplicações.

https://repositorio.ufu.br/bitstream/123456789/14632/1/NGLMalaquiasDISPRT.pdf

WEI. J.D (2008).
https://www.researchgate.net/publication/221787155_Approaches_to_the_Travelling
_Salesman_Problem_Using_Evolutionary_Computing_Algorithms

RAMOS.J.M. (2001).ImplementaçãoeAnálisedoProblemadoCaixeiroViajante
usando uma nova abordagem através dos Algoritmos Genético e Simulated
Annealing https://repositorio.ufsc.br/xmlui/handle/123456789/


