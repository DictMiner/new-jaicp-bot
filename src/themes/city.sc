theme: /City
    
    state: Departure
        a: Пожайлуста, назовите город отправления
        buttons:
            "москва"
            
        state: Get
            q: * $City *
            script:
                # log('\n parseTree.City: \n' + toPrettyString($parseTree.City));
                # $reactions.answer(toPrettyString($City))
                # $reactions.answer(toPrettyString($Cities[6586]['value']['name']))
                # $reactions.answer(Cities[6863])
                $session.departureCity = $parseTree._City;
            a: So, departure city is {{ $session.departureCity.name }}
            go!: /City/Arrival

    state: Arrival
        a: Пожайлуста, назовите город прибытия
        buttons:
            "баку"
            "екатеринбург"
            
        state: Get
            q: * $City *
            script:
                $session.arrivalCity = $parseTree._City;
            a: So, arrival city is {{ $session.arrivalCity.name }}
            go!: /Weather/Current
    
    state: LocalNoMatch
        q: * || fromState = /City
        a: Sorry, I don't understand
        go!: {{ $session.lastState }}