theme: /OrderInfo

    state: OrderRequest
        a: Пожайлуста, назовите ордер 
        buttons:
            "1007379419"
            
        state: Get
            q: * $number *
            script:
                # log('\n parseTree.City: \n' + toPrettyString($parseTree.City));
                # $reactions.answer(toPrettyString($City))
                # $reactions.answer(toPrettyString($Cities[6586]['value']['name']))
                # $reactions.answer(Cities[6863])
                $session.orderInfo = $parseTree._number;
            a: Итак, ордер {{ $session.orderInfo }}
            go!: /OrderInfo/Info

    state: LocalNoMatch
        q: * || fromState = /OrderInfo
        a: Sorry, I don't understand
        go!: {{ $session.lastState }}

    state: Info
        # intent!: /geo
        script:
            $temp.orderInfo = getOrderInfo($session.orderInfo);
        if: $temp.orderInfo
            a: Кастомер {{ $temp.orderInfo.customer_id }}
            a: Инфа об ордере {{ toPrettyString($temp.orderInfo) }}
        else:
            a: Инфа не найдена
        go!: /OrderInfo/OrderRequest
        # go!: /Satisfaction/SatisfiedClient
