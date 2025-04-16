# Sistema de Criptografia de ElGamal em Java

Uma implementação, em Java, do famoso sistema de criptografia assimétrica de ElGamal.

## Pontos importantes
- [O que é um sistema de criptografia com chaves assimétricas?](#assimetricas)
- [Como funciona o sistema de criptografia de ElGamal?](#elgamal)
- [Instalação e uso](#instalacao)
- [Contribuintes](#contribuintes)
- [Notas](#notas)

## O que é um sistema de criptografia com chaves assimétricas?
Em linhas gerais, um sistema assimétrico de criptografia (ou sistema com chaves assimétricas) é aquele que utiliza pares de chaves: públicas,
que podem ser amplamente disseminadas, e privadas, as quais são conhecidas apenas pelo seu portador.

## Como funciona o sistema de criptografia de ElGamal?
O sistema de criptografia de ElGamal é baseado essencialmente na dificuldade computacional de resolver o problema do logaritmo discreto para números primos muito grandes.
### Logaritmo discreto
O logaritmo discreto pode ser definido no contexto de uma função em grupos cíclicos finitos a partir de um gerador desse grupo. Nesse sentido, sendo *g* o gerador de um grupo
cíclico finito *G*, com *h ∈ G*, o logaritmo discreto de *h* na base *g* é um inteiro *x* tal que:

*g^x ≡ h (mod p)*
### Aleatoriedade de chaves
Além da segurança associada ao logaritmo discreto, o sistema criptográfico de ElGamal trabalha com chaves aleatórias, escolhidas tanto pelo emissor quanto pelo receptor da mensagem,
fato que dificulta ainda mais a "quebra" do algoritmo de criptografia.
### Geração de chaves
#### Receptor
  1. Em primeiro lugar o receptor escolhe um número primo grande *p*.
  2. Em seguida, seleciona um raiz primitiva *r* de *p*.
  3. Escolhe ainda um número natural *x* no intervalo *2 < x <= p - 2*.
  4. Calcula *a* de modo que *r^x ≡ a (mod p)*.
  5. Envia a chave pública *(p, r, a)*.
  6. Guarda a chave privada *x*.
#### Emissor
  1. Encripta a mensagem, associando cada caractere a um código a partir de uma lógica pré-definida.
  2. Define blocos de dígitos de tamanho *p - 1*.
  3. Obtém a chave pública *(p, r, a)* do receptor.
  4. Seleciona um número natural *y* tal que *2 < y <= p - 2*.
  5. Calcula *b* de modo que *r^y ≡ b (mod p)*.
  6. Para cada bloco de código *M*, calcula *C ≡ M.(a^y) (mod p)*.
  7. Envia o ciframento *(b, C)* para o receptor.
#### Receptor
  7. Para cada ciframento, calcula *P ≡ C.(b^(p - 1 - x)) ≡ M (mod p)*.
  8. Decripta cada bloco de código *M* a partir da lógica de encriptação desenvolvida.
  9. Une os resultados e forma a mensagem original.

## Instalação e uso
1. Faça download do arquivo *zip*.
2. Extraia o conteúdo.
```bash
unzip <nome do arquivo>.zip
```
4. Navegue até o diretório *src*.
```bash
cd ./src
```
3. Compile o arquivo *Main.java*.
```bash
javac Main.java
```
4. Execute o arquivo com dois argumentos: a mensagem a ser critografada e o número primo grande a ser utilizado na criptografia.
```bash
java Main "Mensagem a ser criptografada" 1009
```
5. Obtenha o resultado.
```txt
Mensagem a ser criptografada
|
|
<mensagem encriptada>
|
|
<mensagem decriptada>
```

## Contribuintes
1. Guilherme Noronha Fragoso
2. Pedro Leal e Lima
3. Pedro Nascimento Paraíso

## Notas
Projeto feito como trabalho final da disciplina de Fundamentos de Matemática para Ciência da Computação II no período 2024.2, ministrada pelo professor Tiago Massoni.

cc@UFCG.
