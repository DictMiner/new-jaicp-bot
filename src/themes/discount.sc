theme: /Discount
    
    state: Inform
        script:
            var nowDate = $jsapi.dateForZone("Europe/Moscow", "dd.MM");
            var answerText = "Хочу отметить, что вам крупно повезло! Сегодня (" + nowDate + ") дейстует акция!";
            var discounts = "Купите сегодня и получите скидку 10%"
            $reactions.answer(answerText)
            $reactions.answer(discounts)
    
            
        go!: /City/Departure
