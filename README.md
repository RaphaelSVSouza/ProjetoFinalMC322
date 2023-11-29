# ProjetoFinalMC322

Este é um projeto em Java desenvolvido para uma plataforma digital focada no setor de turismo e viagens. A plataforma permite aos usuários navegar por diversos pacotes de viagem, visualizar detalhes sobre destinos específicos e efetuar reservas de acordo com suas preferências e necessidades.



## Documentação Técnica

O aplicativo foi desenvolvido em Java utilizando diversos conceitos da Programação Orientada a Objetos, como:

1. *Modularização*: foram divididos em pacotes lógicos como Models, Controllers e Views. No models, temos o pacote destino que está relacionado à todos as entidades que estão no destino, como o próprio lugar, as atividades e a estadia (classes), por exemplo;

2. *Relacionamentos*: Relacionamos diversas classes no projeto, como por exemplo os lugares e os meios de transporte (classes) com o pacote de viagem;

3. *Herança e Classes abstratas*: Usamos heranças diversas vezes, como em Pessoa (classes abstrata) que pode ter como subclasse Usuário ou Administrador, assim como MeioTransporte e Pacote (também classes abstratas);

4. *Polimorfismo e Interfaces*: Usando a interface PossuiValor para as entidades que se relacionam com pacote, podemos calcular o preço total do Pacote iterando sobre todos os itens que implementam essa interface.

5. *Colecoes e Generics*: Agrupamos os pacotes utilizando generics, na coleção ColecoesPacotes.

6. *Exceções*: Por fim, também utilizamos exceções para tratar de usos indevidos da plataforma, como tentativas de acesso à função cuja credencial não permite, invocando uma exceção "PermissãoNegadaExcecao".



### Estrutura do Projeto

controllers:
CadastroUsuario: Classe responsável por cadastrar usuários no sistema.
Reserva: Classe que realiza reservas de pacotes de viagem.

models:

*destino: Pacote que contém classes relacionadas a destinos e atividades turísticas.
Atividades: Classe representando atividades turísticas.
CategoriaAtividade: Enum que representa categorias para atividades.
CategoriaEstadia: Enum que representa categorias de estadia.
Estadia: Classe representando opções de estadia.
Lugar: Classe representando destinos turísticos.

*pacotes: Pacote que contém classes relacionadas a pacotes de viagem.
Pacote: Classe base para pacotes de viagem.
PacoteCompleto: Subclasse que herda de Pacote e adiciona informações específicas, como meio de transporte.
CategoriaPacote: Enum que define categorias para pacotes de viagem.

*pessoas: Pacote que contém classes relacionadas a usuários e administradores.
Pessoa: Classe base para representar pessoas.
Administrador: Subclasse que herda de Pessoa e representa administradores do sistema.
Usuario: Subclasse que herda de Pessoa e representa usuários finais.

*transportes: Pacote que contém classes relacionadas a meios de transporte.
MeioTransporte: Classe base para meios de transporte.
Onibus: Subclasse que herda de MeioTransporte e representa ônibus.
Aviao: Subclasse que herda de MeioTransporte e representa aviões.
CategoriaTransporte: Enum que define categorias para meios de transporte.

*utils: Pacote que contém interfaces e utilitários.

PossuiValor: Interface que indica que uma classe possui um valor associado.
Reservavel: Interface que indica que uma classe pode ser reservada.
ColecoesPacotes: Classe para fazer operações com os pacotes de viagens existentes, como listar pacotes por preço, data e valor.

*views
Login: Classe responsável por gerenciar o login dos usuários e identificar se é um administrador ou usuario. Também possui as tarefas que um usuáriou ou administrador pode realizar no sistema.
Utilização do Projeto
