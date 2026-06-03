# Greener 🌿🔋

O **Greener** é uma ferramenta projetada para coletar métricas de consumo de energia e outras informações essenciais para a avaliação do impacto ambiental de softwares. O objetivo principal é fornecer dados precisos que auxiliem desenvolvedores e organizações a entender e reduzir a pegada de carbono de suas aplicações.

## 🚀 Objetivo

No cenário atual de computação em nuvem e grandes centros de dados, a eficiência energética tornou-se um pilar fundamental da engenharia de software sustentável. O Greener permite o mapeamento do consumo de recursos (CPU, RAM) e sua tradução em métricas de energia (Watts) e impacto ambiental (Intensidade de Carbono).

## ✨ Funcionalidades

- **Mapeamento de Infraestrutura**: Cadastro de servidores (Máquinas) com especificações técnicas de consumo energético (Idle Watts, Max Watts, Watts por GB de RAM).
- **Gestão de Localização**: Definição de Zonas geográficas com suas respectivas taxas de intensidade de carbono.
- **Rastreamento de Aplicações**: Gerenciamento de aplicações e suas instâncias vinculadas à infraestrutura.
- **Coleta de Métricas**: Registro de uso de recursos (CPU e Memória RAM) para análise de eficiência.

## 🛠️ Tecnologias Utilizadas

- **Linguagem**: [Java 25](https://openjdk.org/projects/jdk/25/)
- **Framework**: [Spring Boot 4.0.6](https://spring.io/projects/spring-boot)
- **Gerenciador de Dependências**: Gradle
- **Runtime**: Suporte para [GraalVM Native Image](https://www.graalvm.org/)

## 🏗️ Modelo de Domínio

O núcleo do Greener baseia-se em quatro entidades principais:

1.  **Zone**: Representa a região geográfica onde a infraestrutura está hospedada, contendo o índice de intensidade de carbono da grade elétrica local.
2.  **Machine**: Representa o hardware físico ou virtual, detalhando o consumo basal (idle) e o consumo em carga máxima.
3.  **App**: Representa a aplicação de software sendo monitorada e sua respectiva instância.
4.  **ResourceUsage**: Captura o consumo instantâneo de recursos (CPU em % e RAM em GB).

## 🏃 Como Executar

### Pré-requisitos

- JDK 25
- Gradle (ou use o `gradlew` incluso)

### Executando a aplicação

Para iniciar o servidor localmente:

```bash
./gradlew bootRun
```

### Gerando um Native Image (Opcional)

Para uma inicialização ultrarrápida e menor consumo de memória:

```bash
./gradlew nativeCompile
```

## 📄 Licença

Este projeto está sob a licença [LICENSE](LICENSE).

---
*Para um mundo mais verde através de um software mais eficiente.* 🌍
