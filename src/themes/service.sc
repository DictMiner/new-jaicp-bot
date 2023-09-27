theme: /Service
    
    state: SuggestHelp
        a: Давайте я помогу вам купить билет на самолет, хорошо?
        buttons:
            "Да"
            "Нет"
        
        state: Accepted
            q: * (да/дава*/хорошо) *
            a: Отлично!
            
        state: Rejected
            q: * (нет/не) *
            a: Боюсь, что ничего другого я пока предложить не могу..
