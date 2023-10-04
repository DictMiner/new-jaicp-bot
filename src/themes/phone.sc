theme: /Phone

    state: Ask || modal = true
        a: Для продолжения напишите, пожайлуста, ваш номер телефона 79*********.
        buttons:
            "Отмена"
        
        state: Get
            q: * @duckling.phone-number::phone *
            go!: /Phone/Confirm
            
        state: Wrong
            q: *
            a: Что-то не похоже на номер телефона...
            go!: /Phone/Ask
            
    state: Confirm
        script:
            $temp.phone = $parseTree._phone || $client.phone;
        a: Ваш номер {{ $temp.phone}}, верно?
        script:
            $session.probablyPhone = $temp.phone;
        buttons:
            "Да"
            "Нет"
        
        state: Yes
            q: (да/верно)
            script:
                $client.phone = $session.probablyPhone;
                delete $session.probablyPhone;
            a: Хорошо
            go!: /Discount/Inform
        
        state: No
            q: (нет/не [верно])
            go!: /Phone/Ask