theme: /Service
    
    state: SuggestHelp
        a: Давайте я помогу вам купить билет на самолет, хорошо?
        buttons:
            "Да"
            "Нет"
        
        state: Accepted
            q: * (да/дава*/хорошо) *
            a: Отлично!
            if: $client.phone
                go!: /Phone/Confirm
            else:
                go!: /Phone/Ask
            
        state: Rejected
            q: * (нет/не) *
            a: Боюсь, что ничего другого я пока предложить не могу..
