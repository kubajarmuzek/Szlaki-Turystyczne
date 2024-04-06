package edu.put.szlakiturystyczne

data class Trail(val name: String, val description: String, val stages: List<Stage>)

data class Stage(val name: String, val description: String, val distance: Float)

val trails = listOf(
    Trail(
        "Szlak Beskidzki",
        "Szlak prowadzi przez malownicze tereny Beskidu Śląskiego i Żywieckiego.",
        listOf(
            Stage("Schronisko na Hali Lipowskiej", "Opis etapu", 5.7f),
            Stage("Babia Góra", "Opis etapu", 8.2f),
            Stage("Przełęcz Krowiarki", "Opis etapu", 3.5f),
            Stage("Schronisko na Hali Rysiance", "Opis etapu", 6.8f)
        )
    ),
    Trail(
        "Szlak Tatrzański",
        "Szlak prowadzi przez najwyższe polskie góry - Tatry.",
        listOf(
            Stage("Morskie Oko", "Opis etapu", 10.5f),
            Stage("Czarny Staw pod Rysami", "Opis etapu", 6.2f),
            Stage("Rysy", "Opis etapu", 5.4f),
            Stage("Schronisko PTTK na Polanie Kondratowej", "Opis etapu", 8.1f)
        )
    ),
    Trail(
        "Szlak Gór Stołowych",
        "Szlak prowadzi przez Park Narodowy Gór Stołowych, gdzie znajdują się charakterystyczne skałki i formacje skalne.",
        listOf(
            Stage("Błędne Skały", "Opis etapu", 6.8f),
            Stage("Skalne Grzyby", "Opis etapu", 4.2f),
            Stage("Szczeliniec Wielki", "Opis etapu", 7.5f),
            Stage("Zespół Zamkowy w Karlowie", "Opis etapu", 5.1f)
        )
    ),
    Trail(
        "Szlak Bieszczadzki",
        "Szlak prowadzi przez Bieszczady, malownicze pasmo górskie na południowo-wschodnim krańcu Polski.",
        listOf(
            Stage("Tarnica", "Opis etapu", 9.3f),
            Stage("Chatka Puchatka", "Opis etapu", 7.7f),
            Stage("Połonina Wetlińska", "Opis etapu", 11.2f),
            Stage("Rezerwat Żubrów", "Opis etapu", 8.5f)
        )
    ),
    Trail(
        "Szlak Sudecki",
        "Szlak prowadzi przez Sudety, pasmo górskie na południowym zachodzie Polski.",
        listOf(
            Stage("Śnieżka", "Opis etapu", 6.0f),
            Stage("Karkonosze", "Opis etapu", 9.8f),
            Stage("Schronisko PTTK na Śnieżnych Kotłach", "Opis etapu", 7.3f),
            Stage("Szklarska Poręba", "Opis etapu", 5.5f)
        )
    ),
    Trail(
        "Szlak Mazurski",
        "Szlak prowadzi przez malownicze tereny Pojezierza Mazurskiego, z licznymi jeziorami i lasami.",
        listOf(
            Stage("Mikołajki", "Opis etapu", 7.6f),
            Stage("Głębokie Jezioro", "Opis etapu", 8.3f),
            Stage("Sztynort", "Opis etapu", 6.9f),
            Stage("Kanał Elbląski", "Opis etapu", 12.0f)
        )
    ),
    Trail(
        "Szlak Suwalski",
        "Szlak prowadzi przez Suwalszczyznę, region geograficzny na północnym wschodzie Polski.",
        listOf(
            Stage("Góra Zamkowa", "Opis etapu", 7.2f),
            Stage("Jezioro Hańcza", "Opis etapu", 13.5f),
            Stage("Głazowisko Bachanowo", "Opis etapu", 10.1f),
            Stage("Rezerwat Cisy Staropolskie", "Opis etapu", 8.7f)
        )
    ),
    Trail(
        "Szlak Jurajski",
        "Szlak prowadzi przez Jura Krakowsko-Częstochowską, obszar wyżynny z licznymi skałami wapiennymi.",
        listOf(
            Stage("Ojców", "Opis etapu", 6.4f),
            Stage("Maczuga Herkulesa", "Opis etapu", 5.9f),
            Stage("Zamek w Pieskowej Skale", "Opis etapu", 7.8f),
            Stage("Zamek w Olsztynie", "Opis etapu", 9.2f)
        )
    ),
    Trail(
        "Szlak Warmiński",
        "Szlak prowadzi przez Warmię, region historyczny w północno-wschodniej Polsce.",
        listOf(
            Stage("Olsztyn", "Opis etapu", 8.6f),
            Stage("Kanał Elbląski", "Opis etapu", 10.0f),
            Stage("Góra Czterech Wiatrów", "Opis etapu", 7.3f),
            Stage("Zamek w Lidzbarku Warmińskim", "Opis etapu", 6.8f)
        )
    ),
    Trail(
        "Szlak Świętokrzyski",
        "Szlak prowadzi przez Góry Świętokrzyskie, najstarsze góry w Polsce.",
        listOf(
            Stage("Święty Krzyż", "Opis etapu", 5.1f),
            Stage("Lasy Świętokrzyskie", "Opis etapu", 8.4f),
            Stage("Zamek Krzyżtopór", "Opis etapu", 7.0f),
            Stage("Rezerwat Kadzielnia", "Opis etapu", 6.5f)
        )
    )
)
