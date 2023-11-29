# ProjetoFinalMC322

Apresentamos o aplicativo MSP turismo. Nosso lema é: viaje do seu jeito! Nesse app, você poderá escolher uma categoria de viagem que mais se adeque ao seu perfil!

## Manual

[...]

## Documentação Técnica

O aplicativo foi desenvolvido em Java utilizando diversos conceitos da Programação Orientada a Objetos, como:

1. **Modularização**: foram divididos em pacotes lógicos como Models, Controllers e Views. No models, temos o pacote destino que está relacionado à todos as entidades que estão no destino, como o próprio lugar, as atividades e a estadia (classes), por exemplo;

2. **Relacionamentos**: Relacionamos diversas classes no projeto, como por exemplo os lugares e os meios de transporte (classes) com o pacote de viagem;

3. **Herança e Classes abstratas**: Usamos heranças diversas vezes, como em Pessoa (classes abstrata) que pode ter como subclasse Usuário ou Administrador, assim como MeioTransporte e Pacote (também classes abstratas);

4. **Polimorfismo e Interfaces**: Usando a interface PossuiValor para as entidades que se relacionam com pacote, podemos calcular o preço total do Pacote iterando sobre todos os itens que implementam essa interface.

5. **Colecoes e Generics**: Agrupamos os pacotes utilizando generics, na coleção ColecoesPacotes.

6. **Exceções**: Por fim, também utilizamos exceções para tratar de usos indevidos da plataforma, como tentativas de acesso à função cuja credencial não permite, invocando uma exceção "PermissãoNegadaExcecao".