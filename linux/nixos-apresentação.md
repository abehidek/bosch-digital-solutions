# Apresentação do linux NixOS - Por que NixOS é o melhor sistema operacional existente

// https://serokell.io/blog/what-is-nix
// https://www.tweag.io/blog/2022-07-14-taming-unix-with-nix/
// https://news.ycombinator.com/item?id=31141377

## Principais tópicos

- Problemas do linux atual
- O que é NixOS, nixpkgs, Nix lang
- Como o ecossistema resolve os problemas
- Principais Vantagens do ecossistema
- Como o NixOS e o Nix funciona
- Demonstração do NixOS

## Problemas do linux atual

Primeiro é necessário entender o FHS do linux

o FHS é a estrutura e hierarquia de pastas definidas pelo linux padrão, ela define onde será instalados os pacotes do sistema, onde é armazenado os arquivos do usuário e etc...

Porém apesar de intuitiva e fácil de entender a primeira vista, essa maneira de organizar os arquivos introduz uma série de problemas.

Um deles é reproducibilidade, a capacidade de reproduzir um ambiente em outro lugar.
Toda vez que vc vê um caminho como o /bin/python ou /lib/libudev, existe diversas coisas que você não sabe sobre o arquivo que está localizado ali como:

- A versão do pacote
- Quais bibliotecas são utilizadas
- Quais flags foram utilizadas durante a compilação

E perguntas como essa muita das vezes altera o comportamento de uma aplicação que utiliza essees arquivos.

Existe maneiras para tentar mitigar o dano desse problema, como por exemplo colocar a versão na frente do arquivo como /lib/libudev.so.1.6.3 ou usar /bin/python3.9, no entanto ainda existem diversas incógnitas

Uma solução é utilizar ferramentas como o Docker, Snap ou flatpack que criam um ambiente FHS isolado contendo versões fixas das dependências de uma aplicação, e ai sim distribuir esse ambiente, no entanto, essa solução introduz mais problemas ainda.

Nós podemos querer aplicar diferentes flags para nossa aplicação ou mudar uma de suas dependências, e não existe garantia de que você será capaz de compilar das intruções, ja que colocar todos os artifatos em um ambiente isolado garante consistência, mas não reproducibilidade, já que durante o tempo de compilação, essas ferramentas quase sempre utilizam o sistema do host, além de que dependências que vêm de outros ambientes isolados podem mudar.

## O que é NixOS, nixpkgs e Nix Lang

A ideia do Nix é isolar o processo de compilação, e não o código compilado (artifatos de compilação).

Para cada compilar cada pacote Nix, é necessário calcular sua derivação (arquivo escrita na linguagem de programação Nix), esse arquivo contem:

- Menção de todos os arquivos e outros pacotes que serão necessários durante a compilação
- Instruções de compilação para o pacote
- Metainformação sobre o pacote
- E mais importante, um sufixo que será o caminho a ser instalado que fica na forma:

/nix/store/<hash>-<name>-<version> onde o <hash> é o o hash calculado da derivação.

Fazer isso resolve os problemas citados anteriormente e garante as propriedades:
- Compilar da mesma derivação
