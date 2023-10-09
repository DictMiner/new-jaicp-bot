require: localPatterns.sc
require: themes/service.sc
require: themes/phone.sc
require: themes/discount.sc
require: themes/city.sc
require: themes/luggage.sc
require: themes/weather.sc
require: themes/satisfaction.sc
require: themes/updates.sc

require: scripts/functions.js

require: common.js
    module = sys.zb-common

require: dicts/discounts.yaml
    var = discountInfo

require: slotfilling/slotFilling.sc
    module = sys.zb-common


require: city/cities-ru.csv
    module = sys.zb-common
    name = Cities
    var = $Cities
    
init:
    $global.$converters = {};
    $global.$converters.CityConverter = function CityConverter($parseTree){
        return $Cities[$parseTree.Cities[0].value].value;
    };
    
    bind("postProcess", function($context) {
        $context.session.lastState = $context.currentState;
        log(toPrettyString($context.session.lastState));
    });
    
    # bind("onAnyError", function($context) {
    #     var answers = [
    #       "Something wrong!",
    #       "Mistake happens. Please repeat later",
    #       "Everything has broken. Try another time"
    #     ];
    #     var randomAnswer = answers[$reactions.random(answers.length)];
    #     $reactions.answer(randomAnswer);
    # });

theme: /
    
    state: Welcome
        q!: *start
        q!: $hi
        random:
            a: Здравствуйте!
            a: Приветствую!
        a: меня зовут {{ capitalize($injector.botName) }}
        # script:
        #     $response.replies = $response.replies || [];
        #     $response.replies.push({
        #         type: "image",
        #         imageUri: "https://proprikol.ru/wp-content/uploads/2020/12/samolety-krasivye-kartinki-12.jpg",
        #         text: "Самолет"
        #     });
        go!: /Service/SuggestHelp

    state: NoMatch || noContext = true
        event!: noMatch
        a: Простите, я не поняла.\n\nПереформулируйте, пожайлуста, свой запрос.
        go!: {{ $session.lastState }}
