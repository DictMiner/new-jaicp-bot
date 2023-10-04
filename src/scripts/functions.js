function getCurrentWeather(lat, lon){
    var apiKey = $jsapi.context().injector.weatherApiKey;
    var response = $http.get("http://api.openweathermap.org/data/2.5/weather?APPID=${APIkey}&units=${units}&lang=${lang}&lat=${lat}&lon=${lon}", {
        timeout: 10000,
        query:{
            APIkey: apiKey,
            units: "metric",
            lang: "ru",
            lat: lat,
            lon: lon
        }
    });
    if (!response.isOk || !response.data) {
        return false;
    }
    var weather = {};
    weather.temp = response.data.main.temp;
    weather.desc = response.data.weather[0].description;
    return weather;
}