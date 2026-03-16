# movielist
Este repositório é destinado a uma API de avaliação

Versão do java utilizada na contruição do projeto: 21  
Versão do Spring Boot: 4.0.3  
Banco de dados Utulizado: H2    

Para executar o projeto, via linha de comando, basta entrar no diretório raíz do projeto e executar o seguinte comando (lembrando que é preciso ter a JDK do java instalada e configurada na máquina):  
 ./gradlew bootRun
  
Observação:   
Se for executada via IDE, devem ser feitas as configurações de acordo com cada IDE.  

<h3>Teste da API</h3>  

Com o projeto em execução, para testar o retorna da API, basta chamar o endpoint:  
URL: http://localhost:8080/api/movielist/producers-min-max-interval  
Método HTTP: GET

<img width="1509" height="825" alt="image" src="https://github.com/user-attachments/assets/49eaef2f-5185-4f10-8233-fd8d52731a1b" />
Observação:  
O resultado pode ser confirmado rodando a query:

select   
    m.producers as producer,  
    min(m.produce_year) as previousWin,  
    max(m.produce_year) as followingWin,  
    max(m.produce_year) - min(m.produce_year) as intervalYear  
from movielist m  
where m.winner = true  
group by m.producers  
having intervalYear > 0  
order by 4 asc;  
<img width="979" height="854" alt="image" src="https://github.com/user-attachments/assets/c79e5154-a6df-4519-9bed-76551316022d" />  

Ou rodando a query:  
select producers, array_agg(produce_year order by produce_year) as  years from movielist  
where winner = true   
group by producers  
having cardinality(years) > 1  
order by 2 asc;    
<img width="901" height="657" alt="image" src="https://github.com/user-attachments/assets/0e1bf83e-2d37-4706-8885-a5181981b3ce" />

<h3>Teste de integração</h3>

Para rodar o teste de integração, via linha de comando, basta entrar no diretório raiz do projeto e executar o comando:  
./gradlew test --tests "br.com.movielist.test.integration.*"  
  
<img width="1919" height="287" alt="image" src="https://github.com/user-attachments/assets/1bb299b2-6ee0-4b34-b9a7-a20073db32f4" />

Observação:   
Se for executada via IDE, devem ser feitas as configurações de acordo com cada IDE.  



