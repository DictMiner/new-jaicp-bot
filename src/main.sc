require: slotfilling/slotFilling.sc
  module = sys.zb-common

require: localPatterns.sc
require: themes/service.sc

theme: /
    
    state: Welcome
        q!: *start
        q!: $hi
        random:
            a: Здравствуйте!
            a: Приветствую!
        script:
            $response.replies = $response.replies || [];
            $response.replies.push({
                type: "image",
                imageUri: "https://proprikol.ru/wp-content/uploads/2020/12/samolety-krasivye-kartinki-1-650x477.jpg",
                text: "Самолет"
            });
        go!: /Service/SuggestHelp

    state: NoMatch || noContext = true
        event!: noMatch
        a: Простите, я не поняла.\n\nПереформулируйте, пожайлуста, свой запрос.
        
