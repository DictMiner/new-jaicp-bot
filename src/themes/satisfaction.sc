theme: /Satisfaction
    
    state: SatisfiedClient
        a: Мы очень хотим сделать нашего бота лучше! Расскажите нам, Вы были довольны нашим сервисом?
        buttons:
            "Да"
            "Нет"
            
    state: HappyClient
        q: да
        a: Спасибо за отзыв! Всегда рады Вам помочь!
        script:
            $analytics.setSessionResult("Положительный отзыв")
        go!: /UpdatesInfo/AskToJoin
            
    state: UnHappyClient
        q: нет
        a: Сожалеем что не смогли вам помочь. Обещаем что станем лучше!
        script:
            $analytics.setSessionResult("Отрицательный отзыв")
        go!: /UpdatesInfo/AskToJoin