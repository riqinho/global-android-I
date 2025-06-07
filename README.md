# 📱 GeoImpacto

Aplicativo Android desenvolvido para cadastro de eventos locais com impacto social. Permite registrar nome do local, tipo de evento, grau de impacto, data e número estimado de pessoas afetadas.

## 👨‍💻 Integrantes do Grupo
- Rick Alves Domingues — RM552438  
- Renata Almeida Lima — RM552588

## ✨ Funcionalidades
- Cadastro de eventos com 5 campos principais
- Lista dinâmica com RecyclerView
- Remoção de itens
- Busca em tempo real por nome do local 🔍
- Tela de integrantes
- Layout moderno com `CardView` e `Toolbar` fixa

## 📷 Capturas de Tela
> Insira abaixo prints do app em funcionamento:

| Tela Inicial | Cadastro preenchido | Lista com filtro |
|--------------|---------------------|------------------|
| ![screenshot1](https://i.ibb.co/DD7Mm26J/image.png) | ![screenshot2](https://i.ibb.co/SwLZKjJg/imagem-2025-06-07-201118568.png) | ![screenshot3](https://i.ibb.co/27PQK844/image.png) |

## 🛠️ Tecnologias utilizadas
- Kotlin
- Android SDK
- ViewModel + LiveData
- Room Database
- RecyclerView
- Material Components

## 📂 Estrutura de Telas
- `MainActivity.kt`: tela de cadastro e listagem
- `IntegrantesActivity.kt`: exibe os membros do grupo
- `ItemModel.kt`, `ItemDao.kt`, `ItemDatabase.kt`: gerenciamento de dados com Room
- `ItemsAdapter.kt`: exibição dos itens
- `item_layout.xml`: layout estilizado dos cards

## ✅ Como rodar
1. Clone o projeto no Android Studio  
2. Execute com um emulador ou dispositivo físico Android  
3. O banco é local, não precisa de API ou permissões extras

---

> Projeto acadêmico desenvolvido para avaliação na disciplina de Desenvolvimento Mobile.

