

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
- cor: string
**Métodos**
- getters() e setters()

### Carro
Classe extendida de Veiculo
**Atributos**
- portas: int
- aroRoda: int
- arCondicionado: boolean
- direcaoHidraulica: boolean
**Métodos**
- getters() e setters()

### Motorcicleta
Classe extendida de Veiculo
**Atributos**
- aroRoda: int
- partidaEletrica: boolean
**Métodos**
- getters() e setters()

### Leilao
Classe principal
**Atributos**
- veiculo: Veiculo,
- imovel: Imovel,
- lanceInicial: float
- incrementoMinimo: float
- lances: ```List<Lances>```
- dataLimite: Date
- instituicaoFinanceira: Financeira
- status: String
**Métodos**
- listaProdutos()
- buscaPorChave()
- buscaPorValor()
- buscaPorTipo() 
- exportarDET()
- darLance()
- historicoLances()

### Lance
Classe comum
**Atributos**
- incremento: float
- leilao: Leilao
- horario: Date

### Usuario
Classe comum
**Atributos**
- nome: String
- cpf: String
- nascimento: String
- senha: String

### Leiloeiro
Classe comum
**Atributos**
-  
