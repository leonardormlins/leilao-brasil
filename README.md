# leilao-brasil
Um sistema de leilão via console em Java




## Classes
```
Imovel
|-- Apartamento
|-- Terreno
|-- Casa
|-- Edificio
Veiculo
|-- Carro
|-- Motorcicleta
Leilao
Lance
Usuario
|-- Cliente
|-- EntidadeFinanceira
```
---
### Imovel
Classe do tipo abstrata

**Atributos**
- localizacao: string
- precoOriginal: float
- descricao: String
- inscricaoMunicipal: String
**Métodos**
- getters() e setters()


### Apartamento
Classe extendida de Imovel
**Atributos**
- andar: String
- bloco: String
- condominio: float
- numeroAp: int
- area: float
- comodos: int
- garagem: int
**Métodos**
- getters() e setters()

### Terreno
Classe extendida de Imovel
**Atributos**
- area: string
- murado: boolean
**Métodos**
- getters() e setters()

### Casa
Classe extendida de Imovel
**Atributos**
- areaConstruida: float
- area: float
- comodos: int
- piscina: boolean
- garagem: int
**Métodos**
- getters() e setters()
 
### Edificio
Classe extendida de Imovel
**Atributos**
- andares: int
- comercial: boolean
- numeroSalas: int
**Métodos**
- getters() e setters()

### Veiculo
Classe do tipo abstrata

**Atributos**
- modelo: string
- ano: int
- placa: String
- combustivel: string
- cc: int
**Métodos**
- getters() e setters()
