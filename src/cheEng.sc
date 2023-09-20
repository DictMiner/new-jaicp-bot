theme: /Phone

    state: Hello
        q!: $regex</start>
        a: Добрый день. Вам нужна помощь в покупке билета?
        
                             
        state: no
            q: (нет/не нужна)
            a:  Тогда хорошего Вам дня
        
        state: da  
            q: (да/нужна)
            a:  Вы хотели бы купить билет на самолет или поезд?
            buttons:
                    "Самолет" -> /Phone/SkyTicket
                    "Поезд" -> /Phone/noTicket
            
                
    
    state: noTicket
            a:  Сейчас билетов нет. Попробуйте позже.
    

    state: Ask  ||  modal = true  
            a:  Назовите Ваш номер телефона
            buttons:
                    "11111" -> /Phone/noTicket
                    "22222" -> /Phone/noTicket
            
            state: LocalCatchAll 
                    event!: noMatch
                    a: Я Вас не понял. Повторите пожалуйста.



    state: CatchAll || noContext = true
        event!: noMatch
        random: 
            a: Я Вас не понял. Повторите пожалуйста.
            a: Кажется я оглох, повторите 

    state: Bye
        intent!: /пока
        a: Пока пока