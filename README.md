# lab-a01-app-bff-payment

Projeto de estudo da simula pagamentos com Spring Cloud

---

## 🚀 Começando

Esse projeto é um exemplo de laboratório que simula operações de pagamentos via PIX. É uma API Rest escrito utilizando o
pattern [Backends For Frontends](https://samnewman.io/patterns/architectural/bff/) ou **BFF**. Essa Api nada mais é que
uma peça ponte entre o **front-end** e **back-end**. Por exemplo imagine que esse **BFF** foi escrito para front-end 
**Angular**.
Do Angular é feito uma requisição para o **BFF** que por sua vez faz requisições Rest ao **back-end**
[lab-a01-app-repository-payment](https://github.com/williamreges/lab-a01-app-repository-payment.git) utilizando
[Spring Cloud OpenFeign](https://spring.io/projects/spring-cloud-openfeign) como ferramenta de integração.
E para complementar essa API trabalha com Spring Cloud e está se
regisrando em um [Service Registration and Discovery](https://spring.io/guides/gs/service-registration-and-discovery)
como o Eureka.

### 📋 Pré-requisitos

Instale alugmas ferramentas como

* Java 21
* Maven
* Spring Cloud Eureka

### 🔧 Instalação

Instale o Java 17. Utilizei o [SDKMAN](https://sdkman.io/) como ferramenta no linux:

```bash
  sudo sdk install java 17.0.13-zulu
```

Instale o Maven. Utilizei o [SDKMAN](https://sdkman.io/) como ferramenta no linux:

```bash
  sudo sdk install maven 3.8.5
```

Clone o projeto

```bash
  git clone https://github.com/williamreges/lab-a01-app-bff-payment.git
```

Suba um serviço de registro e descoberta Spring Cloud para que a API se registre nela. Se optar por criar um do zero
siga esse tutorial [Service Registration and Discovery](https://spring.io/guides/gs/service-registration-and-discovery).
Porém, se quiser rodar outro projeto complementar a esse projeto clone o seguinte repo e siga o que está no README.md

```bash
  git clone https://github.com/williamreges/lab-a01-infra-service-registry
```

---

## ⚙️ Executando os testes

Entre no Projeto

```bash
  cd lab-a01-app-bff-payment
```

Instale as dependencies do projeto

```bash
  mvn clean install
```

Start o serviço

```bash
  mvn spring-boot:run
```

Entre na porta http://localhost:8100/actuator/health e se retornar `status: "UP"` é porque está rodando com sucesso.

Para testar uma requisição de operação de pagamento via PIX execute o curl abaixo e a resposta será um UUID.

```bash
  curl --request POST \
  --url http://localhost:8100/transacao-pix \
  --header 'Content-Type: application/json' \
  --header 'User-Agent: insomnia/10.3.0' \
  --data '{
	"codigoPessoa": "fbc5fbc7-9b55-4058-af41-fa94ae092ae8",
	"valorTrancacao": 2500.50,
	"dataTrancacao": "2025-02-03T13:00:00",
	"codigoBeneficiario": "02d807e5-dd29-4a25-9de7-a621209c28b7",
	"mensagemTransacao":" PIX para compra de carro"
}'
```

E com o UUID gerado podemos obter o registro gravado na tabela conforme exemplo abaixo:

```bash
curl --request GET \
--url http://localhost:8100/transacao-pix/8644ae90-9225-41bd-8ff6-0a4b9622bfdc \
--header 'User-Agent: insomnia/10.3.0'
```

E com isso logo será retornado algo parecido com esse body abaixo:

```json
{
  "codigoTrancacao": "8644ae90-9225-41bd-8ff6-0a4b9622bfdc",
  "codigoPessoa": "fbc5fbc7-9b55-4058-af41-fa94ae092ae8",
  "valorTrancacao": 2500.5,
  "dataTrancacao": "2025-02-03T13:00:00",
  "codigoBeneficiario": "02d807e5-dd29-4a25-9de7-a621209c28b7",
  "mensagemTransacao": " PIX para compra de carro"
}
```

## 🔗 Referencias

* [Spring Cloud](https://spring.io/cloud)
* [Spring Cloud OpenFeign](https://spring.io/projects/spring-cloud-openfeign)
* [Service Registration and Discovery](https://spring.io/guides/gs/service-registration-and-discovery)
* [Pattern: Backends For Frontends](https://samnewman.io/patterns/architectural/bff/)
* [SDKMAN](https://sdkman.io/) 
