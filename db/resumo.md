# Resumo - Guilherme Hidek Abe

## Qual é a importância do banco de dados?

A escrita revolucionou a humanidade pois permitiu acumular informação e assim criar progresso, e por muito tempo ela foi a maneira principal de armazenar dados, sejam através de livros, jornais, artigos etc..., no entando, com o advento da era digital, enormes quantidades de informação são criadas a cada segundo, e é no Bancos de dados são onde toda informação é armazenada.

## O que é o Teorema CAP

Atualmente é muito comum o uso de sistemas distribuidos, eles possibilitam escalar o sistema horizontalmente, no entanto, eles não são imunes a falhas, e o teorema CAP descreve o que acontece com um armazenamento de dados distribuidos nesses casos.

CAP é uma sigla que significa:

- C - Consistency (Consistência)
    Sistema consistente retorna as mesmas informações (mantém a consistência entre os membros do sistema distribuido)

- A - Availability (Disponibilidade)
    Permite que o sistema possa ser acessado a qualquer hora e lugar

- P - Partition Tolerance (Tolerância à partições)
    Refere-se a capacidade de um sistema distribuído funcionar no momento de falhas de rede.

O teorema CAP afirma que um sistema distribuido não pode garantir todos os três o tempo todo. Quando as coisas
dão errados, precisamos priorizar no máximo duas características.

## O que é ACID (Atomicidade, Consistência, Isolamento e Durabilidade)

É utilizado na maioria dos RDBMS atualmente, garante que todas as transações no banco de dados sejam realizadas de forma confiável, evitando que os dados se corrompam, ou percam sua consistência.

## O que é BASE (Basically Available Soft state Eventual consistency)

BASE utiliza uma aproximação oposta do ACID (Atomicidade, Consistência, Isolamento e Durabilidade), que são as propriedades tradicionais em bancos de RDBMS.

o BASE essencialmente abraça a ideia de que consistência verdadeira não pode ser alcançada no mundo real, e portanto, não pode ser modelado em sistemas distruídos altamente escaláveis e e de alta disponibilidade.

ele garante disponibilidade alta, mas mantendo a consistência de eventos (todos os eventos no banco de dados são registrados, e em caso de partição, após a correção, os eventos são sincronizados, garantindo a consistência a longo prazo mas não a curto prazo)

O objetivo primário é aumentar o desempenho e disponibilidade, utiliza-se como artifício a distribuição de dados e múltiplos servidores, permitindo a escalabilidade horizontal.

## O que é OLTP e OLAP

OLTP é um termo comumente utilizado no ramo de BI (Business Inteligence) usado para se referir ao gerenciamento de dados transacionais usando sistemas computacionais, eles registram a interação de negócios conformes elas ocorrem na operação diária da organização, e dão suporte à consulta desses dados para criar inferências, tem foco no nível operacional da organização, e visa a execução operacional do negócio.

Já o OLAP é o processamento analítico dos dados provenientes do OLTP, tem foco no nível estratégico da organização e visa a tomada de decisão.

## O que é Data Warehouse 

Repositório central, organizacional e relacional de dados integrados de uma ou mais fontes diferentes, ela armazena informações relacionadas às atividades de uma organização em um banco de dados, e o desenho da base de dados favorece os relatórios, registro de dados transacionais e análise desses dados.