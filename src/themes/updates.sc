theme: /UpdatesInfo
    
    state: AskToJoin
        a: Присоединяйтесь к нам и узнавайте первыми об обновлениях
        script:
            var branch = !testMode() ? $analytics.joinExperiment("UpdatesInfo") : "alreadyJoined";
            if (branch === "A") {
                $reactions.answer("Напишите свой email для получения информации об обновлениях");
            } else if (branch === "B") {
                $response.replies = $response.replies || [];
                $response.replies.push({ 
                    type: "inlineButtons",
                    buttons: [{
                        "text": "Подписаться на обновления:",
                        "url": ""
                    }] 
                });
            }
            else {
                $reactions.answer("По всем вопрос обращаться по электронной почте updates@mail.ru")
            }