patterns:
    $goodTime = (~добрый (~утро|~день|~вечер|~ночь))
    $bot = (бот|робот*|чатбот|чат бот|чат-бот|чатик|~чат)
    $hi = * (здравствуй*/привет*) *
    $phone = $regexp<79\d{9}>
    $number2 = $regexp<\d+> || converter = $converters.numberConverterDigit
    $City = $entity<Cities> || converter = $converters.CityConverter
