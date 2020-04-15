# Integrador3, segunda entrega

Ação 1 : sobrescreva os métodos “toString” e “equals” para as classes Musica e Playlist.
Use “toString” na implementação dos itens de consulta de Musica e Playlists no projeto.

No modelo de objetos implementado em Java, todas as classes são sempre, por
definição, subclasses da classe Object. Isso significa que, se você não incluir uma superclasse
na implementação, sua classe, automaticamente, vai assumir “extends Object”. 

Assim todos os objetos instanciados em Java irão sempre herdar métodos presentes na
superclasse Object. Alguns destes métodos estão lá para serem sobrescritos! Dois deles são os
métodos “toString” e “equals”.

Assinatura do método “toString” : String toString()
O método retorna uma representação do Objeto como um String.
A implementação de toString() herdada da classe Object produz um String padrão que envolve
a referência do objeto e o nome de sua classe. Mas podemos sobrescrever este método
produzindo um String mais significativo para objetos de uma determinada classe.
Por exemplo, um objeto Musica, embora tenha vários atributos, poderia ser representado
somente pelo nome ou pela junção do nome da música e do nome do artista (uma
implementação de toString() na classe Musica retornaria este String)


Assinatura do método “equals” : boolean equals(Object outro)
Um uso típico de equals poderia ser (para o caso de termos dois objetos nas variáveis objeto1 e
objeto2)
  objeto1.equals(objeto2)
Neste caso o método “equals” deve retornar true se objeto1 e objeto2 são iguais, e false caso
contrário.

Observações:
  ● Nesta situação, como objeto1 é o receptor da mensagem, na implementação de equals
temos acesso a ele usando a variável this.
  ● Já o objeto2 estará na variável que é o parâmetro do método.
  
A implementação padrão do método “equals” na classe Object decide se objeto1 e objeto2 são
iguais comparando as referências que estão nessas duas variáveis (ou seja, verifica se temos o
mesmo objeto nas duas variáveis).
Quando sobrepomos “equals” em uma classe, no entanto, podemos também verificar se a
estrutura deles é a mesma, comparando seus atributos. Para um objeto do tipo Música, por
exemplo, poderíamos, na implementação de equals, verificar se os principais atributos dos dois
objetos são iguais: nome da música; Cantor/Cantora; Banda/Grupo.

Ação 2 : Use o mecanismo de Exceções para tratar 2 situações específicas no projeto

Mecanismo de tratamento de exceções estão presentes no framework de muitas linguagens de
programação. Em Java, o mecanismo envolve o uso de objetos que representam a exceção que
deve ser tratada.
Implemente, no projeto, o tratamento das seguintes situações usando o mecanismo de
tratamento de exceções:
  - Ao inserir um objeto Musica em uma ListaDeMusica, se já há, na lista, outro objeto
Musica igual ao que está sendo inserido, jogue a exceção ExcecaoDeMusicaJaExistente
  - Ao remover um objeto Musica de uma ListaDeMusica, se o objeto não é encontrado na
lista, jogue a exceção ExcecaoDeMusicaNaoEncontrada
Observação: use sua implementação de “equals” na classe Musica para verificar as situações
de exceção!

Você deve fazer também o tratamento adequado das exceções nas situações em que elas podem
acontecer. Ou seja, quando os métodos de inserção e remoção de ListaDeMusica são utilizados,
devem estar em um bloco try{} que implementa os catch() adequados.
