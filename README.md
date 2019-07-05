# Paciente System

Projeto de Sistema WEB da matéria de Java EE. 

## Tecnologias Utilizadas
WildFly, JSF, PostgreSQL, Omnifaces e BootsFaces

## Escopo

Dificuldade 1 - Paciente JSF com JPA Simples

Desenvolver  um  sistema  utilizando  técnicas  de desenvolvimento  em  camadas  utilizando  a tecnologia Java para Web.
Desenvolver  um  sistema  para  gerenciar  a internação  de  um  paciente  com  relação  aos medicamentos prescritos.

O sistema deverá ter funcionalidade para cadastramento de pacientes.
Faça  o  mapeamento  da  entidade  para  que  o  banco  de  dados  seja  criado  adequadamente utilizando JPA.

● O  cadastro  de  paciente  deverá  conter  os  campos  nome,  idade,  CPF,  sexo  e  data  de internação.

● Para manipular as informações do paciente, devem-se ter as seguintes funcionalidades:

● Deve-se confeccionar uma janela para cadastramento do paciente. 

● Deve-se confeccionar uma janela para mostrar todos os pacientes cadastrados

● Não deve ser possível cadastrar mais de um paciente com o mesmo CPF.

● Não deve ser possível aceitar cadastramentos de pacientes com CPF inválido.

● Todos os campos são obrigatórios.


## Instalação

Utilizando o Eclipse, vá em "File > Import > JSF Project" e escolha o diretório onde você baixou o projeto.

## Utilização

Para utilizar, é necessário configurar o servidor de aplicações WildFly (ou outro de sua preferência, mas talvez necessite de alguma alteração) e configurar o persistence.xml com a configuração do banco de dados que você utilizar.

```xml
<property name="hibernate.dialect" value="org.hibernate.dialect.PostgreSQL95Dialect" />
<jta-data-source>java:/pacienteSystem</jta-data-source> 
```

Obs: Não foi utilizado o Maven para realizar a build devido a limitações de acesso à internet no campus.
