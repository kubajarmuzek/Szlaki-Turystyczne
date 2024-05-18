package edu.put.szlakiturystyczne

data class Trail(val name: String, val description: String, val stages: List<Stage>, val type: String)

data class Stage(val id: Int,val name: String, val description: String, val distance: Float)

val trails = listOf(
    Trail(
        "Szlak Beskidzki",
        "Szlak prowadzi przez malownicze tereny Beskidu Śląskiego i Żywieckiego.",
        listOf(
            Stage(1,"Schronisko na Hali Lipowskiej", "Opis etapu", 5.7f),
            Stage(2,"Babia Góra", "Opis etapu", 8.2f),
            Stage(3,"Przełęcz Krowiarki", "Opis etapu", 3.5f),
            Stage(4,"Schronisko na Hali Rysiance", "Opis etapu", 6.8f)
        ),
        "Rest"

    ),
    Trail(
        "Szlak Tatrzański",
        "Szlak prowadzi przez najwyższe polskie góry - Tatry.",
        listOf(
            Stage(1,"Morskie Oko", "Opis etapu", 10.5f),
            Stage(2,"Czarny Staw pod Rysami", "Opis etapu", 6.2f),
            Stage(3,"Rysy", "Opis etapu", 5.4f),
            Stage(4,"Schronisko PTTK na Polanie Kondratowej", "Opis etapu", 8.1f)
        ),
        "Tatry"
    ),
    Trail(
        "Szlak Gór Stołowych",
        "Szlak prowadzi przez Park Narodowy Gór Stołowych, gdzie znajdują się charakterystyczne skałki i formacje skalne.",
        listOf(
            Stage(1,"Błędne Skały", "Opis etapu", 6.8f),
            Stage(2,"Skalne Grzyby", "Opis etapu", 4.2f),
            Stage(3,"Szczeliniec Wielki", "Opis etapu", 7.5f),
            Stage(4,"Zespół Zamkowy w Karlowie", "Opis etapu", 5.1f)
        ),
        "Rest"
    ),
    Trail(
        "Szlak Bieszczadzki",
        "Szlak prowadzi przez Bieszczady, malownicze pasmo górskie na południowo-wschodnim krańcu Polski.",
        listOf(
            Stage(1,"Tarnica", "Opis etapu", 9.3f),
            Stage(2,"Chatka Puchatka", "Opis etapu", 7.7f),
            Stage(3,"Połonina Wetlińska", "Opis etapu", 11.2f),
            Stage(4,"Rezerwat Żubrów", "Opis etapu", 8.5f)
        ),
        "Rest"
    ),
    Trail(
        "Szlak Sudecki",
        "Szlak prowadzi przez Sudety, pasmo górskie na południowym zachodzie Polski.",
        listOf(
            Stage(1,"Śnieżka", "Opis etapu", 6.0f),
            Stage(2,"Karkonosze", "Opis etapu", 9.8f),
            Stage(3,"Schronisko PTTK na Śnieżnych Kotłach", "Opis etapu", 7.3f),
            Stage(4,"Szklarska Poręba", "Opis etapu", 5.5f)
        ),
        "Rest"
    ),
    Trail(
        "Szlak Mazurski",
        "Szlak prowadzi przez malownicze tereny Pojezierza Mazurskiego, z licznymi jeziorami i lasami.",
        listOf(
            Stage(1,"Mikołajki", "Opis etapu", 7.6f),
            Stage(2,"Głębokie Jezioro", "Opis etapu", 8.3f),
            Stage(3,"Sztynort", "Opis etapu", 6.9f),
            Stage(4,"Kanał Elbląski", "Opis etapu", 12.0f)
        ),
        "Rest"
    ),
    Trail(
        "Szlak Suwalski",
        "Szlak prowadzi przez Suwalszczyznę, region geograficzny na północnym wschodzie Polski.",
        listOf(
            Stage(1,"Góra Zamkowa", "Opis etapu", 7.2f),
            Stage(2,"Jezioro Hańcza", "Opis etapu", 13.5f),
            Stage(3,"Głazowisko Bachanowo", "Opis etapu", 10.1f),
            Stage(4,"Rezerwat Cisy Staropolskie", "Opis etapu", 8.7f)
        ),
        "Rest"
    ),
    Trail(
        "Szlak Jurajski",
        "Szlak prowadzi przez Jura Krakowsko-Częstochowską, obszar wyżynny z licznymi skałami wapiennymi.",
        listOf(
            Stage(1,"Ojców", "Opis etapu", 6.4f),
            Stage(2,"Maczuga Herkulesa", "Opis etapu", 5.9f),
            Stage(3,"Zamek w Pieskowej Skale", "Opis etapu", 7.8f),
            Stage(4,"Zamek w Olsztynie", "Opis etapu", 9.2f)
        ),
        "Rest"
    ),
    Trail(
        "Szlak Warmiński",
        "Szlak prowadzi przez Warmię, region historyczny w północno-wschodniej Polsce.",
        listOf(
            Stage(1,"Olsztyn", "Opis etapu", 8.6f),
            Stage(2,"Kanał Elbląski", "Opis etapu", 10.0f),
            Stage(3,"Góra Czterech Wiatrów", "Opis etapu", 7.3f),
            Stage(4,"Zamek w Lidzbarku Warmińskim", "Opis etapu", 6.8f)
        ),
        "Rest"
    ),
    Trail(
        "Szlak Świętokrzyski",
        "Szlak prowadzi przez Góry Świętokrzyskie, najstarsze góry w Polsce.",
        listOf(
            Stage(1,"Święty Krzyż", "Opis etapu", 5.1f),
            Stage(2,"Lasy Świętokrzyskie", "Opis etapu", 8.4f),
            Stage(3,"Zamek Krzyżtopór", "Opis etapu", 7.0f),
            Stage(4,"Rezerwat Kadzielnia", "Opis etapu", 6.5f)
        ),
        "Rest"
    ),
    Trail(
        "Szlak Tatrzański",
        "Szlak prowadzi przez najwyższe polskie góry - Tatry.",
        listOf(
            Stage(1,"Morskie Oko", "Opis etapu", 10.5f),
            Stage(2,"Czarny Staw pod Rysami", "Opis etapu", 6.2f),
            Stage(3,"Rysy", "Opis etapu", 5.4f),
            Stage(4,"Schronisko PTTK na Polanie Kondratowej", "Opis etapu", 8.1f)
        ),
        "Tatry"
    ),
    Trail(
        "Szlak Świnicki",
        "Szlak prowadzi na najwyższy szczyt polskich Tatr - Świnicę.",
        listOf(
            Stage(1,"Kuźnice", "Opis etapu", 7.8f),
            Stage(2,"Hala Gąsienicowa", "Opis etapu", 9.2f),
            Stage(3,"Przełęcz Zawrat", "Opis etapu", 6.5f),
            Stage(4,"Schronisko PTTK Murowaniec", "Opis etapu", 8.3f)
        ),
        "Tatry"
    ),
    Trail(
        "Szlak Gąsienicowy",
        "Szlak prowadzi przez malowniczą Dolinę Gąsienicową w Tatrach Zachodnich.",
        listOf(
            Stage(1,"Kuźnice", "Opis etapu", 7.2f),
            Stage(2,"Hala Kondratowa", "Opis etapu", 6.8f),
            Stage(3,"Przełęcz Kondracka", "Opis etapu", 5.1f),
            Stage(4,"Gąsienicowa Dolina", "Opis etapu", 8.7f)
        ),
        "Tatry"
    ),
    // Add more trails here...
    Trail(
        "Szlak Giewont",
        "Szlak prowadzi na jeden z najbardziej charakterystycznych szczytów Tatr - Giewont.",
        listOf(
            Stage(1,"Kuźnice", "Opis etapu", 7.0f),
            Stage(2,"Przełęcz między Kopami", "Opis etapu", 6.3f),
            Stage(3,"Czarny Staw Gąsienicowy", "Opis etapu", 5.7f),
            Stage(4,"Kościeliska Dolina", "Opis etapu", 8.9f)
        ),
        "Tatry"
    ),
    Trail(
        "Szlak Kościeliski",
        "Szlak prowadzi przez malowniczą Kościeliską Dolinę w Tatrach Zachodnich.",
        listOf(
            Stage(1,"Kirów", "Opis etapu", 6.5f),
            Stage(2,"Jaskinia Mroźna", "Opis etapu", 4.8f),
            Stage(3,"Smreczyński Staw", "Opis etapu", 5.2f),
            Stage(4,"Dolina Kościeliska", "Opis etapu", 7.3f)
        ),
        "Tatry"
    ),
    Trail(
        "Szlak Dolina Pięciu Stawów Polskich",
        "Szlak prowadzi przez malowniczą Dolinę Pięciu Stawów Polskich w Tatrach Zachodnich.",
        listOf(
            Stage(1,"Palenica Białczańska", "Opis etapu", 9.2f),
            Stage(2,"Dolina Roztoki", "Opis etapu", 7.6f),
            Stage(3,"Wodogrzmoty Mickiewicza", "Opis etapu", 5.1f),
            Stage(4,"Dolina Pięciu Stawów Polskich", "Opis etapu", 6.8f)
        ),
        "Tatry"
    ),
    Trail(
        "Szlak Dolina Chochołowska",
        "Szlak prowadzi przez malowniczą Dolinę Chochołowską w Tatrach Zachodnich.",
        listOf(
            Stage(1,"Siwa Polana", "Opis etapu", 6.2f),
            Stage(2,"Wąwóz Chochołowski", "Opis etapu", 4.5f),
            Stage(3,"Dolina Chochołowska", "Opis etapu", 8.3f),
            Stage(4,"Siwe Kopy", "Opis etapu", 5.7f)
        ),
        "Tatry"
    ),
    Trail(
        "Szlak Mięguszowiecki",
        "Szlak prowadzi na masyw Mięguszowieckiego Szczytu w Tatrach Wysokich.",
        listOf(
            Stage(1,"Polana Łapszanka", "Opis etapu", 8.4f),
            Stage(2,"Schronisko PTTK Murowaniec", "Opis etapu", 7.9f),
            Stage(3,"Rówień Waksmundzka", "Opis etapu", 6.1f),
            Stage(4,"Kościelec", "Opis etapu", 9.5f)
        ),
        "Tatry"
    ),
)
