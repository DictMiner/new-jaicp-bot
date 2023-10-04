patterns:
    $goodTime = (~добрый (~утро|~день|~вечер|~ночь))
    $bot = (бот|робот*|чатбот|чат бот|чат-бот|чатик|~чат)
    $hi = * (здравствуй*/привет*) *
    $phone = $regexp<79\d{9}>
    
    # $City = $entity<Cities>
    $City = $entity<Cities> || converter = $converters.CityConverter